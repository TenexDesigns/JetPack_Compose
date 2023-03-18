A View Model is a class that is responsible for preparing and managing data for the UI.
It acts as a bridge between the UI and the underlying data sources, such as a database, network, or any other data source.
The View Model is designed to survive configuration changes, such as screen rotation, and to hold onto data during the 
lifetime of the associated UI component.

To create a View Model in Jetpack Compose, you need to use the viewModel() function, 
which is part of the Compose runtime library. Heres an example:




import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MyViewModel : ViewModel() {
    var book = 54
    // Define your data here
}

@Composable
fun MyComposable() {
    val viewModel: MyViewModel = viewModel()
    // Use the ViewModel to get and set data

    viewModel.book = viewModel.book +1
}



In the above code, MyViewModel is a custom ViewModel class that you define to hold your data. In the MyComposable() function,
the viewModel() function is used to create an instance of MyViewModel. You can then use the viewModel 
object to get and set data in your UI.

One of the main benefits of using a View Model in Jetpack Compose is that it simplifies handling configuration changes 
in your app. When the configuration changes, such as the screen orientation changes, the UI component is destroyed and
recreated. However, the View Model survives this process and holds onto the data, so your app can restore the UI state.

For example, lets say you have a list of items that you want to display in a Composable.
You can use a View Model to hold onto the list of items and then display them in the UI.
If the user rotates the screen, the UI component is recreated, but the View Model survives and can provide the list of 
items to the new instance of the UI component.

Overall, the View Model is an essential tool for handling data and state management in Jetpack Compose.
It simplifies handling configuration changes and makes it easier to create responsive and dynamic UIs in your Android app.






Heres Some more  code and an example of a counter app to cememnt the above idea
_______________________________________________________________________________________________________________


Lets build a very simple one screen app called Court-Counter.
Court-Counter is a very straightforward app with buttons that modify a basketball score. 
The finished app has a bug though; if you rotate the phone, your current score will inexplicably disappear.

What’s going on? Rotating a device is one of a few configuration changes that an app can go through during its lifetime,
including keyboard availability and changing the device’s language. 
All of these configuration changes cause the Activity to be torn down and recreated.


This behavior allows us to do things like use a landscape orientation specific layout when the device is rotated on its’ side. 
Unfortunately it can be a headache for new (and sometimes not so new) engineers to wrap their head around.



https://medium.com/androiddevelopers/viewmodels-a-simple-example-ed5ac416317e




At Google I/O 2017, the Android Framework team introduced a new set of Architecture Components, 
one of which deals with this exact rotation issue.

VIEW MODEL
_______________________________________________________________________________________________________________


The ViewModel class is designed to hold and manage UI-related data in a life-cycle conscious way. 
This allows data to survive configuration changes such as screen rotations.

This post is the first in a series exploring the ins and outs of ViewModel. In this post I’ll:


Explain the basic need ViewModels fulfill
Solve the rotation issue by changing the Court-Counter code to use a ViewModel
Take a closer look at ViewModel and UI Component association



The underlying problem

The underlying challenge is that the Android Activity lifecycle has a lot of states and
a single Activity might cycle throug
h these different states [: onCreate(), onStart(), onResume(), onPause(), onStop(), and onDestroy().]
many times due to configuration changes.



As an Activity is going through all of these states, you also might have transient UI data that you need to keep in memory. 
I’m going to define transient UI data as data needed for the UI. Examples include data the user enters, data generated during runtime,
or data loaded from a database.
This data could be bitmap images, a list of objects needed for a RecyclerView or, in this case, a basketball score.



 Instead of having a variable like scoreTeamA within the Activity, and therefore tied to all the whims of the Activity lifecycle,
what if that data was stored somewhere else, outside of the Activity? This is the purpose of the ViewModel class.


In the diagram below, you can see the lifecycle of an Activity which undergoes a rotation and then is finally finished.
The lifetime of the ViewModel is shown next to the associated Activity lifecycle. Note that ViewModels can be easily used 
with both Fragments and Activities, which I’ll call UI controllers. 
This example focuses on Activities.


The diagranm is in this repisortory ,it is called done.png



The ViewModel exists from when the you first request a ViewModel (usually in the onCreate the Activity)
until the Activity is finished and destroyed.
onCreate may be called several times during the life of an Activity, such as when the app is rotated, but the ViewModel survives throughout.



A very simple example

There are three steps to setting up and using a ViewModel:

1.Separate out your data from your UI controller( Fragments and Activities) by creating a class that extends ViewModel
2.Set up communications between your ViewModel and your UI controller
3.Use your ViewModel in your UI controller




Step 1: Create a ViewModel class

Note: To create a ViewModel, you’ll first need to add the correct lifecycle dependency. See how here in this repisortory in the file callled AllDependcies.

In general, you’ll make a ViewModel class for each screen in your app. This ViewModel class will hold all of the data 
associated with the screen and have getters and setters for the stored data. This separates the code to display the UI, 
which is implemented in your Activities and Fragments,
from your data, which now lives in the ViewModel. So, let’s create a ViewModel class for the one screen in Court-Counter:


class ScoreViewModel : ViewModel() {
    // Tracks the score for Team A
    var scoreTeamA = 0

    // Tracks the score for Team B
    var scoreTeamB = 0
}





Step 2: Associate the UI Controller and ViewModel
Your UI controller (aka Activity or Fragment) needs to know about your ViewModel. 
This is so your UI controller can display the data and update the data when UI interactions occur, such as pressing a button to increase
a team’s score in Court-Counter.

ViewModels should not, though, hold a reference to Activities, Fragments, or Contexts.** Furthermore,
ViewModels should not contain elements that contain references to UI controllers, such as Views, since this will create an indirect 
reference to a Context.

The reason you shouldn’t store these objects is that ViewModels outlive your specific UI controller instances 
— if you rotate an Activity three times, you have just created three different Activity instances, but you only have one ViewModel.


With that in mind, let’s create this UI controller/ViewModel association. You’ll want to create a member variable for your ViewModel in the UI Controller. Then in onCreate, you should call:

ViewModelProviders.of(<Your UI controller>).get(<Your ViewModel>.class)



In the case of Court-Counter, this looks like:
@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
   // Other setup code below...
}

**Note: There’s one exception to the “no contexts in ViewModels” rule. Sometimes you might need an Application context 
(as opposed to an Activity context) for use with things like system services. Storing an Application context in
a ViewModel is okay because an Application context is tied to the Application lifecycle. 
This is different from an Activity context, which is tied to the Activity lifecycle.
In fact, if you need an Application context, you should extend AndroidViewModel which is simply a ViewModel that includes
an Application reference.













Step 3: Use the ViewModel in your UI Controller
To access or change UI data, you can now use the data in your ViewModel.
Here’s an example of the new onCreate method and a method for updating the score by adding one point to team A:

// The finished onCreate method
@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
   displayForTeamA(mViewModel.scoreTeamA);
   displayForTeamB(mViewModel.scoreTeamB);
}

// An example of both reading and writing to the ViewModel
public void addOneForTeamA(View v) {
   mViewModel.scoreTeamA = mViewModel.scoreTeamA + 1;
   displayForTeamA(mViewModel.scoreTeamA);
}



Pro tip: ViewModel also works very nicely with another Architecture Component, LiveData, which I won’t be exploring deeply in this series. 
The added bonus here of using LiveData is that it’s observable: it can trigger UI updates when the data changes.
You can learn more about LiveData here.

A closer look at ViewModelsProviders.of
The first time the ViewModelProviders.of method is called by MainActivity, it creates a new ViewModel instance.
When this method is called again, which happens whenever onCreate is called, it will return the pre-existing ViewModel associated
with the specific Court-Counter MainActivity. This is what preserves the data.

This works only if you pass in the correct UI controller as the first argument.
While you should never store a UI controller inside of a ViewModel, the ViewModel class does keep track of the associations
between ViewModel and UI controller instance behind the scenes, using the UI controller you pass in as the first argument.

ViewModelProviders.of(<THIS ARGUMENT>).get(ScoreViewModel.class);
This allows you to have an app that opens a lot of different instances of the same Activity or Fragment,
but with different ViewModel information. Let’s imagine if we extended our Court-Counter example to have the scores
for multiple basketball games. The games are presented in a list, and then clicking on a game in the list opens a 
screen that looks like our current MainActivity, but which I’ll call GameScoreActivity.

For every different game screen you open, if you associate the ViewModel and GameScoreActivity in onCreate,
it will create a different ViewModel instance. If you rotate one of these screens, the connection to the same ViewModel is maintained.


All of this logic is done for you by calling ViewModelProviders.of(<Your UI controller>).get(<Your ViewModel>.class).
So as long as you pass in the correct instance of a UI controller, it just works.





A final thought: ViewModels are very nifty for separating out your UI controller code from the data which fills your UI. That said, they are not a cure all for data persistence and saving app state. In the next
post I’ll explore the subtler interactions of the Activity lifecycle with ViewModels and how ViewModels compare to onSaveInstanceState.































































































































































































































































































































































































































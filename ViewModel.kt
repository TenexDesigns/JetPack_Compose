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




















































































































































































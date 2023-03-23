










In the below code, we have to put the name state so that the vlaue can be put inside there.
We use the remember ,which saves our state during recompositions 
and we use rememberSaveable to save our state during configuration changes.


@Composable
fun Books(name:String,OnNameChange:(String) ->Unit) {
    var name:String by rememberSaveable {mutableStateOf("")}

Column(modifier = Modifier.padding(16.dp)) {
    Text(
        text = "Hello ,$name",
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.h5

    )


    OutlinedTextField(
        value = name,
        onValueChange = {value -> name = value },
        label = { Text("Name") }

    )
}





























However puting our state in our composable makes our composable diffiuclt to reuse and test.
 We can make our composable a stateless(A composable that doesnt hold any state) composable by using state hoisting
e state Hoisting,is where we move our state to the caller of the composable function that initialy contained the state.
    
    We can do this by replacing the state with paramters and events with functions
    The state paramter is the value and the event functions are lambda functions called when an event occurs
    The sattes go down from paper to book and th events come up from books to papers.
    This makes our book content more reusable and testable than before
    
    
   @Composable
    fun Paper(){
        
        var name:String by rememberSaveable{mutableStateof("")}  
        HellloContent(name=name,OnNameChange ={stringvalue -> name = STringValue})
    
    
    }
      
    
    
    
@Composable
fun Books(name:String,OnNameChange:(String) ->Unit) {


Column(modifier = Modifier.padding(16.dp)) {
    Text(
        text = "Hello ,$name",
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.h5

    )


    OutlinedTextField(
        value = name,
        onValueChange =OnNameChange,
        label = { Text("Name") }

    )
}

    
    
    
    What if we want to use our name state in other parts in our appp, such as store it in a database.
    The best way to do this is to use a view model that will store the name state in an observable holder and handle events.
    
    
    
    Here we create a HellowVewModel that extends the view model class
    
    This view model holds and exposes this name in a live data    which can be observed as satte and passed to a composable. 
    
    
class HomeViewModel: ViewModel(){
    private val _name = MutableLiveData("") // We do this so that the name can only be accessed but not changed from outside the view model
    val name: LiveData<String> = _name
    
    // Here we also pass the name from the event to the live data name
    
    fun OnNameChange(newName:String){
        _name.value = newName
    
    }

}
    Then in our state hoisting composable ,we receive the name
@Composable
fun ScreenBBc (Home:HomeViewModel = viewModel()) {
        var name  by Home.name.observeAsState("")// A chnage in this will trugger a recoimposition of the book
    // Te observe as satte ill also remmebre the state making the state survive confuiguration chnages

        Books(name=name, OnNameChange = {value-> Home.OnNameChange(value)})


    }
    
    
//This is the book    
    
        Books(name=name, OnNameChange = {value -> name =value})
                                                                             // The value is being passed into this function
@Composable           //This means that a string is being passed into this function e.g OnNameChange = {value -> name =value})
fun Books(name:String,OnNameChange:(String)->Unit)  {


Column(modifier = Modifier.padding(16.dp)) {
    Text(
        text = "Hello ,$name",
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.h5

    )


    OutlinedTextField(
        value = name,
        onValueChange = OnNameChange,
        label = { Text("Name") }

    )
}


}

    
    
    
    
    
    We use view model to handle events and hold and expose state in an observable state holder like live data
    
    *********************************
    what is an observable and how is it used in viewmodel ,e.g live data
    
    In Android development, a ViewModel is a class that is part of the Architecture Components library,
    which is used to manage the UI-related data in a lifecycle-conscious way.
    Its designed to store and manage UI-related data in a way that is both efficient and easy to use.

    In Jetpack Compose, a ViewModel is used to manage the state of the user interface.
    It can be used to store data that is required by the UI, such as text, images, or other data that needs to be displayed on the screen.
    The ViewModel is also responsible for updating the UI when the underlying data changes.

    One of the key benefits of using a ViewModel in Jetpack Compose is that it separates the data from the UI logic.
    This makes it easier to write and test the code, as well as improving the performance of the app.
    
    
    To use a ViewModel in Jetpack Compose, you can create a class that extends the ViewModel class,
    and then define the data that you want to store. You can then use this ViewModel in your Jetpack Compose code to access 
    and update the data.

    For example, you might create a ViewModel to store the text that is displayed on a screen. You could then use this ViewModel to
    update the text whenever the underlying data changes, such as when a user enters new text into a text field.

Overall, using a ViewModel in Jetpack Compose can help you write cleaner, more efficient code that is easier to test and maintain.
    
    
    
    
    
    
    
    In Android development, an observable is an object that allows you to monitor changes to a particular data value.
    Its a design pattern that enables you to react to changes in the state of an object, without needing to continuously poll
    or check for updates.

In the context of a ViewModel, an observable is used to notify the UI layer when the data managed by the ViewModel changes.
This allows the UI layer to update its state accordingly and provide a smooth user experience.

LiveData is a specific implementation of an observable in Androids Architecture Components library.
    LiveData is a lifecycle-aware observable,
    meaning it will only emit updates when the observing component is in an active state (such as when the UI is visible to the user).
    
    Overall, using an observable such as LiveData in a ViewModel can help you create a more responsive and efficient user interface.
    By only updating the UI when necessary,
    you can minimize the amount of work that needs to be done, resulting in a smoother user experience and improved performance.
    
    
    
    
    are there other observables
    
    
    Yes, there are other observables available in Android development that can be used in conjunction with ViewModel or other architectural
    components. Here are a few examples:

RxJava: RxJava is a popular reactive programming library for Android that provides a rich set of observables and operators 
         for working with asynchronous data streams.
         Observables in RxJava allow you to monitor changes to data in a similar way to LiveData,
         but with additional functionality such as the ability to combine multiple observables and apply transformations to the data.

 Flow:  Flow is a Kotlin-based reactive programming library that provides an asynchronous data stream that can emit multiple values over time.
         Flow is similar to RxJava in many ways, but is designed to integrate more seamlessly with Kotlins coroutines.
    
    
 Data Binding: Data Binding is a library that allows you to bind UI components directly to data sources in your ViewModel. 
                When the data changes, the UI is automatically updated without the need for manual updates. Data Binding can be used in 
                combination with LiveData or other observables to provide a simple and efficient way to update the UI.

  EventBus: EventBus is a library that provides a simple way to communicate between different components in your application 
          using an event-driven architecture. You can use EventBus to publish events from one component and subscribe to those events 
          in another component.
          This can be useful for communicating between the ViewModel and the UI layer, or between different parts of your application.  
    
    
    
    Overall, there are many observables available in Android development, each with their own strengths and weaknesses.
    The choice of which observable to use will depend on the specific needs of your application and the architecture you are using.
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


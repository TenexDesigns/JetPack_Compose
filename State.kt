










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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


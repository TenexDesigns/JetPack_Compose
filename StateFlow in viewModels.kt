There is a compose sate used to access data in our view models
1.Using stateFlow allows you to use flow operaturs e.g map ,filter,combined
2. They are easier to deal with process death.


Here is an example of how we use the stateflow

// This is the view model class
class MainViewModel:ViewModel() {
  // This is the state flow variable that we use inside the view mode
    private val _color = MutableStateFlow(0xFFFFFFFF)
    val color = _color.asStateFlow() // This is the variable we use to access the data in the above flow variable in the external activity or outside the view model


    fun generateNewColor() {
      // Tis genrates a random color 

        val color1 = Random.nextLong(0xFFFFFFFF)
        _color.value = color1


    }

}






THIS IS HOW WE ACCESS THE DATA IN THE VIEW MODEL IN OUR COMPOSABLE

 @Composable
    fun kim(){
        val viewmod =viewModel<MainViewModel>()// Here we access our view model
        val flowColor by viewmod.color.collectAsState()// Here we use this method to collect the value in the variable

      Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(flowColor))
                .clickable { viewmod.generateNewColor() } // Here we call this method whenever the box is clicked.
        ){

        }
    }
    
  
  
  
  
  
  
  PROCESS DEATH
__________________________________________________________________________________________________________________________________________

oR WE CAN MAKE THESE VARIABLES IMUNE TO DATA LOSS WHEN THE ANDROID SYSYTEM KILLS THE APP TO SAVE ON MEMEORY


    class MainViewModel:ViewModel(
      private val savedStateHandle:savedStateHandle
    ) {
      var color = savedStateHandle.getStateFlow("color",0xFFFFFFF)


    fun generateNewColor() {
      // Tis genrates a random color 

        val color1 = Random.nextLong(0xFFFFFFFF)
        savedStateHandle["color"] = color1


    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    HERE WE CAN PREVIEW THE COMPOSABLE ABOVE

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TenexappTheme {
       kim()



        }



    }}





















































































































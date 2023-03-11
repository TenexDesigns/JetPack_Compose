HERE WE ARE GOING TO LEARN J=HOW TO SEND SINGLE AND MULTPLE ARGUMENTS FROM ONE SCREEN TO ANOTHER.


THERE ARE TWO TYPES OF ARGUMENS
Required - You need to pass an argument eveytime you are navigating to another screen.
Optional -  You dont have to passs an argument if you dont want to. It is not a must to pass an argument when yoou want to navigate to another screen,Because you will have declared a deafult value, but the default value can be over riden
We can pass single and multiple argumnets from one screen to another



//Here is where we define the arguments to be received to be sent to tthe other  sceen

      sealed classs Screens(val route:String){
        object Home:Screen(route = "home_screen")
        object Detail:Screen(route = "detail_screen /{"id"}") // Here we have use the /{} and defined the key of the argument we want to receive from the  details sceen
        
      }

      
      
      @Composable
fun HomeScreen(navController:NavController) {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            modifier = Modifier.clickable(

                navController.navigate( route = "detail_screen"+1) //Here is where we send the agument to the other screen
            
            )
            text="Home",
            color= Color.Red,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}



      @Composable
fun DetailsScreen(navController:NavController) {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            modifier = Modifier.clickable(

                navController.navigate( route = Screen.Home.route)
            
            )
            text="Details",
            color= Color.Red,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}










          












          
          @Composable
          fun SetUpNavHost(
            navController:NavHostController
          
          ){
            
            NavHost(
              navControler = navController,
              startDestination = Screen.Home.route ){
                
                
                Composable(
                  route = Screen.Detail.route
                  arguments = Listof(
                    //Here is where we receive the argument .We use the key we gave it
                    navArgument("id"){
                      type =NavType.IntType  //Here we declare the type of argument we are receiving
                                
                                }
                  
                  )
                
                ){
                  
                  //Here is where we receive the sent arguments
                  we can access them by
                  it.arguments?.getInt("id").toString() //This extracts the intege of the key of id from the agrumnent in the it.
                    DeatilsScreen(navControler)// Here is where we pass the navController
                
                
                }
            
            
            
            
            }
            
            To send multiple required arguments ,wwe just add the arguments required in the sealed class
      sealed classs Screens(val route:String){
        object Home:Screen(route = "home_screen")    //Here we are receiving multiple required arguments
        object Detail:Screen(route = "detail_screen /{"id"}/{"name"}") // Here we have use the /{} and defined the key of the argument we want to receive from the  details sceen
        
      }
      
      To receive The multiple arguments ,we go to our navhost
            
            
            
          
          @Composable
          fun SetUpNavHost(
            navController:NavHostController
          
          ){
            
            NavHost(
              navControler = navController,
              startDestination = Screen.Home.route ){
                
                
                Composable(
                  route = Screen.Detail.route
                  arguments = Listof(//Here we reeive the sent arguments
                    
                    
                    //Here is where we receive the argument .We use the key we gave it
                    navArgument("id"){
                      type =NavType.IntType  //Here we declare the type of argument we are receiving
                                
                                }
                    navArgument("name"){
                      type =NavType.StringType  //Here we declare the type of argument we are receiving
                                
                                }
                  
                  )
                
                ){
                  
                  //Here is where we receive the sent arguments
                  we can access them by
                  it.arguments?.getInt("id").toString() //This extracts the intege of the key of id from the agrumnent in the it.
                    DeatilsScreen(navControler)// Here is where we pass the navController
                
                
                }
            
            
            
            
            }
            
            Then we pass the multiple aruments as seen below
            
                  @Composable
fun HomeScreen(navController:NavController) {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            modifier = Modifier.clickable(

                navController.navigate( route = "detail_screen"+1+"George") //Here is where we send the agument to the other screen
            
            )
            text="Home",
            color= Color.Red,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}




NOW FOR OPTIONA ARGUMEMTS 
            
            
            
            
            IN THE SEALED CLASS WE USE A QUESTION MARK INSTEAD
            
                      To send multiple required arguments ,wwe just add the arguments required in the sealed class
      sealed classs Screens(val route:String){
        object Home:Screen(route = "home_screen")    //Here we are receiving multiple required arguments
        object Detail:Screen(route = "detail_screen ?id ={"id"}) // Here we have use the /{} and defined the key of the argument we want to receive from the  details sceen
        if it is multiple optional values e.g detail_screen ?id={id}&name={name} we use an add to sepatate multopl eoptional values
      }
      
      
      
      In our screen we dont pass  anything
      


            
                  @Composable
fun HomeScreen(navController:NavController) {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            modifier = Modifier.clickable(

                navController.navigate( route = "detail_screen?id={}") //Here is where we send the agument to the other screen
                          
            )
            text="Home",
            color= Color.Red,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}



IN OUR NAVHOST
                             
                               @Composable
          fun SetUpNavHost(
            navController:NavHostController
          
          ){
            
            NavHost(
              navControler = navController,
              startDestination = Screen.Home.route ){
                
                
                Composable(
                  route = Screen.Detail.route
                  arguments = Listof(
                    //Here is where we receive the argument .We use the key we gave it
                    navArgument("id"){
                      type =NavType.IntType  //Here we declare the type of argument we are receiving
                      defaultValur = 0
                      or we can declare nullable
                      nullable = true
                                
                                }
                  
                  )
                
                ){
                  
                  //Here is where we receive the sent arguments
                  we can access them by
                  it.arguments?.getInt("id").toString() //This extracts the intege of the key of id from the agrumnent in the it.
                    DeatilsScreen(navControler)// Here is where we pass the navController
                
                
                }
                             
                             






















































































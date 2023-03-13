

THE JETPACK NAIGATION IS MADE UP THESE PARTS

NavController
Its main purpose is to keep track of backstack and state of composable screens
Its good parctice to place our navcontroller high in our composable hierachy
so that we can easily pass it down to our composable tree to all our composable screens.

NavHost
Its amin purpose is to define navigation graph.
So in our navHost we are going to define all of our screens,its routes ,its arguments and every thing we need to set our navigation route sucessfuly.
In our nav host we also define our start destination as well


**NOTE
Each NavController must be associated with a single NavHost composable.
The NavHost links the NavController with a navigation graph that specifies the composable destinations that you should be able to navigate between.
As you navigate between composables, the content of the NavHost is automatically recomposed.
Each composable destination in your navigation graph is associated with a route.


Key Term: Route is a String that defines the path to your composable.
You can think of it as an implicit deep link that leads to a specific destination.
Each destination should have a unique route.



DEFINING SCREENS
In the past we used to define our screen with activities of fragments.
But in jetpack compose we define screen inside a composable function


e.g of screens



@Composable
fun HomeScreen() {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            text="Home",
            color= Color.Red,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}

DETAILS SCREEN

@Composable
fun DetailScreen() {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            text="Detail",
            color= Color.Green,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )



        
 --->       REPRESENTTION OF SCREEN IN JETPACK COMPOSE
      Next we have to decide how to represent our screen in the navigation 
      Each and every screen in our app should have a unique name called a route.
      There are many ways of declareing routes to our screes. WE can use the screen names themselves or we can use a seald class.
      Lets see how to use a sealed class 
    
      
     // we usally access these route names e class we have to define screens we have as objects and give them uniques names as routes ,passed as arguments.
      //In this sealedobjectname.nameofroute   e.g Screens.Home.route
      sealed classs Screens(val route:String){
        object Home:Screen(route = "home_screen")
        object Detail:Screen(route = "detail_screen")
        
      }

      
      

---> Next we have to declare the nav Controller in our main activity
      THIS IS OUR FIRST MAIN COMPONENT OF THE NAVIGATION COMPONENT i.NavigationController
      
      var navController  = rememberNavController()
  
  
  Heres how
      
class MainActivity : ComponentActivity()




      
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController  = rememberNavController()
            TenexappTheme {
              
              
            }

      

      
      NEXT WE HAVE TO DECLARE OUR NAVHOST
          
          
          
         @Composable
          fun SetUpNavHost(
            navController:NavHostController  //This is the navControler that we declared in the mainActivity that we pass as an argument when we call the above function
          
          ){
            
            NavHost(
              navControler = navController,
              startDestination = Screen.Home.route       // Wehen the app statrts thi is the first screen to be seen// or we can just declare "home_route" //This are the unque ames for our screen
            
            ){
              //Inside the body of this navHost we declare all our screen or destinations
            //  Inside this body,it contains an important function called composable().And inside this function we  declare our destinations.
              //This composable function accepts multiple parameters ,one of them being a route.Here we pass in the routes we declared in the sealed class
             
                
                THIS IS OUR NAVIGATION GRAPH .THIS IS THE ROOT NAVGRAPH THAT LEADS TO THIS THEREE SCREENS 
                //Creating the NavHost requires the NavController previously created via rememberNavController() and 
                //the route of the starting destination of your graph. 
                //You can add to your navigation structure by using the composable() method. 
                //This method requires that you provide a route and the composable that should be linked to the destination:
                
                composable(route = Screen.Home.route){
                Then inside here we pass the screen that we want to be seen
                
                HomeScreen()
              
              }
              
              SECOND SCREEN
//But for this screen to be displayed we have to add a click listener  oto the oar of the first screen that we want to be clicked so that we can navigate to this screen
             composable(route = Screen.DEtails.route){
                
                DetailsScreen()
              
              }
            
            
            
            }
          
          
          
          
          
          }

          
          
          TO NAVIGATE FROM HOME SCREEN TO DETAILS SCREEN WE HAVE TO ADD THE CLICKABLE LISTENR TO THE PART WE WANT USER TO CLICK TO NVALGATE TO THE E SCREEN

            
            https://accounts.google.com/b/0/AddMailService
//In our home screen we give it a parameter of navController//
 // We pass this navController  in our NavHost file ehere we dclared this c=scrrens           
@Composable
fun HomeScreen(navController:NavController) {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            modifier = Modifier.clickable(
//Here we receive the clickable modifier
               // we use the navigate method of the navcontroller. This navigate receives many methods ,but one of them is the route
               // this route is used to move from one screen to another
                navController.navigate( route = Screen.Detail.route)
            
            )
            text="Home",
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
                
                
                Composable(){
                    HomeScreen(navControler)// Here is where we pass the navController
                
                
                }
            
            
            
            
            }
            
            
            
            
            WE DO THE SAME FOR US TO NAVIGATE FROM THE DETAILS TO THE HOMESCREEN
              @Composable
fun DetailsScreen(navController:NavController) {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            modifier = Modifier.clickable(
//Here we receive the clickable modifier
               // we use the navigate method of the navcontroller. This navigate receives many methods ,but one of them is the route
               // this route is used to move from one screen to another
                navController.navigate( route = Screen.Home.route)
            
            ),
            text="Home",
            color= Color.Red,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}



// Here is where we pass the navController to the detailsScreen
          
           @Composable
          fun SetUpNavHost(
            navController:NavHostController
          
          ){
            
            NavHost(
              navControler = navController,
              startDestination = Screen.Home.route ){
                
                
                Composable(){
                    DeatilsScreen(navControler)// Here is where we pass the navController
                
                
                }
            
            
            
            
            }
            
            
            HOWEVER WHEN WERE ON THE DETAILS SCREEN ,WE CAN USE THE BACK BUTTON TO GO BACK TO THE SCREEN .
              HOWEVER WHEN WE CLICK THE BACKBUTTON ,WE W=ARE TAKEN TO THE DETAILS SCREEN INSTR=EAD OF OUTOF THE APP.
              tHIS IS BECAUSE THE DTAILS SCRENN IS NOT REMOB=VED FROM THE BACKSTACK
              
              
              //Use this when you just want to pop the backstack
              navController.popBackStack()
              
              //Use this when you want to pass arguments in to the back screen
              
              navController.navigate(Screen.Home.route){
                  
                  popUpTo(Screen.Home.route){
                      
                      inclusive = true
                  
                  }
              
              }
              
              
              exmple
@Composable
fun DetailsScreen(navController:NavController) {

    Box( Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ){
        Text(
            modifier = Modifier.clickable(
//Here we receive the clickable modifier
               // we use the navigate method of the navcontroller. This navigate receives many methods ,but one of them is the route
               // this route is used to move from one screen to another
                navController.popBackStack()          =----------------------------> or 
                
                    or 
                              
              navController.navigate(Screen.Home.route){
                  
                  popUpTo(Screen.Home.route){
                      
                      inclusive = true
                  
                  }
              
              }
              
            )
            
            ),
            text="Home",
            color= Color.Red,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}
              
            
            
            
              
              
              
              

            
            
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          @Composable
          fun SetUpNavHost(){
            
            //This navHost is a predefined composable function that accepts two parameters
            This composable function accepts  mutiple parameters
            we declare our navController ,the one we created above ,in the navController parameter
            We declare our start destination
            and inside the navBuilder we declare all of our destinations which we are going to have in our application
            
            
            
            NavHost(navController = ,navGraph = )
          
          
          
          }
      































































































































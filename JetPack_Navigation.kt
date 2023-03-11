

THE JETPACK NAIGATION IS MADE UP THESE PARTS

NavController
Its main purpose is to keep track of backstack and state of composable screens
Its good parctice to place our navcontroller high in our composable hierachy
so that we can easily pass it down to our composable tree to all our composable screens.

NavHost
Its amin purpose is to define navigation graph.
So in our navHost we are going to define all of our screens,its routes ,its arguments and every thing we need to set our navigation route sucessfuly.
In our nav host we also define our start destination as well


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


var navController  = rememberNavController()

      
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TenexappTheme {
              
              
            }

      

      
      NEXTWE HAVE TO DECLARE OUR NAVHOST
          
          
          
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
              composable(route = Screen.Home.route){
                Then inside here we pass the screen that we want to be seen
                
                HomeScreen()
              
              }
            
            
            
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
      































































































































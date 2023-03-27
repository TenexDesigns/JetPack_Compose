 SPLASH SCREEN. -- You can also strat reading the code from the bottom up

IT IS THE FIRST SCREEN YOU SEE WITH THE APP ICON WHEN YOU OPEN YOUR APP


@Composable
fun AnimatedSplashScreen(navController:NavHostController){


   //We nned this incase couritine scopme called launched effent if we want to call a delay function
    LaunchedEffect(key1 = true){

       
        delay(7000)
        navController.popBackStack() // tHIS IS TO POP THE BACK STACK AND E=REMOVE THE SPALSH SCREEN INCASE USER PRESSES BACK BUTTON
        navController.navigate(Screen.Home.route)


    }

    Splash() // Here we call the splash screen

}












@Composable
fun Splash(){
    Box(modifier = Modifier
        .background(
            if (isSystemInDarkTheme()) Black else Purple700 // Here we check the theme if its ligt or dark


        )
        .fillMaxSize(), 
        contentAlignment = Alignment.Center // We use this to align the icon at the center



        ){
        Icon(
            modifier = Modifier.size(120.dp),
            imageVector = Icons.Default.Email,
            contentDescription = null,
            tint = White
        )
    }
}

-----------------------------------------------------------------------------------------
  THIS IS THE GRAPH TO ENABLE TH USER TO MOVE


@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(navController=navController,
    startDestination = Screen.Splash.route ){


        composable( Screen.Splash.route ){
            AnimatedSplashScreen(navController=navController)


        }
        composable( Screen.Home.route ){
            Box(modifier = Modifier.fillMaxSize()){
                Text(text="Hello George Gcaua")

            }


        }

    }





}

































-------------------- THIS IS THE SEALED CLASS


sealed class Screen (val route:String){

    object Home:Screen(route= "home")
    object Splash:Screen(route= "splash")



}


-------------------------------------------
  
  Then we classs the navGraph here


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            FlowerMeditationAppTheme() {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)



                }

            }
        }
    }





























Instead of having all of our screens be led out of from our root nav host.We can can have nested routes














          Root Gragh
         _______
         |     |    
         |     |    
         |  A  |
         |     |      
         |     |      
            |    
  __________|___________   
  |         |           |  
______      ____       _____
|    |     |    |     |    |
|    |     |    |     |    |
| B  |---> | C  | --->|  D |
|    |     |    |     |    |
|    |     |    |     |    |
            | Nestted graph leading to other screens
            |
            |    
  __________|___________   
  |         |           |  
______      ____       _____
|    |     |    |     |    |
|    |     |    |     |    |
| E  |---> | F  | --->|  G |
|    |     |    |     |    |
|    |     |    |     |    |
  
  
  
  
  
  Here is an example
This is the root navigation graph
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}





//The naviagtion function is an extions of the navigation builder ,
Inside the navigation function we declare all of th screens we want to host,

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE  //This is a string to name/ identitfy this navigation graph
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "Stevdza-San"
                }
            )
        ) {
            DetailScreen(navController = navController)
        }
    }
}



fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Login.route,
        route = AUTH_GRAPH_ROUTE
    ){
        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.SignUp.route
        ) {
            SignUpScreen(navController = navController)
        }
    }
}

  
  
  


























































































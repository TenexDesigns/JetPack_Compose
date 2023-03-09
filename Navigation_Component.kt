The Navigation Architecture Component simplifies navigation implementation while also assisting you in visualizing
your app’s navigation flow.
The library offers a variety of advantages, including:


1. Handling fragment transactions.
2. Handling Up and Back actions correctly by default.
3. Providing standardized resources for animations and transitions.
4. Implementing and handling deep linking.
5. Including Navigation UI patterns, such as navigation drawers and bottom navigation, with minimal additional work.
6. Safe Args - a Gradle plugin that provides type safety when navigating and passing data between destinations.
7. ViewModel support - you can scope a ViewModel to a navigation graph to share UI-related data between the graphs destinations.
8. Handling of fragment transactions automatically
9. By default, up and back actions are handled correctly.
10. Default animation and transition behaviors
11. Deep linking is regarded as a first-rate operation.
12. Implementing navigation UI patterns (such as navigation drawers and bottom navigation) with minimal additional effort
13. When navigating Android Studio tooling for visualizing and editing an app’s navigation flow, use type safety when passing information.


THE NAVIGATION COMPONENT IS MADE UP OF THEREE MAJOR PARTS

Navigation graph (New XML resource) 

This is a resource that collects all navigation-related data in one place.
This includes all of the locations in your app,referred to as destinations, as well as the possible paths a user could 
take through your app.

NavHost (Layout XML view)
This is a unique widget that you can include in your layout. 
It shows various destinations from your Navigation Graph.
The Navigation component contains a default NavHost implementation, NavHostFragment, that displays fragment destinations.

NavController(Kotlin/Java object)
An object that manages app navigation within a NavHost. The NavController orchestrates the swapping of destination content 
in the NavHost as users move throughout your app
This is an object that keeps track of where you are in the navigation graph.
As you move through a navigation graph, it orchestrates the swapping of destination content in the NavHostFragment.





NAVIGATION CONTROLLER
In order to navigate from one screen to another we use navigation controller



package com.example.tenexapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.Coil
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.example.tenexapp.ui.theme.TenexappTheme
import org.w3c.dom.Text


//NAVIGATION HOST IS LIKE A LINK BETWEEN THE NAVIGATION GRAPH AND THE NAVIGATION CONTROLLER
//iT CONTAINS ALL THE COMPOSABLES AND THEIR DESTINATIONS
//tO CREATE A NAVIGATION HOST  first WE HAVE TO CREATE A ROOT,THIS ROOT DEFINES THE DESTINATIONS OF CERTAIN COMPOSABLES
//THIS IS THE ROOT
object  NavRoute{
    val SCREEN_A = "ScreenA" //This is the first destination // Here you can define any string that you want.
    val SCREEN_B = "ScreenB"
    val SCREEN_C = "ScreenC"
}




// THIS IS THE NAV HOST
// It must get the nav host controller so that it can easily navigate between this somponents/ fragments


@Composable
fun MyNavHost(navHostController: NavHostController){

    NavHost(navController = navHostController,// Here we use the navHostController recerived as a argument
        startDestination = NavRoute.SCREEN_A  // HERE WE USE THE ROUTE . tHE BUILDER WE DEAL WITH IT IN THE LAMDA FUNCTION
    ){//Add the Composable to the NavGraphBuilder
        composable(NavRoute.SCREEN_A)// Here we pass our route. Since we create our route i.e the NavRoute.
        {
            ScreenA {
                navHostController.navigate(NavRoute.SCREEN_B)
            } // Here we pass the composable that we want to navigate to.

        }
        //We can duplicate what we didt above here for screen B and c
        composable(NavRoute.SCREEN_B)// Here we pass our route. Since we create our route i.e the NavRoute.
        {
            ScreenB {
                navHostController.navigate(NavRoute.SCREEN_C)
            } // Here we pass the composable that we want to navigate to.

        }
        composable(NavRoute.SCREEN_C)// Here we pass our route. Since we create our route i.e the NavRoute.
        {
            ScreenC {
                // Here we pass the composable that we want to navigate to.
                navHostController.navigate(NavRoute.SCREEN_A) {
                    popUpTo(NavRoute.SCREEN_A){inclusive= true}//Now her the user on pressing the back baton we want then to reach screenA and then get out of the activity
                }
            //Now her the user on pressing the back baton we want then to reach screenA and then get out of the activity
            } // Here we pass the composable that we want to navigate to.

        }
    }

}








class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TenexappTheme {
                // A surface container using the 'background' color from the theme
                
                val navController = rememberNavController()
                Surface(

                    color = MaterialTheme.colors.background
                ) {
                    
                    // Here we can now call the navHost and pass in the navController that we defined .The one that has a rememberd on it. 
                    MyNavHost(navHostController = navController)


                }
            }
        }
    }
}




// NAVIGATE WITH ARGUMENTS
//In order to pass arguments from one composable to another we have to pass it with the route.
//Let us create a variable tht we will pass with the route and the arguments

var routewithArguments ="${NavRoute.SCREEN_A}"


// THESE ARE THE SCREENS WE WILL BE NAVIAGATING TO.




package com.example.tenexapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ScreenA(onNavigation:() -> Unit) {

    Surface(color= Color.Red,modifier=Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center


        ){
            Text(text="This is screen A")
            Button(
                onClick ={
                    onNavigation()

                },
                modifier = Modifier.align( Alignment.BottomCenter)
            ){
                Text(text = "Navigate")

            }

        }


    }



}



@Composable
fun ScreenB(onNavigation:() -> Unit) {

    Surface(color= Color.Blue,modifier=Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center


        ){
            Text(text="This is screen B")
            Button(
                onClick ={
                    onNavigation()
                },
                modifier = Modifier.align( Alignment.BottomCenter)
            ){
                Text(text = "Navigate")

            }

        }


    }



}



@Composable
             // Here we pass the navigation host we created
fun ScreenC(onNavigation:() -> Unit) {

    Surface(color= Color.Green,modifier=Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center


        ){
            Text(text="This is screen C")
            Button(
                onClick ={
                    onNavigation()
                },
                modifier = Modifier.align( Alignment.BottomCenter)
            ){
                Text(text = "Navigate")

            }

        }


    }



}











































































































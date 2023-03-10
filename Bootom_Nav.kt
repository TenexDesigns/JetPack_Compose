package com.example.tenexapp

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState

sealed class Screens(val title:String,val route:String,@DrawableRes val icons:Int){

    object Home:Screens(
        title = "Home",
        route = "home_route",
        icons = R.drawable.home
    )


    object Notification:Screens(
        title = "Home",
        route = "notification_route",
        icons = R.drawable.notification
    )


    object Mesages:Screens(
        title = "Home",
        route = "messages_route",
        icons = R.drawable.messages
    )






}

@Composable
fun BottomNavHost(navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = Screens.Home.route  ){
        composable(route= Screen.Home.route) {
            Home()
        }
        composable(route= Screen.Home.route) {
            Home()
        }
        composable(route= Screen.Home.route) {
            Home()
        }


    }
}


@Composable
fun BottomNavigationScreen(navController: NavController,items:List<Screens>){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation{
        items.forEach{
            screens ->
            BottomNavigationItem(selected = currentDestination?.route == screens.route ,
                onClick = { navController.navigate(screens.route)},
                icon = { Icon( painter = painterResource(id = screens.icons),contentDescription="icon ") },

                ) {

            }
        }

        
    }
}

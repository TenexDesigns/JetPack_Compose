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





READ THE COMMMENTS WITH FOUR COMMENTS LINES .THOSE EXPLAINE ABOUT THE SENDING OF DATA THROUG ARGUMENTS ----- >////


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
      ////Here we receive the string thta was sent with the route
fun ScreenB(string:String?,onNavigation:() -> Unit) {

    Surface(color= Color.Blue,modifier=Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center


        ){
            ////Here we can use the receiverd string
            Text(text="This is screen $string")
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




THIS ARE THE SVREEN WE ARE MOVING TO 
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
      ////Here we receive the string thta was sent with the route
fun ScreenB(string:String?,onNavigation:() -> Unit) {

    Surface(color= Color.Blue,modifier=Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center


        ){
            ////Here we can use the receiverd string
            Text(text="This is screen $string")
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

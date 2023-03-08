@Composable
fun Greeting() {
    Column(modifier =  Modifier.fillMaxSize()) {   
      
                       // Here we use a remeberedSaveable stat that will survice recomposition of activity e.g when the screen orientation is changed
      var password by rememberSaveable{ mutableStateOf("") }

        OutlinedTextField(value = password, onValueChange ={ newText ->  // Here the text that is typed i put in a varilable new text 

            password = newText // We put the typed text into the passowrd variable


        } ,
                          placeholder ={Text(text="password")},
                          label ={Text(text="password")}
                          
                          //IF YOU REMEBER ABOUT UNPUT PASSOWRDS. tHEY HAVE OPEN AND CLOSED EYES TO TOOGLE BETWEEN PASSWORD VISISIBILITY AND NOT.
                          var passowrdVisisbility by remember{mutableStateof("false")}
                          
                          val icon = if(passwordVisibility)
                             painterResoource(id = R.drawerbale.eye_open)
                               else
                             painterResoource(id = R.drawerbale.eye_closed)  ),
        
        
        trailingIcon ={
          IconButton(onClick ={
            passwordVisibility = !passowrdVisibility
          
          }){
            
            Icon{
              painterResource = icon
              contentDescription = "visisbility"
              
            
            },
            
            // HERE IS WHERE WE TOOGLE THE PASSWORD VISIBILITY DEPENDING ON IF PASSOWRD VISIBILITY IS TRUE OR FALSE
            
            visualTransformation = if(passwordVisibility) visualTransformation.None // If asswordVissibility is true we show the password.
            else passwordVisulaTrnsformation()// If passwordvisibily is false we hide the password
          
          
          kwyBoardOptions = keyBoardOptions(
            
            keyboardType = KeyboardType.password   // This removes underscores and gives user a keyboard of type of passowrd
          
          
          )
          
          
          }
        
        
        }
        
    }

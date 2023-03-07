TEXTFIELD

This is the input filed where user enters their text.
We have different types of text fields ,but let us start with the most basic one.


THESE TWO ARE MANDATORY
i.e The value and the onValue change are mandatory 



        TextField(value = "George", onValueChange ={

        } )
        
        
But these two alone will not enable you to type the text you want on the phone.
The reason why you aren able to type is bacause of you havent yet declared the state  state.

To decare state we use the by remembered() method and we put in our state in the mutableStateof()

        // We declare our state here and give it a name of texte
        var text by remembered(mutableStateOf("Type your text here") ) 
        // We set the value here to that of the state we declared  above.
        TextField(value = text, onValueChange ={ newText ->    //Here w get the text passed to the onValueChange method then we set the text to the new text. 
          text = newText

        } )
        
        
        HERE ARE OTHER VALUES WE CAN DECLARE ON THE TEXT


        TextField(value = text, onValueChange ={ newText ->

            text = newText

        },
                 enabled = false, // This either enables or disables the text
                  readOnly = false // This makes the text field focusable but not editable
                  label ={ text = " First Name"} // This puts a label on the input field that tells the user what it is that he is filling in.
                  singleLine= true // This makes the text to be input in only one single line that can be scrolled horizontaly if the text is too much.
                  maxLines = 2 // This sets the max number of lines to which the input can expand to to be 2. The content in there can be scrollable.
                  leadingIcon= {  // This is used to add a leading icon to the text.e.g on whats app input there is an emeoji leading icon
                    IconButton(onClick = {// ere you can implement the onClick listener.}){
                      Icon(
                        imageVector = Icons.Filled.Email, // This is the icon that we put in place.
                        contentDescription = "Email Icon"
                      
                      )
                    
                    }
                    
                  trailingIcon = { // This is the icon that will be implememnted after the input . E.g is the camera icon on the input thxt whatsapp.
                   IconButton(onClick = {// ere you can implement the onClick listener.}){
                           Icon(
                                imageVector = Icons.Filled.Email, // This is the icon that we put in place.
                                contentDescription = "Email Icon"
                      
                      )
                    
                    }
                  
                  keyboardOptions = KeyBoardOptions(
                    keyboardType = keyBoardType.password // This is used to specifiy the type of keyboard that you want e.g password,number,or text
                    imeAction = ImeAction.done // This is used to change the icon at the far right of the keyboard  e.g ImeAction.done is a check mark, ImeAction.go is an arrow  ImeAction.search gives a search icon.
                     // After putting an imeAction and specifiying the type of icon we want. Then we have to specify an action listner and say the ison to be excuted 
                  
                  )
                  
                  
                  
                  keyboardActions = keyboardActions(
                          onDone = {
                                 // Here we specify the action to be taken onclicking the done icon
                                  
                                  Log.d("When clicked do this","clicked")
                          
                          
                          }
                  
                  
                  
                  )
                  
                  }
                  
                  
                  
                  }
             )
                   
                   
                   
                   THER ARE OTHER TYPES OF TEXT FIELDS
                          Outline - Which has an outline
                          Basic --Which doent have ant design nor does it support trailing nor leading icons But we can give it our own desired design
                          e.g background padding  using the modifier.


        





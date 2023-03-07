Thsis is a composable that we can use out of the box in jetpack compose o design our ui

This text takes many parameters 

To set text using the Text() method you do it like

Text(text ="Helloo George")

We can also set padding and background color for this text, using the modifier

e.g

Text( text = "Hello George"                                           // So always put background as first then padding next so as to get a colred padding
      modifier = Modifier.background(MaterialTheme.colors.primary)  //Remeber that modifier always excutes the code from top to bottom
                         .padding(16.dp)  // So if the padding is before the background the you wont see the colored pad
    )



IF YOU WANT TO SET THE STEXT IN A STRING FILE THEN THIS IS HOW YU REFER TO THAT STRING RESOURCE
                                         //This is the name you gave to the string resource
Text( text = stringResource(id = R.string.app_name))
















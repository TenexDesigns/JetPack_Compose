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





WE HAVE SEEN THE ABOVE METHOD OF PUTTING TEXT 
But there is another method using the AnnotedString
This method allows us to make chnages to indivivdual characters


Text(
      
      buildAnnotatedString{
            
            append("G")  // This adds individula characters to the text . And we can style individual charactes separately
            append("e")
            append("o")
            append("r")
            append("g")
            append("e")
      } )

To style  the characters , we use the the withStyle() method. This method has two parametrs 
style = SpanStyle  - This  is used when you want to style individula characters
style = ParagraphStyle - This is used when you wnat to style a whole paragraph i.e All the characters in your texte e.g here All the characters in the word George.

In our above case we are going to use the span style since we only want to style characters
We put the styles to appply on the character within the paranthesus of the span tag



Text(
      
      buildAnnotatedString{
            
            
            // This styles the characters individually.
            withStyle(style = SpanStyle(
                  color = color.Green
                  fontSize = 30.sp
                  fontweight = Fontweight.Bold
            
            
            )) {
                  append("G")
            
            
            }
            
            // Only the character e is styled
             withStyle(style = SpanStyle(
                  color = color.Green
                  fontSize = 30.sp
                  fontweight = Fontweight.Bold
            
            
            )) {
                  append("e")
            
            
            }
            
            
            
            
            
            append("o")
            append("r")
            append("g")
            append("e")
      } )




NOW IF WE WANT TO STYLE ALL THE CHARACTERS WE HAVE TO USE THE PARAGRAPH STYLE 
The paragraph style is used to style all our individula characters e.g To alighn them to the start
To do that we have to put all our chacters ,even th styled ons within the paragraphStyle

EXAMPLE



Text(
      
      buildAnnotatedString{
            withStyle( style =ParagrapgStyle() {
                  
                  
                  
                               withStyle(style = SpanStyle(
                  color = color.Green
                  fontSize = 30.sp
                  fontweight = Fontweight.Bold
            
            
            )) {
                  append("e")
            
            
            }
            
            
            
            
            
            append("o")
            append("r")
            append("g")
            append("e")
            
            
            
            
            
            
            
            }
                     
                     
                     
                     
                     
                     
                     
                     )


























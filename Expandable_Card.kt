HERE WE AR GOING TO MAKE AN EXPANDABLE CARD

This card will have a title and a dropdown icon that will do a 180 degree flip when clicked
The initial state of this icon will be false and on clicking it. The state will be change to true
We will use the state of this icon to expand the card or contarct the card.


    var expandState by remember{ mutableStateOf(false) }  // The state here is false. We have to use the remeber method so that the app remebers about this state.
    val rotationState by animateFloatAsState(targetValue = if(expandState) 180f else 0f)  // Here we set the rotation angle to be either 180 or 0 depending on the expandState.
    
    
    TO MAKE A CARD WE USE THE CARD COMPOSABLE METHOD i.e Card()
    The card function takes in various parameters such as modifier,shape and onClick method that will be excuted once the card is clicked


    Card(
        modifier = Modifier.fillMaxWidth()  // This sets the width of the card
                           .animateContentSize(  // This sets theaniamtion to be used by the card to displaay the information
                               animationSpec = tween(
                                          durationMillis = 300,  // This sets the duration in milisections for the animation
                                          easing = LinearOutSlowInEasing  //Tels what type of aiamation to be excuted
                                                    )


            ),
        shape = Shapes.medium, // This is the second prameter. It is used to shape the card container. We use the shapes we defined in the folder to make this shape.
        onClick = {  // This is the third parameter. We define what will be done on clicking the card here.
            expandState = !expandState  // Here we excute the code that will change the state of the expand state. Here we say that we toggle between the state by setting th 
        } )    {                         // Opposite value on clicking te card.
    

      
      
      // here we define the content that will be in the seeen in the card
      // Here we use a column layout To hold all the items
      // Then we will define a row layout that will hold the title and the drop icon
      
     Column(modifier = Modifier.fillMaxWidth()   // This makes the column containing the content to fill the widthin the card containing it
                               .padding(12.dp)){// This gives the column containing the content a padding of 12 dp
       
       //NOW WE PUT THE ROW HERE THIS WILL CONTAIN THE TITLE AND THE DROP ICON
  Row(verticalAlignment = Alignment.CenterVertically)
            {
                Text(text="This si the Tital",   // This is the title of the CARD
                    modifier = Modifier.weight(6f),   //SINCE THE we want the title to have more spece we use the weight to divide the row into seven portions and give the title 6/7 of the portion 
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold)

                IconButton(modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .weight(1f)  // Here we give the drop icon 1/7 portion of the row
                    .rotate(rotationState),  // Here we excute the angle provide the rotationstate.
                    onClick = {
                        expandState = !expandState   // We excute the code to change the state and make it opposite.
                    }) {
                    Icon(       // Here we set the icon by using the imageVector attribute
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "This is dragDown Arrow"  // We set the contentDecription here for the icon.
                    )

                }

            }
            
            
            
            // NEXT HERE IS THE  CODE TO DISPLAY THE TEXT 
            The text is displayed depending on the state of the expandble state
            
            if(expandState){
                Text(
                    text="Lorem Ipsum is simply dummy text of the" +
                            " printing and typesetting industry. Lorem " +
                            "Ipsum has been the industry's standard dummy text" +
                            " ever since the 1500s, when an unknown printer took a" +
                            " galley of type and scrambled it to make a type specimen " +
                            "book. It has survived not only five centuries, but also the " +
                            "leap into electronic typesetting, remaining essentially" +
                            " unchanged. It was popularised in the 1960s with the release" +
                            " of Letraset sheets containing Lorem Ipsum passages, and more " +
                            "recently with desktop publishing" +
                            " software like Aldus PageMaker including versions of Lorem Ipsum."
                , fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis

                )
       
       
       
       
       
      
      

      

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

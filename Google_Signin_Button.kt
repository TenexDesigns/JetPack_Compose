@Composable
fun GoogleButton() {
    var clicked by remember { mutableStateOf(false) }  // Here we create a state that will tell us if the button is clicked or not

    Surface(            //We use surfacre to create as sufcae that will hold our contetnt 
        modifier = modifier.clickable { clicked = !clicked }, // Here we change the state of the clicked depending on the if the user clicks the surfcae or not.
        shape = shape,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = MaterialTheme.color.surfce
    ) {
      // Within our surface we have a row that will arrange our content in a row
        Row(
            modifier = Modifier
                .padding(  // We add padding on all sides
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(   // Here we animate our button whenever it increases in size
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
          
          // This is the content of the row i.e a gogle icon Text that will change when user clicks and  aprogressive circle that will appear when user clicks
            Icon(
                painter = painterResource(id = icon),  // Here we set the icon
                contentDescription = "Google Button",
                tint = Color.Unspecified  //We set this so that the color origamly on the ison is retained
            )
            Spacer(modifier = Modifier.width(8.dp)) // Here we add a space between the icon and the text
            
            loadingtext = "Signing in progress ..."
            text = "Create a Google acount"
            // Here we chack if clicked id true and if it is true we excute the assigned text
            Text(text = if (clicked) loadingText else text)
            //Here the loading progress bar is added depending on if the user has clicked the surfcae or not
            if (clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.color.Primary
                )
   
            }
        }
    }
}

@Composable
@Preview
private fun GoogleButtonPreview() {
    GoogleButton(

    )
}

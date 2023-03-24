WHAT DOES THIS "content: @Composable ColumnScope.() -> Unit"MEAN IN A COMPOSABLE FUNCTION

It means that this composable function can have childeren e.g column coposable . This column composable has box and image childeren.

Column(){
  
  Box(){
  
  }
  imgae(){
  
  }



}










@Composable
inline fun Column(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit) {

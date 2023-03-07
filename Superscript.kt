@Composable
fun Greeting(normal:String,supe:String) {

  Text(

      buildAnnotatedString {
          withStyle(style = SpanStyle( fontSize = MaterialTheme.typography.h5.fontSize)){

              append(normal)
          }

          withStyle(style = SpanStyle( fontSize = MaterialTheme.typography.h5.fontSize,
                                       fontWeight = FontWeight.Normal,
                                       baselineShift = BaselineShift.Superscript

          )){

              append(supe)
          }
      }
  )
  
  
  Then we call the function and pass the required parameters
  
  Greeting(normal = "George", supe = "Gacau")

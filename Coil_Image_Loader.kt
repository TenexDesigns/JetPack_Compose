This is used to load images from the internet.
There is a dependecy you have to implelemnt
implementation("io.coil-kt:coil-compose:1.3.1")



@Composable
fun CoilImage(){
  //HERE WE DEINE A BOX CONTAINER TO HOLD OUR IMAGE .Theimage container will be 150 by 150dp and the content will be alignend to the center
    Box(modifier = Modifier.height(150.dp)
                           .width(150.dp),
        contentAlignment = Alignment.Center)
  {
   // TO LOAD THE IMAGE FROM THE INTERNT WE HAVE TO VA A URL AND ALSO USERPERMISSION FOR INTERNENT ACCESS.
    
        val painter = rememberImagePainter(   // We use the remmeberImagePainter mathod to fetch the image from the internet 
          // we use the data parameter and pass our image url to fetch the image
            data = "https://images.pexels.com/photos/2499417/pexels-photo-2499417.jpeg?auto=compress&cs=tinysrgb&w=600",
          // The builder is must to be implememented .
         // We use the builder to add features such a placehoder for our image before it loads or an image to show error if image does not load
      builder={
                placeholder(R.drawable.loading_Image) //This sets the loading image befoer the image is fetched from the intrnent
                error(R.drawable.error_image)// This set the image when an error occours in fetching the image from th internet
                crossfade(1000) // This excutes an animation when moving from the placeholder image to the internent image.The animation lasts for 1000 miliseconds
                transformations(// This excutes transformations on the image fetched rom the internet
                    GrayscaleTransformation(),//This makes our mahe to loose its color and be gray
                    CircleCropTransformation(),// This crops our image and make it have a circle
                    BlurTransformation(LocalContext.current), // This makes our image have  bliur
                    RoundedCornersTransformation(50f) // This makes our image have rounded courners

                )


            
        )
       Image(painter = painter, contentDescription = "Logo image")  // This is what puts our image in the box or container that holds it.


    }
}







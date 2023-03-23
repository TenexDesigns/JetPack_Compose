Pick Image from Gallery in Jetpack Compose

We have been hearing about Jetpack Compose for a while now and as announced at Google I/O 2021,
Compose will be stable come July. Jetpack Compose gives us a declarative way of building UIs on the Android platform. 
Let us explore how to select an image from the gallery and display it in an Image Composable.

Of course, we will be using the Activity Result APIs which simplifies our task and we do not need to deal with request codes.
Enough of the long talk, let us create our composable and I will explain below.


@Composable
fun RequestContentPermission() {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    val bitmap =  remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }
    Column() {
        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "Pick image")
        }

        Spacer(modifier = Modifier.height(12.dp))

        imageUri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver,it)

            } else {
                val source = ImageDecoder
                    .createSource(context.contentResolver,it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }

            bitmap.value?.let {  btm ->
                Image(bitmap = btm.asImageBitmap(),
                    contentDescription =null,
                    modifier = Modifier.size(400.dp))
            }
        }

    }
}


We start by declaring an imageUri to hold the image uri, then we get the current context and then on the following line,
we create a variable bitmap to hold a state object which will be the image selected from the gallery converted as a Bitmap.

To pick content from the gallery, we call rememberLauncherForActivityResult and pass ActivityResultContracts.
GetContent() as our contract. This call is similar to registerForActivityResult and when we get the result, 
we set it to the value for imageUri.

When our user clicks the button, they open the gallery and select an image. 
The next few lines just converts the imageUri to a bitmap and we display it in an Image Composable. 
Below is the result on a Pixel 4 emulator
































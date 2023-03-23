The Activity Result APIs are part of the Android Jetpack library and they provide a simplified way to manage Android activity results.
With the Activity Result APIs, you can easily start an activity and receive a result from it, ithout having to manage complex callbacks 
or handle configuration changes.

WHAT IS AN ACTIVITY IN THIS CONTEXT-
An activity refers to an Android component that provides a user interface for an app.
Once the activity completes its task, it can return a result to the calling activity.
The result is then returned to the "ActivityResultLauncher" callback, where we can handle it as needed

//Heres an example of how to use the Activity Result APIs in Jetpack Compose:


The Activity Result APIs are part of the Android Jetpack library and they provide a simplified way to manage Android activity results.
With the Activity Result APIs, you can easily start an activity and receive a result from it, 
without having to manage complex callbacks or handle configuration changes.



Heres an example of how to use the Activity Result APIs in Jetpack Compose:



val launcher = rememberLauncherForActivityResult(
                           ActivityResultContracts.RequestPermission()
) { result ->
                  if (result) { // Heere if the result is true, then the user has granted
                        // Open camera
               } else {
                     // Show dialog
                }
}


@Composable
fun MyComposable() {
    val activity = LocalContext.current 
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Handle the activity result here
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            // Do something with the result data
          else{
           // do something else
          
          }
        }
    }

    Button(onClick = { 
        // Launch the activity and wait for the result
        launcher.launch(permissions)
    }) {
        Text(text = "Launch Activity")
    }
}



In this example, we use the "rememberLauncherForActivityResult" function to create a "ActivityResultLauncher" that starts an activity and
waits for a result. The "ActivityResultLauncher" is passed a contract, in this case ActivityResultContracts."StartActivityForResult()",
which defines the type of activity result that we want to receive.
The result is then handled in the callback function, where we can check the result code and extract any data that was returned.

The ActivityResultContracts provides a range of predefined contracts for getting various types of data, including images, audio, videos, contacts, and documents.


Heres an example of how to use the ActivityResultContracts to get an image from the devices camera or gallery or any other type of data:


ActivityResultContracts.CaptureVideo     - An ActivityResultContract to take a video saving it into the provided content-Uri.
ActivityResultContracts.CreateDocument   - An ActivityResultContract to prompt the user to select a path for creating a new document of the given mimeType,
                                           returning the content: Uri of the item that was created.
ActivityResultContracts.GetContent       - An ActivityResultContract to prompt the user to pick a piece of content,
                                           " receiving a content: Uri" for that content that allows you to use
                                           android.content.ContentResolver.openInputStream to access the raw data.
                                           The input is the mime type to filter by, e.g. image/\*.

ActivityResultContracts.PickContact      - An ActivityResultContract to request the user to pick a contact from the contacts app.
                                               THE OUT PUT IS CONTENT:URI




ActivityResultContracts.PickMultipleVisualMedia -An ActivityResultContract to use the Photo Picker to select a single image, video, or other type of visual media.
                                            The constructor accepts one parameter maxItems to limit the number of selectable items 
                                             The output is a list Uri of the selected media.


ActivityResultContracts.RequestMultiplePermissions - An ActivityResultContract to request permissions

ActivityResultContracts.TakePicture  - An ActivityResultContract to take a picture saving it into the provided content-Uri.

ActivityResultContracts.StartActivityForResult - An ActivityResultContract that doesnt do any type conversion, taking raw Intent as an input and ActivityResult as an output.


ActivityResultContracts.PickVisualMedia.ImageOnly - VisualMediaType object used to filter images only when using the photo picker.

ActivityResultContracts.PickVisualMedia.VideoOnly - VisualMediaType object used to filter video only when using the photo picker.


ActivityResultContracts.PickVisualMedia.ImageAndVideo - VisualMediaType object used to filter images and video when using the photo picker.



you can use the StartActivityForResult contract. This is a generic contract that takes any Intent as an input and returns an ActivityResult, 
allowing you to extract the resultCode and Intent as part of your callback, as shown in the following example:



  WHAT IS THE URI RETURNED BY SOME CONTRACTS

ActivityResultContracts.CaptureVideo - video is saved into the provided content-Uri.
ActivityResultContracts.CreateDocument - returns the content: Uri of the item that was created.
ActivityResultContracts.GetContent - the piecked content is received in a content: Uri.
ActivityResultContracts.PickMultipleVisualMedia -The output is a list Uri of the selected media.
e.t.c



In the code you provided, uri stands for the Uniform Resource Identifier that represents the data that was selected ,captured or created 
by the user in the activity launched using the GetContent,createDocument,cpature videor e.tc contract.

The GetContent contract is a part of the Activity Result API that allows you to launch an activity to select and return data.
In this case, it launches an activity that allows the user to select some form of content (e.g. an image, a video, a document) from their
devices storage, and returns a URI that points to the selected content.

The rememberLauncherForActivityResult function registers a callback function that will be executed when the activity completes and returns a result.
In this case, the callback function takes a single parameter, uri, which represents the URI of the selected content.


You can use this uri parameter to perform further operations on the selected content, such as displaying an image in
your apps UI or processing a document. Note that the value of the uri parameter can be null if the user cancels the activity
or an error occurs, so you should check for null values before using it.
































In Jetpack Compose, rememberLauncherForActivityResult and registerForActivityResult are both used to handle the results of an activity launched with an Intent.
However, they are used slightly differently in Compose than in traditional Android development.

rememberLauncherForActivityResult is used to create a ActivityResultLauncher that can be used to launch an activity and handle its result.
This method is typically used in a Composable function to launch an activity and receive the result.
Heres an example of how to use it:

class MaoinActivity : ComponentActivity() {
    val intentsss = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->
        result.resultCode
    }
    
    
    
    ___________________________________
  
     @Composable
  fun GetPictures(){
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { result->
      //Do what you want with the result
      
      
    }
    
    
    NOW THIS IS MORE EXPLANATION
    
 val Launcher = rememberLauncherForActivityResult(ActivityResultContracts.SomeContract()) { result ->
    // Handle the result
}

Button(onClick = { Launcher.launch() }) {
    Text(text = "Launch Activity")
}


In Jetpack Compose, rememberLauncherForActivityResult and registerForActivityResult are both used to handle the
    results of an activity launched with an Intent. However, they are used slightly differently in Compose than in 
    traditional Android development.
    
Always use  rememberLauncherForActivityResult()  because it is used in a composable ,and when the ui is changed,the composable function comtaining it 
    will be recomposed,but the registerForActivityResult you need to destroy it in the on Destroy method i.e launcher.destroy()
    
    
    
    
    
    
    
    
    
    
    
    
    
    

rememberLauncherForActivityResult is used to create a ActivityResultLauncher that can be used to launch an activity and handle its result. 
    This method is typically used in a Composable function to launch an activity and receive the result. Heres an example of how to use it:

In this example, rememberLauncherForActivityResult creates an instance of ActivityResultLauncher that can be used to
    launch an activity with the SomeContract contract, and handle the result in the lambda function. 
    When the Button is clicked, the launch() method is called on the ActivityResultLauncher to launch the activity.
    
    
    registerForActivityResult is not commonly used in Jetpack Compose, as Composables dont typically have access 
    to an Activity or Fragment instance where this method can be called.
    Instead, rememberLauncherForActivityResult is used to handle activity results within a Composable function.

    
    The key difference between these two methods in Jetpack Compose is where they are typically used.
    rememberLauncherForActivityResult is used in a Composable function to launch an activity and receive the result, 
    while registerForActivityResult is typically used in an Activity or Fragment to handle results for a specific request code.





















































































































































































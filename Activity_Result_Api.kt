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































































































































































































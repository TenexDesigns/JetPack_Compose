
We are Going to discus 2 Ways to Request Permissions in Jetpack Compose
Read More Here--->https://betterprogramming.pub/jetpack-compose-request-permissions-in-two-ways-fd81c4a702c


WE ARE GOING TO DISCUSS THE FIRST AND  SECOND WAY,


The First Way - Where we use the Accompanist permissions library
____________________________________________________________________________________________________________________________



The Accompanist permissions libray makes our lives easier.
We can use their permissionState and PermissionRequired composable to manipulate the result of requests even better. 

STEP 1
//_________________________________________________________________________________________________________________________________________
First, we are gonna add the dependency in the app-level build.gradle file:

implementation “com.google.accompanist:accompanist-permissions:0.23.1”

Note: At the of writing this article, 0.23.1 was the newest stable version. Check if there is a newer version.


We are gonna request the same Camera permission.

Step 2
//_________________________________________________________________________________________________________________________________________

First, we need to create permissionState which will track the state of our permission:

import android.Manifest

val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

Step 3 
//_________________________________________________________________________________________________________________________________________

Create A Composable to handle the permission and what to do incase persiions are granted or not.

we are gonna create CameraPermission composable and pass to it the permission state as a parameter so it can handle permission.
Inside this composable, we are using the accompanist’s PermissionRequired composable which takes in four parameters:
- permissionState: the state of our permission that we previously created
- permissionNotGrantedContent: content that should be shown after the permission is denied
- permissionNotAvailableContent: content that should be shown if the permission is not available
- content: Composable callback that will be called after the permission is granted
CameraPermission composable looks like this:

Note: we need to add ExperimentalPermissionsApi annotation because PermissionState is still experimental.


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPermission(
    permissionState: PermissionState,
) {
    PermissionRequired(
        permissionState = permissionState,
        permissionNotGrantedContent = { /* ... */ },
        permissionNotAvailableContent = { /* ... */ }
    ) {
        // Open Camera
      // Here is the composable function that will be called if the permission is ranted.
    }
}



Step 5
____________________________________________________________________________________________________________________________________________


So basically in our main composable, it looks like this:
In the button onClick callback we just launch a permission request with our permissionState, simple enough.


Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    CameraPermission(permissionState = permissionState)
    Button(
        onClick = {
            permissionState.launchPermissionRequest()
        }
    ) {
        Text(text = "Open Camera")
    }
}




REQUESTING MULTIPLE  PERMISSIONS
____________________________________________________________________________________________________________________________________________

Step 1
Note: type of permissionsState is now MultiplePermissionState, where previously it was PermissionState.

val permissionsState = rememberMultiplePermissionsState(
    permissions = listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
)


Step 2

Next is to create LocationPermissions composable which contains PermissionsRequired accompanist’s composable.
It is similar to PermissionRequired,the difference is only in the first parameter which accepts 
now MultiplePermissionState as the parameter.



@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermissions(
    multiplePermissionState: MultiplePermissionsState
) {
    PermissionsRequired(
        multiplePermissionsState = multiplePermissionState,
        permissionsNotGrantedContent = { /* ... */ },
        permissionsNotAvailableContent = { /* ... */ }
    ) {
        // Use location
    }
}

Step 3

And that’s it. In our main composable we just launch multiple permission requests:

val multiplePermissionState = rememberMultiplePermissionsState(
    permissions = listOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
)
LocationPermissions(multiplePermissionState = multiplePermissionState)
Button(
    onClick = {
        multiplePermissionState.launchMultiplePermissionRequest()
    }
) {
    Text(text = "Open Camera")
}















































































































The Second Method
____________________________________________________________________________________________________________________________

Our first permission that we are gonna request will be Camera permission.
To use the camera on our device, we need to request permission for it because it belongs to the “dangerous” ones right? 
  First, we need to add this permission to the manifest file like this:

<uses-permission android:name=”android.permission.CAMERA” />

After that, we can go to our Composable in which we need to request this permission and create a launcher for activity results like this:


val launcher = rememberLauncherForActivityResult(
    ActivityResultContracts.RequestPermission()
) { isGranted ->
    if (isGranted) {
        // Open camera
    } else {
        // Show dialog
    }
}


We create a launcher for activity results with which we are gonna launch an Android built-in dialog for permission requests.
Activity returns a boolean which tells us If permission is granted or not. If it is granted we open the camera and if not we
could show some info dialog or whatever you want. 
After that, we will add a button whose onClickcallback calls the checkAndRequestCameraPermission function.
This function looks like this:

fun checkAndRequestCameraPermission(
    context: Context,
    permission: String,
    launcher: ManagedActivityResultLauncher<String, Boolean>
) {
    val permissionCheckResult = ContextCompat.checkSelfPermission(context, permission)
    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
        // Open camera because permission is already granted
    } else {
        // Request a permission
        launcher.launch(permission)
    }
}



First, we check if the permission is already granted,
if it is we open the camera and if it is not we request it via the launcher. Finally our main composable looks like this:

Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    val context = LocalContext.current
        
    val permission = Manifest.permission.CAMERA
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Open camera
        } else {
            // Show dialog
        }
    }
    Button(
        onClick = {
            checkAndRequestCameraPermission(context, permission, launcher)
        }
    ) {
        Text(text = "Open Camera")
    }
}


Requesting  Multiple Permissions
______________________________________________________________________________________________

Now we are gonna request two permissions for location. We can request both of them at the same time and no need to request them one by one.
Permissions are ACCESS_COARSE_LOCATION and ACCESS_FINE_LOCATION. As we all know, the first step is to add them to our beloved manifest file:


<uses-permission android:name=”android.permission.ACCESS_COARSE_LOCATION” />
<uses-permission android:name=”android.permission.ACCESS_FINE_LOCATION” />

  
  Then we are gonna add a launcher for activity results and a button for requesting these permissions in the main Composable. Like this:


val permissions = arrayOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION
)
val launcherMultiplePermissions = rememberLauncherForActivityResult(
    ActivityResultContracts.RequestMultiplePermissions()
) { permissionsMap ->
    val areGranted = permissionsMap.values.reduce { acc, next -> acc && next }
    if (areGranted) {
        // Use location
    } else {
        // Show dialog
    }
}
Button(
    modifier = Modifier.padding(top = 30.dp),
    onClick = {    
        checkAndRequestLocationPermissions(
            context,
            permissions,
            launcherMultiplePermissions
        )
    }
) {
    Text(text = "Open Camera")
}



Now we have an array of permissions and a launcher activity that is requesting multiple permissions.
This activity is gonna show us a built-in dialog that requests every permission that we need.
It returns a map of String (permission name) as a key and Boolean (granted or not) as a value.
Function checkAndRequesstLocationPermissions looks like this:


fun checkAndRequestLocationPermissions(
    context: Context,
    permissions: Array<String>,
    launcher: ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>>
) {
    if (
        permissions.all {
            ContextCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    ) {
        // Use location because permissions are already granted
    } else {
        // Request permissions
        launcher.launch(permissions)
    }
}



It will check every permission if it is granted or not.
If all of them are granted we can use location, and if not we are gonna request those that we need.










































































































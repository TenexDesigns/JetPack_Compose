There are a lot of apps that contain TopAppBar, Drawer, Floating Action Button, BottomAppBar,Snackbar.
While you can individually set up all of these in an app but takes a lot of setups. 
 The Scaffold provides slots for a TopBar, BottomBar, SnackBar, FloatingActionBar, Drawer.
Jetpack Compose provides Scaffold Composable which can save a lot of time. It’s like a prebuilt template.
In this article, we will see how to set up Scaffold in android with Jetpack Compose.
We will be building a basic app that will demonstrate the Scaffold composable, here is a video showing the app.


HERE WE ARE GOING TO CREATE THE TopAppBar, Drawer, Floating Action Button, BottomAppBar and then wrap them in the scaffold



THE BOTTTOM BAR

@Composable
fun BottomBar() {
    // BottomAppBar Composable
    BottomAppBar(
        backgroundColor = Color(0xFF0F9D58)
    ) {
        Text(text = "Bottom App Bar", color = Color.White)
    }
}


THE DRAWER


@Composable
fun Drawer() {
    // Column Composable
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        // Repeat is a loop which
        // takes count as argument 
        repeat(5) { item ->
            Text(text = "Item number $item", modifier = Modifier.padding(8.dp), color = Color.Black)
        }
    }
}


THE TOPBAR
/ A function which will receive a 
// callback to trigger to opening the drawer
@Composable
fun TopBar(onMenuClicked: () -> Unit) {
  
    // TopAppBar Composable
    TopAppBar(
        // Provide Title
        title = {
            Text(text = "Scaffold||GFG", color = Color.White)
        },
        // Provide the navigation Icon (Icon on the left to toggle drawer)
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                  
                // When clicked trigger onClick 
                // Callback to trigger drawer open
                modifier = Modifier.clickable(onClick = onMenuClicked), 
                tint = Color.White
            )
        },
        // background color of topAppBar
        backgroundColor = Color(0xFF0F9D58)
    )
}


THE BODY

@Composable
fun Body() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Body Content", color = Color(0xFF0F9D58))
    }
}


HERES WHERE WE WORK WITH THE SCAFFOLD

Since we have already created all the components, the Scaffold code will be pretty simple and self-explanatory.

@Composable
fun ScaffoldExample() {

	// create a scaffold state, set it to close by default
	val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

	// Create a coroutine scope. Opening of
	// Drawer and snackbar should happen in
	// background thread without blocking main thread
	val coroutineScope = rememberCoroutineScope()

	// Scaffold Composable
	Scaffold(
		
		// pass the scaffold state
		scaffoldState = scaffoldState,
		
		// pass the topbar we created
		topBar = {
			TopBar(
				// When menu is clicked open the
				// drawer in coroutine scope
				onMenuClicked = {
					coroutineScope.launch {
						// to close use -> scaffoldState.drawerState.close()
						scaffoldState.drawerState.open()
					}
				})
		},
		
		// pass the bottomBar
		// we created
		bottomBar = { BottomBar() },
		
		// Pass the body in
		// content parameter
		content = {
			Body()
		},
		
		// pass the drawer
		drawerContent = {
			Drawer()
		},

		floatingActionButton = {
			// Create a floating action button in
			// floatingActionButton parameter of scaffold
			FloatingActionButton(

				onClick = {
					// When clicked open Snackbar
					coroutineScope.launch {
						when (scaffoldState.snackbarHostState.showSnackbar(
							// Message In the snackbar
							message = "Snack Bar",
							actionLabel = "Dismiss"
						)) {
							SnackbarResult.Dismissed -> {
								// do something when
							// snack bar is dismissed
							}

							SnackbarResult.ActionPerformed -> {
							// when it appears
							}
						}
					}
				}) {
				// Simple Text inside FAB
				Text(text = "X")
			}
		}
	)
}

Now call this composable from setContent in Mainactivity class



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            Surface(color = Color.White) {
                // Scaffold we created
                ScaffoldExample()
            }         
        }
    }
}



































































































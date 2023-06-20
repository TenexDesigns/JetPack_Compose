1.Data_Model.kt:   ---> Define The Model of the datat to be recived
data class PostResponse(
    val id: String,
    val userId: String,
    val title: String,
    val body: String
)

  
2.Post_Service.kt:   --> Create an Interface with the annotatations to the api routes you want to connect to, The endpont 'posts' in @Get('posts'), is added to the url in the service bulder

interface PostService {
    @GET("posts")
    suspend fun getPostList(): Response<List<PostResponse>>
}



3.Service_Builder.kt:   --> Define a service builder objet that will Instanciet retrofit and map the endponts from the interface to the URL

object ServiceBuilder {
    private const val URL = "https://jsonplaceholder.typicode.com"

    private val okkhttp = OkHttpClient.Builder()
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okkhttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}


4.View_Model.kt:  --> This is where wefetch the data from the api and expose it so that it can be used by composable functions

  //View_Model.kt
class PostViewModel : ViewModel() {
    private val _postList = MutableLiveData<List<PostResponse>>()

    var errorMessage: String? by mutableStateOf("")
    val postList: LiveData<List<PostResponse>>
        get() = _postList

    fun getPostLists() {
        viewModelScope.launch {
            val postService = ServiceBuilder.buildService(PostService::class.java)
            try {
                val response = postService.getPostList()
                if (response.isSuccessful) {
                    _postList.value = response.body()
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }


}






5.Display_data.kt:  - Here we create an instance of the View Model and Consume the data received.

//Display_data.kt
@Composable
fun Display() {
    // Get a reference to the ViewModel
    val postViewModel = viewModel<PostViewModel>()

    // Fetch the data when the Display composable is launched
    LaunchedEffect(Unit) {
        postViewModel.getPostLists()
    }
    val postList = postViewModel.postList.observeAsState(initial = emptyList())

    // Display the posts
    LazyColumn {
        items(postList.value) { post ->
            Text(text = post.title, fontSize = 24.sp, modifier = Modifier.padding(8.dp))
            Text(text = post.body, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}















THE CHANGES MADE ARE THESE ONES
***************************************************************************************************************************

  In the given context, the code is using mutable state (mutableStateListOf<PostResponse>()) to hold the list of posts in the PostViewModel. However, if you want to use LiveData instead, you can make the following modifications:

Update the import statements:
kotlin
Copy code
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
Replace the _postList variable declaration with a MutableLiveData object:
kotlin
Copy code
private val _postList = MutableLiveData<List<PostResponse>>()
Update the postList property to return a LiveData instead of a direct list:
kotlin
Copy code
val postList: LiveData<List<PostResponse>>
    get() = _postList
Update the getPostLists() function to set the value of the MutableLiveData:
kotlin
Copy code
fun getPostLists() {
    viewModelScope.launch {
        val postService = ServiceBuilder.buildService(PostService::class.java)
        try {
            val response = postService.getPostList()
            if (response.isSuccessful) {
                _postList.value = response.body()
            }
        } catch (e: Exception) {
            errorMessage = e.message.toString()
        }
    }
}
Finally, update the Display() composable to observe the postList LiveData:
kotlin
Copy code
@Composable
fun Display() {
    val postViewModel = viewModel<PostViewModel>()

    LaunchedEffect(Unit) {
        postViewModel.getPostLists()
    }

    val postList = postViewModel.postList.observeAsState(initial = emptyList())

    LazyColumn {
        items(postList.value) { post ->
            Text(text = post.title, fontSize = 24.sp, modifier = Modifier.padding(8.dp))
            Text(text = post.body, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
By making these changes, the postList in the PostViewModel will be exposed as a LiveData object, allowing you to observe its changes
  in the Display() composable using observeAsState(). This way, the UI will automatically update whenever the value of postList changes.

















..

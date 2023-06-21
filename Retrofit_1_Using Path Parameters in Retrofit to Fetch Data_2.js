
CODE EXPLAINED
************************************************************************************************8

To use path parameters in the above code, you need to make a few changes in the PostService interface and the PostViewModel. Here's how you can do it:

Update the PostService interface to include a path parameter. Replace the @GET("posts") annotation with @GET("posts/{id}") and add a parameter to the function getPostList():
interface PostService {
    @GET("posts/{id}")
    suspend fun getPostList(@Path("id") id: String): Response<PostResponse>
}
Update the getPostLists() function in the PostViewModel class to accept an id parameter and pass it to the postService.getPostList() function:
fun getPostLists(id: String) {
    viewModelScope.launch {
        val postService = ServiceBuilder.buildService(PostService::class.java)
        try {
            val response = postService.getPostList(id)
            if (response.isSuccessful) {
                _postList.value = listOf(response.body()!!)
            }
        } catch (e: Exception) {
            errorMessage = e.message.toString()
        }
    }
}
Update the Display() composable function to accept an id parameter and pass it to the postViewModel.getPostLists() function:
@Composable
fun Display(id: String) {
    // Get a reference to the ViewModel
    val postViewModel = viewModel<PostViewModel>()

    // Fetch the data when the Display composable is launched
    LaunchedEffect(id) {
        postViewModel.getPostLists(id)
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
Now you can use the Display() composable function with a path parameter like this:

Display(id = "1")
This will fetch and display the post with the specified ID.




    
The code will Loook something like this
************************************************************************************************8


Sure! Heres the modified code with the changes suggested:

1.Data_Model.kt:

data class PostResponse(
    val id: String,
    val userId: String,
    val title: String,
    val body: String
)

  
2.Post_Service.kt:

interface PostService {
    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): Response<PostResponse>
}



3.Service_Builder.kt:

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


4.PostViewModel.kt:

class PostViewModel : ViewModel() {
    private val _postList = MutableLiveData<List<PostResponse>>()

    var errorMessage: String? by mutableStateOf("")
    val postList: LiveData<List<PostResponse>>
        get() = _postList

    fun getPostById(postId: Int) {
        viewModelScope.launch {
            val postService = ServiceBuilder.buildService(PostService::class.java)
            try {
                val response = postService.getPostById(postId)
                if (response.isSuccessful) {
                    _postList.value = listOf(response.body())
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}


5.Display_data.kt:

@Composable
fun Display(postId: Int) {
    val postViewModel = viewModel<PostViewModel>()

    LaunchedEffect(Unit) {
        postViewModel.getPostById(postId)
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
You can now use the Display() composable function by passing the desired postId as an argument,
  and it will fetch and display the post with the given ID. For example:


Display(postId = 1)
Make sure to update the imports in the respective files to include the necessary dependencies.



  

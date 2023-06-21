Query parameters - Are used when you want to sort or filter items based oncertain condtion

https://workers.com/doctors?count=3
https://workers.com/doctors?count=3&country=india
https://workers.com/doctors?occupation=dentist


When You have One Querry Paramter , all you neeed to do is just change the Interface


To use query parameters in the above code, you need to make a few changes in the PostService interface and
   the PostViewModel. Heres how you can do it:

1.Update the PostService interface to include a query parameter. Add a @Query annotation to the getPostList() function,
   specifying the name of the query parameter:

interface PostService {
    @GET("posts")
    suspend fun getPostList(@Query("userId") userId:Int): Response<List<PostResponse>>
}


2.Update the getPostLists() function in the PostViewModel class to accept a userId parameter and pass it to the postService.getPostList() function:
   
fun getPostLists(userId:Int) {
    viewModelScope.launch {
        val postService = ServiceBuilder.buildService(PostService::class.java)
        try {
            val response = postService.getPostList(userId)
            if (response.isSuccessful) {
                _postList.value = response.body()
            }
        } catch (e: Exception) {
            errorMessage = e.message.toString()
        }
    }
}

3.Update the Display() composable function to accept a userId parameter and pass it to the postViewModel.getPostLists() function:

@Composable
fun Display(userId: Int) {
    // Get a reference to the ViewModel
    val postViewModel = viewModel<PostViewModel>()

    // Fetch the data when the Display composable is launched
    LaunchedEffect(userId) {
        postViewModel.getPostLists(userId)
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



Now you can use the Display() composable function with a query parameter like this:

Display(userId = 1)
This will fetch and display the posts with the specified userId query parameter.


In the Display composable function, you can now pass the userId as an argument, which will be used as a query parameter to filter the results.

To use query parameters, simply add the @Query annotation to the appropriate parameter in the API interface method,
   and make sure to update the ViewModel method and the composable function accordingly.

Note: Ensure that you import the correct dependencies (@Query annotation and other required classes/interfaces) in the respective files.




THE FINAL cODE WILL LOOK SOMETHING LIKE THIS
   ***************************************************************************************************************************

1.Data_Model.kt:

data class PostResponse(
    val id: String,
    val userId: String,
    val title: String,
    val body: String
)

   
2.Post_Service.kt:

interface PostService {
    @GET("posts")
    suspend fun getPostList(@Query("userId") userId: String): Response<List<PostResponse>>
}



3.Service_Builder.kt:

object ServiceBuilder {
    private const val URL = "https://jsonplaceholder.typicode.com"

    private val okHttpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())

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

    fun getPostListByUserId(userId: String) {
        viewModelScope.launch {
            val postService = ServiceBuilder.buildService(PostService::class.java)
            try {
                val response = postService.getPostList(userId)
                if (response.isSuccessful) {
                    _postList.value = response.body()
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}


5.Display_data.kt:

@Composable
fun Display(userId: String) {
    val postViewModel = viewModel<PostViewModel>()

    LaunchedEffect(Unit) {
        postViewModel.getPostListByUserId(userId)
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

Now you can use the Display composable function by passing the userId as an argument.
   The userId will be used as a query parameter to fetch the post list filtered by the specified user ID.








































If you have more than one query paramter , you will have to use   QUERY MAP




//Post_Service.kt
interface PostService {
   @GET("posts")
    suspend fun getPostList(@QueryMap filter : HashMap<String,String>): Response<List<PostResponse>>


    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): Response<PostResponse>

   
}












To create and Use retrofit Follow this steps


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

class PostViewModel : ViewModel() {
    private val _postList = mutableStateListOf<PostResponse>()
    var errorMessage: String by mutableStateOf("")
    val postList: List<PostResponse>
        get() = _postList

    fun getPostLists() {
        viewModelScope.launch {
            val postService = ServiceBuilder.buildService(PostService::class.java)
            try {
                val response = postService.getPostList()
                if (response.isSuccessful) {
                    _postList.clear()
                    _postList.addAll(response.body()!!)
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}



5.Display_data.kt:  - Here we create an instance of the View Model and Consume the data received.

@Composable
fun Display() {
    // Get a reference to the ViewModel
    val postViewModel = viewModel<PostViewModel>()

    // Fetch the data when the Display composable is launched
    LaunchedEffect(Unit) {
        postViewModel.getPostList()
    }

    // Display the posts
    LazyColumn {
        items(postViewModel.postList) { post ->
            Text(text = post.title, fontSize = 24.sp, modifier = Modifier.padding(8.dp))
            Text(text = post.body, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

Please note that this order assumes that each file is in its own separate file and is properly imported or referenced as required.





CODE EXPLANANTION
**********************************************************************************************************************************8


The code you provided demonstrates fetching and displaying data using Retrofit and Jetpack Compose. Let's break it down and explain each component:

1.Data_Model.kt:
This file defines the data model PostResponse which represents the structure of a post with properties such as id, userId, title, and body.

2.Post_Service.kt:
The PostService interface defines a Retrofit service endpoint for fetching posts. It contains a single suspended function getPostList() annotated
  with @GET("posts") which specifies the API endpoint. 
  This function returns a Response<List<PostResponse>> object, allowing you to handle the response from the API.

3.Service_Builder.kt:
The ServiceBuilder object is responsible for creating the Retrofit instance. It sets the base URL to "https://jsonplaceholder.typicode.com" and 
  configures the OkHttpClient and GsonConverterFactory. The buildService() function creates and returns the service instance using the provided service type.

4.View_Model.kt:
The PostViewModel is a ViewModel class that handles the fetching of posts and holds the state of the post list and error message.
  It uses mutableStateListOf to store the list of posts as a mutable state. The getPostLists() function makes an asynchronous API 
  call using the PostService defined in ServiceBuilder and updates the _postList accordingly. In case of an exception, it sets the errorMessage.

5.Display_data.kt:
The Display() composable function is responsible for displaying the fetched posts. It retrieves an instance of PostViewModel
  using the viewModel() function from the compose-ViewModel library. Inside the LaunchedEffect, it calls getPostLists() to initiate the API call
    and fetch the posts asynchronously. The LazyColumn is used to display the posts from the postViewModel.postList by iterating over each post 
      and rendering its title, body, and a spacer.

Overall, this code fetches the posts from the specified API endpoint using Retrofit and displays them in a Jetpack Compose UI.
    The ViewModel (PostViewModel) handles the API call and manages the state, while the Composable (Display()) retrieves the ViewModel and 
        displays the fetched posts using a LazyColumn.







CODE EXPLANANTION
**********************************************************************************************************************************8

          The provided code is an example of how to consume an API using Retrofit in Kotlin. Here is a breakdown of what each part of the code does:

1.Data_Model.kt: This file defines the data model for the response received from the API. 
             It uses a data class called PostResponse with properties id, userId, title, and body.
2.Post_Service.kt: This file defines an interface called PostService with a method getPostList() that makes a GET request to the posts endpoint of the API. 
             It uses the @GET annotation to specify the endpoint URL.
3.Service_Builder.kt: This file defines a singleton object called ServiceBuilder that is responsible for creating and configuring the Retrofit instance. 
             It sets the base URL of the API, adds a JSON converter factory, and sets an instance of OkHttpClient.
             It also provides a buildService() function that creates an instance of the specified service interface.
4.View_Model.kt: This file defines a ViewModel class called PostViewModel that fetches the data from the API and exposes it for consumption by composable 
            functions. It uses coroutines and the viewModelScope to launch a coroutine and make the API request.
            If the request is successful, it updates the _postList variable with the response data. If there is an error, it updates the errorMessage variable.
5.Display_data.kt: This file contains a composable function called Display() that displays the data received from the API.
            It uses the viewModel() function to get an instance of the PostViewModel and the LaunchedEffect() function to 
            fetch the data when the composable is launched. It then uses the LazyColumn composable to display each item in the postViewModel.postList.

 The notes provided are not entirely correct. The code is using Retrofit to consume an API, but it is not sending any data in the request body.
           It is making a GET request to the posts endpoint and receiving a list of PostResponse objects in the response body.

To send data in the request body using Retrofit, you can use annotations like @Body, @Field, @FieldMap, or @Part depending on the type of data you want to send. These annotations allow you to specify the format of the data and how it should be serialized.

If you want to send JSON data in the request body, you can use the @Body annotation and pass a RequestBody object. Here's an example:

interface APIService {
    @POST("/api/v1/create")
    suspend fun createEmployee(@Body requestBody: RequestBody): Response<ResponseBody>
}

val retrofit = Retrofit.Builder()
    .baseUrl("http://dummy.restapiexample.com")
    .build()

val service = retrofit.create(APIService::class.java)

val jsonObject = JSONObject()
jsonObject.put("name", "John")
jsonObject.put("salary", "5000")
jsonObject.put("age", "30")

val requestBody = jsonObject.toString().toRequestBody("application/json".toMediaTypeOrNull())

val response = service.createEmployee(requestBody)
This code defines an interface APIService with a method createEmployee() that makes a POST request to the /api/v1/create endpoint. The @Body annotation is used to specify that the request body should be serialized as JSON. The request body is created using a JSONObject and converted to a RequestBody using the toRequestBody() extension function.

You can also send form-encoded or multipart data using Retrofit. Form-encoded data is sent when you use the @FormUrlEncoded annotation and annotate each key-value pair with @Field. Multipart data is sent when you use the @Multipart annotation and annotate each part with @Part. You can refer to the Retrofit documentation for more details and examples on how to send different types of data in the request body using Retrofit.

Sources:




























  ...

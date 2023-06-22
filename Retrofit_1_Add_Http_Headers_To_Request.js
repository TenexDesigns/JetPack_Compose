To add HTTP headers to a request using Retrofit, you have two options: static headers and dynamic headers.

1.Static Headers:
Static headers have fixed key-value pairs that are initiated with the app startup.

interface PostService {

    @Headers("x-device-type:Android","x-foo:bar")           /Static Header - Remains the same for every request
    @GET("posts/{id}")                              
    suspend fun getPostById(@Path("id") postId: Int): Response<PostResponse>

      
}


2.Dynamic Headers:
Dynamic headers allow you to change the headers for different requests.
Retrofit provides flexibility to add dynamic headers by passing them as parameters in the API methods.
Heres an example of adding a dynamic header to a specific API call:



interface PostService {

    @GET("posts/{id}")                              /Dynamic Header - Changes With Every Request, and Needs to be passed on every request
    suspend fun getPostById(@Path("id") postId: Int,@Header("Accept-Language") Language:String): Response<PostResponse>

      
}
 **** If we combine them both, It will look something like this ****
    
   interface PostService {

    @Headers("x-device-type:Android","x-foo:bar")           /Static Header - Remains the same for every request
    @GET("posts/{id}")                              /Dynamic Header - Changes With Every Request, and Needs to be passed on every request
    suspend fun getPostById(@Path("id") postId: Int,@Header("Accept-Language") Language:String): Response<PostResponse>

      
}
    
    *******************************
    
    
    
    
class PostViewModel : ViewModel() {    
    var errorMessage: String? by mutableStateOf("")

    private val _postDetail = MutableLiveData<PostResponse>()
    val postDetail: LiveData<PostResponse>
        get() = _postDetail

    fun getPostById(postId:Int) {
        viewModelScope.launch {
            val postService = ServiceBuilder.buildService(PostService::class.java)
            try {
                val response = postService.getPostById(postId,"EN")
                if (response.isSuccessful) {
                    _postDetail.value = response.body()
                }
            } catch (e: Exception) {
                errorMessage1 = e.message.toString()
            }

        }
    }




4.In this example, the @Header annotation is used to add the "Authorization" header to the getSomeData API call. The value for the header is passed as a parameter to the method.
You can then provide the header value when making the API call:
   val apiService = retrofit.create(APIService::class.java)
   val token = "Your Authorization Token"

   val response = apiService.getSomeData(token)
In this example, the token value is passed as an argument to the getSomeData method, which will be used as the value for the "Authorization" header in the request.
Remember to use headers responsibly and follow the protocols of HTTP. Headers should not be used as a replacement for the request body.



































































































































..

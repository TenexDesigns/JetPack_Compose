Retrofit is a type-safe REST client for Android and Java, which abstracts many tasks involved in making API calls and handling responses.
  Some of the things Retrofit abstracts for us include:

Generating an implementation of the API interface: Retrofit generates an implementation of the interface you define for your API, 
  allowing you to call the API methods directly as if they were regular methods square.github.io.
Handling HTTP requests and responses: Retrofit takes care of making HTTP requests to the API endpoints and parsing the responses into the desired
  data objects square.github.io.
Converting request and response data: Retrofit allows you to use custom converters for serializing and deserializing data, such as JSON or XML.
    By default, it supports OkHttps ResponseBody and RequestBody types, but you can add converters like GsonConverterFactory for JSON or 
    other libraries for different formats square.github.io.
In the context of the given PostService interface:

interface PostService {
    @GET("posts")
    suspend fun getPostList(): Response<List<PostResponse>>
}
Retrofit generates an implementation of the PostService interface when you create a Retrofit instance and call the create() method:

val postService = ServiceBuilder.buildService(PostService::class.java)
This implementation takes care of making the HTTP GET request to the "posts" endpoint, handling the response, 
  and converting the response data into a list of PostResponse objects, all while abstracting the underlying complexity from the developer vogella.com.




  ...

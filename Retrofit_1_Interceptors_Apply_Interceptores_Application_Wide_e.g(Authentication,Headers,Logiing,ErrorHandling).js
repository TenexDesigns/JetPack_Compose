To Create A custom Interceptor and apply e.g Headers to an application wide level, do this 



1. In Your sercice Builder 



(A) Here we define an object than extends the Interceptor interface
    private val headerInterceptor = object: Interceptor{}

(B) Then  we overide functions in the interceptor interface that will hep us Get in the middle of the request response pipeline

 private val headerInterceptor = object: Interceptor{
override fun intercept(chain: Interceptor.Chain): Response {}
  
}

(C) Inside the overidern intercept function , we have a parameter called chain, This paramter enables us to intercept the request pipline and make changes to the request before it is sent to the seerver

 private val headerInterceptor = object: Interceptor{
override fun intercept(chain: Interceptor.Chain): Response {
    var request = chain.request()     // This is to get hold of the  request
    request = request.newBuilder()   // This is used to  enable us to add headers on application wide leve
                .addHeader("x-device-type", Build.DEVICE)   // This are the header
                .addHeader("Accept-Language", Locale.getDefault().language)  // This is a header to check the language
                .build()  // Build to fnlize th interceptor

    
}
  
}



(D)  Finaly , we have to make the request resume its journey on the pipline to  the server and make the interceptor return that response of the pipeline
 private val headerInterceptor = object: Interceptor{
override fun intercept(chain: Interceptor.Chain): Response {
    var request = chain.request()     // This is to get hold of the  request
    request = request.newBuilder()   // This is used to  enable us to add headers on application wide leve
                .addHeader("x-device-type", Build.DEVICE)   // This are the header
                .addHeader("Accept-Language", Locale.getDefault().language)  // This is a header to check the language
                .build()  // Build to fnlize th interceptor

    
}
   
    var response = chain.proceed(request)   //we have to make the request resume its journey on the pipline to  the server 
    return response                       //make the interceptor return that response of the pipeline
  
}




(E) We then Finaly have to  add this custom interceptor to the sevie builder

    // Create OkHttp Client
    private val okkhttp = OkHttpClient.Builder()
                                        .addInterceptor(headerInterceptor)  // We add our custom Interceptor
                                        .addInterceptor(logger)


2. The final Code Will Look Something like this 


/Service_Builder.kt
object ServiceBuilder {

    // Before release, change this URL to your live server URL such as "https://smartherd.com/"
    private const val URL = "https://jsonplaceholder.typicode.com" //1
    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

// Create a Custom Interceptor to apply Headers Application Wide
//val headerInterceptor = Interceptor { TODO("Not yet implemented") }

    private val headerInterceptor = object: Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request.newBuilder()
                .addHeader("x-device-type", Build.DEVICE)
                .addHeader("Accept-Language", Locale.getDefault().language)
                .build()

            var response = chain.proceed(request)
            return response
            TODO("Not yet implemented")
        }


    }





    // Create OkHttp Client
    private val okkhttp = OkHttpClient.Builder()
                                        .addInterceptor(headerInterceptor)
                                        .addInterceptor(logger)

                                         //2
    // Create Retrofit Builder
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okkhttp.build())

    // Create Retrofit Instance
    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}











To create a custom interceptor in Retrofit for application-wide functionality such as adding headers, handling authentication, logging, and error handling, you can follow these steps:
*********************************************************************************************


To create a custom interceptor in Retrofit for application-wide functionality such as adding headers,
  handling authentication, logging, and error handling, you can follow these steps:

1.Create a custom class that implements the Interceptor interface provided by OkHttp. 
This class will handle intercepting the requests and responses. Here's an example implementation that adds headers to every request:

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("HeaderName", "HeaderValue")
            .build()

        return chain.proceed(modifiedRequest)
    }
}

2.Modify the service builder in your application to include the custom interceptor.
You can add it to the OkHttpClient.Builder using the addInterceptor() method. Here's an example:

object ServiceBuilder {
    private const val BASE_URL = "https://your-api-url.com/"

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(CustomInterceptor()) // Add your custom interceptor here

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}


3.Handle authentication:
To handle authentication, you can modify the custom interceptor to add authentication headers based 
on your authentication mechanism. For example, you can add an authentication token obtained from a login process.
Heres an example of modifying the custom interceptor to handle authentication:

class CustomInterceptor(private val authToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $authToken")
            .build()

        return chain.proceed(modifiedRequest)
    }
}

4.Logging:
For logging purposes, you can utilize the HttpLoggingInterceptor provided by OkHttp. 
It logs the request and response information. Heres an example of modifying the custom interceptor to include logging:
kotlin
Copy code
class CustomInterceptor : Interceptor {
    private val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("HeaderName", "HeaderValue")
            .build()

        val response = chain.proceed(modifiedRequest)

        // Logging request and response
        logger.log(originalRequest, response)

        return response
    }
}


5.Error handling: 
Retrofit provides a Callback interface to handle asynchronous requests and responses.
You can handle errors within the onFailure callback. Additionally, you can customize error handling based on HTTP response codes
using Retrofits Response object. Here's an example of handling errors:
kotlin
Copy code
val apiService = ServiceBuilder.buildService(ApiService::class.java)
val call = apiService.getPosts()

call.enqueue(object : Callback<List<PostResponse>> {
    override fun onResponse(
        call: Call<List<PostResponse>>,
        response: Response<List<PostResponse>>
    ) {
        if (response.isSuccessful) {
            val posts = response.body()
            // Handle successful response
        } else {
            // Handle unsuccessful response
        }
    }

    override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
        // Handle network or request failure
    }
})
Ensure that you adjust the code to match your specific requirements, including the header names, values,
  authentication mechanism, logging level, and error handling logic.






























































































..

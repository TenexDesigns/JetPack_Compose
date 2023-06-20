To log HTTP requests and responses using Retrofit with Kotlin, you can use the HttpLoggingInterceptor provided by OkHttp. Follow these steps to set up logging for your Retrofit instance:

1.Add the required dependencies to your build.gradle file:
    implementation 'com.squareup.okhttp3:okhttp:5.0.0-alpha.1'
    implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.1'

2.Create an instance of HttpLoggingInterceptor and set the desired log level:

    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)


3.Add the logging interceptor to the OkHttpClient:

val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
  



4.Use the OkHttpClient with logging enabled when creating the Retrofit instance:

   private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okkHttpClient.build())







THE FINAL CODE WILL LOOK LIKE THIS
***********************************************************************************************8


//Service_Builder.kt
object ServiceBuilder {

    // Before release, change this URL to your live server URL such as "https://smartherd.com/"
    private const val URL = "https://jsonplaceholder.typicode.com" //1
  
    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    // Create OkHttp Client
    private val okkhttp = OkHttpClient.Builder()
                                      .addInterceptor(logger)  //aDD THE  LOGGER

                                         //2
    // Create Retrofit Builder
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okkhttp.build())                             //okkhttp.build()  to build the loogger

    // Create Retrofit Instance
    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}




LOGGING INTERCEPTRO:LOG HTTP REQUEST AND RESPONSE
______________________________________________________________________________________________________________________________________

LOGGING : This using logs to intercept http requests and reponses

The logging interceptor requires this dependecy
implementation 'com.squareup.okhttp3:logging-interceptor:3.9.0'

Add this code in the Service builde

private val logger = HttpLoggingInterceptor().setLeve(TttpLogingInterceptor.level.Basic)// There foru different levels i.e BASIC,
private val Okhttp = OkHttpClient.Builder().addInterceptor(logger)                                                                                                                     BODY
                                                                                                                           HEADERS
                                                                                                                           NONE
          BASIC - REVEALS the follwing
                  Http Method
                  Request size
                  Response size
                  Status code
                
          HEADERS-REVEALS the follwing
                  Headers                                  
                  Http Method
                  Request size
                  Response size
                  Status code
                
          BODY- REVEALS the follwing
                  Request body
                  Response body
                  Headres
                  Http Method
                  Request size
                  Response size
                  Status code
                
          BASIC - REVEALS the follwing
                  Http Method
                  Request size
                  Response size
                  Status code
                








MORE EXPLAANNTION
______________________________________________________________________________________________________________________________________


To log HTTP requests and responses using Retrofit with Kotlin, you can use the HttpLoggingInterceptor provided by OkHttp. Follow these steps to set up logging for your Retrofit instance:

Add the required dependencies to your build.gradle file:
implementation 'com.squareup.okhttp3:okhttp:5.0.0-alpha.1'
implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.1'
Create an instance of HttpLoggingInterceptor and set the desired log level:
val loggingInterceptor = HttpLoggingInterceptor()
loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
Add the logging interceptor to the OkHttpClient:
val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()
Use the OkHttpClient with logging enabled when creating the Retrofit instance:
val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()
Now, your Retrofit instance will log both the request and response data in the Android Logcat howtodoinjava.com. The log level can be changed using HttpLoggingInterceptor.Level:

NONE: No logging.
BASIC: Logs request and response lines.
HEADERS: Logs request and response lines and their respective headers.
BODY: Logs request and response lines and their respective headers and bodies (if present) stackoverflow.com.
Remember to remove or set the log level to NONE in your production builds to avoid logging sensitive information.




MORE EXPLANANTION
**********************************************************

With the above changes, the OkHttp client in the ServiceBuilder is configured with an HttpLoggingInterceptor. The interceptor is set to HttpLoggingInterceptor.Level.BODY, which logs the request and response headers as well as the request and response bodies.

By adding this interceptor, you can easily monitor and debug your network calls by examining the log output.



























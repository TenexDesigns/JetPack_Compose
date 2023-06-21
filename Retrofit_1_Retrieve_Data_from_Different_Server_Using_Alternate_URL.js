To Do this You Need a diffreent interfavece class
  
1.  interface  MessageService {

    @GET
    fun getMessages(@Url anotherUrl:String): Response<String>



}



2. We are still Gouing to Use the same service Builder objet


//Service_Builder.kt
object ServiceBuilder {

    // Before release, change this URL to your live server URL such as "https://smartherd.com/"
    private const val URL = "https://jsonplaceholder.typicode.com" //1
    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    // Create OkHttp Client
    private val okkhttp = OkHttpClient.Builder()
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



3.We create  a new function in the view model to get the data from the url and put it in a a state and expose the satet



//View_Model.kt
class PostViewModel : ViewModel() {
  
    private val _messagefroUrl = MutableLiveData<String>()

    val MessageUrl: LiveData<String>
        get() = _messagefroUrl


  
    fun getMessage(){
        val messageService = ServiceBuilder.buildService(MessageService::class.java)
        try {
            val response = messageService.getMessages("http://google.com/messages")
            if (response.isSuccessful) {
                _messagefroUrl.value = response.body()
            }
        } catch (e: Exception) {
            errorMessage1 = e.message.toString()
        }

    }
}



  
4.Display the data



//Display_data.kt
@Composable
fun Display() {
    // Get a reference to the ViewModel
    val postViewModel = viewModel<PostViewModel>()

    // Fetch the data when the Display composable is launched
    LaunchedEffect(Unit) {
        postViewModel.getMessage()
    }
    val message = postViewModel.messageUrl.observeAsState(initial = "")
  
  Text(text= "The Message is ${message}")



}

  
  
  
  
  
  
  
  
  
  
  THE ABOVE CODE CAN BE WRITTEN ALSO LIKE THIS 
  **************************************************************************************************************************8
  
To retrieve data from a different server with an alternate URL using Retrofit, you can follow these steps:

1.Create a new interface for the alternate API endpoint:

interface MessageService {
    @GET
    suspend fun getMessages(@Url anotherUrl: String): Response<String>
}
In this case, the getMessages function accepts the URL as a dynamic parameter using the @Url annotation.
  
  
  
  

2.Use the existing ServiceBuilder object to build the service:

object ServiceBuilder {
    private val okHttpClient = OkHttpClient.Builder().build()

    private val builder = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())

    fun <T> buildService(serviceType: Class<T>, baseUrl: String): T {
        val retrofit = builder.baseUrl(baseUrl).build()
        return retrofit.create(serviceType)
    }
}
The buildService function in the ServiceBuilder class now accepts the baseUrl parameter to set the base URL for the alternate server.






3.Modify the ViewModel to use the new endpoint:

class PostViewModel : ViewModel() {
    private val _messageFromUrl = MutableLiveData<String>()
    val messageFromUrl: LiveData<String>
        get() = _messageFromUrl

    fun getMessage(url: String) {
        val messageService = ServiceBuilder.buildService(MessageService::class.java, url)
        viewModelScope.launch {
            try {
                val response = messageService.getMessages(url)
                if (response.isSuccessful) {
                    _messageFromUrl.value = response.body()
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
The getMessage function now accepts the url parameter to specify the alternate URL for the API endpoint.
The ServiceBuilder is used to create the service with the provided URL.






4.Display the data in the composables:

@Composable
fun Display(url: String) {
    val postViewModel = viewModel<PostViewModel>()

    LaunchedEffect(Unit) {
        postViewModel.getMessage(url)
    }

    val message = postViewModel.messageFromUrl.observeAsState(initial = "")

    Text(text = "The message is: $message")
}
  
  
The Display composable now accepts the url parameter. The getMessage function is called with the provided URL to fetch the data. 
The result is observed using observeAsState and displayed in the composable.

To use the code and retrieve data from a different server with an alternate URL, call the Display function with the desired URL:

val url = "https://example.com"
Display(url)
This will fetch the data from the specified server using the provided URL.
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


















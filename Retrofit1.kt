There are app we make that are native and can be used as they have all that they rquire.
But  for oue apps to be more expanded it has to connect to the intenert and aceess web services such as e.g apis giving images,
Our app sends this http reuest and the receiving web server send the http response.
How ever handling sending this https request and recenninging the http response in our app is very hard.
That is where our retefit libray comes in .


Retrofit is used to  handle the retrieve, update and delete of  the data from web services.

                                   http response                    
client  <--->   retrofit   <--->                  <------->   web services(webs erver)
                                   http request
                   


HERES WHAT WE WILL LEARN


HTTP fundamentals
Web services - create your own local web server
Retrofit - To get your app online. 



LETS GET STARTED

In the past there we some librays that we used to connect your app to the intennet and handle handle http requests
Examples in clude OkHTTP, HTTPurl ,retrofit and volly.
They all use BackGround Therads and are Assynchronous in nature.
How ever Retrofit stands out of all of this and by far is the best http libray

DISADVANTAGES OF httPURLcOONNECTION
Poor readbilty and less expressive
Lots of boilerpalte code
No built in support for parsing Json
You need to manage background threads manually
Poor resource managemmant

Volly Has many advantages 

But here are some disadvantages

Limited  rest specific features
Poor authentication layer
small comunnity 
meager documentation


INTRODUCTION TO RETROFIT

ADVANTAHGES

Expressive code with more abstraction
Manages resources efficiently
-Background threads
-Async calls and queues
-Automatic JSON parsing usng GSON libray
-Automatic error handling callbacks
-Built in user authenticatioon support

HOW TO USE RETROFIT
To useretrofit, you must have a webserver with web services


This section covers
HTTP fundamentals
-What is HTTP
-What is http request and response
-What are Http methods
Restful web service
-Core concepts 
-Server setup



HTTP UNDAMENTALS

Http request
Http response
Status code
How communication between client and server takes place.


HTTP -Hyper Text Transfer Protocol
It is an application level protocal for distributed,collarborative and hypermedia information sysytems.
Protocal means  rules
This rules are meant for  the client and server
You can consider http as a language for communication between the client and server.
The client sends a request as per the http standersns ,which the server understands. -HTTP request
The server receives the request and sends the response as per the http standernads ,in a way which the client can understand. -HTTP respone

 HOW DOES THE HTTP LOOK LIKE AND WHAT IS ITS STRUCTURE

HTTP REQUEST STRUCTURE

1-REQUEST LINE
The http  has request line 
The request line is amde up 
Method - e.g get ,post ,delete or update
URL - The location of the server that you want to communicate with
HTTP versoion -  which is just the version of the http
2- REQUEST HEADERS -(optinal)
This is optiona;
The request headers defines additional metadat fro your request
e.g what kind of data you are sending,what kind of response you are expecting ,the language you are using.
2- REQUEST BODY -(optional)
The body contains data that you want to sed to the server for processing e.g sending dta to be updated, created or added

JSON data for student object
e.g
{
  "name":"Joseph",
  "age":17
  

}

MAIN HTTP METHODS

GET - Retrieve a resource
POST - Addd a resource
PUT - Replace a resource
PATCH - Update parts of resource
DELETE -Remove a resource



EXAMPLE OF HTTP REQUEST

REQUEST LINE - POST     localhost/profile    HTTP/1/1

REQUEST HEADER   Content-Type:application/x-www-form-urlencoded  //Gives the data format of the  data being sent - In this case it is the form format
                 Accept-Language:en-us // sepcifies the language in which th data is being sent

REQUEST BODY - firstName=Same&lastName=Parker &dob=12/3/2001  //Finaly we can package the coresponding form fields and values in the request body and

This is the http request that the server receives.
On receiving this http request.The server creates a new user in the data base.It may also send a confirmation email to the user.
Once the http server has done this ,it sends a http response to the client 

STRUCTURE OF THE HTTP RESPONSE

The http response has a HTTP VERSUON  and a  STATUS CODE  on the request line
There many be some otional headers on the request header
In the request body we can even send a message to telll the user that the profile has been created succesfully.


STETUS CODES

Status Code Range                               meaning
100's                                            Informational
200's                                            Success
300's                                            Redirects
400's                                            Client Error
500's                                            Server error'

All of this status codes are sent to the client .In our case is the  mobile phone




WEB SERVICES

We have a client(mobile phone) and a web server
Inside the web server we have a web service
A web service is a program in the webserver that reads the http request ,process it and offer the hhtp response


  RESTFUL WEB SERVICE
What makes a web service restful

- It si estableshed through a stateless client-server relationship
- Thses services relie on http methods i.e GET PUT POST DELETE
- Restfull communication oocurs through structured and consistent URLs  e.g delete http:/google.com ,update http:/google.com . The url google.com remains constent.
- They can use diffferent data types to transfer information // Mostly json is used to transfer data.


GETTING STARTED WITH RETEROFIT

To get started with retrofit ,you need to ask user for permission to acess internent

 <uses-permission android:name="android.permission.INTERNET"/>

  
  Then you need to add the retrofit  and GSON dependeancy

    // retrofit

    implementation 'com.squareup.retrofit2:retrofit:2.9.0'

   // GSON
//Gson is used to convert the json received to data user can use ,and convert user data to json.
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'


STEPS INVOLVED IN MAKING THE RETROFIT WORK.

STEP 1
Make an interface

This interface will contain functions that will map to the endpoints urls of your web service
e.g the @GET
       getDestination()
       
       @DELETE
       deleteDEstination()
       
        
STEP 2
MAKE A SERVICE
You have to create a service that will help you call the functions in the the interface 
e.g
createService( <T> Service)
-> destinationService

STEP 3
As the last step.WITIN YOUR ACTVITY
You have to initialize your service in the activity then call the functions in the interface

e.g
destinationService.getDesination()




STEP 1--Make an interface
package com.smartherd.globofly.services
import com.smartherd.globofly.models.Destination
import retrofit2.Call
import retrofit@.http.GET


//  The purpose of this interface is to create functions that will map to our web service end point urls
//Our interface is useles unless we implememnt a class that instanciates this interface. That is wy we created the Service builder file
interface  DestinationServe {

	@GET("destination")
	fun getDestinationList():Call<List<Destination>>
}



       
STEP 2 MAKE A SERVICE


package com.smartherd.globofly.services


object ServiceBuilder{

    //When this url is combined with the value in our @GET method in the intercae ,we then we get a complete url e,g 'http://10.0.2.2:9000/destinations'
    private const val URL = 'http://10.0.2.2:9000/'

    // Create okHTTP Client
    //This client will hep us create the retrofit builder
    private val Okhttp = OkHttpClient.Builder()

    //CREATE RETROFIT BUILDER
    private val builder = Retrofit.Builder().baseUrl(url) //Here we pass the url that we created above
                                  .addConverterFactory(GSONConverterFactory.create())// This is used to convert the data received from json to data and data from app to json
                                  .client(okhttp.build())//Here we pass the okhhtp client we created above


    //In our activity we use this menthod to receive the interface that contains our methods

    fun <T> buildService( serviceType:class <T>): T {
        return retrofit.create(serviceType)

    }}


STEP THREE -> WITIN YOUR ACTVITY You have to initialize your service in the activity then call the functions in the interface




HERES HOW IT IS GOING TO BE IN OUR C=ACTVITY


class DestinationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_list)

                                                           //Here we pass the interface class
        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
                         //We use the above variable to aceess the get method in our interface class
        val requestCall = destinationService.getDestination()


        ///Here we use the enquuq method to make an asynchronous calll to our web service in the backthread
//        ther also other methods of the callback mrthod
//                e.g isExcuted - return boolrean if something is excuted
//        cancel - to cancel a request
//        isCancelled- return true if request was cancellled
//        excute-Excutes things on main thread ,e.g splach screen.But we really do hthis.
        requestCall.enqueue(object:CallBack<List<Destination>>){

            //Here we overide two functions.The on reponse and the onfailure method
            overide fun onResponse( call:Calll<List<Destination>>,response:Response<List<Destination>>){
                here we check if the reponse was suucsfull
                    if(response.isSuccesfull){
                        val destinationsList = response.body!! //Here we get the data that was sent
                        //Here we put the destinations receib=ved in an adapter to be displayed ,or recycler view
                        destiny_recycler_view.adapter = DestinationAdapter(destinationsList)
                    }
                    else if(response.code()==401){
                      
                      Toast.makeText(this@DestinationListActivity, "Your session expired",Toast.LENGHT_Long).show()
                    
                    } else{
                      Toast.makeText(this@DestinationListActivity, "failde to retrieve items",Toast.LENGHT_Long).show()
                      
                      
                    
                    }
                    
                    
                    HERES HOW WE HANDLE HTTP RESPONSE AND ERROE
                    If you receive a tststus code in the range of 200- 299
                    Then the response.isSuccesful is excuted
                    else Then the else bolcock is escuted.
                    We can even target specfic ststsus codes such as 401
                    
            }

//             This on failure is only excuted incase of network error or error when establishing connection with server
//           or error creating http request or error processing http response
            overide fun onFailure(call<List<Destination>>,t:Throwable){

            }
        }
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
                





HOW DO WE  RETRIEVE DATA FROM WEB SERVICE USING REQUEST PARAMETERS
______________________________________________________________________________________________________________________________________

This section covers
- Understanding request parameters
- Using Path parameters
- Using Query parameters
- Handling multiple query parameters by using querymap
- Requestinf resource from differnt web service



UNDERSTANDING REQUEST PARAMETES

www.smartherd.com/users/47 ---------> /47  e.g Here we have a url to go and get as user 47


www.smartherd.com/users?COUNT=3 ---------> count =3  Here we have a url with a questionn mark then a field name ans a field value
www.smartherd.com/users?OCCUPATION = DOCTOR   ----------> occupation=doctor


www.smartherd.com/users?count=3&country=india --------> count=3&country=india


ALL OF THESE SEGMENTATIONS YOU SEE ABOVE ARE ACTUALY REQUEST PARAMETERS.
They help a web server understand what a client is basicaly looking for.


CONSTRUCTING URL IN RESTROFIT

There are two ways of constructing retrofit url


PATHparameters
Wghere you add segments to a url
You use this if you want a particular resource
The example below retrieves a user who has a id of 47

E.G
www.smartherd.com/users/47 -



Query parameters
Where you add Strings to a url
Use this if you want to sort or filter items

e.g
www.smartherd.com/users?COUNT=3 /// This retrieves the first three users
www.smartherd.com/users?OCCUPATION = DOCTOR // This retrives uses whoses occuptaion is being a doctor


When you have lost of query parameter ,the  use a query map


www.smartherd.com/users?count=3&country=india 
This retrieves the first three uses who belong to inda






Using path parameters in retrofit
______________________________________________________________________________________________________________________________________



TO USE PATH PA RAMERS IN OUR RETROFIT ,GO TO THE INTERFACE CLASS

interface  DestinationServe {

	@GET("destination")
	fun getDestinationList():Call<List<Destination>>
	
	//HERES HOW TO USE PATH PARAMETERS
	@GET("destination/{id}")  //Here we add apart on our destiantion to the pathh of the id of our user
	fun getDestination(@Path("id")id:Int):Calll<Destination>  // Here we receive the ide fro the user in the id:Int ,then we pass this isd to the path,o that it can be added to the destination so that our url will look something like this http:??nase-url/destination/47
}




THEN IN OIR ACTIVITY WE CAN FET THE RESOURSE IN TH PATH BY




class DestinationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_list)
	
	//

        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.getDestination(ID) here we pass the id of the object we  desires to aceess
	    
	                                               //Here we are only returning one destination hence we did not put list
	            requestCall.enqueue(object:CallBack<Destination>){
                                                                               
            overide fun onResponse( call:Calll<Destination>,response:Response<Destination>){
                here we check if the reponse was suucsfull
                    if(response.isSuccesfull){
			    
                        val destinationsItem = response.body!!//Here we get the data that was sent
                    //Here we can consume the sent data
                        destiny_recycler_view.adapter = DestinationAdapter(destinationsList)
                    }
                    else if(response.code()==401){
                      
                      Toast.makeText(this@DestinationListActivity, "Your session expired",Toast.LENGHT_Long).show()
                    
                    } else{
                      Toast.makeText(this@DestinationListActivity, "failde to retrieve items",Toast.LENGHT_Long).show()
                      
                      
                    
                    }
                    











































































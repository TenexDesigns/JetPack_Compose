There are app we make that are native and can be used as they have all that they rquire.
But  for oue apps to be more expanded it has to connect to the intenert and aceess web services such as e.g apis giving images,
Our app sends this http reuest and the receiving web server send the http response.
How ever handling sending this https request and receinging the http response in our app is very hard.
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



















































































Query parameters - Are used when you want to sort or filter items based oncertain condtion

https://workers.com/doctors?count=3
https://workers.com/doctors?count=3&country=india
https://workers.com/doctors?occupation=dentist


When You have One Querry Paramter , all you neeed to do is just change the Interface


//Post_Service.kt
interface PostService {
   @GET("posts")
    suspend fun getPostList(@Query("country")country:String?): Response<List<PostResponse>>


    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): Response<PostResponse>

   
}




If you have more than one query paramter , you will have to use   QUERY MAP




//Post_Service.kt
interface PostService {
   @GET("posts")
    suspend fun getPostList(@QueryMap filter : HashMap<String,String>): Response<List<PostResponse>>


    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): Response<PostResponse>

   
}












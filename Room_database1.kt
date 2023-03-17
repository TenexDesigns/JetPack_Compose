Sure, heres a step-by-step tutorial on how to use Room Database in your Kotlin Android app:

Add the dependencies
Add the Room dependencies to your apps build.gradle file.
You can add them by adding the following lines to the dependencies section of your apps build.gradle file:


Add Dependencies
_____________________________________________________________________________________________________________________________________________________
dependencies {
    def room_version = "2.4.0"

    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:$room_version"

    // optional - RxJava2 support for Room
    implementation "androidx.room:room-rxjava2:$room_version"

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation "androidx.room:room-guava:$room_version"

    // optional - Testing Room migrations
    androidTestImplementation "androidx.room:room-testing:$room_version"
}




Create an Entity Class
_____________________________________________________________________________________________________________________________________________________


Create the Entity class
Create a Kotlin data class that represents the entity for your table.
An entity represents a table in your database. Heres an example of a simple entity class:

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val name: String,
    val age: Int
)



Create DAO interface
_____________________________________________________________________________________________________________________________________________________
Create the DAO interface
Create a Kotlin interface that defines the methods to access your entity in the database.
A DAO provides a way to interact with the data in your database. Heres an example of a simple DAO interface:



@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}








Crete the Database Class
_____________________________________________________________________________________________________________________________________________________

Create the Database class
Create a Kotlin abstract class that extends RoomDatabase and defines the entities and DAOs for your database.
Heres an example of a simple database class:


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}




Initialize the database
_____________________________________________________________________________________________________________________________________________________

Initialize the Database
Create a singleton instance of your database by using the Room.databaseBuilder() method.
Heres an example of how to initialize your database:

val appDatabase = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java, "my-database-name"
).build()





Use the Database
_____________________________________________________________________________________________________________________________________________________

Now that youve set up your database, you can use it to interact with your data.
Heres an example of how to insert a user into the database:


val user = User(id = 1, name = "John", age = 30)
appDatabase.userDao().insertUser(user)


And heres an example of how to retrieve all users from the database:

val users = appDatabase.userDao().getAllUsers()




Thats it! You now have a basic understanding of how to use Room Database in your Kotlin Android app. 
Of course, theres a lot more you can do with Room, including handling relationships between entities,
using LiveData and RxJava, and more.
But this should be enough to get you started.

































































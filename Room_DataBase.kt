Data from the app can be saved on users’ devices in different ways.
We can store data in the user’s device in SQLite database, shared preferences, Shared storage and App-specific storage.
In this article, we will take a look at saving data, reading, updating, and deleting data in Room Database on Android. 
We will perform CRUD operations using Room Database on Android. 
In this article, we will take a look at performing CRUD operations in Room Database in Android. 


What is Room? 
  
Room is a persistence library that provides an abstraction layer over the SQLite database to allow a more robust database. 
With the help of room, we can easily create the database and perform CRUD operations very easily. 

Components of Room
The three main components of the room are 
Entity,
Database,
DAO. 


ENTITY

Entity is a modal class that is annotated with @Entity. 
This class is having variables that will be our columns and the class is our table.

DATABASE
It is an abstract class where we will be storing all our database entries which we can call Entities.

DAO

The full form of DAO is a Database access object
which is an interface class with the help of it we can perform different operations in our database.







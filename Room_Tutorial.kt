Room is a persistence library, part of the Android Jetpack.

Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

Room is now considered as a better approach for data persistence than SQLiteDatabase.
It makes it easier to work with SQLiteDatabase objects in your app, decreasing the amount of boilerplate code
and verifying SQL queries at compile time.


WHY USE ROOM?
  
Compile-time verification of SQL queries. each @Query and @Entity is checked at the compile time,
that preserves your app from crash issues at runtime and not only it checks the only syntax, but also missing tables.
Boilerplate code
Easily integrated with other Architecture components (like LiveData)



MAJOR PROBLEMS WITH SQLITE USAGE ARE?

There is no compile-time verification of raw SQL queries. 
For example, if you write a SQL query with a wrong column name that does not exist in real database 
then it will give exception during run time and you can not capture this issue during compile time.

As your schema changes,you need to update the affected SQL queries manually.
This process can be time-consuming and error-prone.

You need to use lots of boilerplate code to convert between SQL queries and Java data objects (POJO).

DIFFERNCES BETWEEN SQLITE AND ROOM

In the case of SQLite, There is no compile-time verification of raw SQLite queries.
But in Room, there is SQL validation at compile time.

You need to use lots of boilerplate code to convert between SQL queries and Java data objects. 
But, Room maps our database objects to Java Object without boilerplate code.

As your schema changes, you need to update the affected SQL queries manually. Room solves this problem.

Room is built to work with LiveData and RxJava for data observation, while SQLite does not.


Room has three main components of Room DB :

Entity
Dao
Database




ENTITY

Represents a table within the database. 
Room creates a table for each class that has @Entity annotation,
the fields in the class correspond to columns in the table.
Therefore, the entity classes tend to be small model classes that don’t contain any logic.



DAO

DAOs are responsible for defining the methods that access the database. 
In the initial SQLite, we use the Cursor objects. 
With Room, we don’t need all the Cursor related code and can simply define our queries using annotations in the Dao class.
This is the place where we write our queries using annotations in the Dao class..


DATA BASE

Contains the database holder and serves as the main access point for the underlying connection to your app’s  data.










Before Jetpack Compose, we used to create a RecyclerView and an Adapter to show a large set of lists.
Now, we can use LazyColumn or LazyRow to show a large set of lists vertically or horizontally with few
lines of code as we will demonstrate in this story.

IN OUR EXAMPLE WE ARE GOING TO BE DISPPLAYING DATA FROM A DATA CLASS
 A data class is a class that we can use to just create objects with same values 
e.g  data class Person (val name:String,val age:Int, val id:Int)
We can use this data class to make a objects that will have the values of name,age and id 
e.g
val personOne = Person("George",34,1)
val personTwo = Person("Eliud",24,2)
val personThree = Person("Boniface",14,3)
val personFour = Person("Allan",44,4)

print(personOne.name)  --->  will print  --> George
print(personTwo.name)  --->  will print  --> Eliud

NOW IN THIS PROGET WE WILL HAVE A PERSON DATA CLASS
data class Person(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int
)
THEN WE HAVE A FILE THAT WILL HAVE ARRAY OF ALL THE OBJECTS OF THE PERSON  CLASS THAT WE CREATE
This class has a method that returns an array of objects of person


class PersonRepository {
    fun getAllData(): List<Person> {
        return listOf(
            Person(
                id = 0,
                firstName = "John",
                lastName = "Doe",
                age = 20
            ),
            Person(
                id = 1,
                firstName = "Maria",
                lastName = "Garcia",
                age = 21
            ),
            Person(
                id = 2,
                firstName = "James",
                lastName = "Johnson",
                age = 22
            ),
            Person(
                id = 3,
                firstName = "Michael",
                lastName = "Brown",
                age = 23
            ),
            Person(
                id = 4,
                firstName = "Robert",
                lastName = "Davis",
                age = 24
            ),
            Person(
                id = 5,
                firstName = "Jenifer",
                lastName = "Miller",
                age = 25
            ),
            Person(
                id = 6,
                firstName = "Sarah",
                lastName = "Lopez",
                age = 26
            ),
            Person(
                id = 7,
                firstName = "Charles",
                lastName = "Wilson",
                age = 27
            ),
            Person(
                id = 8,
                firstName = "Daniel",
                lastName = "Taylor",
                age = 28
            ),
            Person(
                id = 9,
                firstName = "Mark",
                lastName = "Lee",
                age = 29
            ),
        )
    }
}


HERE WE CREATE A CARD/ HOLDER TO HOLDE THE INDIVIDUAL DATA OF EACH PERSON
THIS CARD WILL RECEIVE A PERSON DATA ITEM

@Composable
fun CustomItem(person: Person) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = Typography.h4.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName,
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Normal
        )
    }
}


THEN IN THE MAIN ACTIVITY ,WE HAVE  THE LIST COLUMN


class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TENEXAppTheme {
              //START READING THE CODE HERE
                val personRepository = PersonRepository()// Heree we create an instance of the repsoty class
                val getAllData = personRepository.getAllData() // Here we call the function that gets the array of persons we created

                LazyColumn(
                    contentPadding = PaddingValues(12.dp)
                ) {
                  //Here we use items to pass our arrray of items 
                    items(items = getAllData) { person ->  // Our item method goes throught each item in our array 
                        CustomItem(person = person) // Here we pass the person received to the card holde that we made earlierr
                    }
                }
            }
        }
    }
}










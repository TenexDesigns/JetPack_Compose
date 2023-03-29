 A suspending function is simply a function that can be "paused" and "resumed" at a later time.
They can execute a long running operation and wait for it to complete without blocking.

The syntax of a suspending function is similar to that of a regular function except for the addition of the suspend keyword.

However, suspending functions can only be invoked   within a coroutine 
or by another suspending function  which is in a couroutine scope...


HERE IS HOW TO CALL A SUSPENDING FUNCTION


//This function can only be called within a courtine scope
suspend fun getRemoteData(): String {
   
    return "Remote data"
}



Here we maake a coroutine scope and call our suspendinfg function




fun main(){
                //This makes this coroutine scope run on a background thread called IO
  CoroutineScope(Dispacher.IO).launch{
    
    val result  = getRemoteData()
    
    printLn(result) -----> This will print "Remote Data"
  
  
  }




}

___________________________________________________________________________________________________________________________________________

To invoke a suspending function, you can use the CoroutineScope.launch function in Kotlin to launch a coroutine that can call the suspending function.

Heres an example of how to invoke a suspending function in Kotlin:

import kotlinx.coroutines.*

suspend fun getRemoteData(): String {
    delay(1000) // Simulate network delay
    return "Remote data"
}

fun main() {
  // Since we have not used a coroutine scope to change the thred of this code,This means that this code is being excuted on the main thread
    runBlocking {
        val remoteData = async { getRemoteData() }
        println("Waiting for remote data...")
        val data = remoteData.await()
        println("Remote data received: $data")
    }
}








In programming, a suspend function (sometimes also called a "coroutine" or "async function") is a special type of function that can be paused 
and resumed at certain points during its execution, allowing other code to be executed in the meantime.

Suspend functions are typically used in asynchronous programming, where you need to perform some operation that may take a long time
to complete (such as a network request or file I/O), but you dont want your program to block and wait for that operation to complete before 
continuing to execute other code. Instead, you can use a suspend function to start the operation and then suspend the function until the operation is complete.
While the function is suspended, other code can be executed, such as handling user input or updating the user interface.








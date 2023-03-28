Couritinres help with runing code asynchronously.

HERE IS A LIFE EXAMPLE

In a hotel there is the main casheier called james who takes money from the buyers.
How ever ther may be a buyer called john who has bought too 450 items and serving this buyer will take jammes a long time to finish and will cause a hold up or not make the line move. Behinf john ther are other buyes with 2 or 3 three items. 
Now would it be fair to make this buyes with 2 or 3  items wait till John is finished being seviced.NO it is not fair  ,so what can be done is that another casher called emma is given to john to service his items
while the main casier continoius on with the line so that there is no hold up.Emman can be servicing John making the running og the supermaket faster.


Asynchronous code
The above can be said for asyncrous code.
Those actions that take a long time to be excuted can be performend on another  thread to avoid blocking the main thread and causing stagnation.
Runing code asynchrounusly means that it does not block the ain thereda or is excuted on a background thread.


Asynchronous code is code that does not block the execution thread while waiting for an operation to complete. 
Instead, it schedules the operation and continues executing other tasks while waiting for the result. This allows the code to be more responsive and efficient, 
especially when dealing with long-running operations such as network I/O, disk I/O or database queries.



COURROTINES
_______________________________________________________________________________________________________________________________________________

Coroutines are a lightweight concurrency framework introduced in Kotlin that allow developers to write asynchronous, 
non-blocking code in a more sequential and readable way. They simplify the process of performing long-running operations on the main thread, 
such as network or disk I/O, without blocking the UI and leading to a more responsive application.

Coroutines are essentially lightweight threads that can be launched within a coroutine scope,
such as a function or a coroutine builder like "launch", "async", or "runBlocking".
They can communicate with each other using channels, and can be cancelled at any time without affecting the entire process.

Heres an example of using a coroutine to perform a network request:

Noth--> This is the main thead // Dispachers.Main

Thses are background threds
// Dispachers.IO
// Dispachers.Default
// Dispachers.unconfined

note we use CoroutineScope("").launch{} to launch or start a couritine.


fun fetchUserData() {     
  // Here we launch the  coroutines within a coroutine scope using a coroutine builder like launch ,or async or runBlocking
    CoroutineScope(Dispatchers.IO).launch {// Then we change the code excution from the main thread to the IO threead usion the Dispachers>IO
        // Perform a network request on a background thread
        val result = makeNetworkRequest()

        // Update the UI with the result on the main thread
        withContext(Dispatchers.Main) {  //We use the withContect method to enable us to return To the main Thread .Here we return to the main thread using the Dispachers.Main
            updateUI(result) // Here we send the result to the updata funnction afetr the code excution has been done on the background thread i.e Dispacher>io thread
        }
    }
}


In this example, we create a new coroutine scope using CoroutineScope(Dispatchers.IO) to indicate that the coroutine should be launched on a background thread. 
Within the coroutine scope, we launch a new coroutine using the launch builder and perform a network request asynchronously using the makeNetworkRequest function.
Once the network request is complete, we update the UI with the result using withContext(Dispatchers.Main) to switch back to the main thread.

Heres another example of using a coroutine to perform a long-running computation:

suspend fun doLongComputation(): Int {
    return withContext(Dispatchers.Default) {
        // Perform a long-running computation on a background thread
        computeResult()
    }
}

fun performComputation() {
    CoroutineScope(Dispatchers.Main).launch {
        // Start the computation on a background thread
        val result = doLongComputation()

        // Update the UI with the result on the main thread
        updateUI(result)
    }
}


In this example, we define a suspend function called doLongComputation that performs a long-running computation using computeResult() and returns the result.
We use withContext(Dispatchers.Default) to indicate that the computation should be performed on a background thread.

In performComputation, we launch a new coroutine on the main thread using CoroutineScope(Dispatchers.Main).launch. 
We then call doLongComputation to start the computation on a background thread, and update the UI with the result using updateUI 
on the main thread once the computation is complete.

Overall, coroutines provide a simple and efficient way to write asynchronous code in Kotlin, without the need for callbacks,
threads or complex synchronization mechanisms. They can help simplify code and improve performance by allowing long-running operations
to be performed on a separate thread without blocking the main thread.




__________________________________________________________________________________________________________________________________________________________


In the above context, asynchronous code refers to code that doesnt block the execution thread while waiting for a long-running operation to complete.
Instead, it allows the thread to continue executing other tasks while the long-running operation is being processed in the background.

For example, in the first code sample I provided, the fetchUserData() function performs a network request using a coroutine launched on a background thread.
The network request is an asynchronous operation that could take some time to complete, but instead of blocking the execution thread and causing the UI to freeze, 
the coroutine allows the thread to continue running other tasks until the network request is complete.

Similarly, in the second code sample, the performComputation() function launches a coroutine on the main thread to perform a long-running
computation on a background thread using doLongComputation(). The computation is another example of an asynchronous operation 
that doesnt block the UI and allows the thread to continue running other tasks until its complete.

By using coroutines to write asynchronous code, we can avoid blocking the execution thread, improve the responsiveness of our application,
and ensure a smoother user experience. Coroutines provide a clean and easy-to-read way to perform long-running operations in the background
while keeping the main thread free to handle UI updates and user interactions.





-------------------------------------------------------------------------------------------
  
  In Kotlin, you can launch a coroutine using the launch function from the kotlinx.coroutines library. 
The launch function creates a new coroutine and launches it in the specified coroutine scope.

Here an example of launching a coroutine using the launch function within a function:

import kotlinx.coroutines.*

fun myFunction() {
    CoroutineScope(Dispatchers.Main).launch {
        // Code to be executed asynchronously
    }
}


In this example, we define a function called myFunction. Within myFunction, we create a new coroutine scope using CoroutineScope(Dispatchers.Main) to specify
that the coroutine should be launched on the main thread. 
We then call the launch function on the coroutine scope and provide a block of code to be executed asynchronously.

Any code within the block provided to launch will be executed asynchronously on the specified coroutine scope.
You can perform long-running operations, such as network or disk I/O, within the block without blocking the main thread and making your application more responsive.




LAUNCH ,ASYNC, RUNBLOCKING
// It is always recommended to use launch ,unless you want to use async to get a result ,or use runBlocking that blocks other courtines
_______________________________________________________________________________________________________________________________________________________________________

In the context of coroutines in Kotlin, launch, async, and runBlocking are coroutine builders that are used to start a new coroutine. 
Although they may seem similar at first, they have some important differences that make them suited to different use cases.

In the context of coroutines in Kotlin, launch, async, and runBlocking are different ways of creating and executing coroutines with distinct characteristics 
and use cases.

1.LAUNCH

launch is a coroutine builder that launches a new coroutine and immediately returns a Job instance representing that coroutine.
The coroutine runs in the specified coroutine scope and can be cancelled at any time using the returned Job instance. 
launch is typically used for fire-and-forget operations, where we dont care about the result of the coroutine.
Example:


fun main() {
    CoroutineScope(Dispatchers.Default).launch {
        // run the coroutine on the Default dispatcher
        println("Launching a coroutine on thread ${Thread.currentThread().name}")
    }
    Thread.sleep(1000L) // pause the main thread for 1 second
}



2.ASYNC 

async is a coroutine builder that launches a new coroutine and immediately returns a Deferred instance representing the result of that coroutine.
The coroutine runs in the specified coroutine scope and can be cancelled at any time using the returned Deferred instance.
async is typically used when we need to perform a computation asynchronously and return its result.

fun main() {
    val deferred = CoroutineScope(Dispatchers.Default).async {
        // run the coroutine on the Default dispatcher
        println("Performing a computation on thread ${Thread.currentThread().name}")
        return@async 42
    }
    Thread.sleep(1000L) // pause the main thread for 1 second
    val result = deferred.await() // wait for the coroutine to complete and get its result
    println("Result is $result")
}




3. RUN BLOCKING 

runBlocking is a function that creates a new coroutine scope and runs the specified block of code in that scope.
The coroutine runs on the thread calling runBlocking and blocks the calling thread until the coroutine completes. 
runBlocking is typically used in testing or main functions where we need to wait for the coroutine to complete before exiting the application.

fun main() = runBlocking {
    // create a new coroutine scope and run the code inside it
    println("Launching a coroutine on thread ${Thread.currentThread().name}")
}

Overall, launch, async, and runBlocking are all useful coroutine builders in different situations.
launch is used for fire-and-forget operations, async is used for performing computations asynchronously and returning their results,
and runBlocking is used for running code in a blocking manner in testing or main functions.

























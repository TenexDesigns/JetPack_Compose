Application and Activity context.


They are both instances of Context, but the application instance is tied to the lifecycle of the application,
while the Activity instance is tied to the lifecycle of an Activity.
Thus, they have access to different information about the application environment.

If you read the docs at getApplicationContext it notes that you should only use this if you need a context whose lifecycle 
is separate from the current context. This doesnt apply in either of your examples.

The Activity context presumably has some information about the current activity that is necessary to complete those calls.
If you show the exact error message, might be able to point to what exactly it needs.

But in general, use the activity context unless you have a good reason not to.




                                  Application | Activity | Service | ContentProvider | BroadcastReceiver

[Show a Dialog                            NO       YES        NO         NO                     NO
|Start an Activity                        NO       YES        NO         NO                     NO
Layout Inflation                          NO       YES        NO         NO                     NO
[Start a Service                          YES      YES        YES        YES                    YESO
[Bind to a Service                        YES      YES        YES        YES                    NO
|Send a Broadcast                        YES       YES        YES        YES                    YES
[Register BroadcastReceiver              YES       YES        YES        YES                    NO
[Load Resource Values                    YES       YES        YES        YES                    YES

 
 
 In General, Context means what we are talking about or the situation within which some event happens.
In Android it a context simply means the context of the current state of the application or object.
 Generally, we use it to get information regarding another part of your program (activity/application package).

 

There are few keypoint to understand about context : 

 It is the current state of the app.
 We can use context to get information about the activity/application.
 We can use it to access resources, databases and shared preferences.
 In android, activity/application both extend the Context class.
 
 
 
 
 
 
 
 In Android Application, we can find context almost everywhere and use it as we require.
 But using context in wrong can easily lead to memory leaks which can further lead to other issues.

 

In application, there are different type of context according to the place we are in.
 So to use it efficiently we need to understand both type of context.

 

There are essentially two types of context : 

Application Context
Activity Context
 

Let us get to know more about these two : 

 

1. Application Context : We can access it using getApplicationContext(). 
 It returns the context for the entire application (the process inside which all activity is running).
 If somewhere in the activity we need a context which is tied to the whole application lifecycle and not just the activity. 

But if you want the application class registered in your manifest, we should never call getApplicationContext() 
 because it necessarily may not be the application instance (example in case of test framework).
 The main difference between from this and other context is that it returns a global context 
 i.e. acitivity context may be destroyed or may be unavailable based on your activity lifecycle but the
 application context remains till the application exists so we can use this for notification or any other services for
 which the context is required for longer time.
 
 
 2. Activity Context : Activity context is associated with activity and will be destroyed once activity is destroyed.
 Activity Context has its own functionalities, some of them are : 
    
    * Load Resource Values,
    * Layout Inflation,
    * Start an Activity,
    * Show a Dialog,
    * Start a Service,
    * Bind to a Service,
    * Send a Broadcast,
    * Register BroadcastReceiver.
    
Activity class extends from "ContextThemeWrapper" which extends "ContextWrapper" and that one extends "Context".
 So we can use "this" to access the context in activity or ClassName wherever necessary. 
 
 
 There are mostly 3 main methods to access Context : 
    
 getContext() : returns the context of activity of which its linked
 getApplicationContext() : returns the context of application which has all the acitivities running inside.
 getBaseContext() : Its related to ContextWrapper which is created around already existing context and allow 
 us to modify its behaviour. 
    

So as we can see the context is tied to its component lifecycle and so we should consider before choosing one 
 otherwise its could lead us to memory leaks.

 

The main difference between Application and Activity Context is that Application Context is not related to UI.
 That means we shouldnt use application context for inflate a layout, start activity nor show an dialog.
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

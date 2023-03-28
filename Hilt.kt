Dependecies

  // Dependency Injection
    implementation "com.google.dagger:hilt-android:2.44"
    kapt "com.google.dagger:hilt-compiler:2.44"



Hilt application class

All apps that use Hilt must contain an Application class that is annotated with @HiltAndroidApp.

@HiltAndroidApp triggers Hilts code generation, including a base class for your application that serves as the application-level dependency container.

After doing this , we also neeed to go to the manifest and declare our application there

<application>
  android:name=".MyApplication"

<application/>
  
  
  NEXT WE NEED TO GO TO OUR MAINACTIVITY AND ANNOTET IT WITH THE FOLLOWING 

 
@AndroidEntryPoint  // This addds this class to the dagger graph , thus we can add dependecies to iit
class MainActivity : ComponentActivity() {
  
  
  
  
  DEPENDECY INJECTION
  _____________________________________________________________________________________________________________________


When it comes to dependecy injection, There are two types of injection that you can do

1- Field Injection - This is the simplar injection type. There is not thatmany limitations or work arounds to get it done .
2 - Constructor Injection - You definatly want to use constructor injection over field injection. This is beacuse you are passing parameters to the constructor.And when that object is instaciated ,you know what exactly it needs 
                          - It is also good for writing production code, since you know what the instanciated object needs
                         - It is also good for testing






// To mark this as something that is injectable or as a depencdey in hilt or dagger , we mark it with @Inject
class someClass @Inject constructor(){ // This is a class containing a function
  
  fun doAThing():String{
    return "Look I did something"
  
  }

}



  FIELED INJECTION

  
  @AndroidEntryPoint
class MainActivity : ComponentActivity() { 
  // Here we inject the someclass as a dependecy in the mainclassActvity 
  
  
  // Field injection
  @Inject lateinit var someClass:Someclass
  
  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState){
          
          // This means we can accessthe injected class and the functions it holds
          
          println(someclass.doAthing())   ---> This will print >> "Look I did a thing "
        
        
        
        }


        
        CONSTRUCTOR INJECTION
______________________________________________________________________________________________________________________________________________________________________


      // So what we are going to do is pass this class as a depencecy to the class hee below
      class SomeOtherClass @Inject constructor(){
        
        
        fun doSomeOtherThing() :String{
          
          return "Look I did some other thing !"
        
        
        }
      
      
      
      }
      
      
      // This class

 class someClass @Inject constructor(                              
   private val someOtherClass:SomeOtherClass                         THIS IS CONSTRUCTOR INJECTION //--> This is considred constructor injection
 
 ){ 
  
  fun doAThing():String{
    return "Look I did something"
  
  }
  
  
  fun doTheTHingInA():String{
  
  return  someOtherClass.doSomething()
  
  
  }

}
 
 
 
 
   @AndroidEntryPoint
class MainActivity : ComponentActivity() { 
  // Here we inject the someclass as a dependecy in the mainclassActvity 
  
  
  // Field injection
  @Inject lateinit var someClass:Someclass
  
  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState){
          
          // This means we can accessthe injected class and the functions it holds
          
          println(someclass.doAthing())   ---> This will print >> "Look I did a thing "
          println(someclass.dotheThingInA())   ---> This will print >> "Look I did some other  thing "
        
        
        
        }
      
      


      
      
      
      
      
      
      
      
      SCOPING IN HILT


______________________________________________________________________________________________________________________________________________________________________

      
      Hilt generateds different scopes 
      . Wen we use the @AndroidEnrtyPoint, Hild generates diffenent scopes for different components in our app.
      e.g our App Component gets SingkleTon scope.
      If you annotete a depency with singleton, it will live as long as the app is alive.
      other scopes
      (ViewModel)- This lives as long as view mode which lives longer than activity scope
      ActvityRetainedComponent = ActivityRetainedScope
      ActvityComponent = ActvityScope
      FragmentComponennt = Fragmennt scope 
      
      
      Here if you annotet a depency with e.g @Singleton , that depency will live as long as the app lives
      If you aannote a depencdecy with @ActvityRetainedScope , it will live as long as a view model lives 
      if you annotete a depencecy with @ActvityScoped ,it will live as long as a actvity lives.
      Here are the diffrent scopes.
      
      
         AndroidClass                        	Generated                               component	Scope
      
         Application	                        SingletonComponent	                    @Singleton
         viewModel                           	ActivityRetainedComponent	              @ActivityRetainedScope
         Activity	                            ActivityComponent                      	@ActivityScoped
         Fragment	                            FragmentComponent	                      @FragmentScoped
         View                               	ViewComponent                         	@ViewScoped
         Service	                            ServiceComponent	                      @ServiceScoped
                                                                                    This scopes are arranged in a hierachy where the higher scopes can be injected
                                                                                    downwards
                                                                                    But the lower scopes cannot be injected to the higher scopes.
                                                                                   This is because the top ones out live the one that is lower
                                                                                    So if I have a dependcy that is @AcivityScoped  --- I ca inject it to
                                                                                               @viewScoped ,@fraggmenscpod,@servicescoped
                                                                                              
                                                                                              
                                                                                              
                                                                                  e.g a view model(@ActivityRetained) can be injected into an application (@Singleton) since the activity outlives the viewmodel
                                                                                       But a view model(@ActivityRetained) can not be injected into a fragment(@FragmentScoped)  since the fragment lives a shortr span than the viewmodel
          
      
      













ERROR WHEN DOIUNG CONSTRUCTOR INJECTION
__________________________________________________________________________________________________________________________________________

      
      
       This comes up alot of of times you are building your data sources ,cache datas source,network data source  or any data sourece in your architecture
      even any kind og classs
      
      .What you do is stub out the functions in an interface and then implement those interaces in a class. Here is an example
      
      
      interface SomeInterface{
        
        fun getAThing():String                --What ever class extends or implements this interface must overide this function and ensure that it t=returns a string as indicted 
      
      }

      
      
      
      
      
      
      class someInterfaceImplemetation @Inject constructor():SomeInterface {
        
        overide fun getThing():String{
          
          return "A String"
        
        }
      
      }
      
      THEN WE MAY WANT TO DO CONSTRUCTOR INJECTION WITH THE ABOVE IMPLEMEMNTATION OF AN INTERFACE
      // This scenario comes up when building your cashing sources ,your network sources 
        //private val someOtherClassImplemetation:someInterface  // You can even build fakes for them for testing. This makes testing easier
      
 class someClass @Inject constructor(  
                            // Here this injected dependcy is of the type of the interface it extends
   private val someOtherClassImplemetation:someInterface                                           THIS IS CONSTRUCTOR INJECTION //--> This is considred constructor injection
 
 ){ 
   
   fun doAThing():String{
     return someInterfaceImplemetation.getThing()          This will give you a comple time errror 
                                                           You can not do constructor injection on an interface
   
   
   }
  

  
  
  }

}
      
      
      ____________*******************The second Isssue is if you try to do constructor injection with something tha you cont own e.g a thrid pary libray e.g GSon convert *****************



class someClass @Inject constructor(  
  
  you cant do this since you dont own this libray
                            
   private val gson:Gson                                           THIS IS CONSTRUCTOR INJECTION //--> This is considred constructor injection
 
 ){ 
   
 
   
   }
  

  
  
  }




































HILT DEPENDECY INJECTION      ---> The dependecies for this hilt are at the bootom of the page

There are two types of hilt dependecy injections



Field Injection - This is the simpler way to do it a there are not many work arounds required
Constructor INjection - THe best and most recommended way to do it.

//Fragments scope can look somthing like this

class Name;Fragment(){

}





//Doing this means that the scope of this is Application scope
@AndoirdEntryPoint /// This annotation states the entry point for you hilt dagger // Use this if you want a class to be ables to be injected
class MainActivity : ComponentActivity() {
  
  //This is field injection
  @Inject
  lateinit var someClass:SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SetContent(R.id.layout){
          
          //Field injection
          println(someclass.doThing())
          
          
          //Constructor injection
          //Then here we can use the class in the field injection to get our class form the contructor injection
          
          println(someClass.doSomethingElse())
        
        
        
        
        
        
        }


        
        //Here we create a class and we annotate it the the @Inject annotation
        
        
        class SomeClass @Inject constructor(){
          
          
          fun doAthing():String{
            return "Look I did a thing"
          
          }
        }
        
        
        

          
          
_________________________________________________________________________________________________________________________________________________-          
          
          THIS IS CONSTRUCTOR INJECTION//Use a constructor injection so as to know what those classes need
      //We use @Inject to identitfy the dependcy that is to be injected 
         
         
                                             //hERE WE INJECTED THE CLASS BELOW INTO THIS CLASS     
        class SomeClass @Inject constructor( private val someOtherClass:SomeOtherCLass){
          
          
          fun doAthing():String{
            return "Look I did a thing"
          
          }
          //hERE E CAN ACCESS THE FUNCTIONS OF THE CLASS BELOW
          
           fun doAthing():String{
            return someOtherClass.doAnotherThing()
          
          }
          
        
        
        
        }
        
        
        //tHIS IS THE CLASS WE WILL BE INJECTING TO THE FIRST ONE HERE ABOVE
        
        
       class someotherClass @Inject constructor(){
          
          
          fun doAnotherthing():String{
            return "Something else I did a thing"
          
          }
          
          
          
          
          
        
          
          
          
          
          
          
          
          
Scoping Using Hilt          
_________________________________________________________________________________________________________________________________________________-          
          Singleton Scope
         
         When you use hitl the AppComponent is automaticaly given the Singleto Scope   --> AppComponent = Singleton scope
         The singleton scope will be alive aslong as the app is alive.
         So if you anotete a dependecy with singleton.that depencdecy will be alive as long as the application is alive.
  
         
         ActivityRetainedComponent(ViewModel)
         
         Where ActivityRetainedComponent = ActivityRetainedScope
         This scope will stay longer than an activity but can be destroyed incase there is need for memeory
          
          
          Activity Scope
         This scope will live as long as a activity.
         If an activity dies ,so does this scope
         ActivityComponent = Actvity Scope
         
         
         Fragment scope
         View scope
         Service scope
          
          
          
         
         
         HERES AN EXAMPLE
         
         
         @Singleton //This ensures that this dependecy lives as long as th app is around        
        class SomeClass @Inject constructor(){
          
          
          fun doAthing():String{
            return "Look I did a thing"
          
          }
        }
        
        
        NOTE,
         yOU CAN NOT INJECT ANYTHING THAT IS NOT OF ITS OWN SCOPE
         I.e you can not inject a fragment scope into an actvity scope.
         This appplies to all scopes
         e.g you can only apply a fragmennt scope to a fragment scope
         
         
         but if you have some dependecy of a higher scope you can inject it into lomwer scopes,
         e.g an actvity scope can be injectted in to a fragment.
         
         AndroidClass                        	Generated                               component	Scope
         Application	                        SingletonComponent	                    @Singleton
         Activity                           	ActivityRetainedComponent	              @ActivityRetainedScoped
         ViewModel	                          ViewModelComponent	                    @ViewModelScoped
         Activity	                            ActivityComponent                      	@ActivityScoped
         Fragment	                            FragmentComponent	                      @FragmentScoped
         View                               	ViewComponent                         	@ViewScoped
         Service	                            ServiceComponent	                      @ServiceScoped
                                                                                    This scopes are arranged in a hierachy where the higher scopes can be injected
                                                                                    downwards
                                                                                    But the lower scopes cannot be injected to the higher scopes.
          
          
          
          
          
          
          
        
        
        



Chanleges when using hilt dependecy
_________________________________________________________________________________________________________________________________________________-          

You can not implement something using an interface
         
         class SomeClass
         @Inject
         constructor (
           private val SomeInterfaceImplementation:SomeInterface,//Dagget doen;t know how to implemnt hthe interface implemntattion
           private val gson:GSon //Likewise hit doent know how to implemmt the gson,which is part of a third party libarry.
         ){
           
           fun doAThing(){
             
             return "This is something from SomeInterfaceImplemntation.getAThing"
           
           
           }
           
         
         
         
         
         }
         
         
         
         
         
         
         
         
         
         
         class someInterfaceImplementation @Inject constructor() : SomeInterface{
          //You have to overide the fuction of the interface and make it wht you want it to to,in this case we made ,it retunr a string.
           overiride fun getAThing:String{
             return " a thing"
           
           }
         }
           
           //This is the interface
           interface someInterfcae{
             fun getAThing():String
           
           }
         
         
         You can not impliment thir part classes e.g gson
         
         
         
         
         TO SOLVE THIS PROBLES WE USE TWO
         @Provides -WHich is easuer and works in all cenaries
         @Binds- Which is more complex and doent always work in all scneials
         
         
_________________________________________________________________________________________________________________________________________________-          
         
         
         @PROVIDES
         
         
         
         
         
         
         
                  //There we plovide the scope of the hilt
         @InstllIn(ApplicationComponrnt::Class)
         @Module
         class MyModule{
           
           @Singleton//Here we use the identifier for the application scope
           @Provides
           fun provideSomeInterface():SomeInterface{
             
             return someInterfaceImplenttatio()
           }
         
         
         
         }
         















THESE ARE THE DEPENDCIES TO ENABLE HILT ,AND THE SPLASH API
___________________________________________________________________________________________________________________________________________________



         plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'dagger.hilt.android.plugin'
    id 'kotlin-kapt'
}

android {
    namespace 'com.example.tenexapp'
    compileSdk 33

    defaultConfig {
        applicationId "com.example.tenexapp"
        minSdk 24
        targetSdk 33
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
    buildFeatures {
        compose true
    }


    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
}

dependencies {

    implementation 'androidx.core:core-ktx:1.9.0'
    implementation "androidx.compose.ui:ui:1.3.3"
    implementation "androidx.compose.material:material:1.3.1"
    implementation "androidx.compose.ui:ui-tooling-preview:1.3.3"
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.0'
    implementation 'androidx.activity:activity-compose:1.6.1'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:1.3.3"
    debugImplementation "androidx.compose.ui:ui-tooling:1.3.3"

    // Splash API // Used to implement spash screen on our android application
    implementation 'androidx.core:core-splashscreen:1.1.0-alpha01'

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.6.0-alpha07")

    // Pager and Indicators - Accompanist  // Allows us to implement on boarding screeens
    implementation "com.google.accompanist:accompanist-pager:1.2.1"
    implementation "com.google.accompanist:accompanist-pager-indicators:1.2.1"

    // DataStore Preferences  // Saves a boolean value ,and it allows us to load the spalsh screen the first time the user install the application
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Dagger - Hilt
    implementation "com.google.dagger:hilt-android:2.38.1"
    kapt "com.google.dagger:hilt-android-compiler:2.38.1"
    kapt 'androidx.hilt:hilt-compiler:1.0.0'
    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'
}
























































































































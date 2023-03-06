JETPACKCOMPOS - Is a modern ui toolkit designed to simplyfy ui development and it combines reactive programing modl with the power of kotlin
Jetpack is fully declarative - Meaning you describe your ui by calling a series of functions that transorm data into your y=ui hierachy.
and when ever the underlying data changes the framework automaticaly recalls this functions updating the view hierachy for you.


THIS MEANS THAT 
From now on if you want to build your app with jetpack compose you ar not going to need any xml files for declaring any ui content
Instead you are going to build your UI using  @Composable functions.
Composable functions are highly usable

XML is not yet depricated . You can still build app using fragments and xml or even combine that with jetpack compose


JETPACK COMPOSE 
Also supportsMVVM out of the box
This means that it will be easier to arrange our code into smaller chunks


LIFE CYCLE OF OUR COMPOSABLE
You need to understand Intial composition and Recomposition


LIFE CYCLE 

step 1               

Enter the composition


Step 2

Recompose ) or more times  { composable}

Step 3




Leave the composition




WHEN YOU START A COMPOSE PROJECT . tHERE IS A FILE STRUCTURE

 There is a folder  called ui.theme

This folder contains this files

Color.kt  - Contains custom colors that you define  for your app. To create this colors you use the Color() method and you put your desiered color in hex value. e.g val Teal200 = Color(0xFF03DAC5)
Shape.kt  - Here is where the shapes to be used in the app are declared.
Theme.kt  - This is where the colors ,shapes and typography are all combined for use by the app. The primary ,secondary, onSecondary e,tc colors are declared here for both the loght and dark theme 
Type.kt   - This is where we  declare oir desired typography to match our desired type face.



THN THERE IS THE MAIN.KT 
This is the entrance for our app
We use the setContent to give lyout for our app
Then we get where we get to declare our surfaces i.e inside the AppNameTheme{}
This surface is the container for the actvity. We declare color of this container through the color e.g Surface(color = MaterialTheme.colors.background) This gives the container the color assignened tothe baground valiable 


FIRST WE ARE GOING TO STRAT BY MAKING MINI CONTAINERS IN THIS SURFACE .

But first the jetpack compose  enables us to have a preview of what we are building through the 
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TenexappTheme {
      //PUT WHAT EVER YOU ARE BUILDING HERE TO HAVE A PREVIEW OF IT.
    
    }
    
    
    
    TO MAKE MINI CONTAINERS  
  We have to know that jetpack compose only suppoerts two layouts 
  i.e
  Column - Which arranges items verticaly
  Row - arranges items horizontaly.
  
  
  HERE IS AN EXAMPLE OF COLUM
  
  To create items in colum layout you need to call the coloum composable function.
  This colum is a container . This container we can set ist specs within the parenthesis e.g
  The column accepis parameters within its paraenthesis . 
  This parameters can be 
  Column( modifier = Modefier.height(500.dp)  // This sets the height of this column container
                             .width(200.dp) // This sets the width of this container



























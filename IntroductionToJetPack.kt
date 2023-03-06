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
  This parameters can be modifier, horizontalAlignmemnt,vertical arrangememnt
 
 modifier             - Deals with the specs of the container e.gmodifier = Modifier.height(500.dp)
                                                                                    .width(500.dp)
                                                                                    .background(MaterialTheme.colors.error)
 
 horizontalAlignmemnt - Deals with where the items in the colunm are put or aligned  on the horizontal axixi.e either on the start ,middle or end .We use the Alignmemnt to set their position
 verticalArrangement  - Deals with how items are spread out or arrangaded on the vertical axis. The items can either be arranged in a spaceBetweeen or spaceEvenly or spaceAroud or center or top or bottom of the vertical axix.
  
 HERES THE EXAMPLE 
                     // This sets the height of this column container
 Column( modifier = Modefier.height(500.dp) ,horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top ){
                  // Here is where we describe our item containers using the surface composable function  
   e.g            surface( // Here are parameters that descibe this container){}
 }
 
 
 

HERE IS AN EXAMPLE OF A SURFACE
    
    
    The surface() ,receives parameters that help shape the contaner . The paramaters are e.g
    Modifier - Sets the specs for the surface container e.g with ,height 
    color - Give the color for the container
    and many more parameters
    
        Surface(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp)
            .weight(weight),
        color = color

    ) {}
        
        
        A surface is one item and we can set many more surfaces within a row or column
    
    e.g 
 column(modifier = Modifier.fillMaxSize()){
            // First Item
            Surface(modifier = Modifier.width(20.dp)
                                       .height(200.dp)
                                       .weight(3f), // The weigh is used to grow/expandd the surface cotainer based on the fraction it is give 


                   color = MaterialTheme.colors.secondary
            ) {}
            // Second item 
            Surface(modifier = Modifier.width(20.dp)
                                       .height(200.dp)
                                       .weight(3f), // The weigh is used to grow/expandd the surface cotainer based on the fraction it is give 


                   color = MaterialTheme.colors.secondary
            ) {}
    
    
    This is one way of creating many Items in a column or row
  How ever you can create a composable function of the type of surcafe or row or column that will take your desired shape.
  And you can populate your column or row layout withba s many of this items as yo want by calling the function that created it 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
                             .width(200.dp)  ) // This sets the width of this container
    
    
    
    

























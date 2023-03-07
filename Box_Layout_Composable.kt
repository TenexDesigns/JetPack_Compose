Box ix similar to the frameLayout composable.
Inside the box composable you can add diffrent composables.
Each composable will be STACKED ON TOP OF THE OTHER.
The items in a box are stacked on top of each other
e.g 
box{
    box()         //The box will be at the botton and the text will be on top
    text("Hey")

}


HERE IS AN EXAMPLE OF A BOX.


@Composable
fun BoxComposable() {

    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart){
        Box(modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .background(Color.Blue)){
              Text(text = "I love android")
            }        
    }
}


IN THE ABOVE 
We create a composable custom function and give it a custom name . This cuso  name is what we  will we call to instancite the  box model

Now to instanciate the box composbale we call the Box() composable and ass in some parameters
such as

modifier - To set the spec of the vox mode
contentAlignment - Ths aligns the items within the box model
propagateMinConstraints - This is a bolean

HERES AN EXAMPLE.
This builds a box of 100.dp by 100.dp with a blue background
Within the box , a text of saying "I love android is put"
To actualy have tetxt in a view i android , we use the Text() composable function. This composable function takes in the text and may more parameters e.g fontSizee,Fontstyle,leterspacing ..e.t.c 

 Box(modifier = Modifier.height(100.dp)
                        .width(100.dp)
                        .background(Color.Blue))
            {
              Text(text = "I love android",font-size = 34.sp)
              
            }
            
            
            HERES MORE ABOUT THE BOX MODEL

 The box model can be used to hold other boxex.
This builds a box that fills the entire screen .
This box has another box within it that has the text "I love android" 
The box with the text is alignened to the centerLeft or center start of the full screen box


        //This describes the size of box    //This says how items within box are to be aligned
    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart){
        //This is the child box within the bove box
        Box(modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .background(Color.Blue)){
            //This text is alose a chile od the box that is holding it.
                                          //This make the size of the text to be so large that it is not fully visisbel
                                         //To fix that we can make the box holding the  text to be scrollable by adding 
                                         //The .verticalScroll(remeberscrollSatte()) method.
              Text(text = "I love android",fontSize = 40.sp)
            }        
    }
}

























































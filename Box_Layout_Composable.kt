Box ix similar to the frameLayout composable.
Inside the box composable you can add diffrent composables.
Each composable will be STACKED ON TOP OF THE OTHER.


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

Now to instanciate the boc=x composbale we call the Box() composable and ass in some parameters
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
              Text(text = "I love android")
              
            }
            
            
            HERES MORE ABOUT THE BOX MODEL

 The box model can be used to hold other boxex.

























































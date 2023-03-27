
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowerMeditationAppTheme {
                Column(modifier= Modifier
                    .fillMaxSize()
                    .background(Grey)) {
                    HeaderProfileComponent()
                    SearchBox()
                    MeditationComponent()
                    
                    
                }

            }
        }
    }
}


@Composable
fun SearchBox(){

    OutlinedTextField(value = "",
        onValueChange ={} ,
        placeholder = {Text(text = "Search", fontFamily = nunitoLight)},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search, // Here Use a image verctor
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            Icon(painter = painterResource(id = R.drawable.filter) ,
                contentDescription ="filter Icon",modifier=Modifier.size(24.dp) ) // Here we use a painetr resource
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp)),// This is how  to add the rounded corners on thisoutlined box
        colors =TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.White,
            cursorColor = Color.LightGray,
            trailingIconColor = Color.Black


        )
    )

}

@Composable
fun FilterOptions(){
    val filterOptions = FILTER_CONTENT_LIST

    LazyRow(
        modifier = Modifier.padding(top = 15.dp,start=15.dp)

    ){
        items(filterOptions.size){
            ChipComponent(filter = filterOptions[it])
            
        }

    }
}


@Composable
fun MeditationComponent(){
    val meditationOptions = MEDITATION_TYPE_LIST
    Column(verticalArrangement = Arrangement.spacedBy(3.dp)){

    }

    LazyColumn(
        modifier = Modifier.padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)





    ){//This is like a for each loop .It will loop every item passed here.Here the size of ths
        // array lost is passed which is 9
        items(meditationOptions.size){
            // So this loos from ,1,2,3,4, up to 9
                                                                       // Here we pass that integer that is beeing looped
            MeditationOptionCompoennt(meditationTypes = meditationOptions[it])


        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MeditationOptionCompoennt(meditationTypes:MeditationType){

    Card(
        shape= RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxSize()
    , backgroundColor = meditationTypes.backgroundColor
    ){
        Column(verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
        modifier =  Modifier.padding(20.dp)){
            Row( horizontalArrangement = Arrangement.spacedBy(10.dp)){

                Chip(onClick = { /*TODO*/ },
                    shape= RoundedCornerShape(8.dp ),// This is how to add rounded corners on the chip
                    // If it is a componentn made by google e.g chip ,card ,use the shape attribute to add roundenes to component
                    // If it is not a compoennt e,g text filed ,use the modifier to add rounded corners

                    colors = ChipDefaults.chipColors(
                        contentColor = Black,
                        backgroundColor = meditationTypes.timeBackgroundColor,


                        )
                ) {
                    Text(text = meditationTypes.duration, fontFamily = nunitoMedium)


                }

                Chip(onClick = { /*TODO*/ },
                    shape= RoundedCornerShape(8.dp ),// This is how to add rounded corners on the chip
                    // If it is a componentn made by google e.g chip ,card ,use the shape attribute to add roundenes to component
                    // If it is not a compoennt e,g text filed ,use the modifier to add rounded corners

                    colors = ChipDefaults.chipColors(
                        contentColor = Black,
                        backgroundColor = Color.White,


                        )
                ) {
                    Text(text = meditationTypes.teacher, fontFamily = nunitoMedium)



                }


            }

            Text(text = meditationTypes.title,
                fontSize = 18.sp, color = meditationTypes.contentColor,
                textAlign = TextAlign.Start)

            Text(text = meditationTypes.teacher, fontFamily = nunitoBold,
                fontSize = 18.sp, color = meditationTypes.contentColor,
                textAlign = TextAlign.Start)



        }

    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipComponent(filter:FilterContent){
    
    val contentColor = filter.contentColor
    val chipBackground = filter.backgroundColor
    val filterText = filter.filterText
    
    Chip(onClick = { /*TODO*/ },
        shape= RoundedCornerShape(8.dp ),// This is how to add rounded corners on the chip
        // If it is a componentn made by google e.g chip ,card ,use the shape attribute to add roundenes to component
        // If it is not a compoennt e,g text filed ,use the modifier to add rounded corners

        colors = ChipDefaults.chipColors(
            contentColor = contentColor,
            backgroundColor = chipBackground,


        )
    ) {
        Text(text = filterText, fontFamily = nunitoMedium)

        
    }
    
}




@Composable
fun HeaderProfileComponent(){


    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)

    ){
        
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(contentScale = ContentScale.Crop// This makes the image scale accroeding to screen size
                ,modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.profilepicture),
                contentDescription = "Profile picture")


            Column(modifier = Modifier.padding(start= 10.dp)) {
                Text(
                    text = "Welcome Back",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    fontFamily = nunitoLight

                )

                Text(
                    text = "Miranda Alison",
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
                    fontFamily = nunitoMedium

                )

            }



        }


        Row(verticalAlignment = Alignment.CenterVertically){
            BadgedBox(badge = { Badge(backgroundColor = Green)}) {
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = "Notifications"
                )

            }

        }






    }


}


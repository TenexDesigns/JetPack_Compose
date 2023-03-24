To do this in jetpack compose ,it is advised to start with a details page showing the diffrenet layouts of the components,
either in column or in row layout.

---> Look at the row&column images in this repisortory for more reference.

But this content ,on configuration change ,is not scrollable. There fore we make the comtaing column a scrollable column.

Column(


        ){
            Text(text = "Happy Meal",
                style = TextStyle(fontFamily = FontFamily.Serif,
                    color = Color(0x3333FFFF)

                )
            )
            Text(text = "800 Calories")
            Text(text = "$ 5.99")
        }
    }
      This is how it is done


Scrollable Column(


        ){
            Text(text = "Happy Meal",
                style = TextStyle(fontFamily = FontFamily.Serif,
                    color = Color(0x3333FFFF)

                )
            )
            Text(text = "800 Calories")
            Text(text = "$ 5.99")
        }
    }








@Composable
fun Books(name:String,OnNameChange:(String) ->Unit) {
    var name:String by rememberSaveable {mutableStateOf("")}

Column(modifier = Modifier.padding(16.dp)) {
    Text(
        text = "Hello ,$name",
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.h5

    )


    OutlinedTextField(
        value = name,
        onValueChange = {value -> name = value },
        label = { Text("Name") }

    )
}

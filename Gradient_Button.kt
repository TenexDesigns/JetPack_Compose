import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tenexapp.ui.theme.TenexappTheme
import com.example.tenexapp.ui.theme.color1
import com.example.tenexapp.ui.theme.color2

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        // This is used to remove the default color on the button and leave it transparent
        // So that we can apply our color
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(), // This removes the default padding appliend on the button
        onClick = { onClick() })
    {
        // This box is used to be used as the button
        // It has a color bacground of the gradient w pass to it 
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 8.dp), // Here we apply the padding to it 
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor) // Here w set the text and the text color
        }
    }
}

HERE WE CAN CALL OUR BUTTON IN A PREVIEW

        GradientButton(text = "Click", textColor = Color.Green,
                       //Here we choose the type of gradient we want to be implemented.
            gradient = Brush.horizontalGradient(
              //For the gradiet we have to pass a list of two or more colors
                listOf(color1,color2))  // This are colors we defined in our colors file.
            ) 



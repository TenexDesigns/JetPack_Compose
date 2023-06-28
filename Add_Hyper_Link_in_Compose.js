To add a hyperlink within a text in Jetpack Compose, you can use the ClickableText composable along with an AnnotatedString. AnnotatedString allows you to attach annotations and styles to specific ranges of the text.

Here's an example of how to implement a hyperlink:

@Composable
fun HyperlinkText() {
    val annotatedString = buildAnnotatedString {
        append("Click on this ")

        pushStringAnnotation(tag = "URL", annotation = "https://google.com")
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
            append("hyperlink")
        }
        pop()
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    uriHandler.openUri(annotation.item)
                }
        }
    )
}
In this example, the text "hyperlink" is displayed in blue color with an underline. When clicked, it opens the URL "https://google.com" in a browser.

This is how it works:

buildAnnotatedString is used to construct the AnnotatedString.
pushStringAnnotation is used to attach a URL to the range of text that follows.
withStyle applies a style to the range of text that follows.
pop is called to mark the end of the annotated and styled range of text.
ClickableText is a composable that makes the text clickable.
getStringAnnotations gets the annotations that are attached to the clicked character.
openUri opens the URL in a browser stackoverflow.com.





MORE EXPLANANTION
****************************************************************************************************************************

To add a hyperlink within a Text using Jetpack Compose, you can use the AnnotatedString class and the Clickable modifier. Here's an example:

Import the required classes:
kotlin
Copy code
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
Create a composable function to handle the click on the hyperlink:
kotlin
Copy code
@Composable
fun HyperlinkContent(
    text: String,
    onClick: () -> Unit
) {
    val annotatedString = remember {
        buildAnnotatedString {
            val startIndex = 0
            val endIndex = text.length
            append(text)
            addStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                ),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "URL",
                annotation = "https://www.example.com",
                start = startIndex,
                end = endIndex
            )
        }
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations("URL", offset, offset)
                .firstOrNull()?.let {
                    onClick()
                }
        }
    )
}
In the HyperlinkContent function above, we create an AnnotatedString that includes the hyperlink text. We apply a style to make it appear as a hyperlink, such as blue color and underline. We also add a string annotation with the URL information.

The ClickableText composable is used to display the text and make it clickable. We retrieve the clicked offset and check if there is a string annotation with the "URL" tag at that offset. If it exists, we trigger the onClick callback, which can navigate to the URL or perform any desired action.

Use the HyperlinkContent composable in your UI hierarchy:
kotlin
Copy code
@Composable
fun MyScreen() {
    // Other composables and code

    HyperlinkContent(
        text = "Click here for more information",
        onClick = {
            // Handle the click action, e.g., open a URL
        }
    )

    // Other composables and code
}
You can customize the appearance of the hyperlink by adjusting the styles applied to the AnnotatedString, such as color, underline, or font size.

With the HyperlinkContent composable, you can create clickable hyperlinks within a Text in your Jetpack Compose app.






















  

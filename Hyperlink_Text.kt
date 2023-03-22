

package com.geeksforgeeks.jctextspanhyperlink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			// Calling the composable function
			// to display element and its contents
			MainContent()
		}
	}
}

// Creating a composable
// function to display Top Bar
@Composable
fun MainContent() {
	Scaffold(
		topBar = { TopAppBar(title = { Text("GFG | Text Span Hyperlink", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },
		content = { MyContent() }
	)
}

// Creating a composable function
// to create a Clickable Text
// Calling this function as content
// in the above function
@Composable
fun MyContent(){

	// Creating an annonated string
	val mAnnotatedLinkString = buildAnnotatedString {

		// creating a string to display in the Text
		val mStr = "Click this link to go to web site"
		
		// word and span to be hyperlinked
		val mStartIndex = mStr.indexOf("link")
		val mEndIndex = mStartIndex + 4
		
		append(mStr)
		addStyle(
			style = SpanStyle(
				color = Color.Blue,
				textDecoration = TextDecoration.Underline
			), start = mStartIndex, end = mEndIndex
		)

		// attach a string annotation that
		// stores a URL to the text "link"
		addStringAnnotation(
			tag = "URL",
			annotation = "https://www.geeksforgeeks.org",
			start = mStartIndex,
			end = mEndIndex
		)

	}

	// UriHandler parse and opens URI inside
	// AnnotatedString Item in Browse
	val mUriHandler = LocalUriHandler.current

	Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

		// ???? Clickable text returns position of text
		// that is clicked in onClick callback
		ClickableText(
			text = mAnnotatedLinkString,
			onClick = {
				mAnnotatedLinkString
					.getStringAnnotations("URL", it, it)
					.firstOrNull()?.let { stringAnnotation ->
						mUriHandler.openUri(stringAnnotation.item)
					}
			}
		)
	}
}

// For displaying preview in
// the Android Studio IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	MainContent()
}

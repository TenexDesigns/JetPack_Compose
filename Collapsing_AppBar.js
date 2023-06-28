To implement a collapsing top bar with animation in Jetpack Compose, you can use a combination of LazyColumn, rememberLazyListState, and graphicsLayer to create a parallax-like scrolling effect.

Here's an example:

@Composable
fun CollapsingEffectScreen() {
    val items = (1..100).map { "Item $it" }
    val lazyListState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0
    LazyColumn(
        Modifier.fillMaxSize(),
        lazyListState,
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.recife),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .graphicsLayer {
                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                        translationY = scrolledY * 0.5f
                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                    }
                    .height(240.dp)
                    .fillMaxWidth()
            )
        }
        items(items) {
            Text(
                text = it,
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}
In this example, an Image composable is used as the top bar. As the user scrolls, the image moves up slower than the rest of the content, creating a parallax-like effect. This is achieved by modifying the translationY property of the graphicsLayer based on the scroll offset of the LazyColumn. The scroll offset is obtained from the LazyListState of the LazyColumn.

Please note that this is a basic example and you might need to adjust the code according to your specific needs. For example, you may want to replace the Image composable with a more complex layout, or adjust the speed of the parallax effect by changing the multiplier of translationY stackoverflow.com, androidexample365.com.





MORE EXPLANANTION

********************************************************************************************************

  import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val lazyListState = rememberLazyListState()
    Scaffold(
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                MainContent(lazyListState = lazyListState)
                TopBar(lazyListState = lazyListState)
            }
        }
    )
}

@Composable
fun TopBar(lazyListState: LazyListState) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary)
            .animateContentSize(animationSpec = tween(durationMillis = 300))
            .height(height = if (lazyListState.isScrolled) 0.dp else TOP_BAR_HEIGHT)
            ,
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        Text(
            text = "Title",
            style = TextStyle(
                fontSize = MaterialTheme.typography.h6.fontSize,
                color = MaterialTheme.colors.surface
            )
        )
    }
}

@Composable
fun MainContent(lazyListState: LazyListState) {
    val numbers = remember { List(size = 25) { it } }
    val padding by animateDpAsState(
        targetValue = if (lazyListState.isScrolled) 0.dp else TOP_BAR_HEIGHT,
        animationSpec = tween(durationMillis = 300)
    )
    LazyColumn(
        modifier = Modifier.padding(top = padding),
        state = lazyListState
    ) {
        items(
            items = numbers,
            key = { it }
        ) {
            NumberHolder(number = it)
        }
    }
}

@Composable
fun NumberHolder(number: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = number.toString(),
            style = TextStyle(
                fontSize = MaterialTheme.typography.h1.fontSize,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

val TOP_BAR_HEIGHT = 56.dp
val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0



      MORE EXPLANANTION
*************************************************************************************************************
        
The code you provided demonstrates an animated top bar implementation in Jetpack Compose. Let's go through the code and understand its functionality:

The MainScreen composable is the entry point of the screen. It sets up the layout using the Scaffold composable and places the MainContent and TopBar composables inside a Box. The lazyListState is passed as a parameter to both composables.

The TopBar composable represents the top app bar. It uses the TopAppBar composable from the Material Design components. The modifier of the TopAppBar specifies that it should fill the width of the screen and have a background color defined by MaterialTheme.colors.primary. The height of the top app bar is animated using animateContentSize with a duration of 300 milliseconds. If the lazyListState indicates that the list is scrolled (lazyListState.isScrolled), the height of the top app bar is set to 0, otherwise, it is set to TOP_BAR_HEIGHT. The title of the top app bar is set to "Title" using the Text composable.

The MainContent composable represents the main content of the screen, which is a LazyColumn displaying a list of numbers. The padding between the top of the LazyColumn and its content is animated using animateDpAsState. If the lazyListState indicates that the list is scrolled (lazyListState.isScrolled), the padding is set to 0, otherwise, it is set to TOP_BAR_HEIGHT. The NumberHolder composable is used to display each number in a Row.

The NumberHolder composable displays a single number in a Row with centered vertical alignment. The number is displayed using the Text composable.

The TOP_BAR_HEIGHT constant defines the height of the top app bar.

The extension property LazyListState.isScrolled is a custom property that returns true if the list is scrolled (i.e., the first visible item index or the first visible item scroll offset is greater than 0).

Overall, this code achieves the effect of animating the top app bar and adjusting the padding of the main content based on the scroll position of the list. As the list is scrolled, the top app bar animates its height to 0 and the padding of the main content adjusts accordingly.








      MORE EXPLANANTION
*************************************************************************************************************

  This code demonstrates how to create an animated top bar that collapses as the user scrolls down a list in Jetpack Compose.

Here's a breakdown of the code:

MainScreen: This is the main screen of your app. It consists of a Scaffold which contains a Box that fills the entire screen. Within this Box, there are two composables: MainContent and TopBar.
TopBar: This is the top bar of your app. The height of the top bar is determined by the isScrolled property of LazyListState. If the list is scrolled (isScrolled = true), the height of the top bar will be 0.dp, otherwise, it will be TOP_BAR_HEIGHT (56.dp). The change in height is animated using the animateContentSize modifier.
MainContent: This is the main content of your app, which is a LazyColumn containing a list of numbers. The top padding of the LazyColumn is determined by the isScrolled property of LazyListState, similar to the TopBar. If the list is scrolled, the top padding will be 0.dp, otherwise, it will be TOP_BAR_HEIGHT. The change in padding is animated using animateDpAsState.
NumberHolder: This is a simple row that displays a number in a large font size.
LazyListState.isScrolled: This is an extension property of LazyListState that returns true if the list is scrolled and false otherwise. The list is considered scrolled if the first visible item index is greater than 0 or the first visible item scroll offset is greater than 0.
When you run this code, you will see a list of numbers with a top bar containing a title. As you scroll down the list, the top bar will smoothly collapse and the list will move up to fill the space. When you scroll back up to the top of the list, the top bar will smoothly expand back to its original size jetpackcompose.net, stackoverflow.com.





















  

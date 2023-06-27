In Jetpack Compose, you can create swipeable components using the Modifier.swipeable modifier. Here's an example of a basic swipeable card:

@Composable
fun SwipeableCard() {
    val state = rememberSwipeableState(initialValue = 0)
    val anchors = mapOf(0f to 0, width.toPx() to 1) // Define anchors

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(x = state.offset)
            .swipeable(
                state = state,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                orientation = Orientation.Horizontal
            ),
        backgroundColor = Color.Red,
        elevation = 4.dp
    ) {
        Text("Swipe me", Modifier.padding(16.dp))
    }
}
In this example, rememberSwipeableState is used to create a SwipeableState for the card. The offset modifier is used to move the card horizontally based on the swipe. The swipeable modifier is used to make the card swipeable. The anchors define the positions the card can stop at after a swipe. In this case, the card can stop at its original position (0) or at a position to the right (width of the card). The thresholds define when the swipe is considered large enough to move the card to the next anchor. In this case, if the swipe is more than half the distance to the next anchor, the card will move to the next anchor proandroiddev.com.

Please note that the width.toPx() is used as an example, you'd need to replace it with the actual width of your component. You can get the width using LocalConfiguration.current or Modifier.onSizeChanged.

This example creates a card that can be swiped to the right. If the card is swiped more than half the width of the card, the card will move to the right. If the card is swiped less than half the width of the card, the card will move back to its original position.







MORE EXPLANANTION
*****************************************************************************************************




To create a swipeable component with Jetpack Compose, you can use the Modifier.swipeable modifier along with gesture callbacks to handle the swipe gestures. Here's an example of how you can implement this:

kotlin
Copy code
@Composable
fun SwipeableComponent(
    onSwipeLeft: () -> Unit,
    onSwipeRight: () -> Unit,
    content: @Composable () -> Unit
) {
    val offsetX = remember { Animatable(0f) }

    val swipeableModifier = Modifier
        .offset { IntOffset(offsetX.value.roundToInt(), 0) }
        .graphicsLayer {
            translationX = offsetX.value
            clip = true
        }
        .pointerInput(Unit) {
            detectHorizontalDragGestures { _, dragAmount ->
                launch {
                    offsetX.snapTo(offsetX.value + dragAmount)
                }
            }
            detectDragGestures(
                onDragEnd = { velocity ->
                    if (velocity.x < 0) {
                        onSwipeLeft()
                    } else {
                        onSwipeRight()
                    }
                }
            )
        }

    Box(
        modifier = swipeableModifier
    ) {
        content()
    }
}
In this example, the SwipeableComponent composable represents a component that can be swiped horizontally. It takes onSwipeLeft and onSwipeRight callbacks to handle the respective swipe actions. The actual content of the component is passed as the content parameter.

The offsetX variable is used to keep track of the horizontal offset of the component. It is created as an Animatable to enable smooth animations.

The swipeableModifier is a combination of modifiers and gesture callbacks. It uses the offset modifier to translate the component horizontally based on the offsetX value. The graphicsLayer modifier is used to apply the translation to the underlying graphics layer, ensuring clipping of content that extends beyond the component's boundaries.

The pointerInput modifier is used to detect and handle horizontal drag gestures. The detectHorizontalDragGestures callback is triggered when a drag gesture occurs. It updates the offsetX value based on the drag amount.

The detectDragGestures callback is used to detect the end of a drag gesture. It checks the velocity of the drag and triggers the appropriate swipe action callback (onSwipeLeft or onSwipeRight) based on the direction of the velocity.

Inside the Box composable, the swipeableModifier is applied to enable the swipe behavior on the component. The actual content is rendered within the Box.

To use the swipeable component in your app, you can wrap your desired content with the SwipeableComponent and provide the necessary swipe action callbacks. Here's an example:

kotlin
Copy code
@Composable
fun Display() {
    SwipeableComponent(
        onSwipeLeft = { /* Handle left swipe */ },
        onSwipeRight = { /* Handle right swipe */ }
    ) {
        // Your content here
        Text(
            text = "Swipe me",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}
In this example, the Display composable wraps a Text component with the SwipeableComponent. You can replace the Text component with any other content you want to make swipeable.

Remember to import the necessary Compose dependencies:

kotlin
Copy code
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.snapTo
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.orientationGestureFilter
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
Feel free to customize the swipeable component based on your specific requirements, such as adding animations or adjusting the sensitivity of the swipe gestures.



















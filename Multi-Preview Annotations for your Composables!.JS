In Jetpack Compose, you can use the @Preview annotation to create previews of your composables. If you want to create multiple previews for different states of your composable, you have several options:

Combine multiple composables in a single preview: You can create a new composable specifically for previewing that includes multiple instances of the composable you want to preview, each with different state.
@Preview(showBackground = true)
@Composable
fun MultipleTopBarPreviews() {
    Column {
        MainScreen()
        Spacer(Modifier.height(16.dp))
        MainScreen()
    }
}
Use PreviewParameter: If your composable depends on some parameters, you can use PreviewParameter to provide different values for these parameters, and you will get separate previews for each value.
class DummyListStateProvider: PreviewParameterProvider<LazyListState> {
    override val values: Sequence<LazyListState> = sequenceOf(
        LazyListState(firstVisibleItemIndex = 0, firstVisibleItemScrollOffset = 0),
        LazyListState(firstVisibleItemIndex = 10, firstVisibleItemScrollOffset = 50)
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(
    @PreviewParameter(DummyListStateProvider::class) lazyListState: LazyListState
) {
    TopBar(lazyListState = lazyListState)
}
Please note that you can only have one @PreviewParameter per preview composable.

Use multiple @Preview annotations: You can use multiple @Preview annotations on a single composable to create multiple previews with different parameters. This can be useful if you want to preview your composable in different configurations, like different themes or locales.
@Preview(showBackground = true, name = "Light Theme")
@Composable
fun LightThemeTopBarPreview() {
    MaterialTheme(colors = lightColors()) {
        TopBar(lazyListState = rememberLazyListState())
    }
}

@Preview(showBackground = true, name = "Dark Theme")
@Composable
fun DarkThemeTopBarPreview() {
    MaterialTheme(colors = darkColors()) {
        TopBar(lazyListState = rememberLazyListState())
    }
}
In these examples, the TopBar composable is previewed in both light and dark themes stackoverflow.com, goodrequest.com.


MORE EXPLANANTION
*********************************************************************************************************************************************


Multi-Preview in Android Studio allows you to simultaneously preview different states or variations of your composables. Here's how you can set up Multi-Preview for your Jetpack Compose composables:

Open your composables file in Android Studio.

Make sure you have the latest version of Android Studio installed, as Multi-Preview is supported starting from Android Studio Arctic Fox (2020.3.1) or higher.

Locate the composable you want to create multiple previews for.

Place your cursor inside the composable function.

Right-click and select "Show in Composable Preview" from the context menu. This action will open the Composable Preview panel.

In the Composable Preview panel, click on the "Preview" tab.

On the right side of the Preview tab, click on the "+" button to add a new preview configuration.

Give a name to your preview configuration, e.g., "Default," "Dark Theme," "Error State," etc.

Customize the configuration settings for the preview. You can change the values of the composable's parameters or provide different data to simulate different states or scenarios.

Repeat steps 7-9 to create additional preview configurations as needed.

To switch between different preview configurations, select the desired configuration from the drop-down menu at the top of the Preview tab.

You can also switch between different configurations by using the "Previous Configuration" and "Next Configuration" buttons next to the drop-down menu.

By setting up multiple preview configurations, you can easily visualize and test different variations of your composables without having to manually modify the code each time.

Note: Multi-Preview is a feature provided by Android Studio and might have some limitations or specific behaviors based on the version you are using. Make sure you have the latest version installed to leverage the full capabilities of Multi-Preview.





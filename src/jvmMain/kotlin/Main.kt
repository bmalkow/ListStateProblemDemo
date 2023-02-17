import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
	var text by remember { mutableStateOf("Hello, World!") }

	MaterialTheme {
		Button(onClick = {
			text = "Hello, Desktop!"
		}) {
			List()
		}
	}
}

fun main() = application {
	Window(onCloseRequest = ::exitApplication) {
		App()
	}
}

@Preview
@Composable
fun List() {
	println("Begin List()")
	val data = listOf("Item 01", "Item 02", "Item 03", "Item 04", "Item 05", "Item 06")
	val listState = rememberLazyListState()
	Column {
		Box {
			LazyColumn(state = listState, reverseLayout = true) {
				itemsIndexed(data) { index, rowItem ->
					Text(rowItem)
				}
			}
		}
		// The problematic line:
		listState.layoutInfo
	}
	println("End List()")
}
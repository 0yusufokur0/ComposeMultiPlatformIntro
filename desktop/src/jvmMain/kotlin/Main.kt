import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import me.yusuf.common.TranslateAPI

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        DesktopMaterialTheme {
            var text by remember { mutableStateOf("Hello, World!") }

            Button(onClick = {
                TranslateAPI(
                    "auto", "tr", "hi",
                    object : TranslateAPI.TranslateListener {
                        override fun onSuccess(translatedText: String?) {
                            text = translatedText.toString()
                        }

                        override fun onFailure(ErrorText: String?) {
                            text = ErrorText.toString()
                        }
                    })
            }) {
                Text(text)
            }

        }
    }
}
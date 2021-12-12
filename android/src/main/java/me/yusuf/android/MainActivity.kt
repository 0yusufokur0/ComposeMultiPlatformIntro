package me.yusuf.android

import me.yusuf.common.App
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import me.yusuf.common.getPlatformName

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // App()
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
}
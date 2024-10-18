package br.com.alura.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    MyFirstComposable()
                }
            }
        }
    }
}

@Composable
fun MyFirstComposable(modifier: Modifier = Modifier) {
    Text(
        text = "Meu primeiro texto",
        modifier = modifier
    )
    Text(
        text = "Meu segundo texto maior",
        modifier = modifier
    )
}

@Preview
@Composable
fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MyFirstComposable()
        }
    }
}
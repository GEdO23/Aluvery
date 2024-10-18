package br.com.alura.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

@Preview(group = "LayoutComposables", showBackground = true)
@Composable
private fun ColumnPreview() {
    Column { 
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(group = "LayoutComposables", showBackground = true)
@Composable
private fun RowPreview() {
    Row { 
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(group = "LayoutComposables", showBackground = true)
@Composable
private fun BoxPreview() {
    Box {
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(group = "LayoutComposables", showBackground = true)
@Composable
private fun CustomLayoutPreview() {
    Column { 
        Text("Texto 1")
        Text("Texto 2")
        Row { 
            Text("Texto 3")
            Text("Texto 4")
        }
        Box {
            Row {
                Text("Texto 5")
                Text("Texto 6")
            }
            Column {
                Text("Texto 7")
                Text("Texto 8")
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
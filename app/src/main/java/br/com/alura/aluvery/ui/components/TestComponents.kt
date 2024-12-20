package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.ui.theme.AluveryTheme


@Preview(group = "LayoutComposables", showBackground = true)
@Composable
fun ColumnPreview() {
    Column {
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(group = "LayoutComposables", showBackground = true)
@Composable
fun RowPreview() {
    Row {
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(group = "LayoutComposables", showBackground = true)
@Composable
fun BoxPreview() {
    Box {
        Text("Texto 1")
        Text("Texto 2")
    }
}

@Preview(group = "ModifierComposables", showBackground = true, showSystemUi = true)
@Preview(group = "LayoutComposables", showBackground = true)
@Composable
fun CustomLayoutPreview() {
    Column(
        Modifier
            .padding(8.dp)
            .background(color = Color.Blue)
            .padding(all = 8.dp)
//        .height(400.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text("Texto 1")
        Text("Texto 2")
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 16.dp
                )
                .background(Color.Green)
                .fillMaxWidth(0.9f)
        ) {
            Text("Texto 3")
            Text("Texto 4")
        }
        Box(
            Modifier
                .padding(8.dp)
                .background(color = Color.Red)
                .padding(all = 8.dp)
//            .width(100.dp)
        ) {
            Row(
                Modifier
                    .padding(8.dp)
                    .background(color = Color.Cyan)
                    .padding(all = 8.dp)
                    .fillMaxWidth()
            ) {
                Text("Texto 5")
                Text("Texto 6")
            }
            Column(
                Modifier
                    .padding(8.dp)
                    .background(color = Color.Yellow)
                    .padding(all = 8.dp)
            ) {
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
private fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MyFirstComposable()
        }
    }
}
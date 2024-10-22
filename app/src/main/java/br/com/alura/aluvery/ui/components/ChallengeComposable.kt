package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.R
import br.com.alura.aluvery.ui.theme.Purple500
import br.com.alura.aluvery.ui.theme.Teal200

@Composable
fun ProductCard(modifier: Modifier = Modifier, description: String = "") {
    Surface(modifier = modifier, shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp) {
        Column(
            Modifier
                .heightIn(250.dp, 260.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                Modifier
                    .height(imageSize)
                    .background(Brush.horizontalGradient(listOf(Purple500, Teal200)))
                    .fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.ic_launcher_background),
                    "Product's Image",
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(Modifier.height(imageSize / 2))

            Column(Modifier.padding(16.dp)) {
                Text(
                    LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "R$ 14,99", Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }

            if (description.isNotBlank()) {
                Column(
                    Modifier
                        .background(Purple500)
                        .padding(16.dp)
                ) {
                    Text(description, color = Color.White)
                }
            }
        }
    }
}

@Preview(group = "Challenge 3")
@Composable
private fun ProductCardPreview() {
    Surface(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .padding(vertical = 16.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            ProductCard(description = LoremIpsum(50).values.first())
            ProductCard()
            ProductCard(description = LoremIpsum(50).values.first())
            Spacer(Modifier)
        }
    }
}


@Composable
fun ProductKitCard(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 4.dp
    ) {
        Row(modifier = Modifier.height(200.dp)) {
            ProductKitHeader(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(
                        brush = Brush.verticalGradient(listOf(Teal200, Purple500))
                    ),
                imageSize = 100.dp,
                imageSource = painterResource(R.drawable.ic_launcher_background)
            )
            ProductKitText(
                text = LoremIpsum(50).values.first(),
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}

@Composable
fun ProductKitImage(
    painter: Painter,
    size: Dp,
    modifier: Modifier = Modifier,
    background: Color = Color.Unspecified
) {
    Image(
        painter = painter,
        contentDescription = "Imagem do produto disponibilizado em kit",
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(background)
            .border(
                width = 2.dp,
                brush = Brush.verticalGradient(listOf(Purple500, Teal200)),
                shape = CircleShape
            )
    )
}

@Composable
fun ProductKitHeader(
    imageSource: Painter,
    modifier: Modifier = Modifier,
    imageSize: Dp = 0.dp,
    imageBackground: Color = Color.Unspecified
) {
    Box(
        modifier = modifier
            .width(imageSize)
    ) {
        ProductKitImage(
            size = imageSize,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = imageSize / 2),
            painter = imageSource,
            background = imageBackground,
        )
    }
    Spacer(modifier = Modifier.padding(end = imageSize / 2))
}

@Composable
fun ProductKitText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        maxLines = 6,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
    )
}

@Preview(group = "Challenge 1", showBackground = true)
@Composable
private fun Challenge1Preview() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight()
                .background(Color.Blue)
        )
        Column {
            Text(
                text = "Test 1", modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(16.dp)
            )
            Text(
                text = "Test 2", modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(16.dp)
            )
        }
    }
}

@Preview(group = "Challenge 2", showBackground = true)
@Composable
private fun Challenge2Preview() {
    ProductKitCard()
}

@Preview(group = "Challenge 2")
@Composable
private fun ProductKitImagePreview() {
    val imageSize = 100.dp

    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(imageSize)
    ) {
        ProductKitImage(
            size = imageSize,
            painter = painterResource(R.drawable.ic_launcher_background)
        )
    }
}

@Preview(group = "Challenge 2", showBackground = true)
@Composable
private fun ProductKitHeaderPreview() {
    val imageSize = 100.dp

    Row(modifier = Modifier.size(imageSize * 2)) {
        ProductKitHeader(
            modifier = Modifier
                .fillMaxHeight()
                .background(
                    brush = Brush.verticalGradient(listOf(Teal200, Purple500))
                ),
            imageSize = imageSize,
            imageSource = painterResource(R.drawable.ic_launcher_background)
        )
    }
}

@Preview(group = "Challenge 2", showBackground = true)
@Composable
private fun ProductKitTextPreview() {
    ProductKitText(
        text = LoremIpsum(50).values.first(),
        modifier = Modifier.padding(32.dp)
    )
}
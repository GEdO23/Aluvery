package br.com.alura.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.extensions.toBrazilianCurrency
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.ui.theme.AluveryTheme
import br.com.alura.aluvery.ui.theme.Purple500
import br.com.alura.aluvery.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    Column {
                        ProductsSection()
                        ProductsSection()
                        ProductsSection()
                    }
                }
            }
        }
    }
}

@Composable
fun ProductsSection() {
    Column {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            ProductItem(
                product = Product(
                    name = "Hamburguer",
                    price = BigDecimal("12.99"),
                    image = R.drawable.burger
                )
            )
            ProductItem(
                product = Product(
                    name = "Pizza",
                    price = BigDecimal("19.99"),
                    image = R.drawable.pizza
                )
            )
            ProductItem(
                product = Product(
                    name = "Batata frita",
                    price = BigDecimal("7.99"),
                    image = R.drawable.fries
                )
            )
            Spacer(Modifier)
        }
    }
}

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: Product
) {
    Surface(modifier = modifier, shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(brush = Brush.horizontalGradient(listOf(Purple500, Teal200)))
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = "Product's Image",
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun ProductsSectionPreview() {
    AluveryTheme {
        Surface(Modifier.fillMaxSize()) {
            Column {
                ProductsSection()
                ProductsSection()
                ProductsSection()
            }
        }
    }
}

@Preview
@Composable
private fun ProductItemPreview() {
    AluveryTheme {
        Surface {
            ProductItem(
                modifier = Modifier.padding(16.dp),
                product = Product(
                    name = LoremIpsum(50).values.first(),
                    price = BigDecimal("14.99"),
                    image = R.drawable.ic_launcher_background
                )
            )
        }
    }
}
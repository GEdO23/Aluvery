package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.R
import br.com.alura.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductsSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
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

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {
    ProductsSection()
}
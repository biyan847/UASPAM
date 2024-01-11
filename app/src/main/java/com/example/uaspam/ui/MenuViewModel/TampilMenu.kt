package com.example.uaspam.ui.MenuViewModel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uaspam.Model.Makanan

@Composable
fun ListMakanan(
    itemMakanan: List<Makanan>,
    modifier: Modifier = Modifier,
    onItemClick: (Makanan) -> Unit,
    onOrderClick: (Makanan) -> Unit // Tambahkan parameter ini
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemMakanan, key = { it.id }) { makanan ->
            DataMakan(
                makanan = makanan,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(makanan) }
            )
            TextButton(onClick = { onOrderClick(makanan) }) { // Tambahkan fungsi untuk tombol order
                Text(text = "Order")
            }
        }
    }
}

@Composable
fun DataMakan(
    makanan: Makanan,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = makanan.namamkn,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                )
                Text(
                    text = makanan.harga,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = makanan.jenis,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
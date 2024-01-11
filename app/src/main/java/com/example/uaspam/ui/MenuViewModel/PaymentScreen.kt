package com.example.uaspam.ui.MenuViewModel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uaspam.Model.Makanan


@Composable
fun ItemDetails(
    makanan: Makanan, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier, colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ItemDetailsRow(
                labelResID ="Nama",
                itemDetail = makanan.namamkn,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
            ItemDetailsRow(
                labelResID = "Harga",
                itemDetail = makanan.harga,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
            ItemDetailsRow(
                labelResID = "Jenis",
                itemDetail = makanan.jenis,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
        }

    }
}


@Composable
private fun ItemDetailsRow(
    labelResID: String, itemDetail: String, modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = labelResID, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetail, fontWeight = FontWeight.Bold)
    }
}

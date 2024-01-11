package com.example.uaspam.ui.DataPelanggan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uaspam.Navigation.DestinasiNavigasi
import com.example.uaspam.ui.AddPelanggan


object DestinasiDataPel : DestinasiNavigasi {
    override val route = "Item_entry"
    override val titleRes = "add pelanggan"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiInput(
    addPelanggan: AddPelanggan,
    modifier: Modifier = Modifier,
    onValueChange: (AddPelanggan) -> Unit = {},
    enabled: Boolean = true,
    onSaveClick: () -> Unit,
    OnNextClick: () -> Unit,

    ){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 700.dp, width = 200.dp),

            shape = RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp, bottomEnd = 50.dp, bottomStart = 50.dp),
            colors = CardDefaults.outlinedCardColors(
                containerColor = Color(0xFFC2AECF),
            ),
            border = BorderStroke(2.dp, Color.Black)
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ){
                OutlinedTextField(

                    value = addPelanggan.plgn,
                    onValueChange = { onValueChange(addPelanggan.copy(plgn = it)) },
                    label = { Text("Nama") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = enabled,
                    shape = RoundedCornerShape(20.dp),

                    )

                OutlinedTextField(
                    value = addPelanggan.Nomormeja,
                    onValueChange = { onValueChange(addPelanggan.copy(Nomormeja = it)) },
                    label = { Text("No Meja") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = enabled,
                    shape = RoundedCornerShape(20.dp),
                )
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .weight(1f, false),
                ){
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ){
                        Button(
                            onClick = onSaveClick,
                            shape = MaterialTheme.shapes.small,
                        ) {
                            Text("Submit")
                        }
                        OutlinedButton(
                            modifier = Modifier.weight(1f), onClick =
                            OnNextClick) {
                            Text("Next")
                        }
                    }
                }
            }
        }
    }
}


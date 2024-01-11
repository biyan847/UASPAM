package com.example.uaspam.ui.DataPelanggan


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.uaspam.data.PelangganRepository
import com.example.uaspam.ui.AddPelanggan
import com.example.uaspam.ui.AddUIState
import com.example.uaspam.ui.toPelanggan

class DetailDatapelViewModel(private val pelangganRepository: PelangganRepository): ViewModel(){
    var AddUiState by mutableStateOf(AddUIState())
        private set
    fun UpdateAddUIState(addPelanggan: AddPelanggan) {
        AddUiState = AddUIState(addPelanggan =addPelanggan)
    }

    suspend fun addpelanggan() {
        pelangganRepository.save(AddUiState.addPelanggan.toPelanggan())
    }
}
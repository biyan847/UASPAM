package com.example.uaspam.ui.DataPelanggan


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.uaspam.data.PelangganRepository

class DetailDatapelViewModel(private val pelangganRepository: PelangganRepository): ViewModel(){
    var AddUiState by mutableStateOf(AddUIState())
        private set
    fun UpdateAddUIState(addPelanggan: AddPelanggan) {
        AddUIState = AddUIState(addPelanggan = addPelanggan)
    }

    suspend fun addpelanggan() {
        pelangganRepository.save(AddUIState.addPelanggan.toPelanggan())
    }
}
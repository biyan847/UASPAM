package com.example.uaspam.ui.MenuViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uaspam.Model.Makanan
import com.example.uaspam.data.MakananRepository
import com.example.uaspam.ui.MakananUIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed class KontakUIState {
    data class Success(val makanan: Flow<List<Makanan>>) : KontakUIState()
    object Error : KontakUIState()
    object Loading : KontakUIState()
}

class MenuViewModel(private val makananRepository: MakananRepository) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUIState: StateFlow<MakananUIState> = makananRepository.getAll()
        .filterNotNull()
        .map {
            MakananUIState(listMakanan = it.toList(), it.size)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = MakananUIState()
        )
}
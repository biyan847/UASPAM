package com.example.uaspam.ui.MenuViewModel

import com.example.uaspam.Model.Makanan
import kotlinx.coroutines.flow.Flow

sealed class MakananUIState {
    data class Success(val makanan: Flow<List<Makanan>>) : MakananUIState()
    object Error : MakananUIState()
    object Loading : MakananUIState()
}
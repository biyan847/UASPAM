package com.example.uaspam.ui.Edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uaspam.data.MakananRepository
import com.example.uaspam.ui.AddEvent
import com.example.uaspam.ui.AddUIState
import com.example.uaspam.ui.toAdmin
import com.example.uaspam.ui.toUIStateAdmin
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditMakananViewModel (
    savedStateHandle: SavedStateHandle,
    private val makananrepo : MakananRepository
): ViewModel() {
    var makanUiState by mutableStateOf(AddUIState())
        private set

    private  val makananId: String = checkNotNull(savedStateHandle[EditMakananScreen.makananId])

    init {
        viewModelScope.launch {
            makanUiState =
                makananrepo.getMakananById(makananId)
                    .filterNotNull()
                    .first()
                    .toUIStateAdmin()
        }
    }

    fun updateUiState(addEvent: AddEvent){
        makanUiState = makanUiState.copy(addEvent = addEvent)
    }
    suspend fun updatemakanan(){
        makananrepo.update(makanUiState.addEvent.toAdmin())
    }
}
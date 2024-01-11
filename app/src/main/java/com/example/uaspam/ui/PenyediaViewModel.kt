package com.example.uaspam.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.uaspam.MakananAplication
import com.example.uaspam.ui.Add.AddViewModel
import com.example.uaspam.ui.DataPelanggan.DetailDatapelViewModel
import com.example.uaspam.ui.Detail.DetailViewModel
import com.example.uaspam.ui.Edit.EditMakananViewModel
import com.example.uaspam.ui.MenuViewModel.MenuViewModel

fun CreationExtras.apkikasiMakanan(): MakananAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MakananAplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            AddViewModel(apkikasiMakanan().container.makananRepository)
        }

        initializer {
            MenuViewModel(apkikasiMakanan().container.makananRepository)
        }

        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                apkikasiMakanan().container.makananRepository
            )
        }

        initializer {
            EditMakananViewModel(
                createSavedStateHandle(),
                apkikasiMakanan().container.makananRepository
            )
        }
    }
    val comsumen = viewModelFactory {
        initializer {
            DetailDatapelViewModel(apkikasiMakanan().container.pelangganRepository)
        }
    }

}
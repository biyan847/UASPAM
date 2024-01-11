package com.example.uaspam

import android.app.Application
import com.example.uaspam.data.MakananContainer

class MakananAplication : Application() {

    lateinit var container: MakananContainer

    override fun onCreate() {
        super.onCreate()

        container = MakananContainer()
    }
}
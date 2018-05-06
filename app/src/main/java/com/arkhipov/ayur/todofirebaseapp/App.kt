package com.arkhipov.ayur.todofirebaseapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var mInstance: Context
        fun getInstance() = mInstance
    }

    //private lateinit var fireDb: FirebaseFirestore

    override fun onCreate() {
        super.onCreate()
        mInstance = applicationContext as App
        //fireDb = FirebaseFirestore.getInstance()
    }

    //fun getFireDb() = fireDb
}
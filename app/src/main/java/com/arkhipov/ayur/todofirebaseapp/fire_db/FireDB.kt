package com.arkhipov.ayur.todofirebaseapp.fire_db

import com.arkhipov.ayur.todofirebaseapp.App
import com.arkhipov.ayur.todofirebaseapp.common.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class FireDB {
    private val fireDB: FirebaseFirestore
    constructor() {
        FirebaseApp.initializeApp(App.getInstance())
        fireDB = FirebaseFirestore.getInstance()
    }

    fun addNewUser(user: Map<String, Any>) {
        fireDB.collection("users")
                .add(user)
                .addOnSuccessListener {
                    Log.d("DocumentSnapshot добавлен с ID: " + it.getId())
                }
                .addOnFailureListener {
                    Log.w("Ошиька добавления документа ${it.message}")
                }
    }

    fun getUserData() {
        fireDB.collection("users")
                .get()
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        for (document in it.getResult()) {
                            Log.d("${document.id} => ${document.data}")
                        }
                    } else {
                        Log.w("Ошибка получения документа. ${it.exception}")
                    }
                }
    }

}
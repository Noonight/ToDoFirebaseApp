package com.arkhipov.ayur.todofirebaseapp.home

import com.arkhipov.ayur.todofirebaseapp.App
import com.arkhipov.ayur.todofirebaseapp.fire_db.FireDB
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class HomePresenter(private val fireDB: FireDB = FireDB()) : MvpBasePresenter<HomeView>() {

    fun addUser(user: Map<String, Any>) {
        fireDB.addNewUser(user)
    }

    fun getUsers() {
        fireDB.getUserData()
    }
}
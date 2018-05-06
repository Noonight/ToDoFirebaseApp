package com.arkhipov.ayur.todofirebaseapp.home

import com.hannesdorfmann.mosby3.mvp.MvpView

interface HomeView : MvpView {

    fun showError()

    fun showLoading()

}

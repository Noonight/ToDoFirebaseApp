package com.arkhipov.ayur.todofirebaseapp.home

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.arkhipov.ayur.todofirebaseapp.R
import com.hannesdorfmann.mosby3.mvp.MvpActivity

class HomeActivity : MvpActivity<HomeView, HomePresenter>(), HomeView {

    @BindView(R.id.et_login)
    lateinit var etLogin: EditText
    @BindView(R.id.email)
    lateinit var etEmail: EditText
    @BindView(R.id.et_password)
    lateinit var etPassword: EditText
    @BindView(R.id.et_confirmPassword)
    lateinit var etConfirmPassword: EditText
    @BindView(R.id.btn_registration)
    lateinit var btnRegistration: Button

    override fun createPresenter(): HomePresenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    fun initViews() {
        /*btnRegistration.setOnClickListener {
            if (fieldsIsEmpty()) {
            Toast.makeText(this, "Fields can't be null", Toast.LENGTH_SHORT).show()
        } else {
            val user = HashMap<String, Any>()
            user.put("login", etLogin.text)
            user.put("email", etEmail.text)
            user.put("password", etPassword.text)
            user.put("confirmPassword", etConfirmPassword.text)
            presenter.addUser(user)
        }
        }*/
    }

    @OnClick(R.id.btn_registration)
    fun registration() {
        if (fieldsIsEmpty()) {
            Toast.makeText(this, "Fields can't be null", Toast.LENGTH_SHORT).show()
        } else {
            val user = HashMap<String, Any>()
            user.put("login", etLogin.text.toString())
            user.put("email", etEmail.text.toString())
            user.put("password", etPassword.text.toString())
            user.put("confirm_password", etConfirmPassword.text.toString())
            presenter.addUser(user)
        }
    }

    @OnClick(R.id.btn_get_data)
    fun getData() {
        presenter.getUsers()
    }

    private fun fieldsIsEmpty(): Boolean {
        return if (TextUtils.isEmpty(etLogin.text) &&
                TextUtils.isEmpty(etEmail.text) &&
                TextUtils.isEmpty(etPassword.text) &&
                TextUtils.isEmpty(etConfirmPassword.text)) true else false
    }

    override fun showError() {

    }

    override fun showLoading() {

    }
}

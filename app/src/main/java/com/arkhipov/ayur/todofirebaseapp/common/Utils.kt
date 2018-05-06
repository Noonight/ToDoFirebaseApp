package com.arkhipov.ayur.todofirebaseapp.common

class Utils {

    companion object {

        fun checkConfirmPassword(password1: String, password2: String): Boolean {
            return password1.equals(password2)
        }

    }

}
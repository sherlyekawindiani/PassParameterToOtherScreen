package com.sherlyeka.passparametertootherscreen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.content.SharedPreferences
import android.os.Bundle
import com.sherlyeka.passparametertootherscreen.helper.Constant
import com.sherlyeka.passparametertootherscreen.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sharedpref = PreferencesHelper( this)

        textUsername.text = sharedpref.getString( Constant.PREF_USERNAME)

        buttonLogout.setOnClickListener{
            sharedpref.clear()
            moveIntent()

        }
    }
    private fun moveIntent(){
        startActivity(Intent( this, LoginActivity::class.java ))
        finish()
    }

}
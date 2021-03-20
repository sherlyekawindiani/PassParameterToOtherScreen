package com.sherlyeka.passparametertootherscreen

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.Toast
import com.sherlyeka.passparametertootherscreen.helper.Constant
import com.sherlyeka.passparametertootherscreen.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var sharedpref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedpref = PreferencesHelper( this)

        buttonLogin.setOnClickListener(){
            if (editUsername.text.isNotEmpty() && editUsername.text.isNotEmpty()){
               saveSession( editUsername.text.toString(), editPassword.text.toString() )
                moveIntent()
            }

        }

    }

    override fun onStart() {
        super.onStart()
        if (sharedpref.getBoolean( Constant.PREF_IS_LOGIN)){
            moveIntent()

        }
    }


    private fun moveIntent(){
        startActivity(Intent( this, UserActivity::class.java ))
        finish()
    }

    private fun saveSession(username: String, password: String){
        sharedpref.put( Constant.PREF_USERNAME, username )
        sharedpref.put( Constant.PREF_PASSWORD, password )
        sharedpref.put( Constant.PREF_IS_LOGIN, true )
    }



}


package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun onClickButtonPaseo(view: View) {
        val prIntent = Intent(this, WalkActivity::class.java)
        startActivity(prIntent)
    }


    fun onClickButtonBaño(view: View) {
        val prIntent = Intent(this, BathActivity::class.java)
        startActivity(prIntent)
    }

    fun onClickButtonHospedaje(view: View) {
        val prIntent = Intent(this, LodgingActivity::class.java)
        startActivity(prIntent)
    }

    fun onClickButtonPeluqueria(view: View) {
        val prIntent = Intent(this, HairActivity::class.java)
        startActivity(prIntent)
    }


}

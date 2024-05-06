package com.example.imada2p1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Background Figure 1: GabrielleHavenDoorHangersSigns. 2020. Welcome Friends Snoopy Woodstock Door
// Hanger.
        val btnContinue = findViewById<Button>(R.id.btnContinue)

        btnContinue.setOnClickListener {    //The IIE. 2024.
            val intent = Intent(this, imada2p2::class.java)
            startActivity(intent)
        }
    }
}

package com.example.myapplication

import android.R
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var etNom: EditText? = null
    private var etAnnee: EditText? = null
    private var btnVerifier: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNom = findViewById<EditText?>(R.id.et_nom)
        etAnnee = findViewById<EditText?>(R.id.et_annee)
        btnVerifier = findViewById<Button?>(R.id.btn_verifier)

        btnVerifier!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                verifierSaisie()
            }
        })
    }

    private fun verifierSaisie() {
        val nom = etNom!!.getText().toString().trim { it <= ' ' }
        val anneeStr = etAnnee!!.getText().toString().trim { it <= ' ' }


        if (TextUtils.isEmpty(nom)) {
            etNom!!.setError("Veuillez saisir le nom")
            return
        }

        if (TextUtils.isEmpty(anneeStr)) {
            etAnnee!!.setError("Veuillez saisir l'année")
            return
        }


    }
}
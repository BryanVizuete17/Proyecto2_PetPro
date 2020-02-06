package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegistryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)


        val buttonAceptarRegistro: Button = findViewById(R.id.buttonAceptarRegistro)
        buttonAceptarRegistro.setOnClickListener {

            var nombre: EditText = findViewById(R.id.editTextNombreReg)
            var apellido: EditText = findViewById(R.id.editTextApellidoReg)
            var email: EditText = findViewById(R.id.editTextEmailReg)
            var phone: EditText = findViewById(R.id.editTextPhoneReg)
            var pw: EditText = findViewById(R.id.editTextPwReg)
            var confPw: EditText = findViewById(R.id.editTextConfirmaPwReg)

            if (nombre.text.toString().isEmpty()) {
                nombre.setError("Ingresar nombre de usuario ")
            }

            if (apellido.text.toString().isEmpty()) {
                apellido.setError("Ingresar apellido de usuario ")
            }

            if (email.text.toString().isEmpty()) {
                email.setError("Ingresar correo electrónico de usuario ")
            }

            if (phone.text.toString().isEmpty()) {
                phone.setError("Ingresar teléfono de usuario ")
            }

            if (pw.text.toString().isEmpty()) {
                pw.setError("Ingresar contraseña de usuario ")
            }

            if (confPw.text.toString().isEmpty()) {
                confPw.setError("Confirmar contraseña de usuario ")
            } else {
                /*val prIntent: Intent = Intent(this, Register::class.java)
                startActivity(prIntent)*/
            }


        }
    }
}

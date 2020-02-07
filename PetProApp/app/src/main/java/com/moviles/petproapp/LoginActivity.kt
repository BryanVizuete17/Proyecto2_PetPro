package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var nombreUsuario: EditText
    private lateinit var passwordUsuario: EditText
    private lateinit var usuario: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        nombreUsuario = findViewById(R.id.editTextUserLogin)
        passwordUsuario = findViewById(R.id.editTextPwLogin)

        auth = FirebaseAuth.getInstance()
    }


    fun onClickLogin(view: View) {

        usuario = nombreUsuario.text.toString()
        password = passwordUsuario.text.toString()

        when {
            usuario.isEmpty() -> {
                nombreUsuario.error = "Campo obligatorio"
            }
            password.isEmpty() -> {
                passwordUsuario.error = "Campo obligatorio"
            }
            password.length < 8 -> {
                passwordUsuario.error = "La contraseña debe tener al menos 8 caracteres"
            }
            else -> {
                loginUser()
            }
        }
    }

    fun onClickButtonRegistro(view: View) {
        val prIntent: Intent = Intent(this, RegistryActivity::class.java)
        startActivity(prIntent)
    }

    private fun loginUser() {
        auth.signInWithEmailAndPassword(usuario,password)
            .addOnCompleteListener(this){task ->
                if (task.isSuccessful){
                    val intentHome = Intent(this,HomeActivity::class.java)
                    startActivity(intentHome)
                    finish()
                }else{
                    Toast.makeText(this, "Error durante la autenticación", Toast.LENGTH_LONG).show()
                }
            }
    }
}

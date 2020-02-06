package com.moviles.petproapp

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.util.regex.Pattern


class RegistryActivity : AppCompatActivity() {

    private lateinit var nombreUsuario: EditText
    private lateinit var apellidoUsuario: EditText
    private lateinit var emailUsuario: EditText
    private lateinit var telefonoUsuario: EditText
    private lateinit var passwordUsuario: EditText
    private lateinit var confirmarPasswordUsuario: EditText
    private lateinit var db: FirebaseFirestore
    private lateinit var nombre: String
    private lateinit var apellido: String
    private lateinit var email: String
    private lateinit var telefono: String
    private lateinit var password: String
    private lateinit var confirmacion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)

        nombreUsuario = findViewById(R.id.editTextNombreReg)
        apellidoUsuario = findViewById(R.id.editTextApellidoReg)
        emailUsuario = findViewById(R.id.editTextEmailReg)
        telefonoUsuario = findViewById(R.id.editTextPhoneReg)
        passwordUsuario = findViewById(R.id.editTextPwReg)
        confirmarPasswordUsuario = findViewById(R.id.editTextConfirmaPwReg)
    }

    fun onClickRegistrarUsuario(view: View){

        nombre = nombreUsuario.text.toString()
        apellido = apellidoUsuario.text.toString()
        email = emailUsuario.text.toString()
        telefono = telefonoUsuario.text.toString()
        password = passwordUsuario.text.toString()
        confirmacion = confirmarPasswordUsuario.text.toString()

        when{
            nombre.isEmpty() -> {
                nombreUsuario.error = "Campo obligatorio"
            }
            apellido.isEmpty() -> {
                apellidoUsuario.error = "Campo obligatorio"
            }
            email.isEmpty() -> {
                emailUsuario.error = "Campo obligatorio"
            }
            !validarEmail(email) -> {
                emailUsuario.error = "Correo electrónico no valido"
            }
            telefono.isEmpty() -> {
                telefonoUsuario.error = "Campo obligatorio"
            }
            password.isEmpty() -> {
                passwordUsuario.error = "Campo obligatorio"
            }
            password.length < 8 -> {
                passwordUsuario.error = "La contraseña debe tener al menos 8 caracteres"
            }
            confirmacion.isEmpty() -> {
                confirmarPasswordUsuario.error = "Campo obligatorio"
            }
            !confirmacion.equals(password) -> {
                confirmarPasswordUsuario.error = "La confirmacion no coincide con la contraseña"
            }
            else -> {

                // Intent y funcion de validacion con email
            }
        }
    }

    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}

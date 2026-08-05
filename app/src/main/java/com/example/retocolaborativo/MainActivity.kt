package com.example.retocolaborativo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var token: String? = null   // aquí guardaremos la "manilla"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hacerLogin("emilys", "emilyspass")
    }


    private fun hacerLogin(usuario: String, clave: String) {
        // lifecycleScope.launch = ejecuta en una corrutina (sin congelar la app)
        lifecycleScope.launch {


            try {
                val resp = RetrofitClient.api.login(
                    LoginRequest(usuario, clave)
                )
                if (resp.isSuccessful) {
                    token = resp.body()?.accessToken   // ← guardamos el token
                    Log.d("API", "Token recibido: $token")
                    obtenerUsuario()                  // seguimos al GET

        }
            }
        }
    }
}




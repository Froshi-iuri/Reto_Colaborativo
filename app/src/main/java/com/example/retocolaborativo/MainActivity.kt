package com.example.retocolaborativo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.retocolaborativo.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var token: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        token = prefs.getString("token_guardado", null)
        if (token != null) obtenerUsuario()

        binding.btnLogin.setOnClickListener {
            val user = binding.etUsername.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()
            if (user.isNotEmpty() && pass.isNotEmpty()) hacerLogin(user, pass)
            else Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun hacerLogin(usuario: String, clave: String) {
        lifecycleScope.launch {
            try {
                val resp = RetrofitClient.api.login(LoginRequest(usuario, clave))
                if (resp.isSuccessful) {
                    token = resp.body()?.accessToken
                    getSharedPreferences("app_prefs", Context.MODE_PRIVATE).edit()
                        .putString("token_guardado", token).apply()
                    obtenerUsuario()
                } else {
                    Toast.makeText(this@MainActivity, "Login falló", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e("API", "Error: ${e.message}")
            }
        }
    }

    private fun obtenerUsuario() {
        val t = token ?: return
        lifecycleScope.launch {
            try {
                val resp = RetrofitClient.api.getCurrentUser("Bearer $t")
                if (resp.isSuccessful) {
                    val user = resp.body()
                    binding.tvResult.text = "Hola ${user?.firstName}"
                }
            } catch (e: Exception) {
                Log.e("API", "Error: ${e.message}")
            }
        }
    }
}
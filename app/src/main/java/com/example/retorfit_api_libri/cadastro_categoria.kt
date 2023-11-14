package com.example.retorfit_api_libri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class cadastro_categoria : AppCompatActivity() {

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_categoria)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)

        findViewById<Button>(R.id.btnCadastrarCategoria).setOnClickListener {
            val nomeCategoria = txtCategoria.text
            //Log.e("TESTE", "${nomeCategoria}")
            createCategory(nomeCategoria.toString())

        }

    }

    private fun createCategory(nome_categoria: String){
        lifecycleScope.launch {
            val body = JsonObject().apply {
                addProperty("nome_categoria", nome_categoria)
            }

            val result =apiService.createCategory(body)

            if(result.isSuccessful){
                val msg =  result.body()?.get("mensagemStatus")
                Log.e("CREATING-CATEGORY", "CREATE CATEGORY SUCCESS: ${result.body()?.get("mensagemStatus")}")
            }else{
                Log.e("CREATING-CATEGORY", "ERROR: ${result.message()}")
            }
        }
    }

    private fun getCategoryByID(){
        lifecycleScope.launch {
            val result = apiService.getCategoryByID("1")
            if(result.isSuccessful){
                Log.e("GETTING-CATEGORY", "getUserByID: ${result.body()?.data}")
            }else{
                Log.e("GETTING-CATEGORY", "getUserByID: ${result.message()}")
            }
        }
    }
}
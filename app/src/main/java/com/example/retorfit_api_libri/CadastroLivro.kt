package com.example.retorfit_api_libri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.JsonObject

class CadastroLivro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_livro)

        //DECLARANDO E RECUPERANDO OS OBJETOS DE VIEW
        val txtTitulo = findViewById<EditText>(R.id.txtTitulo)
        val txtPreco = findViewById<EditText>(R.id.txtPreco)
        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)
        val txtDescricao = findViewById<EditText>(R.id.txtLivroDescricao)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrarLivro)

        //TRATAMENTO DA AÇÃO S CLIQUE DO BOTÃO CADASTRAR
        btnCadastrar.setOnClickListener {

            //ENTRADA DOS DADOS DE LIVRO
            val titulo = txtTitulo.text.toString()
            val preco = txtPreco.text.toString()
            val categoria = txtCategoria.text.toString()
            val descricao = txtDescricao.text.toString()

            //MOTAGEM DO CORPO JSON DOS DADOS DE LIVRO
            val body = JsonObject().apply {
                addProperty("titulo", titulo)
                addProperty("preco", preco)
                addProperty("categoria", categoria)
                addProperty("descricao", descricao)
            }

            //TESTE DO CORPO DE DADOS JSON
            Log.e("BODY-JSON", body.toString())

            //NAVEGAÇÃO PARA A TELA DE IMAGENS DE LIVRO
            val intent = Intent(
                    this,
                                CadastroLivroImagem::class.java).apply {
                                        putExtra("bodyJSON", body.toString())
                                }

            startActivity(intent)

        }


    }
}
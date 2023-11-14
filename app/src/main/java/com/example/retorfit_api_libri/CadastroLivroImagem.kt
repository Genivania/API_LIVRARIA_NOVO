package com.example.retorfit_api_libri

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference

class CadastroLivroImagem : AppCompatActivity() {

    //ATRIBUTOS DE MANIPULAÇÃO DE ENDEREÇOS DAS IMAGENS
    private var imageUriGRD: Uri? = null
    private var imageUriPEQ: Uri? = null

    /* CONFIGURAÇÕES DO FIREBASE */
    //DECLARAÇÃO DO STORAGE
    private lateinit var storageRef: StorageReference

    //DECLARAÇÃO DO FIRESTORE DATABASE
    private lateinit var firebaseFirestore: FirebaseFirestore

    /* OBJETOS DE VIEW DA TELA */
    //IMAGEVIEW
    private var btnImgGRD: ImageView? = null
    private var btnImgPEQ: ImageView? = null

    //BUTTON
    private var btnUpload: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_livro_imagem)

        //TESTE DE RECEBIMENTO DO JSON
        val bodyJSON = intent.getStringExtra("bodyJSON")
            Log.e("TESTE-JSON", bodyJSON.toString())

        //RECUPERA OS ELEMENTOS DE VIEW DE IMAGENS
        btnImgGRD = findViewById<ImageView>(R.id.imgGRD)
        btnImgPEQ = findViewById<ImageView>(R.id.imgPEQ)

        //RECUPERA O ELEMENTO DE VIEW DE BUTTON
        btnUpload = findViewById<Button>(R.id.btnCadastrarLivro)

        //TRATAMENTO DO EVENTO DE CLICK DO BOTÃO DE IMAGEM GRANDE
        btnImgGRD?.setOnClickListener {
            Toast.makeText(this,
                                "BOTÃO DA IMAGEM GRANDE",
                                    Toast.LENGTH_LONG).show()
        }

        //TRATAMENTO DO EVENTO DE CLICK DO BOTÃO DE IMAGEM PEQUENA
        btnImgPEQ?.setOnClickListener {
            Toast.makeText(this,
                "BOTÃO DA IMAGEM PEQUENA",
                Toast.LENGTH_LONG).show()
        }
        //TRATAMENTO DO EVENTO DE CLICK DO BOTÃO DE CADASTRO
        btnUpload?.setOnClickListener {
            Toast.makeText(this,
                "BOTÃO DE CADASTRO",
                Toast.LENGTH_LONG).show()
        }

    }
}
package com.example.perfil_aluno.model

import com.example.perfil_aluno.R

class Aluno(
    val nome: String,
    val curso:String,
) {
    var faltas:Int=0
    var nota:Int=0
    var foto:Int= R.drawable.imagembmw

}

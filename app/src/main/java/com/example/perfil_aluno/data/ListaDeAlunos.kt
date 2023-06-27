package com.example.perfil_aluno.data

import com.example.perfil_aluno.model.Aluno

class ListaDeAlunos {

    fun carregarListaDeAlunos():List<Aluno>{
        return listOf<Aluno>(
            Aluno("Pedro","CriaçãoDeAplicativo"),
            Aluno("joão","CriaçãoDeAplicativo"),
            Aluno("Maria","CriaçãoDeAplicativo"),
            Aluno("Antonio","CriaçãoDeAplicativo"),
            Aluno("Godofreldo","CriaçãoDeAplicativo"),
            Aluno("Joana","CriaçãoDeAplicativo"),
            Aluno("RycharllisonPinto","CriaçãoDeAplicativo"),

        )
    }
}
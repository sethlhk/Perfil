package com.example.perfil_aluno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.perfil_aluno.data.ListaDeAlunos
import com.example.perfil_aluno.model.Aluno
import com.example.perfil_aluno.ui.theme.Perfil_alunoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Perfil_alunoTheme {
                AppDiariodeClasse()
            }
        }
    }
}

@Composable
fun AppDiariodeClasse() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {


        LazyColumn {
            items(ListaDeAlunos().carregarListaDeAlunos()) { Aluno ->
                Portal_aluno(aluno = Aluno)
            }
        }

    }
}

@Composable
fun Portal_aluno(
    aluno: Aluno
) {
    var expandir by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.imagembmw),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Column() {
                    Text(text = "nome")
                    Text(text = "curso")
                }
                Spacer(modifier = Modifier.width(80.dp))
                Icon(
                    imageVector =
                    if (expandir)
                        Icons.Filled.KeyboardArrowDown
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { expandir = !expandir }
                )
            }
            if (expandir) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Faltas ${aluno.faltas}",
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "nota: ${aluno.nota}",
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCardAluno() {
    Portal_aluno(
        aluno = Aluno(
            nome = "Pedro Augusto Frois",
            curso = "CriaçãoDeAplicativo"
        )
    )
}





        
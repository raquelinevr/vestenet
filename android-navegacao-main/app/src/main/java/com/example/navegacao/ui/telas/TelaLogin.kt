package com.example.navegacao.ui.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun TelaLogin(modifier: Modifier = Modifier, onSignInClick: () -> Unit) {
    var login by remember {mutableStateOf("")}
    var senha by remember {mutableStateOf("")}
    var mensagemErro by remember { mutableStateOf<String?>(null) }

    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
            TextField(value = login, onValueChange = {login = it},
                placeholder = {Text("Login")}
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = senha, onValueChange = {senha = it},
                placeholder = {Text("Senha")},
                visualTransformation = PasswordVisualTransformation(),
                )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (login ==  senha) {
                    onSignInClick()
                } else {
                    mensagemErro = "Login ou senha inválidos!"
                }
            }) {
                Text("Entrar")
            }
        mensagemErro?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
            LaunchedEffect(Unit) {
                delay(3000)
                mensagemErro = null
            }
        }
    }
}
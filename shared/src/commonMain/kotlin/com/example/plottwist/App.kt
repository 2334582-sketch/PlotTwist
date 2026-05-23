package com.example.plottwist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import plottwist.shared.generated.resources.Res
import plottwist.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        // Cambio 1
        Text("⚠️ Sección de Pruebas - Rama 2", style = MaterialTheme.typography.titleMedium)
        var showContent by remember { mutableStateOf(false) }

        // Cambio 2
        Button(onClick = { /* Acción vacía */ }) {
            Text("Modificacion hecha por Rama2")
        }

        // Cambio 3
        Text("Desarrollado en 2026", style = MaterialTheme.typography.labelSmall)
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Proyecto plot twist")
                Text("Equipo: El Tronco, Ali, Dayana")
                Button(onClick = { /* Acción vacía */ }) {
                    Text("Botón moverse")
                }
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
        }
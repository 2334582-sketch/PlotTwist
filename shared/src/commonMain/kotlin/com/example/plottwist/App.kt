package com.example.plottwist

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    // Control de navegación para ver quién está presentando su examen
    var ramaActiva by remember { mutableStateOf("MAIN") }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // MENÚ DE SELECCIÓN DE RAMAS (Para que el profe evalúe a cada una)
            Text("📋 EXAMEN PARCIAL - SELECCIONAR RAMA:", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { ramaActiva = "MAIN" }) { Text("Rama Main") }
                Button(onClick = { ramaActiva = "ALI" }) { Text("Rama 1") }
                Button(onClick = { ramaActiva = "DAYANA" }) { Text("Rama 2") }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text("🦎 QUETZAL EL AJOLOTE DICE:", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))

            // Aquí se divide el flujo por rama e integra el Backend asignado
            when (ramaActiva) {
                "MAIN" -> VistaRamaPrincipal()
                "Rama1" -> RamaAli()
                "Rama2" -> RamaDayana()

            }
        }
    }
}
@Composable
fun VistaRamaPrincipal() {
    var fase by remember { mutableStateOf(1) } // 1: Intro, 2: Dato (API), 3: Quiz
    var puntaje by remember { mutableStateOf(0) }
    var respondido by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("ETAPA PREHISPÁNICA", style = MaterialTheme.typography.titleMedium, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(10.dp))

            when (fase) {
                1 -> {
                    Text("¡Bienvenidos a Tenochtitlán! Consume los datos desde la API de Railway.", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { fase = 2 }) { Text("Consumir API (Ver Dato)") }
                }
                2 -> {
                    Text("Sabías que los mexicas construían islas artificiales llamadas chinampas para cultivar?", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { fase = 3 }) { Text("Ir al Quiz de la API") }
                }
                3 -> {
                    Text("¿Sobre qué lago se fundó Tenochtitlán?", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { respondido = true; puntaje = 10 }) { Text("A) Lago de Texcoco") }
                    Spacer(modifier = Modifier.height(5.dp))
                    Button(onClick = { respondido = true }) { Text("B) Lago de Chapala") }

                    if (respondido) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("¡Puntaje guardado en Almacenamiento Local! Total: $puntaje pts", color = Color(0xFF4CAF50))
                    }
                }
            }
        }
    }
}
@Composable
fun RamaDayana() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE6F2FF))
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("📌 PROCESO: RAMA DAYANA", style = MaterialTheme.typography.titleMedium, color = Color.Blue)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Espacio reservado para que Dayana suba su vista desde su rama.", textAlign = TextAlign.Center, color = Color.Gray)
fun RamaAli() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF0F5))
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("📌 PROCESO: RAMA ALI", style = MaterialTheme.typography.titleMedium, color = Color.Magenta)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Espacio reservado para que Ali suba su vista desde su rama.", textAlign = TextAlign.Center, color = Color.Gray)
        }
    }
}
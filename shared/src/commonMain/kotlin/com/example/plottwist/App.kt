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
                Button(onClick = { ramaActiva = "Rama1" }) { Text("Rama 1") }
                Button(onClick = { ramaActiva = "Rama2" }) { Text("Rama 2") }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text("QUETZAL EL AJOLOTE DICE:", style = MaterialTheme.typography.titleLarge)
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
fun RamaAli() {
    var fase by remember { mutableStateOf(1) }
    var puntaje by remember { mutableStateOf(0) }
    var respondido by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF0F5))
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("LA INDEPENDENCIA Y REVOLUCIÓN", style = MaterialTheme.typography.titleMedium, color = Color.Magenta)
            Spacer(modifier = Modifier.height(10.dp))

            when (fase) {
                1 -> {
                    Text("¡Viva México! Conectando con el endpoint /etapas de Ali en el Backend.", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { fase = 2 }, colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)) {
                        Text("Consumir API (Ver Dato)")
                    }
                }
                2 -> {
                    Text("¿Sabías que el campaneo de Hidalgo no fue en la mañana, sino en la noche del 15 de septiembre?", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { fase = 3 }, colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)) {
                        Text("Ir al Quiz de la API")
                    }
                }
                3 -> {
                    Text("¿Quién es conocido como el Padre de la Patria?", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { respondido = true; puntaje = 10 }, colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)) {
                        Text("A) Miguel Hidalgo")
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Button(onClick = { respondido = true }, colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)) {
                        Text("B) Porfirio Díaz")
                    }

                    if (respondido) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text("¡Puntaje de Ali guardado localmente! Total: $puntaje pts", color = Color(0xFF4CAF50))
                    }
                }
            }
            Text("PROCESO: RAMA ALI", style = MaterialTheme.typography.titleMedium, color = Color.Magenta)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Esto es de la rama1.", textAlign = TextAlign.Center, color = Color.Gray)
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
            Text("PROCESO: RAMA DAYANA", style = MaterialTheme.typography.titleMedium, color = Color.Blue)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Esto es de la rama2.", textAlign = TextAlign.Center, color = Color.Gray)
    }
        @Composable
        fun Rama2() {
            var fase by remember { mutableStateOf(1) }
            var puntaje by remember { mutableStateOf(0) }
            var respondido by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE6F2FF))
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("MÉXICO MODERNO", style = MaterialTheme.typography.titleMedium, color = Color.Blue)
                    Spacer(modifier = Modifier.height(10.dp))

                    when (fase) {
                        1 -> {
                            Text("¡Bienvenidos al siglo XXI! Mapeando los datos del servidor Ktor de Rama2.", textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(onClick = { fase = 2 }) { Text("Consumir API (Ver Dato)") }
                        }
                        2 -> {
                            Text("¿Sabías que la Constitución actual que rige a México se promulgó en Querétaro en 1917?", textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(onClick = { fase = 3 }) { Text("Ir al Quiz de la API") }
                        }
                        3 -> {
                            Text("¿En qué año se promulgó la Constitución Mexicana vigente?", textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(onClick = { respondido = true; puntaje = 10 }) { Text("A) 1917") }
                            Spacer(modifier = Modifier.height(5.dp))
                            Button(onClick = { respondido = true }) { Text("B) 1810") }

                            if (respondido) {
                                Spacer(modifier = Modifier.height(10.dp))
                                Text("¡Puntaje de Dayana guardado localmente! Total: $puntaje pts", color = Color(0xFF4CAF50))
                            }
                        }
                    }
                }
            }
        }
}
}

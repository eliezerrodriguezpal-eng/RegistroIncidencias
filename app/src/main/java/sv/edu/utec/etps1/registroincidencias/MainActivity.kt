package sv.edu.utec.etps1.registroincidencias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.edu.utec.etps1.registroincidencias.ui.theme.RegistroIncidenciasTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RegistroIncidenciasTheme {
                RegistroIncidenciaScreen()
            }
        }
    }
}

@Composable
fun RegistroIncidenciaScreen() {

    // Variables para guardar temporalmente lo escrito
    var titulo by remember {
        mutableStateOf("")
    }

    var descripcion by remember {
        mutableStateOf("")
    }

    var mensaje by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            // Título principal
            Text(
                text = "REGISTRO DE INCIDENCIA",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Ingrese los datos de la incidencia",
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier.height(25.dp)
            )

            // Tarjeta del formulario
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    // Campo para el título
                    Text(
                        text = "Título de la incidencia",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    OutlinedTextField(
                        value = titulo,
                        onValueChange = {
                            titulo = it
                            mensaje = ""
                        },
                        label = {
                            Text("Escriba el título")
                        },
                        placeholder = {
                            Text("Ejemplo: Problema con el sistema")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    // Campo para la descripción
                    Text(
                        text = "Descripción",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    OutlinedTextField(
                        value = descripcion,
                        onValueChange = {
                            descripcion = it
                            mensaje = ""
                        },
                        label = {
                            Text("Descripción de la incidencia")
                        },
                        placeholder = {
                            Text("Explique brevemente el problema")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 5
                    )

                    Spacer(
                        modifier = Modifier.height(25.dp)
                    )

                    // Botón principal
                    Button(
                        onClick = {

                            if (titulo.isBlank() || descripcion.isBlank()) {

                                mensaje =
                                    "Por favor, complete el título y la descripción."

                            } else {

                                mensaje =
                                    "Incidencia registrada correctamente."
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text = "REGISTRAR INCIDENCIA",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    // Mensaje de respuesta
                    if (mensaje.isNotBlank()) {

                        Text(
                            text = mensaje,
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}
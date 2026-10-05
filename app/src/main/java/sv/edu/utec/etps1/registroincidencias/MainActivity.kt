package sv.edu.utec.etps1.registroincidencias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
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

    // Variables para guardar temporalmente los datos
    var titulo by remember {
        mutableStateOf("")
    }

    var descripcion by remember {
        mutableStateOf("")
    }

    var prioridad by remember {
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
                        singleLine = true,

                        // Configuración del teclado
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            imeAction = ImeAction.Next
                        )
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
                        minLines = 5,

                        // Configuración del teclado
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            imeAction = ImeAction.Done
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    // Selección de prioridad
                    Text(
                        text = "Seleccione la prioridad",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        // Prioridad Baja
                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    prioridad = "Baja"
                                    mensaje = ""
                                },
                            shape = RoundedCornerShape(8.dp),
                            color = if (prioridad == "Baja")
                                MaterialTheme.colorScheme.primaryContainer
                            else
                                MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = "Baja",
                                modifier = Modifier.padding(12.dp),
                                fontWeight = if (prioridad == "Baja")
                                    FontWeight.Bold
                                else
                                    FontWeight.Normal
                            )
                        }

                        // Prioridad Media
                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    prioridad = "Media"
                                    mensaje = ""
                                },
                            shape = RoundedCornerShape(8.dp),
                            color = if (prioridad == "Media")
                                MaterialTheme.colorScheme.primaryContainer
                            else
                                MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = "Media",
                                modifier = Modifier.padding(12.dp),
                                fontWeight = if (prioridad == "Media")
                                    FontWeight.Bold
                                else
                                    FontWeight.Normal
                            )
                        }

                        // Prioridad Alta
                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    prioridad = "Alta"
                                    mensaje = ""
                                },
                            shape = RoundedCornerShape(8.dp),
                            color = if (prioridad == "Alta")
                                MaterialTheme.colorScheme.primaryContainer
                            else
                                MaterialTheme.colorScheme.surfaceVariant
                        ) {
                            Text(
                                text = "Alta",
                                modifier = Modifier.padding(12.dp),
                                fontWeight = if (prioridad == "Alta")
                                    FontWeight.Bold
                                else
                                    FontWeight.Normal
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    // Mostrar prioridad seleccionada
                    if (prioridad.isNotBlank()) {

                        Text(
                            text = "Prioridad seleccionada: $prioridad",
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(25.dp)
                    )

                    // Botón principal
                    Button(
                        onClick = {

                            if (
                                titulo.isBlank() ||
                                descripcion.isBlank() ||
                                prioridad.isBlank()
                            ) {

                                mensaje =
                                    "Por favor, complete todos los campos y seleccione una prioridad."

                            } else {

                                mensaje =
                                    "Incidencia registrada correctamente. Prioridad: $prioridad"
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
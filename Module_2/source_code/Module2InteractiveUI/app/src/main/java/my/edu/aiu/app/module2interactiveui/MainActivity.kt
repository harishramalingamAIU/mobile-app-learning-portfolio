package my.edu.aiu.app.module2interactiveui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Student(val name: String, val course: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    InteractiveProfileScreen()
                }
            }
        }
    }
}

@Composable
fun InteractiveProfileScreen() {
    var name by remember { mutableStateOf("") }
    var submittedName by remember { mutableStateOf("") }
    var clickCount by remember { mutableIntStateOf(0) }

    val student = Student(
        submittedName.ifBlank { "Student" },
        "Mobile Application Development"
    )

    val greeting: (String) -> String = {
        if (it.isBlank()) "Please enter your name." else "Welcome, $it!"
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Interactive Profile", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                submittedName = name
                clickCount++
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        Spacer(Modifier.height(24.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(greeting(submittedName), fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(8.dp))
                Text("Name: ${student.name}")
                Text("Course: ${student.course}")
                Text("Button clicked: $clickCount time(s)")
                Spacer(Modifier.height(8.dp))
                Text(
                    if (clickCount >= 3)
                        "Great! You have interacted with the app several times."
                    else
                        "Try clicking the button three times."
                )
            }
        }
    }
}

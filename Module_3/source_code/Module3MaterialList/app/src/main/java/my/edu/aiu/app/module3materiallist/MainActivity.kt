package my.edu.aiu.app.module3materiallist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AndroidTopic(val title: String, val description: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { AndroidTopicsApp() } }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidTopicsApp() {
    val topics = listOf(
        AndroidTopic("Kotlin", "Modern programming language used for Android development."),
        AndroidTopic("Jetpack Compose", "Declarative toolkit for building Android user interfaces."),
        AndroidTopic("Material Design 3", "Design system for modern Android applications."),
        AndroidTopic("LazyColumn", "Efficiently displays vertically scrolling lists."),
        AndroidTopic("Navigation", "Moves users between different screens in an app."),
        AndroidTopic("ViewModel", "Stores and manages UI-related application data.")
    )

    var selectedTopic by remember { mutableStateOf<AndroidTopic?>(null) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Android Learning Topics") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(topics) { topic ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { selectedTopic = topic },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(Modifier.padding(18.dp)) {
                        Text(topic.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(6.dp))
                        Text(topic.description)
                    }
                }
            }
        }
    }

    selectedTopic?.let { topic ->
        AlertDialog(
            onDismissRequest = { selectedTopic = null },
            title = { Text(topic.title) },
            text = { Text(topic.description) },
            confirmButton = {
                TextButton(onClick = { selectedTopic = null }) { Text("OK") }
            }
        )
    }
}

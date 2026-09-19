package my.edu.aiu.app.module4navigationarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AppUiState(val name: String = "", val completedLessons: Int = 0)

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    fun updateName(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun completeLesson() {
        _uiState.value = _uiState.value.copy(
            completedLessons = _uiState.value.completedLessons + 1
        )
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { NavigationArchitectureApp() } }
    }
}

@Composable
fun NavigationArchitectureApp(appViewModel: AppViewModel = viewModel()) {
    val navController = rememberNavController()
    val uiState by appViewModel.uiState.collectAsState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("home") },
                    icon = { Text("🏠") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("progress") },
                    icon = { Text("📊") },
                    label = { Text("Progress") }
                )
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                HomeScreen(
                    uiState,
                    appViewModel::updateName,
                    appViewModel::completeLesson
                ) { navController.navigate("progress") }
            }

            composable("progress") {
                ProgressScreen(uiState, navController)
            }
        }
    }
}

@Composable
fun HomeScreen(
    uiState: AppUiState,
    onNameChange: (String) -> Unit,
    onCompleteLesson: () -> Unit,
    onOpenProgress: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Home Screen", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = uiState.name,
            onValueChange = onNameChange,
            label = { Text("Your name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = onCompleteLesson, modifier = Modifier.fillMaxWidth()) {
            Text("Complete a Lesson")
        }

        Spacer(Modifier.height(12.dp))

        OutlinedButton(onClick = onOpenProgress, modifier = Modifier.fillMaxWidth()) {
            Text("View Progress")
        }
    }
}

@Composable
fun ProgressScreen(uiState: AppUiState, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Progress Screen", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(20.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(20.dp)) {
                Text("Student: ${uiState.name.ifBlank { "Not entered" }}")
                Text("Completed lessons: ${uiState.completedLessons}")
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Home")
        }
    }
}

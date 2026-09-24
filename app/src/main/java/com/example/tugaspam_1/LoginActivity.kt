package com.example.tugaspam_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.tugaspam_1.ui.theme.*

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Sesuaikan nama Theme dengan file di folder ui.theme (biasanya TugasPAM_1Theme atau AvatarAppTheme)
            TugasPAM_1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var showForgotDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMessage.isNotBlank()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = errorMessage, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (UserRepository.validateLogin(username, password)) {
                    errorMessage = ""
                    context.startActivity(Intent(context, ProfileActivity::class.java))
                } else {
                    errorMessage = "Username atau password salah"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(onClick = { showForgotDialog = true }) {
            Text("Lupa Password")
        }

        TextButton(onClick = {
            context.startActivity(Intent(context, RegistrationActivity::class.java))
        }) {
            Text("Belum punya akun? Daftar")
        }
    }

    if (showForgotDialog) {
        AlertDialog(
            onDismissRequest = { showForgotDialog = false },
            confirmButton = {
                TextButton(onClick = { showForgotDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Lupa Password") },
            text = { Text("Fitur reset password belum tersedia pada versi ini.") }
        )
    }
}
package com.example.tugaspam_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugaspam_1.ui.theme.TugasPAM_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasPAM_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home", style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "Pilih halaman yang ingin dibuka",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { context.startActivity(Intent(context, RegistrationActivity::class.java)) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrasi")
        }

        Button(
            onClick = { context.startActivity(Intent(context, LoginActivity::class.java)) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Button(
            onClick = { context.startActivity(Intent(context, ProfileActivity::class.java)) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Profil User")
        }

        Button(
            onClick = { context.startActivity(Intent(context, AvatarActivity::class.java)) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Avatar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TugasPAM_1Theme {
        HomeScreen()
    }
}
package com.example.tugaspam_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tugaspam_1.ui.theme.TugasPAM_1Theme

class AvatarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasPAM_1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AvatarScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Ditambahkan agar TopAppBar M3 tidak error
@Composable
fun AvatarScreen() {
    var showBrow by remember { mutableStateOf(true) }
    var showEye by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("AvatarApp") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFE91E63),
                titleContentColor = Color.White
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(260.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.face_0004),
                    contentDescription = "Wajah",
                    modifier = Modifier.matchParentSize()
                )
                if (showBrow) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0001),
                        contentDescription = "Alis",
                        modifier = Modifier.matchParentSize()
                    )
                }
                if (showEye) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0003),
                        contentDescription = "Mata",
                        modifier = Modifier.matchParentSize()
                    )
                }
                if (showNose) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0002),
                        contentDescription = "Hidung",
                        modifier = Modifier.matchParentSize()
                    )
                }
                if (showMouth) {
                    Image(
                        painter = painterResource(id = R.drawable.face_0000),
                        contentDescription = "Mulut",
                        modifier = Modifier.matchParentSize()
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CheckboxWithLabel("Brow", showBrow) { showBrow = it }
            CheckboxWithLabel("Eye", showEye) { showEye = it }
            CheckboxWithLabel("Nose", showNose) { showNose = it }
            CheckboxWithLabel("Mouth", showMouth) { showMouth = it }
        }
    }
}

@Composable
fun CheckboxWithLabel(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(label)
    }
}
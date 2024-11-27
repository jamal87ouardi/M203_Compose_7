package com.example.m203_compose_7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.m203_compose_7.ui.theme.M203_Compose_7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M203_Compose_7Theme {

            }
        }
    }
}

object GlobalState {
    var currentScreen = mutableStateOf("screen1")
}

@Composable
fun AppContent() {
    when (GlobalState.currentScreen.value) {
        "screen1" -> Screen1()
        "screen2" -> Screen2()
    }
}

@Composable
fun Screen1() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Écran 1")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { GlobalState.currentScreen.value = "screen2" }) {
            Text("Aller à l'Écran 2")
        }
    }
}

@Composable
fun Screen2() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Écran 2")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { GlobalState.currentScreen.value = "screen1" }) {
            Text("Retour à l'Écran 1")
        }
    }
}


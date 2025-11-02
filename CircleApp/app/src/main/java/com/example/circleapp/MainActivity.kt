package com.example.circleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.circleapp.screens.CalculationScreen
import com.example.circleapp.ui.theme.CircleAppTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CircleAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(), color = Color(0xFFADD8E6)
                ){
                    CalculationScreen(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

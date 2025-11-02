@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.circleapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.circleapp.R
import kotlin.math.PI


@Composable
fun CalculationScreen(modifier: Modifier = Modifier) {
    var textFieldEntry by remember { mutableStateOf("") }
    var areaCalculation by remember {mutableStateOf<Double?>(null)}
    var isCalculationButtonEnabled by remember { mutableStateOf(false) }
    var isTextFieldEnabled by remember { mutableStateOf(true) }
    CircleAppTopBar()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        // This image is licensed and released into the public domain
        // https://commons.wikimedia.org/wiki/File:Circle_Area.svg
        Image(
            painter = painterResource(R.drawable.circle_area),
            contentDescription = "Area of a circle image and formula",
            modifier = Modifier
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier.border(width = 1.dp, color = Color.Gray),
            value = textFieldEntry,
            enabled = isTextFieldEnabled,
            label = {Text(stringResource(com.example.circleapp.R.string.text_field_label))},
            onValueChange = {
                    enteredRadiusString -> textFieldEntry = enteredRadiusString
                isCalculationButtonEnabled = true
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFADD8E6),
                focusedContainerColor = Color(0xFFADD8E6),
                disabledContainerColor = Color(0xFFADD8E6),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        if (areaCalculation == null){
            Button(
                onClick = {
                    try{
                        areaCalculation = calculateAreaOfCircle(textFieldEntry.toDouble())
                        isTextFieldEnabled = false
                    }catch (e: NumberFormatException){
                        Log.e("TextFieldEmpty", "A Radius must be entered " +
                                "to perform calculations")
                    }
                },
                enabled = isCalculationButtonEnabled
            ) {
                Text(text = stringResource(com.example.circleapp.R.string.calculate))
            }
        } else {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                Text(text = "Radius obtained: ${textFieldEntry}")
                Text(text = "Area calculated: ${areaCalculation}")

                Button(
                    onClick = {
                        areaCalculation = null
                        textFieldEntry = ""
                        isCalculationButtonEnabled = false
                        isTextFieldEnabled = true
                    },
                ) {
                    Text(text = stringResource(com.example.circleapp.R.string.button_calculate_new))
                }
            }
        }

    }
}

@Composable
fun CircleAppTopBar( modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFFADD8E6)
        )
    )
}

fun calculateAreaOfCircle(r: Double): Double {
    val area = PI * r * r
    return area
}

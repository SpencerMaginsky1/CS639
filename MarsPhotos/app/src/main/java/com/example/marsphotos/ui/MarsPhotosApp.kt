/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.marsphotos.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marsphotos.R
import com.example.marsphotos.ui.screens.HomeScreen
import com.example.marsphotos.ui.screens.MarsViewModel
import com.example.marsphotos.ui.screens.MarsPhotoGridScreen
import androidx.compose.ui.graphics.Color

sealed class Screen{
    object MarsPhotos: Screen()
    object PhotoResults: Screen()
}
@Composable
fun MarsPhotosApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.PhotoResults) }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { MarsTopAppBar(scrollBehavior = scrollBehavior) },
        floatingActionButton = {
            if (currentScreen is Screen.PhotoResults) {
                FloatingActionButton(
                    onClick = { currentScreen = Screen.MarsPhotos }
                ) {
                    Text(
                        text = stringResource(R.string.button_photos),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                     )

                }
            } else if (currentScreen is Screen.MarsPhotos){
                FloatingActionButton(
                    onClick = { currentScreen = Screen.PhotoResults }
                ) {
                    Text(
                        text = stringResource(R.string.button_results),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(), color = Color(0xFFADD8E6)
        ) {
            when(currentScreen){
                is Screen.PhotoResults -> {
                    val marsViewModel: MarsViewModel = viewModel()
                    HomeScreen(
                        marsUiState = marsViewModel.marsUiState,
                        contentPadding = it,
                        onNavToPhotoDisplay = { currentScreen = Screen.MarsPhotos }
                    )
                }
                is Screen.MarsPhotos -> {
                    val marsViewModel: MarsViewModel = viewModel()
                    MarsPhotoGridScreen(
                        marsUiState = marsViewModel.marsUiState,
                        onNavToHomeScreen = { currentScreen = Screen.PhotoResults }
                    )
                }

            }
        }
    }
}

@Composable
fun MarsTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
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

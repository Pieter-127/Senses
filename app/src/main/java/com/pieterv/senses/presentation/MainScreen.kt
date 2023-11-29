package com.pieterv.senses.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.pieterv.senses.presentation.component.Animation

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    MainScreenContent(viewModel.state)

    LaunchedEffect(key1 = Unit) {
        viewModel.startLightSensor()
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreenContent(state = MainScreenState())
}

@Composable
fun MainScreenContent(state: MainScreenState) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = if (state.isCurrentlyDark) {
            Color.DarkGray
        } else {
            Color.White
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Animation(Modifier.testTag("Animation"), state = state)
        }
    }
}

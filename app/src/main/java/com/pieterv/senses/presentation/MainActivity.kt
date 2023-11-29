package com.pieterv.senses.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pieterv.senses.presentation.navigation.Navigation
import com.pieterv.senses.ui.theme.SensesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensesTheme {
                Navigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SensesTheme {
        MainScreenContent(state = MainScreenState())
    }
}

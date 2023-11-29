package com.pieterv.senses.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class MainScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var state: MainScreenState

    @Test
    fun animationIsDisplayed() {
        state = MainScreenState(isCurrentlyDark = true)
        composeTestRule.setContent {
            MainScreenContent(state)
        }

        composeTestRule.onNodeWithTag("Animation").assertIsDisplayed()
    }
}

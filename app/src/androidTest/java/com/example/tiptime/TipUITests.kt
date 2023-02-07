package com.example.tiptime

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput

import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                Surface (modifier = Modifier.fillMaxSize()){
                    TipTimeScreen()
                }
            }
        }
        composeTestRule.onNodeWithText("Bill amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip: (%)").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip amount: $expectedTip").assertExists(
            "No node with this text was found."
        )
    }
}
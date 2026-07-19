package com.arrowreveal.puzzle.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101827))
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Arrow Reveal Puzzle",
            color = Color.White,
            fontSize = 32.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "Ready to reveal the hidden image?",
            color = Color.LightGray,
            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        Button(
            onClick = {
                // Start game action
            }
        ) {

            Text(
                text = "Start Level"
            )

        }
    }
}

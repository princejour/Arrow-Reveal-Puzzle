package com.arrowreveal.puzzle.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arrowreveal.puzzle.R
import com.arrowreveal.puzzle.model.ImageRevealState


@Composable
fun ImageRevealView(

    state: ImageRevealState

) {


    Box(

        modifier =
            Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(
                    Color.Black
                ),

        contentAlignment =
            Alignment.Center

    ) {


        Image(

            painter =
                painterResource(
                    id = R.drawable.image_placeholder
                ),

            contentDescription =
                state.imageName

        )


        if(!state.completed) {


            Text(

                text =
                    "${state.revealPercent.toInt()}%",

                color =
                    Color.White,

                fontSize =
                    30.sp

            )

        }


    }

}

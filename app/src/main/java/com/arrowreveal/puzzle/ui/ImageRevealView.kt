package com.arrowreveal.puzzle.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
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
                .height(220.dp),

        contentAlignment =
            Alignment.Center

    ) {


        Image(

            painter =
                painterResource(
                    id =
                        R.drawable.image_placeholder
                ),

            contentDescription =
                state.imageName,

            modifier =
                Modifier
                    .fillMaxWidth()

        )



        ImageMask(

            progress =
                state.revealPercent / 100f

        )



        if(!state.completed){


            Text(

                text =
                    "${state.revealPercent.toInt()}%",

                color =
                    Color.White,

                fontSize =
                    32.sp

            )

        }


    }

}

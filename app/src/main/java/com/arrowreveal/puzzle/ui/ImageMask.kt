package com.arrowreveal.puzzle.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ImageMask(

    progress: Float

) {


    Canvas(

        modifier =
            Modifier.fillMaxSize()

    ){


        val hiddenPercent =
            1f - progress



        drawRect(

            color =
                Color.Black.copy(
                    alpha = hiddenPercent
                )

        )


    }

}

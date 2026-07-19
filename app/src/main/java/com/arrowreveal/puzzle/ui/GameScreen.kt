package com.arrowreveal.puzzle.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun GameScreen(

    gameViewModel: GameViewModel = viewModel()

) {


    val state by
        gameViewModel.gameState.collectAsState()



    Column(

        modifier =
            Modifier.fillMaxSize(),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center

    ){


        Text(

            text =
                "Level ${state.level}",

            fontSize =
                28.sp

        )


        Spacer(
            modifier =
                Modifier.height(20.dp)
        )



        GameBoard(

            state = state,

            onBlockClick = {

                gameViewModel.selectBlock(it)

            }

        )



        Spacer(
            modifier =
                Modifier.height(20.dp)
        )



        if(state.isCompleted){


            Text(
                text =
                    "🎉 You Win!"
            )


            Button(

                onClick = {

                    gameViewModel.nextLevel()

                }

            ){

                Text(
                    "Next Level"
                )

            }


        }



    }

}

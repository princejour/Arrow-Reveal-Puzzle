package com.arrowreveal.puzzle.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.Direction
import com.arrowreveal.puzzle.model.GameState


@Composable
fun GameBoard(

    state: GameState,

    onBlockClick: (Block) -> Unit

) {


    LazyVerticalGrid(

        columns =
            GridCells.Fixed(
                state.gridSize
            ),

        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp)

    ) {


        items(

            state.blocks,

            key = {
                it.id
            }

        ){ block ->


            AnimatedVisibility(

                visible =
                    !block.removed,

                exit =
                    fadeOut()

            ){

                BlockView(

                    block = block,

                    onClick = {
                        onBlockClick(block)
                    }

                )

            }

        }

    }

}



@Composable
private fun BlockView(

    block: Block,

    onClick: () -> Unit

){


    androidx.compose.foundation.layout.Box(

        modifier =
            Modifier
                .padding(5.dp)
                .aspectRatio(1f)
                .background(
                    Color(0xFF2563EB)
                )
                .clickable {
                    onClick()
                },

        contentAlignment =
            Alignment.Center

    ){


        Text(

            text =
                arrowSymbol(
                    block.direction
                ),

            fontSize =
                32.sp,

            color =
                Color.White

        )


    }

}



private fun arrowSymbol(

    direction: Direction

): String {


    return when(direction){

        Direction.UP ->
            "⬆"

        Direction.DOWN ->
            "⬇"

        Direction.LEFT ->
            "⬅"

        Direction.RIGHT ->
            "➡"

    }

}

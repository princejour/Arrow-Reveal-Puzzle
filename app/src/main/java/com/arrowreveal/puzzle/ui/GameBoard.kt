package com.arrowreveal.puzzle.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
            Modifier.fillMaxWidth()

    ){


        items(

            state.blocks,

            key = {
                it.id
            }

        ){ block ->


            BlockView(

                block = block,

                onClick = {

                    onBlockClick(block)

                }

            )

        }


    }


}





@Composable
private fun BlockView(

    block: Block,

    onClick: () -> Unit

){


    val offsetValue by animateFloatAsState(

        targetValue =

            if(block.isMoving)

                600f

            else

                0f,


        animationSpec =

            tween(
                durationMillis = 350
            ),

        label = "slide"

    )



    val modifier =

        when(block.direction){


            Direction.UP ->

                Modifier.offset(
                    y = (-offsetValue).dp
                )


            Direction.DOWN ->

                Modifier.offset(
                    y = offsetValue.dp
                )


            Direction.LEFT ->

                Modifier.offset(
                    x = (-offsetValue).dp
                )


            Direction.RIGHT ->

                Modifier.offset(
                    x = offsetValue.dp
                )

        }



    Box(

        modifier =

            modifier

                .padding(4.dp)

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

                when(block.direction){

                    Direction.UP ->
                        "⬆"

                    Direction.DOWN ->
                        "⬇"

                    Direction.LEFT ->
                        "⬅"

                    Direction.RIGHT ->
                        "➡"

                },


            fontSize =

                30.sp,


            color =

                Color.White

        )


    }


}

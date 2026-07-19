package com.arrowreveal.puzzle.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
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
import com.arrowreveal.puzzle.model.ImageTile


@Composable
fun ImageRevealView(

    tiles: List<ImageTile>,

    gridSize: Int

) {


    Column(

        horizontalAlignment =
            Alignment.CenterHorizontally

    ) {


        Text(

            text =
                "Hidden Image",

            fontSize =
                22.sp

        )



        LazyVerticalGrid(

            columns =
                GridCells.Fixed(
                    gridSize
                ),

            horizontalArrangement =
                Arrangement.Center

        ){


            items(

                tiles,

                key = {
                    it.id
                }

            ){ tile ->


                TileView(
                    tile
                )


            }


        }

    }

}





@Composable
private fun TileView(

    tile: ImageTile

){


    Box(

        modifier =
            Modifier

                .padding(2.dp)

                .aspectRatio(1f)

                .background(

                    if(tile.revealed)

                        Color(0xFF22C55E)

                    else

                        Color(0xFF111827)

                ),

        contentAlignment =
            Alignment.Center

    ){


        Text(

            text =

                if(tile.revealed)

                    "🖼"

                else

                    "?",


            color =
                Color.White

        )


    }

}

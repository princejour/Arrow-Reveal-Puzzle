package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.Direction
import com.arrowreveal.puzzle.model.GameState
import com.arrowreveal.puzzle.model.ImagePattern


class LevelGenerator {


    private val patternLibrary =
        PatternLibrary()



    fun createLevel(

        level: Int

    ): GameState {



        val pattern =
            choosePattern(level)



        val cells =
            patternLibrary.getPattern(
                pattern
            )



        val blocks =
            mutableListOf<Block>()



        cells.forEachIndexed { index, cell ->


            blocks.add(

                Block(

                    id = index,

                    row = cell.row,

                    column = cell.column,

                    direction =
                        directionForCell(
                            cell.row,
                            cell.column
                        )

                )

            )


        }



        return GameState(

            level = level,

            gridSize = 5,

            blocks = blocks

        )

    }





    private fun choosePattern(

        level: Int

    ): ImagePattern {


        val patterns =
            ImagePattern.entries


        return patterns[
            (level - 1)
                % patterns.size
        ]

    }





    private fun directionForCell(

        row: Int,

        column: Int

    ): Direction {


        return when {


            row == 0 ->
                Direction.UP


            row == 4 ->
                Direction.DOWN


            column == 0 ->
                Direction.LEFT


            column == 4 ->
                Direction.RIGHT


            else ->
                Direction.RIGHT

        }

    }

}

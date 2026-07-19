package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.Direction
import com.arrowreveal.puzzle.model.GameState
import com.arrowreveal.puzzle.model.LevelConfig


class LevelGenerator {


    private val levelDatabase =
        LevelDatabase()


    private val patternLibrary =
        PatternLibrary()


    private val validator =
        PuzzleGeneratorValidator()



    /**
     * إنشاء مستوى كامل
     */
    fun createLevel(

        levelNumber: Int

    ): GameState {


        val config =
            levelDatabase.getLevel(
                levelNumber
            )


        var attempts = 0



        while(attempts < 100){


            val state =
                buildLevel(
                    config
                )


            if(
                validator.validate(
                    state
                )
            ){

                return state

            }


            attempts++

        }



        return buildLevel(config)

    }




    private fun buildLevel(

        config: LevelConfig

    ): GameState {


        val cells =
            patternLibrary.getPattern(
                config.imagePattern
            )



        val blocks =
            cells
                .take(
                    config.blockCount
                )
                .mapIndexed { index, cell ->


                    Block(

                        id = index,

                        row = cell.row,

                        column = cell.column,

                        direction =
                            getDirection(
                                cell.row,
                                cell.column,
                                config.gridSize
                            )

                    )

                }



        return GameState(

            level = config.level,

            gridSize = config.gridSize,

            blocks = blocks

        )

    }





    private fun getDirection(

        row: Int,

        column: Int,

        size: Int

    ): Direction {


        return when {


            row == 0 ->
                Direction.UP


            row == size - 1 ->
                Direction.DOWN


            column == 0 ->
                Direction.LEFT


            column == size - 1 ->
                Direction.RIGHT


            else ->

                when((row + column) % 4){

                    0 ->
                        Direction.UP

                    1 ->
                        Direction.RIGHT

                    2 ->
                        Direction.DOWN

                    else ->
                        Direction.LEFT

                }

        }

    }

}

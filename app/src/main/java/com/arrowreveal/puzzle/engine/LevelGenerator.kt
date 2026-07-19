package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.Direction
import com.arrowreveal.puzzle.model.GameState
import kotlin.random.Random


class LevelGenerator {


    private val solver =
        PuzzleSolver()


    private val engine =
        PuzzleEngine()



    fun createLevel(

        level: Int

    ): GameState {


        var attempts = 0


        while(attempts < 100){


            val state =
                generateRandomLevel(
                    level
                )


            if(
                solver.hasPossibleMoves(
                    state,
                    engine
                )
            ){

                return state

            }


            attempts++

        }


        // حل احتياطي إذا فشل التوليد
        return generateRandomLevel(level)

    }




    private fun generateRandomLevel(

        level: Int

    ): GameState {


        val size = when {

            level < 5 ->
                4

            level < 15 ->
                5

            level < 30 ->
                6

            else ->
                7

        }



        val blocks =
            mutableListOf<Block>()


        var id = 0



        for(row in 0 until size){

            for(column in 0 until size){


                if(
                    Random.nextFloat()
                    < 0.55f
                ){


                    blocks.add(

                        Block(

                            id = id++,

                            row = row,

                            column = column,

                            direction =
                                randomDirection()

                        )

                    )

                }

            }

        }



        return GameState(

            level = level,

            gridSize = size,

            blocks = blocks

        )

    }




    private fun randomDirection():

            Direction {


        return Direction.entries.random()

    }

}

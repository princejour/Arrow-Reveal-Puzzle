package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.GameState


class PuzzleGeneratorValidator {


    private val engine =
        PuzzleEngine()



    /**
     * اختبار وجود حل للمستوى
     */
    fun validate(

        state: GameState

    ): Boolean {


        var current =
            state



        var safetyCounter = 0



        while(

            current.blocks.isNotEmpty()
            &&
            safetyCounter < 200

        ){


            val movable =

                current.blocks.firstOrNull {

                    engine.canRemove(
                        it,
                        current
                    )

                }



            if(movable == null){

                return false

            }



            current =
                engine.removeBlock(
                    movable,
                    current
                )



            safetyCounter++

        }



        return current.blocks.isEmpty()

    }


}

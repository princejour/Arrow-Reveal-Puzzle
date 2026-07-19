package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.GameState


class PuzzleSolver {


    /**
     * التحقق هل توجد حركات ممكنة
     */
    fun hasPossibleMoves(
        state: GameState,
        engine: PuzzleEngine
    ): Boolean {


        for(block in state.blocks){

            if(
                engine.canRemove(
                    block,
                    state
                )
            ){

                return true

            }

        }


        return false

    }



    /**
     * فحص هل المستوى منتهي
     */
    fun isSolved(
        state: GameState
    ): Boolean {


        return state.blocks.isEmpty()

    }



    /**
     * حساب عدد القطع القابلة للإزالة حاليا
     */
    fun availableMoves(
        state: GameState,
        engine: PuzzleEngine
    ): Int {


        var count = 0


        state.blocks.forEach { block ->


            if(
                engine.canRemove(
                    block,
                    state
                )
            ){

                count++

            }

        }


        return count

    }

}

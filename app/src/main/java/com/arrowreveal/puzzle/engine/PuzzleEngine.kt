package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.Direction
import com.arrowreveal.puzzle.model.GameState


class PuzzleEngine {



    /**
     * هل تستطيع القطعة الخروج؟
     */
    fun canRemove(

        block: Block,

        state: GameState

    ): Boolean {


        var row =
            block.row


        var column =
            block.column



        while(true){


            when(block.direction){


                Direction.UP ->
                    row--


                Direction.DOWN ->
                    row++


                Direction.LEFT ->
                    column--


                Direction.RIGHT ->
                    column++

            }



            // خرجت من اللوحة
            if(

                row < 0 ||
                column < 0 ||
                row >= state.gridSize ||
                column >= state.gridSize

            ){

                return true

            }



            val blocked =

                state.blocks.any {


                    it.id != block.id &&

                    it.row == row &&

                    it.column == column


                }



            if(blocked){

                return false

            }

        }

    }





    /**
     * إزالة قطعة بعد نجاح الحركة
     */
    fun removeBlock(

        block: Block,

        state: GameState

    ): GameState {



        val remaining =

            state.blocks.filter {

                it.id != block.id

            }



        val progress =

            if(state.blocks.isEmpty())

                1f

            else

                1f -

                (

                    remaining.size.toFloat()
                    /
                    state.blocks.size.toFloat()

                )





        return state.copy(

            blocks = remaining,

            moves =
                state.moves + 1,


            revealProgress =
                progress,


            isCompleted =
                remaining.isEmpty()

        )

    }



}

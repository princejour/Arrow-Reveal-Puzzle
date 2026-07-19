package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.Direction
import com.arrowreveal.puzzle.model.GameState
import kotlin.random.Random


class PuzzleEngine {


    /**
     * إنشاء مستوى جديد قابل للعب
     */
    fun generateLevel(
        level: Int,
        gridSize: Int = 5
    ): GameState {

        val blocks = mutableListOf<Block>()

        var id = 0


        for (row in 0 until gridSize) {

            for (column in 0 until gridSize) {


                // لا نملأ كل الخانات
                if (Random.nextFloat() < 0.55f) {


                    val direction =
                        Direction.entries[
                            Random.nextInt(
                                Direction.entries.size
                            )
                        ]


                    blocks.add(
                        Block(
                            id = id++,
                            row = row,
                            column = column,
                            direction = direction
                        )
                    )

                }

            }
        }


        return GameState(
            level = level,
            gridSize = gridSize,
            blocks = blocks
        )

    }



    /**
     * فحص هل يمكن للقطعة الخروج
     */
    fun canRemove(
        block: Block,
        state: GameState
    ): Boolean {


        var row = block.row
        var column = block.column


        while (true) {


            when(block.direction) {

                Direction.UP ->
                    row--

                Direction.DOWN ->
                    row++

                Direction.LEFT ->
                    column--

                Direction.RIGHT ->
                    column++

            }


            // وصلت إلى خارج اللوحة
            if(
                row < 0 ||
                row >= state.gridSize ||
                column < 0 ||
                column >= state.gridSize
            ){
                return true
            }


            // يوجد حاجز
            val obstacle =
                state.blocks.any {

                    it.id != block.id &&
                    !it.removed &&
                    it.row == row &&
                    it.column == column

                }


            if(obstacle){
                return false
            }

        }

    }



    /**
     * إزالة قطعة
     */
    fun removeBlock(
        block: Block,
        state: GameState
    ): GameState {


        val updated =
            state.blocks.map {

                if(it.id == block.id){

                    it.copy(
                        removed = true
                    )

                }
                else {
                    it
                }

            }


        val remaining =
            updated.filter {
                !it.removed
            }


        return state.copy(
            blocks = remaining,
            moves = state.moves + 1,
            revealProgress =
                1f -
                (remaining.size.toFloat()
                        /
                state.blocks.size.toFloat()),

            isCompleted =
                remaining.isEmpty()
        )

    }

}

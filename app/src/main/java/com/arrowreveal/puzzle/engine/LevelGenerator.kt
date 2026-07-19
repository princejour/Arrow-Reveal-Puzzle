package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.Direction
import com.arrowreveal.puzzle.model.GameState
import kotlin.random.Random


class LevelGenerator {


    /**
     * إنشاء مستوى مضمون الحل
     *
     * الفكرة:
     * نبدأ من قطع قريبة من الحواف،
     * ثم نبني اللوحة بالعكس حتى يكون
     * لكل قطعة مسار خروج.
     */
    fun createLevel(
        level: Int
    ): GameState {


        val size = when {

            level < 5 -> 4

            level < 15 -> 5

            level < 30 -> 6

            else -> 7

        }


        val blocks =
            mutableListOf<Block>()


        var id = 0


        val positions =
            mutableListOf<Pair<Int,Int>>()



        for(row in 0 until size){

            for(column in 0 until size){

                positions.add(
                    Pair(row,column)
                )

            }
        }



        positions.shuffle()



        val amount =
            (size * size * 0.55).toInt()



        positions
            .take(amount)
            .forEach { position ->


                val direction =
                    chooseDirection(
                        position.first,
                        position.second,
                        size
                    )


                blocks.add(

                    Block(
                        id = id++,
                        row = position.first,
                        column = position.second,
                        direction = direction
                    )

                )


            }



        return GameState(
            level = level,
            gridSize = size,
            blocks = blocks
        )

    }



    private fun chooseDirection(
        row:Int,
        column:Int,
        size:Int
    ):Direction {


        val possible =
            mutableListOf<Direction>()


        if(row == 0)
            possible.add(Direction.UP)


        if(row == size-1)
            possible.add(Direction.DOWN)


        if(column == 0)
            possible.add(Direction.LEFT)


        if(column == size-1)
            possible.add(Direction.RIGHT)



        // إذا لم تكن على الحافة
        if(possible.isEmpty()){

            possible.addAll(
                Direction.entries
            )

        }


        return possible.random()

    }

}

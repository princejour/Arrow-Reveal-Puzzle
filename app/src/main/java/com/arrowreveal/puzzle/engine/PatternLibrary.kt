package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.ImagePattern


data class PatternCell(

    val row: Int,

    val column: Int

)



class PatternLibrary {


    /**
     * الحصول على شكل الصورة المختار
     */
    fun getPattern(

        pattern: ImagePattern

    ): List<PatternCell> {


        return when(pattern){


            ImagePattern.LION -> lion()


            ImagePattern.CAT -> cat()


            ImagePattern.WOMAN -> woman()


            ImagePattern.MAP -> map()


            ImagePattern.EAGLE -> eagle()


        }

    }





    private fun lion(): List<PatternCell> {


        return listOf(

            PatternCell(0,1),
            PatternCell(0,2),

            PatternCell(1,0),
            PatternCell(1,1),
            PatternCell(1,2),
            PatternCell(1,3),

            PatternCell(2,0),
            PatternCell(2,1),
            PatternCell(2,2),
            PatternCell(2,3),

            PatternCell(3,1),
            PatternCell(3,2)

        )

    }





    private fun cat(): List<PatternCell> {


        return listOf(

            PatternCell(0,0),
            PatternCell(0,3),

            PatternCell(1,0),
            PatternCell(1,1),
            PatternCell(1,2),
            PatternCell(1,3),

            PatternCell(2,1),
            PatternCell(2,2),

            PatternCell(3,0),
            PatternCell(3,3)

        )

    }





    private fun woman(): List<PatternCell> {


        return listOf(

            PatternCell(0,2),

            PatternCell(1,1),
            PatternCell(1,2),
            PatternCell(1,3),

            PatternCell(2,0),
            PatternCell(2,1),
            PatternCell(2,2),
            PatternCell(2,3),
            PatternCell(2,4),

            PatternCell(3,1),
            PatternCell(3,3)

        )

    }





    private fun map(): List<PatternCell> {


        return listOf(

            PatternCell(0,0),
            PatternCell(0,1),
            PatternCell(0,2),

            PatternCell(1,0),
            PatternCell(1,2),

            PatternCell(2,0),
            PatternCell(2,1),
            PatternCell(2,2)

        )

    }





    private fun eagle(): List<PatternCell> {


        return listOf(

            PatternCell(0,1),
            PatternCell(0,2),

            PatternCell(1,0),
            PatternCell(1,1),
            PatternCell(1,2),
            PatternCell(1,3),

            PatternCell(2,1),
            PatternCell(2,2),

            PatternCell(3,0),
            PatternCell(3,3)

        )

    }


}

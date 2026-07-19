package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.ImagePattern
import com.arrowreveal.puzzle.model.LevelConfig


class LevelDatabase {


    /**
     * إعدادات المستويات الأساسية
     */
    private val levels =
        listOf(

            LevelConfig(
                level = 1,
                gridSize = 4,
                imagePattern = ImagePattern.CAT,
                blockCount = 10,
                difficulty = 1
            ),


            LevelConfig(
                level = 2,
                gridSize = 5,
                imagePattern = ImagePattern.LION,
                blockCount = 15,
                difficulty = 2
            ),


            LevelConfig(
                level = 3,
                gridSize = 5,
                imagePattern = ImagePattern.WOMAN,
                blockCount = 18,
                difficulty = 3
            ),


            LevelConfig(
                level = 4,
                gridSize = 6,
                imagePattern = ImagePattern.MAP,
                blockCount = 22,
                difficulty = 4
            ),


            LevelConfig(
                level = 5,
                gridSize = 6,
                imagePattern = ImagePattern.EAGLE,
                blockCount = 25,
                difficulty = 5
            )

        )




    /**
     * جلب إعدادات مستوى معين
     */
    fun getLevel(

        number: Int

    ): LevelConfig {


        return levels.firstOrNull {

            it.level == number

        } ?: levels.last()

    }

}

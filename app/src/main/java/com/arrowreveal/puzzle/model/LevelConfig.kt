package com.arrowreveal.puzzle.model


/**
 * إعدادات كل مستوى
 */
data class LevelConfig(

    // رقم المستوى
    val level: Int,


    // حجم الشبكة
    val gridSize: Int,


    // الصورة التي ستُكشف
    val imagePattern: ImagePattern,


    // عدد القطع
    val blockCount: Int,


    // مستوى الصعوبة
    val difficulty: Int

)

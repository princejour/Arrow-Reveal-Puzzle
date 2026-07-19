package com.arrowreveal.puzzle.model

/**
 * يمثل الحالة الحالية للعبة
 */
data class GameState(

    // رقم المستوى الحالي
    val level: Int = 1,

    // حجم لوحة اللعب (مثلا 5x5)
    val gridSize: Int = 5,

    // قائمة القطع الموجودة
    val blocks: List<Block> = emptyList(),

    // عدد الحركات
    val moves: Int = 0,

    // هل انتهى المستوى؟
    val isCompleted: Boolean = false,

    // نسبة ظهور الصورة المخفية
    val revealProgress: Float = 0f

)

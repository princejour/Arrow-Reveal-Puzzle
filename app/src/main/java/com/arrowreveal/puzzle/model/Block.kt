package com.arrowreveal.puzzle.model

/**
 * اتجاه السهم داخل القطعة
 */
enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}


/**
 * تمثل قطعة واحدة داخل لوحة اللغز
 */
data class Block(

    // معرف القطعة
    val id: Int,

    // موقعها في الشبكة
    val row: Int,
    val column: Int,

    // اتجاه السهم
    val direction: Direction,

    // هل تم حذفها من اللوحة؟
    var removed: Boolean = false

)

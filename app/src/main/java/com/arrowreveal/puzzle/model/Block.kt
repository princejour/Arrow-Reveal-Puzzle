package com.arrowreveal.puzzle.model


/**
 * اتجاه السهم
 */
enum class Direction {

    UP,

    DOWN,

    LEFT,

    RIGHT

}



/**
 * قطعة اللعبة
 */
data class Block(


    val id: Int,


    val row: Int,


    val column: Int,


    val direction: Direction,



    // هل القطعة تتحرك الآن؟
    val isMoving: Boolean = false



)

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
 * قطعة اللغز الأساسية
 */
data class Block(

    /**
     * معرف فريد للقطعة
     */
    val id: Int,


    /**
     * موقع القطعة داخل الشبكة
     */
    val row: Int,

    val column: Int,


    /**
     * اتجاه السهم
     */
    val direction: Direction,



    /**
     * حالة الحركة
     * تستخدم عند خروج القطعة من اللوحة
     */
    val isMoving: Boolean = false,



    /**
     * حالة محاولة الحركة الفاشلة
     * تستخدم للاهتزاز والوميض الأحمر
     */
    val isBlocked: Boolean = false

)

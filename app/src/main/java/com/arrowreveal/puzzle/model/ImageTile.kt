package com.arrowreveal.puzzle.model


/**
 * جزء من الصورة المخفية
 */
data class ImageTile(

    // رقم الجزء
    val id: Int,


    // مكانه في الشبكة
    val row: Int,

    val column: Int,


    // هل تم كشفه؟
    var revealed: Boolean = false

)

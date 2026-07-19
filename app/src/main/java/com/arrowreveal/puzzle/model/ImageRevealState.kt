package com.arrowreveal.puzzle.model


/**
 * نظام الصورة المخفية
 *
 * كل مستوى يحتوي على صورة يتم كشفها
 * مع إزالة قطع اللغز.
 */
data class ImageRevealState(

    // اسم الصورة
    val imageName: String = "",


    // نسبة الكشف من 0 إلى 100
    val revealPercent: Float = 0f,


    // هل ظهرت الصورة كاملة؟
    val completed: Boolean = false

)

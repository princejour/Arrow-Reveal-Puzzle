package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.ImageRevealState

class ImageRevealEngine {

    /**
     * حساب نسبة ظهور الصورة.
     *
     * @param totalBlocks عدد القطع الأصلية.
     * @param remainingBlocks عدد القطع المتبقية.
     */
    fun calculateReveal(
        totalBlocks: Int,
        remainingBlocks: Int
    ): ImageRevealState {

        if (totalBlocks <= 0) {
            return ImageRevealState(
                revealPercent = 100f,
                completed = true
            )
        }

        val removed = totalBlocks - remainingBlocks

        val percent = (removed.toFloat() / totalBlocks.toFloat()) * 100f

        return ImageRevealState(
            revealPercent = percent,
            completed = percent >= 100f
        )
    }

    /**
     * اختيار صورة حسب المستوى.
     */
    fun getImageForLevel(level: Int): String {

        val images = listOf(
            "lion",
            "cat",
            "woman",
            "map",
            "eagle",
            "tiger"
        )

        return images[(level - 1) % images.size]
    }
}

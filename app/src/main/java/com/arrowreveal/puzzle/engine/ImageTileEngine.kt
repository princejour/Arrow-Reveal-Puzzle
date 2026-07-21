package com.arrowreveal.puzzle.engine

import com.arrowreveal.puzzle.model.ImageTile

class ImageTileEngine {

    /**
     * إنشاء شبكة أجزاء الصورة.
     */
    fun createTiles(size: Int): List<ImageTile> {

        val tiles = mutableListOf<ImageTile>()
        var id = 0

        for (row in 0 until size) {
            for (column in 0 until size) {
                tiles.add(
                    ImageTile(
                        id = id++,
                        row = row,
                        column = column
                    )
                )
            }
        }

        return tiles
    }

    /**
     * كشف جزء من الصورة.
     */
    fun revealTile(
        tiles: List<ImageTile>,
        tileId: Int
    ): List<ImageTile> {

        return tiles.map { tile ->
            if (tile.id == tileId) {
                tile.copy(revealed = true)
            } else {
                tile
            }
        }
    }

    /**
     * حساب نسبة الكشف.
     */
    fun calculateProgress(
        tiles: List<ImageTile>
    ): Float {

        if (tiles.isEmpty()) {
            return 0f
        }

        val revealed = tiles.count { it.revealed }

        return revealed.toFloat() / tiles.size.toFloat()
    }
}

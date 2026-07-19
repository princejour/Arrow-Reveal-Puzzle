package com.arrowreveal.puzzle.ui

import androidx.lifecycle.ViewModel
import com.arrowreveal.puzzle.engine.ImageTileEngine
import com.arrowreveal.puzzle.engine.LevelDatabase
import com.arrowreveal.puzzle.engine.LevelGenerator
import com.arrowreveal.puzzle.engine.PuzzleEngine
import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.GameState
import com.arrowreveal.puzzle.model.ImageTile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class GameViewModel : ViewModel() {


    private val levelGenerator =
        LevelGenerator()


    private val levelDatabase =
        LevelDatabase()


    private val puzzleEngine =
        PuzzleEngine()


    private val imageTileEngine =
        ImageTileEngine()



    private var currentLevel = 1



    private val _gameState =
        MutableStateFlow(
            GameState()
        )


    val gameState: StateFlow<GameState> =
        _gameState



    private val _imageTiles =
        MutableStateFlow(
            emptyList<ImageTile>()
        )


    val imageTiles: StateFlow<List<ImageTile>> =
        _imageTiles



    init {

        startLevel()

    }



    /**
     * بداية مستوى
     */
    private fun startLevel(){


        val config =
            levelDatabase.getLevel(
                currentLevel
            )



        val state =
            levelGenerator.createLevel(
                currentLevel
            )



        _gameState.value =
            state



        _imageTiles.value =
            imageTileEngine.createTiles(
                config.gridSize
            )

    }





    /**
     * الضغط على قطعة
     */
    fun selectBlock(

        block: Block

    ){


        val state =
            _gameState.value



        if(
            puzzleEngine.canRemove(
                block,
                state
            )
        ){


            _gameState.value =
                puzzleEngine.removeBlock(
                    block,
                    state
                )



            revealTile()

        }

    }





    private fun revealTile(){


        val tiles =
            _imageTiles.value



        val hidden =
            tiles.firstOrNull {

                !it.revealed

            }



        if(hidden != null){


            _imageTiles.value =
                imageTileEngine.revealTile(
                    tiles,
                    hidden.id
                )

        }

    }





    /**
     * الانتقال للمستوى التالي
     */
    fun nextLevel(){


        currentLevel++


        startLevel()

    }





    fun restart(){


        startLevel()

    }


}

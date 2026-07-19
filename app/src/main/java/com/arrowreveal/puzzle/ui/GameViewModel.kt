package com.arrowreveal.puzzle.ui

import androidx.lifecycle.ViewModel
import com.arrowreveal.puzzle.engine.ImageTileEngine
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


    private val puzzleEngine =
        PuzzleEngine()


    private val imageTileEngine =
        ImageTileEngine()



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

        startNewLevel()

    }



    fun startNewLevel(){


        val newState =
            levelGenerator.createLevel(
                _gameState.value.level
            )


        _gameState.value =
            newState



        _imageTiles.value =
            imageTileEngine.createTiles(
                newState.gridSize
            )

    }




    fun selectBlock(

        block: Block

    ){


        val current =
            _gameState.value



        if(
            puzzleEngine.canRemove(
                block,
                current
            )
        ){


            val updated =
                puzzleEngine.removeBlock(
                    block,
                    current
                )


            _gameState.value =
                updated



            revealNextTile()


        }

    }





    private fun revealNextTile(){


        val currentTiles =
            _imageTiles.value



        val hidden =
            currentTiles.filter {
                !it.revealed
            }



        if(hidden.isNotEmpty()){


            val tile =
                hidden.first()



            _imageTiles.value =
                imageTileEngine.revealTile(
                    currentTiles,
                    tile.id
                )

        }

    }



    fun nextLevel(){

        _gameState.value =
            levelGenerator.createLevel(
                _gameState.value.level + 1
            )

    }



    fun restart(){

        startNewLevel()

    }

}

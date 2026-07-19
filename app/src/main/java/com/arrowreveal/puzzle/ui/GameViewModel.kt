package com.arrowreveal.puzzle.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arrowreveal.puzzle.engine.ImageTileEngine
import com.arrowreveal.puzzle.engine.LevelDatabase
import com.arrowreveal.puzzle.engine.LevelGenerator
import com.arrowreveal.puzzle.engine.PuzzleEngine
import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.GameState
import com.arrowreveal.puzzle.model.ImageTile
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


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

        loadLevel()

    }





    /**
     * تحميل المستوى الحالي
     */
    private fun loadLevel(){


        val config =
            levelDatabase.getLevel(
                currentLevel
            )


        _gameState.value =
            levelGenerator.createLevel(
                currentLevel
            )


        _imageTiles.value =
            imageTileEngine.createTiles(
                config.gridSize
            )

    }





    /**
     * اختيار قطعة
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

            moveBlock(block)

        }
        else {

            showBlocked(block)

        }

    }





    /**
     * تشغيل حركة القطعة قبل حذفها
     */
    private fun moveBlock(

        block: Block

    ){


        viewModelScope.launch {


            val moving =

                _gameState.value.blocks.map {


                    if(it.id == block.id)

                        it.copy(
                            isMoving = true
                        )

                    else

                        it


                }



            _gameState.value =

                _gameState.value.copy(

                    blocks = moving

                )



            delay(350)



            _gameState.value =

                puzzleEngine.removeBlock(

                    block,

                    _gameState.value

                )



            revealImage()

        }

    }





    /**
     * حركة فاشلة
     */
    private fun showBlocked(

        block: Block

    ){


        viewModelScope.launch {


            val blocked =

                _gameState.value.blocks.map {


                    if(it.id == block.id)

                        it.copy(
                            isBlocked = true
                        )

                    else

                        it


                }



            _gameState.value =

                _gameState.value.copy(

                    blocks = blocked

                )



            delay(200)



            _gameState.value =

                _gameState.value.copy(

                    blocks =

                        _gameState.value.blocks.map {

                            it.copy(
                                isBlocked = false
                            )

                        }

                )


        }

    }





    /**
     * كشف جزء من الصورة
     */
    private fun revealImage(){


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
     * المستوى التالي
     */
    fun nextLevel(){


        currentLevel++


        loadLevel()

    }





    /**
     * إعادة المستوى
     */
    fun restart(){


        loadLevel()

    }


}

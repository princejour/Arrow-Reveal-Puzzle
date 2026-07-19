package com.arrowreveal.puzzle.ui

import androidx.lifecycle.ViewModel
import com.arrowreveal.puzzle.engine.LevelGenerator
import com.arrowreveal.puzzle.engine.PuzzleEngine
import com.arrowreveal.puzzle.model.Block
import com.arrowreveal.puzzle.model.GameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class GameViewModel : ViewModel() {


    private val levelGenerator =
        LevelGenerator()


    private val puzzleEngine =
        PuzzleEngine()



    private val _gameState =
        MutableStateFlow(
            GameState()
        )


    val gameState: StateFlow<GameState> =
        _gameState



    init {

        startNewLevel()

    }



    /**
     * إنشاء مستوى جديد
     */
    fun startNewLevel(){

        _gameState.value =
            levelGenerator.createLevel(
                _gameState.value.level
            )

    }



    /**
     * الضغط على قطعة
     */
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

            _gameState.value =
                puzzleEngine.removeBlock(
                    block,
                    current
                )

        }

    }



    /**
     * إعادة المستوى
     */
    fun restart(){

        startNewLevel()

    }



    /**
     * المستوى التالي
     */
    fun nextLevel(){

        _gameState.value =
            levelGenerator.createLevel(
                currentLevel =
                _gameState.value.level + 1
            )

    }

}

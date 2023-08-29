package com.example.reversiapp.ui.main

import androidx.lifecycle.ViewModel
import com.example.reversiapp.data.StoneColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(MainState(1, 1, StoneColor.Black))
    val state = _state.asStateFlow()

    /**
     * Main画面のイベント処理
     */
    fun onEvent(event: MainEvent) {
        when (event) {
            MainEvent.FinishTurn -> {
                _state.update {
                    it.copy(currentTurnColor = StoneColor.White)
                }
            }
            is MainEvent.OnTapCell -> {
                val currentTurnColor = _state.value.currentTurnColor
                val stoneList = _state.value.stonesData.toMutableList()
                stoneList[event.stone.index] =
                    event.stone.copy(
                        colorName = currentTurnColor
                    )
                _state.update {
                    it.copy(
                        currentTurnColor =
                            if (currentTurnColor == StoneColor.White) StoneColor.Black
                            else StoneColor.White,
                        stonesData = stoneList
                    )
                }
            }
            is MainEvent.CheckScreenSize -> {
                // TODO: 
            }
            else -> {}
        }
    }
}

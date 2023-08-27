package com.example.reversiapp.ui.main

import androidx.lifecycle.ViewModel
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
            else -> {}
        }
    }
}

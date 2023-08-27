package com.example.reversiapp.ui.main

import com.example.reversiapp.data.Stone

sealed interface MainEvent {
    /**
     * Settings画面への遷移時イベント
     */
    object NavigateSettings : MainEvent

    /**
     * ターン終了時イベント
     */
    object FinishTurn : MainEvent

    /**
     * セル選択処理
     */
    data class OnTapCell(
        val stone: Stone
    ) : MainEvent
}

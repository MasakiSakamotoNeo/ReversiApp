package com.example.reversiapp.ui.main

sealed interface MainEvent {
    /**
     * Settings画面への遷移時イベント
     */
    object NavigateSettings : MainEvent

    /**
     * ターン終了時イベント
     */
    object FinishTurn : MainEvent
}

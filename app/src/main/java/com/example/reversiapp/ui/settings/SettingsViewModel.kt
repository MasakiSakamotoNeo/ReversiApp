package com.example.reversiapp.ui.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    /**
     * 設定画面でのイベント処理
     */
    fun onEvent(event: SettingsEvent) {
        when (event) {
            else -> {

            }
        }
    }
}

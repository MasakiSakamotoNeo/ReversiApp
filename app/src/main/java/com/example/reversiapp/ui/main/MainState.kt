package com.example.reversiapp.ui.main

data class MainState(
    val boardWidth: Int,
    val boardHeight: Int,
    val currentTurnColor: StoneColor
)

enum class StoneColor {
    White, Black
}

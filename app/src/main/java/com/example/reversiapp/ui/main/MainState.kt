package com.example.reversiapp.ui.main

import com.example.reversiapp.data.Stone

// 石の数は最大64（8 x 8）
private const val MAX_STONE_SIZE = 64

data class MainState(
    val boardWidth: Int,
    val boardHeight: Int,
    val currentTurnColor: StoneColor,
    val stonesData: List<Stone> = mutableListOf<Stone>().apply {
        repeat(MAX_STONE_SIZE) { add(Stone(it)) }
    }
)

enum class StoneColor {
    White, Black, None
}

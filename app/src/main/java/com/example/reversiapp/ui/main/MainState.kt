package com.example.reversiapp.ui.main

import com.example.reversiapp.data.Stone
import com.example.reversiapp.data.StoneColor

// 石の数は最大64（8 x 8）
private const val MAX_STONE_SIZE = 64

data class MainState(
    val boardWidth: Int = -1,
    val boardHeight: Int = -1,
    val currentTurnColor: StoneColor = StoneColor.Black,
    val stonesData: List<Stone> = mutableListOf<Stone>().apply {
        repeat(MAX_STONE_SIZE) { add(Stone(it)) }
    }
)

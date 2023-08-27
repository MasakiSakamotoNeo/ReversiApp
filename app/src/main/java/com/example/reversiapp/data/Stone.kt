package com.example.reversiapp.data

import com.example.reversiapp.ui.main.StoneColor

/**
 * オセロの石
 */
data class Stone(
    val index: Int,
    val colorName: StoneColor = StoneColor.None
)

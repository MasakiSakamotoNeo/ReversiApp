package com.example.reversiapp.data

/**
 * オセロの石
 */
data class Stone(
    val index: Int,
    val colorName: StoneColor = StoneColor.None
)

enum class StoneColor {
    White, Black, None
}

package com.marcuswkl.minesweeper.model

abstract class Tile(val tileType: String) {
  val isRevealed = false
  val symbol: String
}

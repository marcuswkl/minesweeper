package com.marcuswkl.minesweeper.model

abstract class Tile(val tileType: String) {
  var isTileClicked = false
  var isFlagMarked = false
  var isQuestionMarked = false
  var symbol: String

  // Different tiles have different left click behaviour
  def tileClick(): Unit
}

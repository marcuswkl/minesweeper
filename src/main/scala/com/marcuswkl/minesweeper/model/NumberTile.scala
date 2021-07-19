package com.marcuswkl.minesweeper.model

class NumberTile(var symbol: String = "1") extends Tile("number") {
  var numberOfMines = 1
  override def tileClick(): Unit = {
    isTileClicked = true
  }

  def incrementNumber(): Unit = {
    numberOfMines += 1
    symbol = numberOfMines.toString
  }
}

package com.marcuswkl.minesweeper.model

class NumberTile(var symbol: String = "1") extends Tile("number") {
  var numberOfMines = 1

  def incrementNumber(): Unit = {
    numberOfMines += 1
    symbol = numberOfMines.toString
  }
}

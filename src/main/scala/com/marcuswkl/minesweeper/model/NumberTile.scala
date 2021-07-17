package com.marcuswkl.minesweeper.model

class NumberTile(val symbol: String = "1") extends Tile("number") {
  override def leftClick(): Unit = {
    isLeftClicked = true
    println("Number tile!")
  }
}

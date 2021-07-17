package com.marcuswkl.minesweeper.model

class MineTile(val symbol: String = "💣") extends Tile("mine") {
  override def leftClick(): Unit = {
    isLeftClicked = true
    println("Bomb exploded!")
  }
}

package com.marcuswkl.minesweeper.model

class EmptyTile(val symbol: String = "") extends Tile("empty") {
  override def leftClick(): Unit = {
    isLeftClicked = true
    println("Empty tile!")
  }
}

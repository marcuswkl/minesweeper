package com.marcuswkl.minesweeper.model

class EmptyTile(var symbol: String = "") extends Tile("empty") {
  override def leftClick(): Unit = {
  }
}

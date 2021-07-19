package com.marcuswkl.minesweeper.model

class MineTile(var symbol: String = "💣") extends Tile("mine") {
  override def tileClick(): Unit = {
    isTileClicked = true
  }
}

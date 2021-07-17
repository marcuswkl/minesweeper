package com.marcuswkl.minesweeper.model

abstract class Tile(val tileType: String) {
  var isLeftClicked = false
  val symbol: String

  // Different tiles have different left click behaviour
  def leftClick(): Unit

  // All tiles have same right click behaviour
  def rightClick(): Unit = {
    // TODO Implement right click marker functionality
  }
}

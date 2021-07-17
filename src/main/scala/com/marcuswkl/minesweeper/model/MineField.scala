package com.marcuswkl.minesweeper.model

import scala.collection.mutable.ListBuffer
import scala.util.Random

class MineField(val noOfTiles: Int) {
  var listOfTiles: Array[Tile] = Array[Tile]()
  var noOfMineTiles: Int = 0

  // Generate tiles for minefield randomly
  def generateTiles(): Array[Tile] = {
    val tempListBuffer: ListBuffer[Tile] = ListBuffer[Tile]()
    for (_ <- 1 to noOfTiles) {
      if (Random.nextDouble() <= 0.2) {
        tempListBuffer += new MineTile()
        noOfMineTiles += 1
        println("Added mine tile")
      } else {
        tempListBuffer += new EmptyTile()
        println("Added empty tile")
      }
    }
    tempListBuffer.toArray
  }

  /*  def generateMines(): Unit = {
    // Generate mines in tiles randomly
    for (tile <- tiles) {
      if (Random.nextDouble() <= 0.2) {
        tile.text = "💣"
        mineCounterInt += 1
      }
    }
  }*/

}

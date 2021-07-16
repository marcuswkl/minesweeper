package com.marcuswkl.minesweeper.model

import scala.collection.mutable.ListBuffer
import scala.util.Random

class MineField(val noOfTiles: Int) {
  var listBufferOfTiles: ListBuffer[Tile] = ListBuffer[Tile]()

  // Generate tiles for minefield randomly
  def generateTiles(): Unit = {
    for (_ <- 1 to noOfTiles) {
      if (Random.nextDouble() <= 0.2) {
        listBufferOfTiles += new MineTile()
        println("Added mine tile")
      } else {
        listBufferOfTiles += new EmptyTile()
        println("Added empty tile")
      }
    }
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

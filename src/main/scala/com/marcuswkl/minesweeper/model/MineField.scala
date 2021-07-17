package com.marcuswkl.minesweeper.model

import scala.collection.mutable.ListBuffer
import scala.util.Random

class MineField(val noOfTiles: Int) {
  var listOfTiles: Array[Tile] = Array[Tile]()
  var noOfMineTiles: Int = 0

  // Generate mine tiles and empty tiles for minefield randomly
  def generateMineAndEmptyTiles(): ListBuffer[Tile] = {
    val tempListBuffer: ListBuffer[Tile] = ListBuffer[Tile]()
    for (_ <- 1 to noOfTiles) {
      if (Random.nextDouble() <= 0.2) {
        tempListBuffer += new MineTile()
        noOfMineTiles += 1
      } else {
        tempListBuffer += new EmptyTile()
      }
    }
    tempListBuffer
  }

  // Generate number tiles to indicate mines for minefield
  def generateNumberTiles(mineAndEmptyTiles: ListBuffer[Tile]): Array[Tile] = {
    var tileNo = 1
    for (_ <- 1 to noOfTiles) {
      // Check if the current tile is a mine tile
      if (mineAndEmptyTiles(tileNo - 1).tileType == "mine") {
        // Obtain the tile numbers of the surrounding tiles
        val surroundingTilesNo = obtainSurroundingTilesNo(tileNo)
        for (surroundingTileNo <- surroundingTilesNo) {
            // Replace the tile with a danger tile if it is an empty tile
            if (mineAndEmptyTiles(surroundingTileNo - 1).tileType == "empty") {
              mineAndEmptyTiles(surroundingTileNo - 1) = new NumberTile()
            }
        }
      }
      tileNo += 1
    }
    mineAndEmptyTiles.toArray
  }

  // Obtain the tile numbers of the surrounding tiles
  // Top Left -6, Top -5, Top Right -4, Left -1, Right +1, Bottom Left +4, Bottom + 5, Bottom Right + 6
  def obtainSurroundingTilesNo(tileNo: Int) : List[Int] = {
    tileNo match {
      // If the mine tile is on the top left of the minefield
      case 1 => List(tileNo + 1, tileNo + 5, tileNo + 6)
      // If the mine tile is on the top right of the minefield
      case 5 => List(tileNo - 1, tileNo + 4, tileNo + 5)
      // If the mine tile is on the bottom left of the minefield
      case 21 => List(tileNo - 5, tileNo - 4, tileNo + 1)
      // If the mine tile is on the bottom right of the minefield
      case 25 => List(tileNo - 6, tileNo - 5, tileNo - 1)
      // If the mine tile is on the left of the minefield
      case 6 | 11 | 16 => List(tileNo - 5, tileNo - 4, tileNo + 1, tileNo + 5, tileNo + 6)
      // If the mine tile is on the right of the minefield
      case 10 | 15 | 20 => List(tileNo - 6, tileNo - 5, tileNo - 1, tileNo + 4, tileNo + 5)
      // If the mine tile is on the top of the minefield
      case 2 | 3 | 4 => List(tileNo - 1, tileNo + 1, tileNo + 4, tileNo + 5, tileNo + 6)
      // If the mine tile is on the bottom of the minefield
      case 22 | 23 | 24 => List(tileNo - 6, tileNo - 5, tileNo - 4, tileNo - 1, tileNo + 1)
      // If the mine tile is in the centre area of the minefield
      case 7 | 8 | 9 | 12 | 13 | 14 | 17 | 18 | 19  => List(tileNo - 6, tileNo - 5, tileNo - 4, tileNo - 1, tileNo + 1,
        tileNo + 4, tileNo + 5, tileNo + 6)
      // Invalid mine tile number
      case _ => List()
    }
  }

}

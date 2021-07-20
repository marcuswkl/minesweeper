package com.marcuswkl.minesweeper.model

class FlagMarker(val symbol: String = "🚩") extends Marker() {
  // Update the flag mark status of the tile
  override def updateTileMarkedStatus(tile: Tile, isMarked: Boolean): Unit = {
    tile.isFlagMarked = isMarked
  }

  // Update the old mark status and new flag mark status of the tile
  override def updateTileMarkedStatus(tile: Tile, oldMarked: Boolean, newMarked: Boolean): Unit = {
    if (tile.isQuestionMarked) {
      tile.isQuestionMarked = oldMarked
    }
    tile.isFlagMarked = newMarked
  }
}

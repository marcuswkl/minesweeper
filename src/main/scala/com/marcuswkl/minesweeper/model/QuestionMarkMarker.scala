package com.marcuswkl.minesweeper.model

class QuestionMarkMarker(val symbol: String = "?") extends Marker() {
  // Update the flag mark status of the tile
  override def updateTileMarkedStatus(tile: Tile, isMarked: Boolean): Unit = {
    tile.isQuestionMarked = isMarked
  }

  // Update the old mark status and new question mark status of the tile
  override def updateTileMarkedStatus(tile: Tile, oldMarked: Boolean, newMarked: Boolean): Unit = {
    if (tile.isFlagMarked) {
      tile.isFlagMarked = oldMarked
    }
    tile.isQuestionMarked = newMarked
  }
}

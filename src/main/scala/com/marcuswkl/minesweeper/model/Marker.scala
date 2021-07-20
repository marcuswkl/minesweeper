package com.marcuswkl.minesweeper.model

import javafx.scene.control.Button
import scalafx.scene.paint.Color

abstract class Marker {
  val symbol: String

  // All markers are placed the same way
  def placeMarker(tileButton: Button, tile: Tile): Unit = {
    // Replace the corresponding tile symbol with the flag marker symbol
    tileButton.setText(symbol)
    // Unhide the button text to show the symbol
    tileButton.setTextFill(Color.Black)
    updateTileMarkedStatus(tile, isMarked = true)
  }

  // All markers are replaced the same way
  def replaceMarker(tileButton: Button, tile: Tile): Unit = {
    // Replace the old marker symbol with the new marker symbol
    tileButton.setText(symbol)
    updateTileMarkedStatus(tile, oldMarked = false, newMarked = true)
  }

  // All markers are removed the same way
  def removeMarker(tileButton: Button, tile: Tile): Unit = {
    // Hide the button text before replacing the flag marker symbol
    tileButton.setTextFill(Color.Transparent)
    // Replace the flag marker symbol with the corresponding tile symbol
    tileButton.setText(tile.symbol)
    updateTileMarkedStatus(tile, isMarked = false)
  }

  // Different markers will update tile marked status differently
  def updateTileMarkedStatus(tile: Tile, isMarked: Boolean): Unit

  // Overloaded to update two marked statuses for marker replacement
  def updateTileMarkedStatus(tile: Tile, oldMarked: Boolean, newMarked: Boolean): Unit
}

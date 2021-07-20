package com.marcuswkl.minesweeper.model

import javafx.scene.control.Button
import scalafx.scene.effect.InnerShadow
import scalafx.scene.paint.Color

abstract class Tile(val tileType: String) {
  var isOpened = false
  var isFlagMarked = false
  var isQuestionMarked = false
  var symbol: String

  // All tiles open the same way
  def openTile(tileButton: Button): Unit = {
    // Unhide the button text to show the symbol
    tileButton.setTextFill(Color.Black)
    // Change the look of the button to indicate clicked
    tileButton.setEffect(new InnerShadow())
    // Update the tile status as opened
    isOpened = true
  }

  // All tiles remove mark the same way
  def removeMark(tileButton: Button): String = {
    var markType = ""
    // Hide the button text before replacing the marker symbol
    tileButton.setTextFill(Color.Transparent)
    // Replace the marker symbol with the corresponding tile symbol
    tileButton.setText(symbol)
    // Update the tile status as not marked
    if (isFlagMarked) {
      isFlagMarked = false
      markType = "flag"
    } else if (isQuestionMarked) {
      isQuestionMarked = false
      markType = "question mark"
    }
    // Return the mark type removed
    markType
  }
}

package com.marcuswkl.minesweeper.view

import com.marcuswkl.minesweeper.MainApp
import com.marcuswkl.minesweeper.model.{EmojiButton, Game, Tile}
import scalafx.application.Platform
import scalafx.event.ActionEvent
import scalafx.scene.control.{Alert, Button, Label}
import scalafx.scene.image.ImageView
import scalafx.scene.layout.TilePane
import scalafx.scene.paint.Color
import scalafxml.core.macros.sfxml

import java.util.{Timer, TimerTask}
import javafx.{scene => jfxs}
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.effect.InnerShadow

@sfxml
class GameController(private val mineCounter: Label, private val timeCounter: Label, private val emojiButton: ImageView,
                     private val minefield: TilePane, private val tile1: Button, private val tile2: Button,
                     private val tile3: Button, private val tile4: Button, private val tile5: Button,
                     private val tile6: Button, private val tile7: Button, private val tile8: Button,
                     private val tile9: Button, private val tile10: Button, private val tile11: Button,
                     private val tile12: Button, private val tile13: Button, private val tile14: Button,
                     private val tile15: Button, private val tile16: Button, private val tile17: Button,
                     private val tile18: Button, private val tile19: Button, private val tile20: Button,
                     private val tile21: Button, private val tile22: Button, private val tile23: Button,
                     private val tile24: Button, private val tile25: Button) {

  // Create new game instance
  val gameInstance = new Game()

  // Initialise time counter text and emoji button emoji
  timeCounter.text = gameInstance.timeCounter.displayCounterValue()
  emojiButton.image = EmojiButton.emojiSmile

  // Insert tile buttons into array for easier usage
  val tileButtons: List[Button] = List(tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, tile10, tile11,
    tile12, tile13, tile14, tile15, tile16, tile17, tile18, tile19, tile20, tile21, tile22, tile23, tile24, tile25)

  // Generate tiles for minefield
  gameInstance.mineField.listOfTiles =
    gameInstance.mineField.generateNumberTiles(gameInstance.mineField.generateEmptyAndMineTiles())

  // Initialise mine counter text
  gameInstance.mineCounter.counterValue = gameInstance.mineField.noOfMineTiles
  mineCounter.text = gameInstance.mineCounter.displayCounterValue()

  var tileCounter = 0
  for (tileButton <- tileButtons) {
    // Assign the symbol of the generated tile to the corresponding tile button text
    tileButton.text = gameInstance.mineField.listOfTiles(tileCounter).symbol
    // Hide the button text after assigning the symbol
    tileButton.textFill = Color.Transparent
    // Increase tile counter to move to the next generated tile
    tileCounter += 1
  }

  // Change mode to open tile
  def handleOpenTile(): Unit = {
    gameInstance.mode = "tile"
  }

  // Change mode to place flag
  def handlePlaceFlag(): Unit = {
    gameInstance.mode = "flag"
  }

  // Change mode to place question mark
  def handlePlaceQuestionMark(): Unit = {
    gameInstance.mode = "question mark"
  }

  // Handle tile button click
  def handleClick(event: ActionEvent): Unit = {
    // Get tile button object
    val tileButton = event.source.asInstanceOf[jfxs.control.Button]
    // Get tile number from tile button FXId
    val tileNo = tileButton.getId.substring(4).toInt
    // Get the corresponding tile
    // Tile number decremented to align with array index
    val tile = gameInstance.mineField.listOfTiles(tileNo - 1)

    // Execute the corresponding click method based on the mode
    // If the mode is open tile
    if (gameInstance.mode == "tile") {
      // If the tile is not marked
      if (!tile.isFlagMarked && !tile.isQuestionMarked) {
        // Unhide the button text to show the symbol
        tileButton.setTextFill(Color.Black)
        // Change the look of the button to indicate clicked
        tileButton.setEffect(new InnerShadow())
        // Execute corresponding tile click method
        tile.tileClick()
        // Update emoji button based on corresponding tile type
        gameInstance.emojiButton.updateEmoji(tile.tileType)
        emojiButton.image = gameInstance.emojiButton.emoji
        // Check game status
        gameInstance.checkStatus(gameInstance.mineField.listOfTiles)
      }
      // If the tile is marked
      else {
        // Hide the button text before replacing the marker symbol
        tileButton.setTextFill(Color.Transparent)
        // Replace the marker symbol with the corresponding tile symbol
        tileButton.setText(tile.symbol)
        // Unmark the tile
        if (tile.isFlagMarked) {
          tile.isFlagMarked = false
        } else {
          tile.isQuestionMarked = false
        }
      }
    }
    // If the mode is place flag
    else if (gameInstance.mode == "flag") {
      // If the tile is not opened
      if (!tile.isTileClicked) {
        // If the tile is not marked
        if (!tile.isFlagMarked && !tile.isQuestionMarked) {
          // Replace the corresponding tile symbol with the flag marker symbol
          tileButton.setText(gameInstance.flagMarker.symbol)
          // Unhide the button text to show the symbol
          tileButton.setTextFill(Color.Black)
          // Mark the tile as flag marked
          tile.isFlagMarked = true
        }
        // If the tile is question marked
        else if (tile.isQuestionMarked) {
          // Replace the question mark marker symbol with the flag marker symbol
          tileButton.setText(gameInstance.flagMarker.symbol)
          // Change the mark of the tile to flag marked
          tile.isQuestionMarked = false
          tile.isFlagMarked = true
        }
        // If the tile is flag marked
        else {
          // Hide the button text before replacing the flag marker symbol
          tileButton.setTextFill(Color.Transparent)
          // Replace the flag marker symbol with the corresponding tile symbol
          tileButton.setText(tile.symbol)
          // Unmark the tile
          tile.isFlagMarked = false
        }
      }
    } else {
      // If the tile is not opened
      if (!tile.isTileClicked) {
        // If the tile is not marked
        if (!tile.isFlagMarked && !tile.isQuestionMarked) {
          // Replace the corresponding tile symbol with the question mark marker symbol
          tileButton.setText(gameInstance.questionMarkMarker.symbol)
          // Unhide the button text to show the symbol
          tileButton.setTextFill(Color.Black)
          // Mark the tile as question marked
          tile.isQuestionMarked = true
        }
        // If the tile is flag marked
        else if (tile.isFlagMarked) {
          // Replace the flag marker symbol with the question mark marker symbol
          tileButton.setText(gameInstance.questionMarkMarker.symbol)
          // Change the mark of the tile to question marked
          tile.isFlagMarked = false
          tile.isQuestionMarked = true
        }
        // If the tile is question marked
        else {
          // Hide the button text before replacing the question mark marker symbol
          tileButton.setTextFill(Color.Transparent)
          // Replace the question mark marker symbol with the corresponding tile symbol
          tileButton.setText(tile.symbol)
          // Unmark the tile
          tile.isQuestionMarked = false
        }
      }
    }
  }

  // Start the time counter
  gameInstance.timeCounter.startTimeCounter(timeCounter)
}

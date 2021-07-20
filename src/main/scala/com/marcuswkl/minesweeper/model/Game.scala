package com.marcuswkl.minesweeper.model

import com.marcuswkl.minesweeper.MainApp
import javafx.scene.control.Button
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType

class Game() {
  // Initialise the game
  var mineCounter: MineCounter = new MineCounter()
  var timeCounter: TimeCounter = new TimeCounter()
  var emojiButton: EmojiButton = new EmojiButton(EmojiButton.emojiSmile)
  var mineField: MineField = new MineField(25)
  var flagMarker: FlagMarker = new FlagMarker()
  var questionMarkMarker: QuestionMarkMarker = new QuestionMarkMarker()
  var mode: String = "tile"

  // Execute the corresponding action based on the selected mode
  def executeModeAction(tileButton: Button, tile: Tile): Unit = {
    // If the mode is tile
    if (mode == "tile") {
      performTileAction(tileButton, tile)
    }
    // If the mode is flag
    else if (mode == "flag") {
      performFlagAction(tileButton, tile)
    }
    // If the mode is question mark
    else {
      performQuestionMarkAction(tileButton, tile)
    }
  }

  def performTileAction(tileButton: Button, tile: Tile): Unit = {
    // If the tile is not marked
    if (!tile.isFlagMarked && !tile.isQuestionMarked) {
      // Open the tile
      tile.openTile(tileButton)
      // Update emoji button based on corresponding tile type
      emojiButton.updateEmoji(tile.tileType)
      // Check game status
      checkStatus(mineField.listOfTiles)
    }
    // If the tile is marked
    else {
      val markType = tile.removeMark(tileButton)
      if (markType == "flag") {
        mineCounter.incrementCounter()
      }
    }
  }

  def performFlagAction(tileButton: Button, tile: Tile): Unit = {
    // If the tile is not opened
    if (!tile.isOpened) {
      // If the tile is not marked
      if (!tile.isFlagMarked && !tile.isQuestionMarked) {
        flagMarker.placeMarker(tileButton, tile)
        mineCounter.decrementCounter()
      }
      // If the tile is question marked
      else if (tile.isQuestionMarked) {
        flagMarker.replaceMarker(tileButton, tile)
        mineCounter.decrementCounter()
      }
      // If the tile is flag marked already
      else {
        flagMarker.removeMarker(tileButton, tile)
        mineCounter.incrementCounter()
      }
    }
  }

  def performQuestionMarkAction(tileButton: Button, tile: Tile): Unit = {
    // If the tile is not opened
    if (!tile.isOpened) {
      // If the tile is not marked
      if (!tile.isFlagMarked && !tile.isQuestionMarked) {
        questionMarkMarker.placeMarker(tileButton, tile)
      }
      // If the tile is flag marked
      else if (tile.isFlagMarked) {
        questionMarkMarker.replaceMarker(tileButton, tile)
        mineCounter.incrementCounter()
      }
      // If the tile is question marked already
      else {
        questionMarkMarker.removeMarker(tileButton, tile)
      }
    }
  }

  // Checks the status of the minefield to determine if the user wins or loses
  def checkStatus(listOfTiles: Array[Tile]): Unit = {
    var emptyTileClicks = 0
    var numberTileClicks = 0
    var mineTileClicks = 0

    for (tile <- listOfTiles) {
      // Count the number of empty tile clicks
      if (tile.tileType == "empty" && tile.isOpened) {
        emptyTileClicks += 1
      }
      // Count the number of number tile clicks
      else if (tile.tileType == "number" && tile.isOpened) {
        numberTileClicks += 1
      }
      // Count the number of mine tile clicks
      else if (tile.tileType == "mine" && tile.isOpened) {
        mineTileClicks += 1
      }
    }

    // If the user wins the game
    if (emptyTileClicks == mineField.noOfEmptyTiles &&
      numberTileClicks == mineField.noOfNumberTiles) {
      winGame()
    }

    // If the user loses the game
    if (mineTileClicks >= 1) {
      loseGame()
    }
  }

  def winGame(): Unit = {
    new Alert(AlertType.Information){
      initOwner(MainApp.stage)
      title       = "Minesweeper"
      headerText  = "Congratulations"
      contentText = "You win the game!"
    }.showAndWait()
    MainApp.showMenu()
  }

  def loseGame(): Unit = {
    new Alert(AlertType.Information){
      initOwner(MainApp.stage)
      title       = "Minesweeper"
      headerText  = "Condolences"
      contentText = "You lose the game!"
    }.showAndWait()
    MainApp.showMenu()
  }
}

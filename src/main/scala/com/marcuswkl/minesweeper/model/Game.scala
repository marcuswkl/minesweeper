package com.marcuswkl.minesweeper.model

import com.marcuswkl.minesweeper.MainApp
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType

class Game() {
  var mineCounter: MineCounter = new MineCounter()
  var timeCounter: TimeCounter = new TimeCounter()
  var emojiButton: EmojiButton = new EmojiButton(EmojiButton.emojiSmile)
  var mineField: MineField = new MineField(25)
  var flagMarker: FlagMarker = new FlagMarker()
  var questionMarkMarker: QuestionMarkMarker = new QuestionMarkMarker()
  var mode: String = "tile"

  // Checks the status of the minefield to determine if the user wins or loses
  def checkStatus(listOfTiles: Array[Tile]): Unit = {
    var emptyTileClicks = 0
    var numberTileClicks = 0
    var mineTileClicks = 0

    for (tile <- listOfTiles) {
      // Count the number of empty tile clicks
      if (tile.tileType == "empty" && tile.isTileClicked) {
        emptyTileClicks += 1
      }
      // Count the number of number tile clicks
      else if (tile.tileType == "number" && tile.isTileClicked) {
        numberTileClicks += 1
      }
      // Count the number of mine tile clicks
      else if (tile.tileType == "mine" && tile.isTileClicked) {
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

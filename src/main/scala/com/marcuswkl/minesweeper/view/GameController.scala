package com.marcuswkl.minesweeper.view

import com.marcuswkl.minesweeper.model.{EmojiButton, Game}
import scalafx.application.Platform
import scalafx.event.ActionEvent
import scalafx.scene.control.{Button, Label}
import scalafx.scene.image.ImageView
import scalafx.scene.layout.TilePane
import scalafx.scene.paint.Color
import scalafxml.core.macros.sfxml

import java.util.{Timer, TimerTask}
import javafx.{scene => jfxs}

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
  gameInstance.mineField.listOfTiles = gameInstance.mineField.generateTiles()

  // Initialise mine counter text
  gameInstance.mineCounter.counterValue = gameInstance.mineField.noOfMineTiles
  mineCounter.text = gameInstance.mineCounter.displayCounterValue()

  // Assign the symbol of the generated tile to the corresponding tile button text
  var tileCounter = 0
  for (tileButton <- tileButtons) {
    tileButton.text = gameInstance.mineField.listOfTiles(tileCounter).symbol
    // Hide the text after assigning the symbol
    tileButton.textFill = Color.Transparent
    // Increase tile counter to move to the next generated tile
    tileCounter += 1
  }

  // Start updating the counter each second
  def startTimeCounter(): Unit = {
    // Create a new thread for update execution
    val updateCounterRunnable = new Runnable() {
      def run(): Unit = {
        gameInstance.timeCounter.updateCounter()
        timeCounter.text = gameInstance.timeCounter.displayCounterValue()
      }
    }
    // Create a timer and schedule the update thread
    val timeCounterTimer = new Timer()
    val updateCounterTask = new TimerTask {
      override def run(): Unit = {
        Platform.runLater(updateCounterRunnable)
      }
    }
    timeCounterTimer.schedule(updateCounterTask, 1000, 1000)
  }

  // Handle tile button click
  def handleClick(event: ActionEvent): Unit = {
    // Get tile button object
    val tileButton = event.source.asInstanceOf[jfxs.control.Button]
    // Get tile button FXId
    val buttonFXId = tileButton.getId
    // Get tile number from FXId
    val tileNo = buttonFXId.substring(4).toInt
    // Unhide the button text to show the symbol
    tileButton.setTextFill(Color.Black)
    // Get the corresponding tile
    // Tile number decremented to align with array index
    val tile = gameInstance.mineField.listOfTiles(tileNo - 1)
    // Execute corresponding tile click method
    tile.leftClick()
    // Update emoji button based on corresponding tile type
    gameInstance.emojiButton.updateEmoji(tile.tileType)
    emojiButton.image = gameInstance.emojiButton.emoji
  }

  //  generateMines()
  startTimeCounter()
}
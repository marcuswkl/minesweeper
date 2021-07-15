package com.marcuswkl.minesweeper.view

import com.marcuswkl.minesweeper.model.Game
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.{Button, Label}
import scalafx.scene.image.ImageView
import scalafx.scene.layout.TilePane
import scalafxml.core.macros.sfxml

import scala.util.Random

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

  // Insert tiles into array for easier usage
  val tiles: Array[Button] = Array(tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, tile10, tile11,
    tile12, tile13, tile14, tile15, tile16, tile17, tile18, tile19, tile20, tile21, tile22, tile23, tile24, tile25)

  emojiButton.image = Game.emojiSmile

  var mineCounterInt: Int = 0

  def generateMines(): Unit = {
    // Generate mines in tiles randomly
    for (tile <- tiles) {
      if (Random.nextDouble() <= 0.2) {
        tile.text = "💣"
        mineCounterInt += 1
      }
    }
  }

  def handleClick(event: ActionEvent): Unit = {
    val buttonText = event.source.asInstanceOf[jfxs.control.Button].getText
    if (buttonText == "💣") {
      println("Bomb exploded!")
      emojiButton.image = Game.emojiDead
    } else {
      println("No bomb found!")
      emojiButton.image = Game.emojiOpenMouth
    }
  }

  generateMines()
  mineCounter.text = "00" + mineCounterInt.toString
}

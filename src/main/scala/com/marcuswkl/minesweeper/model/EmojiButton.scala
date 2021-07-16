package com.marcuswkl.minesweeper.model

import scalafx.scene.image.Image

class EmojiButton(var emoji: Image) {
  // Update emoji when user clicks a tile
  def updateEmoji(): Unit = {
    // TODO Update emoji based on boolean status - step on mine or not
  }
}

// Companion object to store emoji images
object EmojiButton {
  val emojiSmile = new Image(getClass.getResourceAsStream("../images/emoji-smile.png"))
  val emojiOpenMouth = new Image(getClass.getResourceAsStream("../images/emoji-open-mouth.png"))
  val emojiDead = new Image(getClass.getResourceAsStream("../images/emoji-dead.png"))
}

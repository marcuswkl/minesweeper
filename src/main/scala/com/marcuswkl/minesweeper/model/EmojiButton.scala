package com.marcuswkl.minesweeper.model

import scalafx.scene.image.Image

class EmojiButton(var emoji: Image) {
  // Update emoji when user clicks a tile
  def updateEmoji(tileType: String): Unit = {
    if (tileType == "empty") {
      emoji = EmojiButton.emojiSmile
    } else if (tileType == "number") {
      emoji = EmojiButton.emojiOpenMouth
    } else {
      emoji = EmojiButton.emojiDead
    }
  }
}

// Companion object to store emoji images
object EmojiButton {
  // Tile mode emojis
  val emojiSmile = new Image(getClass.getResourceAsStream("../images/emoji-smile.png"))
  val emojiOpenMouth = new Image(getClass.getResourceAsStream("../images/emoji-open-mouth.png"))
  val emojiDead = new Image(getClass.getResourceAsStream("../images/emoji-dead.png"))
  // Marker mode emojis
  val emojiFlag = new Image(getClass.getResourceAsStream("../images/emoji-flag.png"))
  val emojiQuestionMark = new Image(getClass.getResourceAsStream("../images/emoji-question-mark.png"))
}

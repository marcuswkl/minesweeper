package com.marcuswkl.minesweeper.model

import scalafx.scene.image.Image

class EmojiButton(var emoji: Image) {
  // Update emoji when user changes mode
  def updateModeEmoji(mode: String): Unit = {
    if (mode == "tile") {
      emoji = EmojiButton.emojiSmile
    } else if (mode == "flag") {
      emoji = EmojiButton.emojiFlag
    } else {
      emoji = EmojiButton.emojiQuestionMark
    }
  }

  // Update emoji when user clicks a tile in tile mode
  def updateTileModeEmoji(tileType: String): Unit = {
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
  // Mode emojis
  val emojiSmile = new Image(getClass.getResourceAsStream("../images/emoji-smile.png"))
  val emojiFlag = new Image(getClass.getResourceAsStream("../images/emoji-flag.png"))
  val emojiQuestionMark = new Image(getClass.getResourceAsStream("../images/emoji-question-mark.png"))
  // Tile mode emojis
  val emojiOpenMouth = new Image(getClass.getResourceAsStream("../images/emoji-open-mouth.png"))
  val emojiDead = new Image(getClass.getResourceAsStream("../images/emoji-dead.png"))
}

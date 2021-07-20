package com.marcuswkl.minesweeper.model

import scalafx.scene.image.Image

class EmojiImage(var emoji: Image) {
  // Update emoji when user changes mode
  def updateModeEmoji(mode: String): Unit = {
    if (mode == "tile") {
      emoji = EmojiImage.emojiSmile
    } else if (mode == "flag") {
      emoji = EmojiImage.emojiFlag
    } else {
      emoji = EmojiImage.emojiQuestionMark
    }
  }

  // Update emoji when user clicks a tile in tile mode
  def updateTileModeEmoji(tileType: String): Unit = {
    if (tileType == "empty") {
      emoji = EmojiImage.emojiSmile
    } else if (tileType == "number") {
      emoji = EmojiImage.emojiOpenMouth
    } else {
      emoji = EmojiImage.emojiDead
    }
  }

}

// Companion object to store emoji images
object EmojiImage {
  // Mode emojis
  val emojiSmile = new Image(getClass.getResourceAsStream("../images/emoji-smile.png"))
  val emojiFlag = new Image(getClass.getResourceAsStream("../images/emoji-flag.png"))
  val emojiQuestionMark = new Image(getClass.getResourceAsStream("../images/emoji-question-mark.png"))
  // Tile mode emojis
  val emojiOpenMouth = new Image(getClass.getResourceAsStream("../images/emoji-open-mouth.png"))
  val emojiDead = new Image(getClass.getResourceAsStream("../images/emoji-dead.png"))
}

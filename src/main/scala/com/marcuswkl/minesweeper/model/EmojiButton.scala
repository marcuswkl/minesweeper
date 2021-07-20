package com.marcuswkl.minesweeper.model

import scalafx.scene.image.{Image, ImageView}

class EmojiButton(var emoji: Image) {
  // Update emoji when user clicks a tile
  def updateEmoji(tileType: String, emojiButton: ImageView): Unit = {
    if (tileType == "empty") {
      emoji = EmojiButton.emojiSmile
      emojiButton.setImage(emoji)
    } else if (tileType == "number") {
      emoji = EmojiButton.emojiOpenMouth
      emojiButton.setImage(emoji)
    } else {
      emoji = EmojiButton.emojiDead
      emojiButton.setImage(emoji)
    }
  }
}

// Companion object to store emoji images
object EmojiButton {
  val emojiSmile = new Image(getClass.getResourceAsStream("../images/emoji-smile.png"))
  val emojiOpenMouth = new Image(getClass.getResourceAsStream("../images/emoji-open-mouth.png"))
  val emojiDead = new Image(getClass.getResourceAsStream("../images/emoji-dead.png"))
}

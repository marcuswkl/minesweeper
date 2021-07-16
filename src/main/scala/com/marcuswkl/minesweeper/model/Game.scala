package com.marcuswkl.minesweeper.model

import scalafx.scene.image.Image

class Game() {
  var mineCounter: MineCounter = new MineCounter(5)
  var timeCounter: TimeCounter = new TimeCounter()
  var emojiButton: EmojiButton = new EmojiButton(EmojiButton.emojiSmile)
  var mineField: MineField = new MineField()
}

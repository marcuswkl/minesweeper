package com.marcuswkl.minesweeper.model

class Game() {
  var mineCounter: MineCounter = new MineCounter()
  var timeCounter: TimeCounter = new TimeCounter()
  var emojiButton: EmojiButton = new EmojiButton(EmojiButton.emojiSmile)
  var mineField: MineField = new MineField(25)
  var mode: String = "tile"
}

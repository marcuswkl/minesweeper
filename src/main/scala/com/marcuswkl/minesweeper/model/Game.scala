package com.marcuswkl.minesweeper.model

import scalafx.scene.image.Image

class Game() {
  var mineCounter: MineCounter = new MineCounter(5)
  var timeCounter: TimeCounter = new TimeCounter()
  var emojiButton: EmojiButton = new EmojiButton()
  var mineField: MineField = new MineField()
}

/*object Game {
  val emojiSmile = new Image(getClass.getResourceAsStream("../images/emoji-smile.png"))
  val emojiOpenMouth = new Image(getClass.getResourceAsStream("../images/emoji-open-mouth.png"))
  val emojiDead = new Image(getClass.getResourceAsStream("../images/emoji-dead.png"))
}*/

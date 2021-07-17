package com.marcuswkl.minesweeper.model

class MineCounter(var counterValue: Int = 0) extends Counter("mine") {
  override def updateCounter(): Unit = {
    counterValue -= 1
    // TODO Update when flag marker placed
  }

  // Display positive and negative digits using three places format (nnn)
  override def displayCounterValue(): String = {
    // Display positive single digit with two leading zeroes
    if (counterValue >= 0 && counterValue <= 9) {
      "00" + counterValue.toString
    }
    // Display positive double digit with one leading zero
    else if (counterValue >= 10 && counterValue <= 99) {
      "0" + counterValue.toString
    }
    // Display negative single digit with one middle zero
    else if (counterValue <= -1 && counterValue >= -9) {
      "-0" + counterValue.abs.toString
    }
    // Display digits directly if positive three digits or negative two digits
    else {
      counterValue.toString
    }
  }
}

package com.marcuswkl.minesweeper.model

import java.util.{Timer, TimerTask}

class TimeCounter(var counterValue: Int = 0) extends Counter("time") {
  override def updateCounter(): Unit = {
    counterValue += 1
  }

  // Display positive digits using three places format (nnn)
  override def displayCounterValue(): String = {
    // Display positive single digit with two leading zeroes
    if (counterValue >= 0 && counterValue <= 9) {
      "00" + counterValue.toString
    }
    // Display positive double digit with one leading zero
    else if (counterValue >= 10 && counterValue <= 99) {
      "0" + counterValue.toString
    }
    // Display digits directly if positive three digits
    else {
      counterValue.toString
    }
  }
}

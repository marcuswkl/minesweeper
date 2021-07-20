package com.marcuswkl.minesweeper.model

import scalafx.application.Platform
import scalafx.scene.control.Label

import java.util.{Timer, TimerTask}

class TimeCounter(var counterValue: Int = 0) extends Counter("time") {
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

  // Start updating the counter each second
  def startTimeCounter(counterLabel: Label): Unit = {
    // Create a new thread for update execution
    val updateCounterRunnable = new Runnable() {
      def run(): Unit = {
        incrementCounter()
        counterLabel.text = displayCounterValue()
      }
    }
    // Create a timer and schedule the update thread
    val timeCounterTimer = new Timer()
    val updateCounterTask = new TimerTask {
      override def run(): Unit = {
        Platform.runLater(updateCounterRunnable)
      }
    }
    timeCounterTimer.schedule(updateCounterTask, 1000, 1000)
  }

  def hideTimeCounter(counterLabel: Label): Unit = {
    counterLabel.visible = false
  }
}

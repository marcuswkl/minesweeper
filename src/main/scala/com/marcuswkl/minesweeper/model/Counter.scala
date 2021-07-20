package com.marcuswkl.minesweeper.model

abstract class Counter(val counterType: String) {
  var counterValue: Int

  // All counters will increment in the same way
  def incrementCounter(): Unit = {
    counterValue += 1
  }

  // All counters will decrement in the same way
  def decrementCounter(): Unit = {
    counterValue -= 1
  }

  // Different counters will display differently
  def displayCounterValue(): String
}

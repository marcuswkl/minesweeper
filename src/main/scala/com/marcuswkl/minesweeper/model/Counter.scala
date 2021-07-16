package com.marcuswkl.minesweeper.model

abstract class Counter(val counterType: String) {
  var counterValue: Int

  // Different counters will update differently
  def updateCounter(): Unit

  // Different counters will display differently
  def displayCounterValue(): String
}

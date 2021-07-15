package com.marcuswkl.minesweeper.view

import com.marcuswkl.minesweeper.MainApp
import scalafx.application.Platform
import scalafxml.core.macros.sfxml

@sfxml
class MenuController() {
  // Play the game
  def handlePlay() : Unit = {
    MainApp.showGame()
  }

  // Exit the game
  def handleExit() {
    Platform.exit()
  }
}

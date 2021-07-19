package com.marcuswkl.minesweeper.view

import com.marcuswkl.minesweeper.MainApp
import scalafx.application.Platform
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import scalafxml.core.macros.sfxml

@sfxml
class RootLayoutController() {
  // Exit the game
  def handleExit() {
    Platform.exit()
  }

  // Create a new game
  def handleNew() {
    MainApp.showGame()
  }

  // Display about dialog
  def handleAbout() {
    new Alert(AlertType.Information){
      initOwner(MainApp.stage)
      title       = "Minesweeper"
      headerText  = "About Minesweeper"
      contentText = "Minesweeper is a single-player puzzle video game. The objective of the game is to clear a " +
        "rectangular board containing hidden \"mines\" or bombs without detonating any of them, with help from clues" +
        " about the number of neighbouring mines in each field. The game originates from the 1960s, and it has been" +
        " written for many computing platforms in use today. It has many variations and offshoots. - Wikipedia\n\n" +
        "This version is copyrighted by Marcus Wong Ke Lun."
    }.showAndWait()
  }
}

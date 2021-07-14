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

  // Display about dialog
  def handleAbout() {
    new Alert(AlertType.Information){
      initOwner(MainApp.stage)
      title       = "About"
      headerText  = "Minesweeper"
      contentText = "Copyrighted by Marcus Wong Ke Lun"
    }.showAndWait()
  }
}

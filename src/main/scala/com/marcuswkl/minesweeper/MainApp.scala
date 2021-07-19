package com.marcuswkl.minesweeper

import com.marcuswkl.minesweeper.view.GameController
import javafx.scene.control.SplitPane
import javafx.scene.layout.{AnchorPane, BorderPane}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.Image
import scalafxml.core.{FXMLLoader, NoDependencyResolver}

object MainApp extends JFXApp {
  // Transform the path of RootLayout.fxml to URI for resource location
  val rootResource = getClass.getResourceAsStream("view/RootLayout.fxml")
  // Initialise the loader object
  val loader = new FXMLLoader(null, NoDependencyResolver)
  // Load root layout from fxml file
  loader.load(rootResource)
  // Retrieve the root component BorderPane from the FXML
  val roots = loader.getRoot[BorderPane]

  var gameStarted = false
  var gameControllerOption: Option[GameController#Controller] = None

  // Initialise stage
  stage = new PrimaryStage {
    title = "Minesweeper"
    scene = new Scene {
      root = roots
    }
    icons += new Image(getClass.getResourceAsStream("images/minesweeper-icon.png"))
  }

  // Display the menu
  def showMenu(): Unit = {
    val resource = getClass.getResourceAsStream("view/Menu.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots = loader.getRoot[AnchorPane]
    this.roots.setCenter(roots)
  }

  // Display the game
  def showGame(): Unit = {
    val resource = getClass.getResourceAsStream("view/Game.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots = loader.getRoot[SplitPane]
    this.roots.setCenter(roots)
    gameControllerOption = Option(loader.getController[GameController#Controller])
    gameStarted = true
  }

  // Display the menu when the app starts
  showMenu()

}

package com.marcuswkl.minesweeper

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import javafx.scene.layout.{AnchorPane, BorderPane}
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

  // Initialise stage
  stage = new PrimaryStage {
    title = "Minesweeper"
    scene = new Scene {
      root = roots
    }
    icons += new Image(getClass.getResourceAsStream("images/minesweeper-icon.png"))
  }

  def showMenu(): Unit = {
    val resource = getClass.getResourceAsStream("view/Menu.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots = loader.getRoot[AnchorPane]
    this.roots.setCenter(roots)
  }

  def showGame(): Unit = {
    // Show game code
  }

  // Display the menu when the app starts
  showMenu()

}

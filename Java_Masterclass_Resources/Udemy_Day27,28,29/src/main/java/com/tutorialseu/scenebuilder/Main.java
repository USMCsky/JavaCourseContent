package com.tutorialseu.scenebuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/com/tutorialseu/scenebuilder/layout.fxml"));

        // Set the title of the window
        primaryStage.setTitle("JavaFX Scene Builder Example");

        // Create a scene with the loaded layout
        Scene scene = new Scene(root, 600, 400);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

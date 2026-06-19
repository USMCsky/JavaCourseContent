package com.tutorialseu.keyevents;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file from the resources directory
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tutorialseu/keyevents/KeyEventDemo.fxml"));
        AnchorPane root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Directly set the event handler on the scene
        scene.setOnKeyPressed(event -> {
            KeyEventController controller = loader.getController();
            controller.handleKeyPressed(event);
        });

        // Set the stage
        primaryStage.setTitle("JavaFX Key Events Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

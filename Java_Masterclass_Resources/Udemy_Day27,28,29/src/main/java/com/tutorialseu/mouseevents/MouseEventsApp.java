package com.tutorialseu.mouseevents;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MouseEventsApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tutorialseu/mouseevents/MouseEvents.fxml"));
        Parent root = loader.load();

        // Set up the scene
        Scene scene = new Scene(root);

        // Handle mouse movement within the scene
        scene.setOnMouseMoved(event -> {
            // Get the controller instance
            MouseEventsController controller = loader.getController();
            // Pass the event to the controller's handleMouseMovement method
            controller.handleMouseMovement(event);
        });

        // Set the stage title
        primaryStage.setTitle("Mouse Events Example");

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Display the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

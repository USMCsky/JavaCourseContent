package com.tutorialseu.moveshape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MoveShapeApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/tutorialseu/moveshape/MoveShape.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Move Shape with Keystrokes");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Request focus on the root node to capture key events
        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

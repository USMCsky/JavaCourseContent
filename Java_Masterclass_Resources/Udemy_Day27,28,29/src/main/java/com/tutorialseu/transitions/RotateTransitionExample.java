package com.tutorialseu.transitions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.RotateTransition;
import javafx.util.Duration;

public class RotateTransitionExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Step 2: Creating a Shape
        Rectangle rectangle = new Rectangle(100, 100, Color.BLUE);

        // Step 3: Creating a Rotate Transition
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(3));
        rotateTransition.setNode(rectangle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(true);

        // Step 4: Setting up the Layout
        StackPane root = new StackPane(rectangle);
        Scene scene = new Scene(root, 300, 250);

        // Step 5: Finalizing the Stage
        primaryStage.setTitle("Rotate Transition Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Step 6: Starting the Transition
        rotateTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


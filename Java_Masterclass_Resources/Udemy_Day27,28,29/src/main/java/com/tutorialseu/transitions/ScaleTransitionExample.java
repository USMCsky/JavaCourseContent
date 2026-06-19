package com.tutorialseu.transitions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

public class ScaleTransitionExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Step 2: Creating a Shape
        Circle circle = new Circle(50, Color.RED);

        // Step 3: Creating a Scale Transition
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.seconds(2));
        scaleTransition.setNode(circle);
        scaleTransition.setByX(1.5);
        scaleTransition.setByY(1.5);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);

        // Step 4: Setting up the Layout
        StackPane root = new StackPane(circle);
        Scene scene = new Scene(root, 400, 400);

        // Step 5: Finalizing the Stage
        primaryStage.setTitle("Scale Transition Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Step 6: Starting the Transition
        scaleTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


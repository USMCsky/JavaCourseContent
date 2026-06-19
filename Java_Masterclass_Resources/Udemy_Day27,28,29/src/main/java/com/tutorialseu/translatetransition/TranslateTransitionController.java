package com.tutorialseu.translatetransition;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TranslateTransitionController {

    @FXML
    private Circle myCircle;

    @FXML
    private Button animateButton;

    private TranslateTransition initialRightTransition;
    private TranslateTransition leftTransition;
    private TranslateTransition rightTransition;
    private boolean isAnimating = false;
    private boolean isInitialAnimationDone = false;

    public void initialize() {
        // Initial right transition: 100px to the right
        initialRightTransition = new TranslateTransition();
        initialRightTransition.setNode(myCircle);
        initialRightTransition.setDuration(Duration.seconds(1));
        initialRightTransition.setByX(100);

        // Left transition: 200px to the left
        leftTransition = new TranslateTransition();
        leftTransition.setNode(myCircle);
        leftTransition.setDuration(Duration.seconds(2));
        leftTransition.setByX(-200);

        // Right transition: 200px to the right
        rightTransition = new TranslateTransition();
        rightTransition.setNode(myCircle);
        rightTransition.setDuration(Duration.seconds(2));
        rightTransition.setByX(200);

        // Chain transitions
        initialRightTransition.setOnFinished(event -> {
            isInitialAnimationDone = true;
            leftTransition.play();
        });

        leftTransition.setOnFinished(event -> rightTransition.play());
        rightTransition.setOnFinished(event -> leftTransition.play());

        // Set up the animation control on the button click
        animateButton.setOnAction(event -> {
            if (isAnimating) {
                stopAnimation();
            } else {
                startAnimation();
            }
        });
    }

    private void startAnimation() {
        if (isInitialAnimationDone) {
            rightTransition.play(); // Continue with the right-left loop after the initial animation
        } else {
            initialRightTransition.play(); // Start with the initial right movement
        }
        animateButton.setText("Stop");
        isAnimating = true;
    }

    private void stopAnimation() {
        if (isInitialAnimationDone) {
            leftTransition.pause();
            rightTransition.pause();
        } else {
            initialRightTransition.pause();
        }
        Platform.exit(); // Close the application window
    }
}

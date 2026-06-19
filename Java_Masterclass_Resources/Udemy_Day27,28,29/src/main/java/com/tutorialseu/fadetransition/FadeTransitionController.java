package com.tutorialseu.fadetransition;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class FadeTransitionController {

    @FXML
    private Label textLabel;

    private boolean isVisible = false;

    @FXML
    private void initialize() {
        // Set the label's text to be initially invisible (empty)
        textLabel.setText("");
        textLabel.setOpacity(0.0);
    }

    @FXML
    private void handleFadeTransition() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), textLabel);

        if (isVisible) {
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
        } else {
            textLabel.setText("Hello, JavaFX!");  // Set the text when becoming visible
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
        }

        fadeTransition.play();
        isVisible = !isVisible;

        // Clear the text after the fade-out transition
        if (!isVisible) {
            fadeTransition.setOnFinished(event -> textLabel.setText(""));
        }
    }
}

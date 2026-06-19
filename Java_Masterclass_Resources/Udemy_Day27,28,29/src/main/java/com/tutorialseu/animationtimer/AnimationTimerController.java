package com.tutorialseu.animationtimer;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AnimationTimerController {

    @FXML
    private Label animatedLabel;

    private double opacity = 1.0;
    private boolean fadingOut = true;
    private long lastUpdate = 0;

    public void initialize() {
        // Start the animation timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Update animation at 50 FPS (20 milliseconds interval)
                if (now - lastUpdate >= 20_000_000) {
                    // Adjust the opacity
                    if (fadingOut) {
                        opacity -= 0.01;
                        if (opacity <= 0.0) {
                            fadingOut = false;
                        }
                    } else {
                        opacity += 0.01;
                        if (opacity >= 1.0) {
                            fadingOut = true;
                        }
                    }

                    // Apply the opacity to the label
                    animatedLabel.setOpacity(opacity);

                    // Record the last update time
                    lastUpdate = now;
                }
            }
        };

        // Start the timer
        timer.start();
    }
}


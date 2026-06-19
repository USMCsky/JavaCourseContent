package com.tutorialseu.keyevents;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class KeyEventController {

    @FXML
    private Label labelOutput;

    // Method to handle key pressed events
    @FXML
    public void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                labelOutput.setText("Up Arrow Pressed");
                break;
            case DOWN:
                labelOutput.setText("Down Arrow Pressed");
                break;
            case LEFT:
                labelOutput.setText("Left Arrow Pressed");
                break;
            case RIGHT:
                labelOutput.setText("Right Arrow Pressed");
                break;
            default:
                labelOutput.setText("Press an arrow key...");
                break;
        }
    }
}



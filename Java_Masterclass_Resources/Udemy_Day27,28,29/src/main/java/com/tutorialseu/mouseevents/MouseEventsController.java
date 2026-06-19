package com.tutorialseu.mouseevents;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MouseEventsController {

    @FXML
    private Label xLabel;

    @FXML
    private Label yLabel;

    @FXML
    void handleMouseMovement(MouseEvent event) {
        // Capture the X and Y coordinates of the mouse pointer
        double x = event.getX();
        double y = event.getY();

        // Update the labels with the coordinates
        xLabel.setText("X Coordinate: " + x);
        yLabel.setText("Y Coordinate: " + y);
    }
}
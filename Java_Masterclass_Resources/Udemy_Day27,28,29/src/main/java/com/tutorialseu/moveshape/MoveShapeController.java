package com.tutorialseu.moveshape;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MoveShapeController {

    @FXML
    private Circle movableCircle;

    private final double SCENE_WIDTH = 600; // Width of the scene
    private final double SCENE_HEIGHT = 400; // Height of the scene
    private final double CIRCLE_RADIUS = 50; // Radius of the circle

    // Method to initialize the circle's position and color
    @FXML
    public void initialize() {
        // Set the initial position of the circle at the center of the scene
        movableCircle.setLayoutX(SCENE_WIDTH / 2);
        movableCircle.setLayoutY(SCENE_HEIGHT / 2);

        // Set the initial color based on the center position
        updateCircleColor();
    }

    // Method to handle key presses
    @FXML
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                if (movableCircle.getLayoutY() - CIRCLE_RADIUS > 0) {
                    movableCircle.setLayoutY(movableCircle.getLayoutY() - 10);
                }
                break;
            case DOWN:
                if (movableCircle.getLayoutY() + CIRCLE_RADIUS < SCENE_HEIGHT) {
                    movableCircle.setLayoutY(movableCircle.getLayoutY() + 10);
                }
                break;
            case LEFT:
                if (movableCircle.getLayoutX() - CIRCLE_RADIUS > 0) {
                    movableCircle.setLayoutX(movableCircle.getLayoutX() - 10);
                }
                break;
            case RIGHT:
                if (movableCircle.getLayoutX() + CIRCLE_RADIUS < SCENE_WIDTH) {
                    movableCircle.setLayoutX(movableCircle.getLayoutX() + 10);
                }
                break;
            default:
                break;
        }
        updateCircleColor();
    }

    // Method to gradually update the color of the circle based on its position
    private void updateCircleColor() {
        double x = movableCircle.getLayoutX();
        double y = movableCircle.getLayoutY();

        // Calculate the normalized values (range 0 to 1) based on the circle's position
        double normalizedX = x / SCENE_WIDTH;
        double normalizedY = y / SCENE_HEIGHT;

        // Calculate the RGB components based on the normalized position
        double red = (1 - normalizedX) * (1 - normalizedY); // Top-left -> Red
        double green = normalizedX * (1 - normalizedY);     // Top-right -> Green
        double blue = (1 - normalizedX) * normalizedY;      // Bottom-left -> Blue
        double yellow = normalizedX * normalizedY;          // Bottom-right -> Yellow

        // Combine the RGB components and ensure they are within the valid range (0.0 to 1.0)
        double finalRed = Math.min(red + yellow, 1.0);
        double finalGreen = Math.min(green + yellow, 1.0);
        double finalBlue = Math.min(blue + yellow, 1.0);

        // Set the circle's fill color
        movableCircle.setFill(Color.color(finalRed, finalGreen, finalBlue));
    }
}

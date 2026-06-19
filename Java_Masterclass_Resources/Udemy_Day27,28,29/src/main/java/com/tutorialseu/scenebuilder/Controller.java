package com.tutorialseu.scenebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private void handleButtonClick() {
        label.setText("Button Pressed!");
    }
}

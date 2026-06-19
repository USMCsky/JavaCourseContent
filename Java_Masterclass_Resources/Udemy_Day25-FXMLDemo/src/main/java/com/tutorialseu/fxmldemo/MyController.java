package com.tutorialseu.fxmldemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MyController {

    @FXML
    private Label myLabel;

    @FXML
    private void handleButtonClick() {
        myLabel.setText("Button Clicked!");
    }
}
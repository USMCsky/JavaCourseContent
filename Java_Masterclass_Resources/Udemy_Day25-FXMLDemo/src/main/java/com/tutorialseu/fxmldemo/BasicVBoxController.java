package com.tutorialseu.fxmldemo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BasicVBoxController {

    @FXML
    private void handleButtonClick() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Button Clicked");
        alert.setHeaderText(null);
        alert.setContentText("Hello, you clicked the button!");
        alert.showAndWait();
    }
}
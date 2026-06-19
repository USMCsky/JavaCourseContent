package com.tutorialseu.form;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private Button button;

    @FXML
    protected void handleSubmitAction() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}

package com.tutorialseu.bindingproperties;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BindingController {

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Label sumLabel;

    @FXML
    public void initialize() {
        sumLabel.textProperty().bind(
                Bindings.createStringBinding(
                        () -> {
                            String text1 = textField1.getText();
                            String text2 = textField2.getText();

                            // Handle null or empty inputs
                            if (text1 == null || text1.trim().isEmpty() || text2 == null || text2.trim().isEmpty()) {
                                return "Enter valid numbers";
                            }

                            try {
                                double num1 = Double.parseDouble(text1);
                                double num2 = Double.parseDouble(text2);
                                return "Sum = " + (num1 + num2);
                            } catch (NumberFormatException e) {
                                return "Enter valid numbers";
                            }
                        },
                        textField1.textProperty(), textField2.textProperty()
                )
        );
    }
}
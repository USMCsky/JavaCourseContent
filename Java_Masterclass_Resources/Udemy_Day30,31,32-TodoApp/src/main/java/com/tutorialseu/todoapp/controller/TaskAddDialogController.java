package com.tutorialseu.todoapp.controller;

import com.tutorialseu.todoapp.exceptions.EmptyTaskTitleException;
import com.tutorialseu.todoapp.exceptions.InvalidTaskTitleException;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class TaskAddDialogController {

    @FXML
    private MFXTextField taskTitleField;

    @FXML
    private TextArea taskDescriptionField;

    private TodoController mainController;

    public void setMainController(TodoController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleSubmit() {
        String title = taskTitleField.getText();
        String description = taskDescriptionField.getText();

        try {
            validateTaskTitle(title);  // Validate task title

            mainController.addTaskFromDialog(title, description);
            closeDialog();

        } catch (InvalidTaskTitleException | EmptyTaskTitleException e) {
            showErrorAlert(e.getMessage());  // Show error alert on catching the exception
        }

    }

    @FXML
    private void handleCancel() {
        closeDialog();
    }

    private void closeDialog() {
        Stage stage = (Stage) taskTitleField.getScene().getWindow();
        stage.close();
    }

    private void showErrorAlert(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Validation Error");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    private void validateTaskTitle(String title) throws InvalidTaskTitleException, EmptyTaskTitleException {
        if (title == null || title.trim().isEmpty()) {
            throw new EmptyTaskTitleException("Task title cannot be empty or null.");
        }

        if (!title.matches("[a-zA-Z0-9 ]+")) {  // Only allows letters, numbers, and spaces
            throw new InvalidTaskTitleException("Task title contains invalid characters.");
        }
    }
}


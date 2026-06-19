package com.tutorialseu.todoapp.controller;

import com.tutorialseu.todoapp.exceptions.CommentLengthExceededException;
import com.tutorialseu.todoapp.exceptions.EmptyTaskTitleException;
import com.tutorialseu.todoapp.exceptions.InvalidTaskTitleException;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import com.tutorialseu.todoapp.dto.TaskDTO;
import javafx.scene.text.Text;

public class TaskViewDialogController {

    @FXML
    private MFXTextField taskTitleField;

    @FXML
    private TextArea taskDescriptionField;

    @FXML
    private MFXComboBox<String> statusComboBox;

    @FXML
    private MFXTextField commentField;

    @FXML
    private VBox commentList;

    private TaskDTO task;
    private TaskCardController mainController;

    public void setTaskDetails(TaskDTO task, TaskCardController mainController) {
        this.task = task;
        this.mainController = mainController;

        taskTitleField.setText(task.getTitle());
        taskDescriptionField.setText(task.getDescription());

        statusComboBox.getItems().clear();  // Clear any existing items
        statusComboBox.getItems().addAll("ToDo", "InProgress", "Done");

        // Use Platform.runLater to delay setting the value until the UI is fully loaded
        Platform.runLater(() -> {
            statusComboBox.setValue(task.getStatus());
        });

        // Display existing comments
        task.getComments().forEach(comment -> displayComment(comment));
    }

    private void displayComment(String comment) {
        Text commentLabel = new Text(comment);
        commentLabel.setStyle("-fx-padding: 3px;");
        commentList.getChildren().addFirst(commentLabel);
    }

    @FXML
    private void handleAddComment() {
        String comment = commentField.getText();
        try {
            validateComment(comment);  // Validate comment length

            if (!comment.isEmpty()) {
                task.addComment(comment);
                displayComment(comment);
                commentField.clear();
            }
        } catch (CommentLengthExceededException e) {
            showErrorAlert(e.getMessage());  // Show error alert on catching the exception
        }
    }

    @FXML
    private void handleUpdate() {
        try {
            validateTaskTitle(taskTitleField.getText());  // Validate task title

            // Update task details
            task.setTitle(taskTitleField.getText());
            task.setDescription(taskDescriptionField.getText());
            task.setStatus(statusComboBox.getValue());

            // Notify the main controller to update the task list
            mainController.updateTask(task);

            // Close the dialog
            closeDialog();
        } catch (InvalidTaskTitleException | EmptyTaskTitleException e) {
            showErrorAlert(e.getMessage());  // Show error alert on catching the exception
        }
    }

    @FXML
    private void handleDelete() {
        mainController.deleteTask(task);  // Notify the main controller to delete the task
        closeDialog();  // Close the dialog after deletion
    }

    @FXML
    private void handleCancel() {
        closeDialog();
    }

    private void closeDialog() {
        taskTitleField.getScene().getWindow().hide();
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

    private void validateComment(String comment) throws CommentLengthExceededException {
        if (comment.length() > 100) {
            throw new CommentLengthExceededException("Comment length cannot exceed 100 characters.");
        }
    }
}


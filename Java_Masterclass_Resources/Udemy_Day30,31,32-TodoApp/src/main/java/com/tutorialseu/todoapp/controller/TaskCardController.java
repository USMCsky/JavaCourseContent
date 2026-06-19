package com.tutorialseu.todoapp.controller;

import com.tutorialseu.todoapp.dto.TaskDTO;
import com.tutorialseu.todoapp.dto.TaskList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskCardController {

    @FXML
    private Label taskName;

    @FXML
    private Label taskTimestamp;

    @FXML
    private Label taskStatus;

    private String taskId;

    private final TaskList taskList = new TaskList();

    private TodoController mainController;

    public void setTaskDetails(String name, LocalDateTime timestamp, String status, String id, TodoController controller) {
        taskName.setText(name);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a, MM/dd/yyyy");
        taskTimestamp.setText(timestamp.format(formatter));
        taskStatus.setText(status);
        this.taskId = id; // Id has been added
        applyStatusColor(status);// Changing color based on status

        mainController = controller; // Added reference to the controller to redraw the taskList after updation.
    }

    private void applyStatusColor(String status) {
        switch (status) {
            case "ToDo":
                taskStatus.setStyle("-fx-text-fill: grey;");
                break;
            case "InProgress":
                taskStatus.setStyle("-fx-text-fill: orange;");
                break;
            case "Done":
                taskStatus.setStyle("-fx-text-fill: green;");
                break;
            default:
                taskStatus.setStyle("-fx-text-fill: black;");
                break;
        }
    }

    @FXML
    private void handleViewTask() {
        TaskDTO task = taskList.getTaskById(taskId);
        showViewTaskDialog(task);
    }

    private void showViewTaskDialog(TaskDTO task) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tutorialseu/todoapp/task_view_dialog.fxml"));
            VBox dialogPane = loader.load();

            TaskViewDialogController dialogController = loader.getController();
            dialogController.setTaskDetails(task, this);

            Stage dialogStage = new Stage();
            dialogStage.setTitle("View Task");
            dialogStage.initModality(Modality.APPLICATION_MODAL);

            Scene scene = new Scene(dialogPane);

            String css = this.getClass().getResource("/com/tutorialseu/todoapp/viewdialogstyles.css").toExternalForm();
            scene.getStylesheets().add(css);

            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTask(TaskDTO task) {
        // Logic to update the task in the task list
        taskList.updateTask(task);
        taskName.setText(task.getTitle());
        taskStatus.setText(task.getStatus());
        applyStatusColor(task.getStatus());

        // Resorting the tasks based on status change.
        mainController.redrawTaskList();
    }

    public void deleteTask(TaskDTO task) {
        taskList.removeTask(task);  // Remove the task from the task list
        mainController.redrawTaskList();  // Redraw the task list after deletion
    }
}

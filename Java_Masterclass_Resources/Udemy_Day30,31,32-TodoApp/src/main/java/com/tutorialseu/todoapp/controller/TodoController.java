package com.tutorialseu.todoapp.controller;

import com.tutorialseu.todoapp.dto.TaskDTO;
import com.tutorialseu.todoapp.dto.TaskList;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TodoController {

    @FXML
    private VBox taskListVBox;

    @FXML
    private MFXComboBox<String> statusComboBox;

    private TaskList taskList;

    public void initialize() {
        taskList = new TaskList();
        statusComboBox.getItems().addAll("All", "ToDo", "InProgress", "Done");
        statusComboBox.setValue("All");

        // Add listener to the ComboBox for filtering tasks by status
        statusComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filterTasksByStatus(newValue);
            }
        });

        // Load tasks and display them
        redrawTaskList();
    }

    @FXML
    private void handleAddTask() {
        showAddTaskDialog();
    }

    private void showAddTaskDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tutorialseu/todoapp/task_add_dialog.fxml"));
            VBox dialogPane = loader.load();

            // Set the controller for the dialog and pass the main controller reference
            TaskAddDialogController dialogController = loader.getController();
            dialogController.setMainController(this);

            // Create and show the dialog
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Task");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(dialogPane);

            String css = this.getClass().getResource("/com/tutorialseu/todoapp/addtaskstyles.css").toExternalForm();
            scene.getStylesheets().add(css);

            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTaskFromDialog(String title, String description) {
        addTask(title, description, LocalDateTime.now(), "ToDo");
    }

    private void addTask(String title, String description, LocalDateTime dateAdded, String status) {
        TaskDTO newTask = new TaskDTO(title, description, dateAdded, status);
        taskList.addTask(newTask); // Automatically sorts after adding
        redrawTaskList();  // Redraw task cards in sorted order
    }

    /**
     * Redraws the task list in the VBox after sorting.
     */
    public void redrawTaskList() {
        // Clear the current task cards
        taskListVBox.getChildren().clear();

        // Re-render the task cards in the sorted order
        for (TaskDTO task : taskList.getTasks()) {
            displayTask(task);
        }
    }

    /**
     * Filters tasks by the selected status and displays them in the VBox.
     *
     * @param status the selected status to filter tasks by
     */
    private void filterTasksByStatus(String status) {
        // Clear the current task cards
        taskListVBox.getChildren().clear();

        List<TaskDTO> filteredTasks;

        if ("All".equals(status)) {
            // If "All" is selected, show all tasks
            filteredTasks = taskList.getTasks();
        } else {
            // Filter tasks by the selected status
            filteredTasks = taskList.getTasks().stream()
                    .filter(task -> task.getStatus().equals(status))
                    .collect(Collectors.toList());
        }

        // Display the filtered tasks
        for (TaskDTO task : filteredTasks) {
            displayTask(task);
        }
    }

    private void displayTask(TaskDTO task) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tutorialseu/todoapp/task_card.fxml"));
            HBox taskCard = loader.load();

            TaskCardController controller = loader.getController();
            controller.setTaskDetails(task.getTitle(), task.getDateAdded(), task.getStatus(), task.getId(), this);

            taskListVBox.getChildren().add(taskCard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

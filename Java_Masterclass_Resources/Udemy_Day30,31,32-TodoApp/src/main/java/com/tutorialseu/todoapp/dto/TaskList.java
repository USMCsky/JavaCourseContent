package com.tutorialseu.todoapp.dto;

import com.tutorialseu.todoapp.TaskStorage;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskList implements Serializable {

    private static final long serialVersionUID = 2L;

    private static List<TaskDTO> tasks = new ArrayList<>();

    private static final String FILE_PATH = "src/tasks.bin";  // Path to save the file

    private static final String FILE_NAME = "tasks.bin";

    public TaskList() {
        loadTasks();  // Load tasks when initializing the TaskList
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void addTask(TaskDTO task) {
        tasks.add(task);
        sortTasksByStatus();  // Sort tasks when a new one is added
        saveTasks();  // Save tasks to the file
    }

    public void removeTask(TaskDTO task) {
        TaskDTO removedTask = getTaskById(task.getId());
        tasks.remove(removedTask);
        saveTasks();
    }

    /**
     * Updates an existing task in the list with new details.
     *
     * @param updatedTask the task containing updated details
     */
    public void updateTask(TaskDTO updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            TaskDTO currentTask = tasks.get(i);

            // Search for the task by its unique ID
            if (currentTask.getId().equals(updatedTask.getId())) {
                // Update task details
                currentTask.setTitle(updatedTask.getTitle());
                currentTask.setDescription(updatedTask.getDescription());
                currentTask.setStatus(updatedTask.getStatus());

                // Update comments if needed
                currentTask.setComments(updatedTask.getComments());

                // Break as task has been found and updated
                break;
            }
        }

        sortTasksByStatus();
        saveTasks();  // Save tasks to the file
    }

    public TaskDTO getTaskById(String id){
        for (TaskDTO currentTask : tasks) {
            if (currentTask.getId().equals(id)) {
                return currentTask;
            }
        }

        return null;
    }

    /**
     * Sorts tasks by status, with "ToDo" first, then "InProgress," and "Done" last.
     */
    private void sortTasksByStatus() {
        tasks.sort(Comparator.comparingInt(task -> {
            switch (task.getStatus()) {
                case "ToDo": return 1;
                case "InProgress": return 2;
                case "Done": return 3;
                default: return 4;  // Handle unexpected statuses, if any
            }
        }));
    }

    /**
     * Saves the current task list to the tasks.bin file.
     */
    private void saveTasks() {
        File appDataFolder = TaskStorage.getAppDataFolder();  // Get the app-specific folder
        File taskFile = new File(appDataFolder, FILE_NAME);    // Define the tasks.bin file inside that folder

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(taskFile))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads tasks from the tasks.bin file if it exists.
     */
    @SuppressWarnings("unchecked")
    private void loadTasks() {
        File appDataFolder = TaskStorage.getAppDataFolder();  // Get the app-specific folder
        File taskFile = new File(appDataFolder, FILE_NAME);    // Define the tasks.bin file inside that folder

        if (taskFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(taskFile))) {
                tasks = (List<TaskDTO>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            saveTasks();  // If the file does not exist, create it
        }
    }

}


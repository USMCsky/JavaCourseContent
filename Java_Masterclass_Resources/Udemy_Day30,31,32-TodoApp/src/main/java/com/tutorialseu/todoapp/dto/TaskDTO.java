package com.tutorialseu.todoapp.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDTO implements Serializable {

    private static final long serialVersionUID = 1L;  // Serial version UID for serialization

    private String id;  // Unique identifier for the task
    private String title;
    private String description;
    private LocalDateTime dateAdded;
    private String status;
    private List<String> comments;

    public TaskDTO(String title, String description, LocalDateTime dateAdded, String status) {
        this.id = UUID.randomUUID().toString();  // Generate a unique ID
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.status = status;
        this.comments = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public void setComments(List<String> comments){
        this.comments = comments;
    }

}
module com.tutorialseu.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens com.tutorialseu.todoapp to javafx.fxml;
    opens com.tutorialseu.todoapp.controller to javafx.fxml;
    exports com.tutorialseu.todoapp;
}
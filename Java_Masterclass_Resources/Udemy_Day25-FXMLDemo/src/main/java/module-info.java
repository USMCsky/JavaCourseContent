module com.tutorialseu.fxmldemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tutorialseu.fxmldemo to javafx.fxml;
    exports com.tutorialseu.fxmldemo;
}
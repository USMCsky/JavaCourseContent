module com.tutorialseu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tutorialseu.scenebuilder to javafx.fxml;
    exports com.tutorialseu.scenebuilder;

    opens com.tutorialseu.form to javafx.fxml;
    exports com.tutorialseu.form;

    opens com.tutorialseu.keyevents to javafx.fxml;
    exports com.tutorialseu.keyevents;

    opens com.tutorialseu.mouseevents to javafx.fxml;
    exports com.tutorialseu.mouseevents;

    opens com.tutorialseu.bindingproperties to javafx.fxml;
    exports com.tutorialseu.bindingproperties;

    opens com.tutorialseu.sceneswitching to javafx.fxml;
    exports com.tutorialseu.sceneswitching;

    opens com.tutorialseu.moveshape to javafx.fxml;
    exports com.tutorialseu.moveshape;

    opens com.tutorialseu.translatetransition to javafx.fxml;
    exports com.tutorialseu.translatetransition;

    opens com.tutorialseu.fadetransition to javafx.fxml;
    exports com.tutorialseu.fadetransition;

    opens com.tutorialseu.animationtimer to javafx.fxml;
    exports com.tutorialseu.animationtimer;

    opens com.tutorialseu.transitions to javafx.fxml;
    exports com.tutorialseu.transitions;

}
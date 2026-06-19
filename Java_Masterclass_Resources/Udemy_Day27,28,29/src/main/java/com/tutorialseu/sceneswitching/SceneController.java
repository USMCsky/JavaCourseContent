package com.tutorialseu.sceneswitching;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class SceneController {

    @FXML
    private Label headingLabel;

    @FXML
    private void switchToScene2(ActionEvent event) throws IOException {
        loadScene(event, "/com/tutorialseu/sceneswitching/Scene2.fxml", "Scene 2");
    }

    @FXML
    private void switchToScene1(ActionEvent event) throws IOException {
        loadScene(event, "/com/tutorialseu/sceneswitching/Scene1.fxml", "Scene 1");
    }

    private void loadScene(ActionEvent event, String fxmlFile, String sceneTitle) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle(sceneTitle);
        stage.show();
    }

    @FXML
    private void closeApp(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

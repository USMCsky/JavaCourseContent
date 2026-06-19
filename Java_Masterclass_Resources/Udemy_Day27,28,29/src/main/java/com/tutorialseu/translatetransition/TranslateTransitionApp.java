package com.tutorialseu.translatetransition;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TranslateTransitionApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tutorialseu/translatetransition/TranslateTransitionDemo.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Translate Transition Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
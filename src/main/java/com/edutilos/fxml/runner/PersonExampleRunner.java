package com.edutilos.fxml.runner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by edutilos on 20.06.18.
 */
public class PersonExampleRunner extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = (AnchorPane)loader.load(PersonExampleRunner.class.getResourceAsStream("../fxml/PersonExample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

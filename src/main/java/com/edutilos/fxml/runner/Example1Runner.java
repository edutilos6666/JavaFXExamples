package com.edutilos.fxml.runner;

import com.edutilos.fxml.controller.Example1Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * Created by edutilos on 20.06.18.
 */
public class Example1Runner extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        String filename = "../fxml/Example1.fxml";
        AnchorPane root = (AnchorPane)loader.load(Example1Runner.class.getResourceAsStream(filename));
//        AnchorPane root = (AnchorPane)loader.load(Example1Runner.class.getResource(filename));
        Example1Controller controller = loader.getController();
        controller.setTmp("hello tmp");
        System.out.println(controller.getTmp());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

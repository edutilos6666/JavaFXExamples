package com.edutilos.fxml.runner;

import com.edutilos.fxml.controller.AreaChartExampleController;
import com.edutilos.fxml.controller.PersonExampleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by edutilos on 22.06.18.
 */
public class Tester extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(PersonExampleController.class.getResourceAsStream("../fxml/AreaChartExample.fxml"));
            AreaChartExampleController controller = loader.getController();
            controller.afterStartupFinished();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

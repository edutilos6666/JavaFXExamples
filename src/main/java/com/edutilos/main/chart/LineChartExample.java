package com.edutilos.main.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by edutilos on 10.06.18.
 */
public class LineChartExample extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    //properties
    private Scene scene;
    private VBox root;
    private Label lblTitle;
    private LineChart<Number,Number> chart;
    private Button btnChange;
    private Random random;


    @Override
    public void start(Stage primaryStage) throws Exception {
        addComponents();
        registerEvents();
        scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addComponents() {
        root = new VBox();
        root.setSpacing(10);
        lblTitle = new Label("LineChart for OS");
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        chart = new LineChart<>(xAxis, yAxis);
        chart.getData().add(getDataForChart(lblTitle.getText()));
        btnChange = new Button("Change LineChart");
        root.getChildren().clear();
        root.getChildren().addAll(lblTitle, chart, btnChange);
    }

    private double generateRandomValue() {
        random = new Random();
        return 100*random.nextDouble() + 200*random.nextDouble() + 300*random.nextDouble();
    }

    private XYChart.Series<Number,Number> getDataForChart(String title) {
        XYChart.Series<Number,Number> res = new XYChart.Series<>();
        res.setName(title);
        res.getData().addAll(new XYChart.Data<>(1, generateRandomValue()),
                new XYChart.Data<>(2, generateRandomValue()),
                new XYChart.Data<>(3, generateRandomValue()),
                new XYChart.Data<>(4, generateRandomValue()),
                new XYChart.Data<>(5, generateRandomValue()),
                new XYChart.Data<>(6, generateRandomValue()));
        return res;
    }



    private int counter = 0 ; 
    private void registerEvents() {
        btnChange.setOnAction(handler-> {
            counter = (counter+1)%3; 
            switch(counter) {
                case 0: 
                    lblTitle.setText("LineChart for Operating Systems");
                    chart.getData().clear();
                    chart.getData().add(getDataForChart(lblTitle.getText()));
                    break;
                case 1:
                    lblTitle.setText("LineChart for Browsers");
                    chart.getData().clear();
                    chart.getData().add(getDataForChart(lblTitle.getText()));
                    break;
                case 2:
                    lblTitle.setText("LineChart for Auto models");
                    chart.getData().clear();
                    chart.getData().add(getDataForChart(lblTitle.getText()));
                    break;
            }
        });
    }
}

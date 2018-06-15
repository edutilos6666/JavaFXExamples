package com.edutilos.main.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by edutilos on 10.06.18.
 */
public class LineChartExample2 extends Stage{
    public LineChartExample2() {
        setStage();
    }

    //properties
    private Scene scene;
    private VBox root;
    private Label lblTitle;
    private LineChart<Number,Number> chart;
    private Button btnChange;
    private Random random;
    private int counter = 0 ;
    private String[] labels = {"Chrome", "Firefox", "Edge", "Safari"};


   public void setStage()  {
        addComponents();
        registerEvents();
        scene = new Scene(root, 500, 500);
        this.setScene(scene);
    }

    private void addComponents() {
        root = new VBox();
        root.setSpacing(10);
        lblTitle = new Label("LineChart for Browsers");
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        chart = new LineChart<>(xAxis, yAxis);
        chart.getData().add(getDataForChart(labels[counter]));
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




    private void registerEvents() {
        btnChange.setOnAction(handler-> {
            counter = (counter+1)%4;
            switch(counter) {
                case 0:
                case 1:
                case 2:
                    chart.getData().add(getDataForChart(labels[counter]));
                    break;
                case 3:
                    chart.getData().clear();
                    chart.getData().add(getDataForChart(labels[counter]));
                    break;
            }
        });
    }
}

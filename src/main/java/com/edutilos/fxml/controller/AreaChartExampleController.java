package com.edutilos.fxml.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Random;

/**
 * Created by edutilos on 22.06.18.
 */
public class AreaChartExampleController {

    @FXML
    private Label lblTitle;
    @FXML
    private AreaChart<Number, Number> chartArea;
    @FXML
    private Button btnChange;

    private Random random;
    private int counter = 0 ;
    private String[] labels = {"Chrome", "Firefox", "Edge", "Safari"};


    public void afterStartupFinished() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        chartArea.getData().add(getDataForChart(labels[counter]));
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



    @FXML
    private void handleBtnChange() {
            counter = (counter+1)%4;
            switch(counter) {
                case 0:
                case 1:
                case 2:
                    chartArea.getData().add(getDataForChart(labels[counter]));
                    break;
                case 3:
                    chartArea.getData().clear();
                    chartArea.getData().add(getDataForChart(labels[counter]));
                    break;
            }
    }
}

package com.edutilos.fxml.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

/**
 * Created by edutilos on 10.06.18.
 */
public class LineChartExampleController {
    @FXML
    private Label lblTitle;
    @FXML
    private LineChart<Number,Number> chartLine;
    @FXML
    private Button btnChange;
    private Random random;

    private int counter = 0 ;
    private String[] labels = {"Chrome", "Firefox", "Edge", "Safari"};





    public void afterStartupFinished() {
        chartLine.getData().add(getDataForChart(lblTitle.getText()));
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
                    chartLine.getData().add(getDataForChart(labels[counter]));
                    break;
                case 3:
                    chartLine.getData().clear();
                    chartLine.getData().add(getDataForChart(labels[counter]));
                    break;
            }
    }
}

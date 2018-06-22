package com.edutilos.fxml.controller;

import javafx.fxml.FXML;
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
public class LineChartExample2Controller {
    @FXML
    private Label lblTitle;
    @FXML
    private LineChart<Number,Number> chartLine;
    @FXML
    private Button btnChange;
    private Random random;




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



    private int counter = 0 ;

    @FXML
    private void handleBtnChange() {
            counter = (counter+1)%3; 
            switch(counter) {
                case 0: 
                    lblTitle.setText("LineChart for Operating Systems");
                    chartLine.getData().clear();
                    chartLine.getData().add(getDataForChart(lblTitle.getText()));
                    break;
                case 1:
                    lblTitle.setText("LineChart for Browsers");
                    chartLine.getData().clear();
                    chartLine.getData().add(getDataForChart(lblTitle.getText()));
                    break;
                case 2:
                    lblTitle.setText("LineChart for Auto models");
                    chartLine.getData().clear();
                    chartLine.getData().add(getDataForChart(lblTitle.getText()));
                    break;
            }
    }
}

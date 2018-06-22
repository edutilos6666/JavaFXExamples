package com.edutilos.fxml.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Random;

/**
 * Created by edutilos on 22.06.18.
 */
public class BubbleChartExampleController {
    @FXML
    private Label lblTitle;
    @FXML
    private BubbleChart<Number,Number> chartBubble;
    @FXML
    private Button btnChange;
    private Random random = new Random();
    private int counter = 0 ;
    private String[] labels = {"Chrome", "Firefox", "Edge", "Safari"};


    public void afterStartupFinished() {
        NumberAxis yAxis = ((NumberAxis)chartBubble.getYAxis());
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, " €"));
        chartBubble.getData().add(getDataForChart(labels[counter]));
    }

    private double generateRandomValue() {
        return 30*random.nextDouble();
    }

    private double generateRandomBubbleRadius() {
        return random.nextDouble()*2;
    }

    private XYChart.Series<Number,Number> getDataForChart(String title) {
        XYChart.Series<Number,Number> res = new XYChart.Series<>();
        res.setName(title);
        res.getData().addAll(new XYChart.Data<>(1, generateRandomValue(),generateRandomBubbleRadius()),
                new XYChart.Data<>(2, generateRandomValue(),generateRandomBubbleRadius()),
                new XYChart.Data<>(3, generateRandomValue(),generateRandomBubbleRadius()),
                new XYChart.Data<>(4, generateRandomValue(),generateRandomBubbleRadius()),
                new XYChart.Data<>(5, generateRandomValue(),generateRandomBubbleRadius()),
                new XYChart.Data<>(6, generateRandomValue(),generateRandomBubbleRadius()));
        return res;
    }



    @FXML
    private void handleBtnChange() {
            counter = (counter+1)%4;
            switch(counter) {
                case 0:
                case 1:
                case 2:
                    chartBubble.getData().add(getDataForChart(labels[counter]));
                    break;
                case 3:
                    chartBubble.getData().clear();
                    chartBubble.getData().add(getDataForChart(labels[counter]));
                    break;
            }
    }
}

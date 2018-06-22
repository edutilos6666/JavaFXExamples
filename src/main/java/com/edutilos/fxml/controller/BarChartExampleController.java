package com.edutilos.fxml.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Random;

/**
 * Created by edutilos on 22.06.18.
 */
public class BarChartExampleController {
    @FXML
    private Label lblTitle;
    @FXML
    private BarChart chartBar;
    @FXML
    private Button btnChange;
    private Random random;
    private int counter = 0 ;
    private String[] barLabels = {"Chrome", "Firefox", "Edge", "Safari", "IE10", "IE11"};
    private String[] mainLabels = {"Year 2010","Year 2011", "Year 2012", "Year 2013" };


    public void afterStartupFinished() {
        chartBar.getData().add(getDataForChart(mainLabels[counter]));
    }

    private double generateRandomValue() {
        random = new Random();
        return 100*random.nextDouble() + 200*random.nextDouble() + 300*random.nextDouble();
    }

    private XYChart.Series<String,Number> getDataForChart(String title) {
        XYChart.Series<String,Number> res = new XYChart.Series<>();
        res.setName(title);
        res.getData().addAll(new XYChart.Data(barLabels[0], generateRandomValue()),
                new XYChart.Data(barLabels[1], generateRandomValue()),
                new XYChart.Data(barLabels[2], generateRandomValue()),
                new XYChart.Data(barLabels[3], generateRandomValue()),
                new XYChart.Data(barLabels[4], generateRandomValue()),
                new XYChart.Data(barLabels[5], generateRandomValue()));
        return res;
    }



    @FXML
    private void handleBtnChange(ActionEvent evt) {
            counter = (counter+1)%4;
            switch(counter) {
                case 0:
                case 1:
                case 2:
                    chartBar.getData().add(getDataForChart(mainLabels[counter]));
                    break;
                case 3:
                    chartBar.getData().clear();
                    chartBar.getData().add(getDataForChart(mainLabels[counter]));
                    break;
            }
    }
}

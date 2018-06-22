package com.edutilos.fxml.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by edutilos on 10.06.18.
 */
public class PieChartExampleController {
    @FXML
    private Label lblTitle;
    @FXML
    private PieChart chartPie;
    @FXML
    private Button btnChange;
    private Random random;





    public void afterStartupFinished() {
        chartPie.setData(getDataForChart1());
    }

    private double generateRandomValue() {
        random = new Random();
        return 100*random.nextDouble() + 200*random.nextDouble() + 300*random.nextDouble();
    }

    private ObservableList<PieChart.Data> getDataForChart1() {
        ObservableList<PieChart.Data> res = FXCollections.observableArrayList();
        res.addAll(new PieChart.Data("Windows 8", generateRandomValue()),
                new PieChart.Data("Windows 9", generateRandomValue()),
                new PieChart.Data("Windows 10", generateRandomValue()),
                new PieChart.Data("Ubuntu 16.04 LTS", generateRandomValue()),
                new PieChart.Data("Ubuntu 14.04 LTS", generateRandomValue()),
                new PieChart.Data("Windows XP", generateRandomValue()),
                new PieChart.Data("Mac OS", generateRandomValue()));
        return res;
    }

    private ObservableList<PieChart.Data> getDataForChart2() {
        ObservableList<PieChart.Data> res = FXCollections.observableArrayList();
        res.addAll(new PieChart.Data("Chrome", generateRandomValue()),
                new PieChart.Data("Firefox", generateRandomValue()),
                new PieChart.Data("IE", generateRandomValue()),
                new PieChart.Data("Safari", generateRandomValue()),
                new PieChart.Data("Microsoft Edge", generateRandomValue()));
        return res;
    }

    private ObservableList<PieChart.Data> getDataForCHart3() {
        ObservableList<PieChart.Data> res = FXCollections.observableArrayList();
        res.addAll(new PieChart.Data("Mercedes Benz", generateRandomValue()),
                new PieChart.Data("Audi", generateRandomValue()),
                new PieChart.Data("Volkswagen", generateRandomValue()),
                new PieChart.Data("Ford", generateRandomValue()),
                new PieChart.Data("Fiat", generateRandomValue()),
                new PieChart.Data("Azsamand", generateRandomValue()),
                new PieChart.Data("Hammer", generateRandomValue()),
                new PieChart.Data("Opel", generateRandomValue()));
        return res;
    }


    private int counter = 0 ;
    @FXML
    private void handleBtnChange() {
            counter = (counter+1)%3;
            switch(counter) {
                case 0:
                    lblTitle.setText("PieChart for Operating Systems");
                    chartPie.setData(getDataForChart1());
                    break;
                case 1:
                    lblTitle.setText("PieChart for Browsers");
                    chartPie.setData(getDataForChart2());
                    break;
                case 2:
                    lblTitle.setText("PieChart for Auto models");
                    chartPie.setData(getDataForCHart3());
                    break;
            }
    }
}

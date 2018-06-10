package com.edutilos.main.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class PieChartExample extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    //properties
    private Scene scene;
    private VBox root;
    private Label lblTitle;
    private PieChart chart;
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
        lblTitle = new Label("PieChart for OS");
        chart = new PieChart();
        chart.setData(getDataForChart1());
        btnChange = new Button("Change PieChart");
        root.getChildren().clear();
        root.getChildren().addAll(lblTitle, chart, btnChange);
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
    private void registerEvents() {
        btnChange.setOnAction(handler-> {
            counter = (counter+1)%3; 
            switch(counter) {
                case 0: 
                    lblTitle.setText("PieChart for Operating Systems");
                    chart.setData(getDataForChart1());
                    break;
                case 1:
                    lblTitle.setText("PieChart for Browsers");
                    chart.setData(getDataForChart2());
                    break;
                case 2:
                    lblTitle.setText("PieChart for Auto models");
                    chart.setData(getDataForCHart3());
                    break;
            }
        });
    }
}

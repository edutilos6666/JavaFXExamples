package com.edutilos.main.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
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
public class BarChartExample extends Stage{
    public BarChartExample() {
        setStage();
    }

    //properties
    private Scene scene;
    private VBox root;
    private Label lblTitle;
    private BarChart chart;
    private Button btnChange;
    private Random random;
    private int counter = 0 ;
    private String[] barLabels = {"Chrome", "Firefox", "Edge", "Safari", "IE10", "IE11"};
    private String[] mainLabels = {"Year 2010","Year 2011", "Year 2011", "Year 2012" };

   public void setStage()  {
        addComponents();
        registerEvents();
        scene = new Scene(root, 500, 500);
        this.setScene(scene);
    }

    private void addComponents() {
        root = new VBox();
        root.setSpacing(10);
        lblTitle = new Label("BarChart for Browsers");
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        chart = new BarChart(xAxis, yAxis);
        chart.getData().add(getDataForChart(mainLabels[counter]));
        btnChange = new Button("Change BarChart");
        root.getChildren().clear();
        root.getChildren().addAll(lblTitle, chart, btnChange);
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



    private void registerEvents() {
        btnChange.setOnAction(handler-> {
            counter = (counter+1)%4;
            switch(counter) {
                case 0:
                case 1:
                case 2:
                    chart.getData().add(getDataForChart(mainLabels[counter]));
                    break;
                case 3:
                    chart.getData().clear();
                    chart.getData().add(getDataForChart(mainLabels[counter]));
                    break;
            }
        });
    }
}

package com.edutilos.main.chart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.BubbleChart;
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
public class BubbleChartExample extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    //properties
    private Scene scene;
    private VBox root;
    private Label lblTitle;
    private BubbleChart<Number,Number> chart;
    private Button btnChange;
    private Random random = new Random();
    private int counter = 0 ;
    private String[] labels = {"Chrome", "Firefox", "Edge", "Safari"};


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
        lblTitle = new Label("BubbleChart for Browsers");
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        chart = new BubbleChart<>(xAxis, yAxis);
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, " €"));
        chart.getData().add(getDataForChart(labels[counter]));
        btnChange = new Button("Change BubbleChart");
        root.getChildren().clear();
        root.getChildren().addAll(lblTitle, chart, btnChange);
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

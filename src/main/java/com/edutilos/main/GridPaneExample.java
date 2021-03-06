package com.edutilos.main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by edutilos on 10.06.18.
 */
public class GridPaneExample extends Stage {
    public GridPaneExample() {
        setStage();
    }

    //properties
    private Scene scene;
    private GridPane root;
    private Label lblTitle, lblId, lblName , lblAge, lblWage, lblActive;
    private TextField fieldId, fieldName, fieldAge, fieldWage, fieldActive;
    private Button btnOk , btnClear;

    public void setStage() {
        addComponents();
        registerEvents();
        scene = new Scene(root, 500, 500);
        this.setScene(scene);
    }

    private void addComponents() {
        root = new GridPane();
        lblTitle = new Label("Example1 Simple Form");
        lblId = new Label("Id:");
        lblName = new Label("Name:");
        lblAge = new Label("Age:");
        lblWage = new Label("Wage:");
        lblActive = new Label("Active:");
        fieldId = new TextField();
        fieldId.setTooltip(new Tooltip("insert id value"));
        fieldId.setPromptText("insert id value");
        fieldName = new TextField();
        fieldAge = new TextField();
        fieldWage = new TextField();
        fieldActive = new TextField();
        fieldName.setPromptText("insert name value");
        fieldAge.setPromptText("insert age value");
        fieldWage.setPromptText("insert wage value");
        fieldActive.setPromptText("insert active value");

        btnOk = new Button("OK");
        btnClear = new Button("Clear");
        root.addRow(0, lblTitle);
        root.addRow(1,lblId, fieldId);
        root.addRow(2, lblName, fieldName);
        root.addRow(3, lblAge, fieldAge);
        root.addRow(4, lblWage, fieldWage);
        root.addRow(5, lblActive, fieldActive);
        root.addRow(6, btnOk, btnClear);
    }

    private void registerEvents() {
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    long id = Long.parseLong(fieldId.getText());
                    String name = fieldName.getText();
                    int age = Integer.parseInt(fieldAge.getText());
                    double wage = Double.parseDouble(fieldWage.getText());
                    boolean active = Boolean.parseBoolean(fieldActive.getText());
                    StringBuilder sb = new StringBuilder();
                    String nl = "\r\n";
                    sb.append("id = ").append(id).append(nl)
                            .append("name = ").append(name).append(nl)
                            .append("age = ").append(age).append(nl)
                            .append("wage = ").append(wage).append(nl)
                            .append("active = ").append(active);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Message for you");
                    alert.setContentText(sb.toString());
                    alert.showAndWait();
                } catch(Exception ex) {
                    ex.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Error Message of type java.lang.Exception");
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                }
            }
         });

        btnClear.setOnAction(event-> {
            try {
                fieldId.clear();
                fieldName.clear();
                fieldAge.clear();
                fieldWage.clear();
                fieldActive.clear();
            } catch(Exception ex) {
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Error Message of type java.lang.Exception");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });
    }
}

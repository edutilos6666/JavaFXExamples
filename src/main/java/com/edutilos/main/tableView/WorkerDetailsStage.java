package com.edutilos.main.tableView;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by edutilos on 10.06.18.
 */
public class WorkerDetailsStage extends Stage {
    //Properties
    private Worker selected;
    private Scene scene;
    private GridPane root;
    private Label lblTitle, lblId, lblName , lblAge, lblWage, lblActive;
    private TextField fieldId, fieldName, fieldAge, fieldWage, fieldActive;
    private Button btnOk;

    public WorkerDetailsStage(Worker selected) {
        this.selected = selected;
        setStage();
        populateData();
    }

    private void populateData() {
        fieldId.setText(selected.getId().toString());
        fieldName.setText(selected.getName());
        fieldAge.setText(selected.getAge().toString());
        fieldWage.setText(selected.getWage().toString());
        fieldActive.setText(selected.isActive().toString());
    }



    private void setStage() {
        addComponents();
        registerEvents();
        scene = new Scene(root, 500, 500);
        this.setScene(scene);
      //  this.showAndWait();
    }

    private void addComponents() {
        root = new GridPane();
        lblTitle = new Label("Worker Details");
        lblId = new Label("Id:");
        fieldId = new TextField();
        lblName= new Label("Name:");
        fieldName = new TextField();
        lblAge = new Label("Age:");
        fieldAge = new TextField();
        lblWage = new Label("Wage:");
        fieldWage = new TextField();
        lblActive = new Label("Active:");
        fieldActive = new TextField();
        btnOk = new Button("Ok");
        root.addRow(0,lblTitle);
        root.addRow(1, lblId, fieldId);
        root.addRow(2, lblName, fieldName);
        root.addRow(3, lblAge, fieldAge);
        root.addRow(4, lblWage, fieldWage);
        root.addRow(5, lblActive, fieldActive);
        root.addRow(6, btnOk);
        fieldId.setEditable(false);
        fieldName.setEditable(false);
        fieldAge.setEditable(false);
        fieldWage.setEditable(false);
        fieldActive.setEditable(false);
    }

    private void registerEvents() {
        btnOk.setOnAction(handler->{
            this.close();
        });

    }
}

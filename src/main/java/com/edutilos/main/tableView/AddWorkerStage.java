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
public class AddWorkerStage extends Stage {
    //Properties
    private ObservableList<Worker> data;
    private Scene scene;
    private GridPane root;
    private Label lblTitle, lblId, lblName , lblAge, lblWage, lblActive;
    private TextField fieldId, fieldName, fieldAge, fieldWage, fieldActive;
    private Button btnOk, btnCancel;

    public AddWorkerStage(ObservableList<Worker> data) {
        this.data = data;
        setStage();
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
        lblTitle = new Label("Add New Worker");
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
        btnCancel = new Button("Cancel");
        root.addRow(0,lblTitle);
        root.addRow(1, lblId, fieldId);
        root.addRow(2, lblName, fieldName);
        root.addRow(3, lblAge, fieldAge);
        root.addRow(4, lblWage, fieldWage);
        root.addRow(5, lblActive, fieldActive);
        root.addRow(6, btnOk, btnCancel);
    }

    private void registerEvents() {
        btnOk.setOnAction(handler->{
            try {
                Long id = Long.parseLong(fieldId.getText());
                String name = fieldName.getText();
                Integer age = Integer.parseInt(fieldAge.getText());
                Double wage = Double.parseDouble(fieldWage.getText());
                Boolean active = Boolean.parseBoolean(fieldActive.getText());
                data.add(new Worker(id, name, age, wage, active));
                this.close();
            } catch(Exception ex) {
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Alert");
                alert.setHeaderText("Message from Exception");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }  finally {
                 //this.close();
            }
        });

        btnCancel.setOnAction(handler->{
            this.close();
        });
    }
}

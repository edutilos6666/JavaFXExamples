package com.edutilos.fxml.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by edutilos on 20.06.18.
 */
public class Example1Controller {
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblId;
    @FXML
    private Label lblName;
    @FXML
    private Label lblAge;
    @FXML
    private Label lblWage;
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldAge;
    @FXML
    private TextField fieldWage;
    @FXML
    private Button btnOK;
    @FXML
    private Button btnClear;

    @FXML
    public void handleBtnOK(ActionEvent evt) {
        try {
            long id = Long.parseLong(fieldId.getText());
            String name = fieldName.getText();
            int age = Integer.parseInt(fieldAge.getText());
            double wage = Double.parseDouble(fieldWage.getText());
            StringBuilder sb = new StringBuilder();
            String nl = "\r\n";
            sb.append("Id = ").append(id).append(nl)
                    .append("Name = ").append(name).append(nl)
                    .append("Age = ").append(age).append(nl)
                    .append("Wage = ").append(wage).append(nl);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("<<Input>>");
            alert.setContentText(sb.toString());
            alert.showAndWait();
        } catch(Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("<<Exception>>");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void  handleBtnClear(ActionEvent evt) {
        fieldId.clear();
        fieldName.clear();
        fieldAge.clear();
        fieldWage.clear();
    }

    private String tmp;
    public void setTmp(String tmp) {
        this.tmp = tmp;
    }
    public String getTmp() {
        return this.tmp;
    }
}

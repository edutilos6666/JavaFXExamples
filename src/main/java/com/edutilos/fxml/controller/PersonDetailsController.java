package com.edutilos.fxml.controller;

import com.edutilos.fxml.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by edutilos on 20.06.18.
 */
public class PersonDetailsController {
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
    private Label lblActive;
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldAge;
    @FXML
    private TextField fieldWage;
    @FXML
    private TextField fieldActive;
    @FXML
    private Button btnClose;

    private TableView<Person> tvPerson;
    private Person selectedPerson; 

    public boolean onStartupFinished() {
        selectedPerson = tvPerson.getSelectionModel().getSelectedItem();
        if(selectedPerson == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Please choose one table entry");
            alert.showAndWait();
            return false;
        } else {
            fieldId.setText(selectedPerson.getId().toString());
            fieldName.setText(selectedPerson.getName());
            fieldAge.setText(selectedPerson.getAge().toString());
            fieldWage.setText(selectedPerson.getWage().toString());
            fieldActive.setText(selectedPerson.getActive().toString());
            return true;
        }

    }



    @FXML
    private void handleBtnClose(ActionEvent evt) {
        Stage stage = (Stage)btnClose.getScene().getWindow();
        stage.close();
    }

    public void setTvPerson(TableView<Person> tvPerson) {
        this.tvPerson = tvPerson;
    }
}

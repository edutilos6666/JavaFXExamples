package com.edutilos.fxml.controller;

import com.edutilos.fxml.model.Person;
import com.edutilos.fxml.util.PersonUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by edutilos on 20.06.18.
 */
public class PersonUpdateController {
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
    private Button btnOK;
    @FXML
    private Button btnCancel;

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
    private void handleBtnOK(ActionEvent evt) {
        try {
            Long id = Long.parseLong(fieldId.getText());
            String name = fieldName.getText();
            int age = Integer.parseInt(fieldAge.getText());
            double wage = Double.parseDouble(fieldWage.getText());
            boolean active = fieldActive.getText().equalsIgnoreCase("true");
           // tvPerson.getItems().add(new Person(id, name, age, wage, active));
            //that does not work:
                      /*selectedPerson.setId(id);
            selectedPerson.setName(name);
            selectedPerson.setAge(age);
            selectedPerson.setWage(wage);
            selectedPerson.setActive(active);*/

            tvPerson.getItems().set(tvPerson.getSelectionModel().getSelectedIndex(),
                    new Person(id, name, age, wage, active));

            Stage stage = (Stage)btnOK.getScene().getWindow();
            stage.close();
        } catch(Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Exception");
            alert.setHeaderText(ex.getMessage());
            alert.setContentText(ex.getStackTrace()[0].toString());
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBtnCancel(ActionEvent evt) {
        Stage stage = (Stage)btnOK.getScene().getWindow();
        stage.close();
    }

    public void setTvPerson(TableView<Person> tvPerson) {
        this.tvPerson = tvPerson;
    }
}

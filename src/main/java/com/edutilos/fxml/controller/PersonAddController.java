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
public class PersonAddController {
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

    @FXML
    private void handleBtnOK(ActionEvent evt) {
        try {
            Long id = Long.parseLong(fieldId.getText());
            if(PersonUtils.checkIfIdDuplicate(tvPerson.getItems(), id)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Warning");
                alert.setContentText(String.format("Id = %d already exists.",id));
                alert.showAndWait();
                return ;
            }

            String name = fieldName.getText();
            int age = Integer.parseInt(fieldAge.getText());
            double wage = Double.parseDouble(fieldWage.getText());
            boolean active = fieldActive.getText().equalsIgnoreCase("true");
            tvPerson.getItems().add(new Person(id, name, age, wage, active));
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

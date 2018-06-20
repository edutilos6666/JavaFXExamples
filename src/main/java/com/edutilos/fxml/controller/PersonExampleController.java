package com.edutilos.fxml.controller;

import com.edutilos.fxml.model.Person;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by edutilos on 20.06.18.
 */
public class PersonExampleController {
    @FXML
    private Label lblTitle;
    @FXML
    private TableView<Person> tvPerson;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDetails;
    @FXML
    private Button btnRemove;

    @FXML
    private MenuItem itemAddPerson;
    @FXML
    private MenuItem itemUpdatePerson;
    @FXML
    private MenuItem itemPersonDetails;
    @FXML
    private MenuItem itemRemovePerson;
    @FXML
    private MenuItem itemExit;

//    private FXMLLoader loader;

    public PersonExampleController() {
    }

    @FXML
    private void handleBtnAdd(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(PersonExampleController.class.getResourceAsStream("../fxml/PersonAdd.fxml"));
            PersonAddController controller = loader.getController();
            controller.setTvPerson(tvPerson);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBtnUpdate(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(PersonExampleController.class.getResourceAsStream("../fxml/PersonUpdate.fxml"));
            PersonUpdateController controller = loader.getController();
            controller.setTvPerson(tvPerson);
            boolean noError = controller.onStartupFinished();
            if(!noError) return;
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleBtnDetails(ActionEvent evt) {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(PersonExampleController.class.getResourceAsStream("../fxml/PersonDetails.fxml"));
            PersonDetailsController controller = loader.getController();
            controller.setTvPerson(tvPerson);
            boolean noError = controller.onStartupFinished();
            if(!noError) return;
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleBtnRemove(ActionEvent evt) {
        Person p = tvPerson.getSelectionModel().getSelectedItem();
        if(p == null) return ;
        tvPerson.getItems().remove(p);
    }


    @FXML
    private void handleItemExit(ActionEvent evt) {
        System.out.println(evt.getTarget().getClass().getName());
        Platform.exit();
    }



}

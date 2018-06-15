package com.edutilos.main;

import com.edutilos.main.tableView.WorkerExample;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by edutilos on 15.06.18.
 */
public class LoginPage extends Application {
    //properties
    private Stage stage;
    private Scene scene;
    private GridPane root;
    private Label lblTitle, lblUsername, lblPassword;
    private TextField fieldUsername, fieldPassword;
    private ComboBox<String> comboValidator;
    private Button btnLogin , btnCancel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        addComponents();
        registerEvents();
        scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        stage = primaryStage;
        primaryStage.show();
    }

    public void addComponents() {
        root = new GridPane();
        lblTitle = new Label("Welcome to the Login Page");
        lblUsername = new Label("Username:");
        fieldUsername = new TextField();
        fieldUsername.setPromptText("Enter valid username");
        lblPassword = new Label("Password:");
        fieldPassword = new TextField();
        fieldPassword.setPromptText("Enter valid password");
        comboValidator = new ComboBox<>(FXCollections.observableArrayList("InMemory", "File", "Mysql"));
        comboValidator.getSelectionModel().select(0);
        btnLogin = new Button("Login");
        btnCancel = new Button("Cancel");
        Group g = new Group();
        root.addRow(0, new Group(), lblTitle, new Group());
        root.addRow(1,lblUsername, new Group(), fieldUsername);
        root.addRow(2, lblPassword, new Group(), fieldPassword);
        root.addRow(3, comboValidator, btnLogin, btnCancel);
    }

    public void registerEvents() {
        //Stage $this = this;
        btnLogin.setOnAction(handler-> {
            try {
                String username = fieldUsername.getText();
                String password = fieldPassword.getText();
                String validatorOption = comboValidator.getSelectionModel().getSelectedItem();
                Validator validator;
                switch (validatorOption) {
                    case "InMemory":
                        validator = new Validator(false);
                        if(validator.validateInMemory(username, password)) {
                            WorkerExample mainPage = new WorkerExample(stage);
                            mainPage.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setHeaderText("WARNING Message");
                            alert.setContentText("Login failed!");
                        }
                        break;
                    case "File":
                        validator = new Validator(false);
                        if(validator.validateInMemory(username, password)) {
                            WorkerExample mainPage = new WorkerExample(stage);
                            mainPage.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setHeaderText("WARNING Message");
                            alert.setContentText("Login failed!");
                        }
                        break;

                    case "Mysql":
                        validator = new Validator(true);
                        if(validator.validateMySQL(username, password)) {
                            WorkerExample mainPage = new WorkerExample(stage);
                            mainPage.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setHeaderText("WARNING Message");
                            alert.setContentText("Login failed!");
                        }
                        break;
                }
            } catch(Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error occured during login process");
                alert.setContentText(ex.getMessage());
            }
        });


        btnCancel.setOnAction(handler->{
            fieldUsername.clear();
            fieldPassword.clear();
            comboValidator.getSelectionModel().select(0);
        });
    }
}

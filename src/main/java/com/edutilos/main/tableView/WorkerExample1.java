package com.edutilos.main.tableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by edutilos on 10.06.18.
 */
public class WorkerExample1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //properties
    private Scene scene;
    private VBox root;
    private TableView<Worker> tvWorker;
    private ObservableList<Worker> data;
    private TableColumn<Worker,Long> colId;
    private TableColumn<Worker, String> colName;
    private TableColumn<Worker, Integer> colAge;
    private TableColumn<Worker, Double> colWage;
    private TableColumn<Worker, Boolean> colActive;
    private Button btnAdd, btnEdit, btnRemove, btnDetails;

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
        tvWorker = new TableView<>();
        data = FXCollections.observableArrayList();
        data.addAll(Worker.generatyDummyWorker(),
                Worker.generatyDummyWorker());

        colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<Worker,Long>("id"));
        colName = new TableColumn<>("Name");
        colName.setCellValueFactory(new PropertyValueFactory<Worker,String>("name"));
        colAge = new TableColumn<>("Age");
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colWage = new TableColumn<>("Wage");
        colWage.setCellValueFactory(new PropertyValueFactory<>("wage"));
        colActive = new TableColumn<>("Active");
        colActive.setCellValueFactory(new PropertyValueFactory<>("active"));
        tvWorker.getColumns().addAll(colId, colName, colAge, colWage, colActive);
        tvWorker.setItems(data);

        btnAdd = new Button("Add new worker");
        btnEdit = new Button("Edit selected worker");
        btnRemove = new Button("Remove selected worker");
        btnDetails = new Button("Details of selected worker");
        VBox vbButtons = new VBox();
        vbButtons.getChildren().addAll(btnAdd,btnEdit,btnRemove, btnDetails);
        root.getChildren().addAll(tvWorker, vbButtons);
    }

    private void registerEvents() {
        btnAdd.setOnAction(handler->{
            AddWorkerStage stage = new AddWorkerStage(data);
            stage.showAndWait();
        });

        btnEdit.setOnAction(handler->{
            int selectedIndex = tvWorker.getSelectionModel().getSelectedIndex();
            if(selectedIndex >= 0) {
                EditWorkerStage stage = new EditWorkerStage(data, selectedIndex);
                stage.showAndWait();
            }
        });


        btnRemove.setOnAction(handler->{
            Worker selected = tvWorker.getSelectionModel().getSelectedItem();
            if(selected != null)
                data.remove(selected);
        });

        btnDetails.setOnAction(handler->{
            Worker selected = tvWorker.getSelectionModel().getSelectedItem();
            if(selected != null) {
                WorkerDetailsStage stage = new WorkerDetailsStage(selected);
                stage.showAndWait();
            }
        });
    }
}

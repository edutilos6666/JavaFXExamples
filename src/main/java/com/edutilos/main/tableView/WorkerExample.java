package com.edutilos.main.tableView;

import com.edutilos.main.*;
import com.edutilos.main.chart.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by edutilos on 10.06.18.
 */
public class WorkerExample extends Stage {

    //properties
    private Stage owner;
    private Scene scene;
    private BorderPane root0;
    private VBox root;
    private TableView<Worker> tvWorker;
    private ObservableList<Worker> data;
    private TableColumn<Worker,Long> colId;
    private TableColumn<Worker, String> colName;
    private TableColumn<Worker, Integer> colAge;
    private TableColumn<Worker, Double> colWage;
    private TableColumn<Worker, Boolean> colActive;
    private Button btnAdd, btnEdit, btnRemove, btnDetails;

    public  WorkerExample(Stage owner) {
        this.owner = owner;
        root0 = new BorderPane();
        addMenubar();
        addComponents();
        registerEvents();
        scene = new Scene(root0, 500, 500);
        this.initModality(Modality.WINDOW_MODAL);
        this.setOnShowing(handler->{
            owner.hide();
        });
        this.setOnCloseRequest(handler->{
            owner.show();
        });
        this.setOnHiding(handler->{
            owner.show();
        });
        this.setScene(scene);
    }

    private void addMenubar() {
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(this.widthProperty());
        //menu TableView
        Menu menuTV = new Menu("TableView");
        MenuItem itemAddWorker = new MenuItem("Add New Worker");
        MenuItem itemEditWorker = new MenuItem("Edit Selected Worker");
        MenuItem itemWorkerDetails = new MenuItem("Details of Selected Worker");
        MenuItem itemRemoveWorker = new MenuItem("Remove Selected Worker");
        MenuItem itemSignOut = new MenuItem("Sign Out");
        menuTV.getItems().addAll(itemAddWorker, itemEditWorker, itemRemoveWorker, itemWorkerDetails, itemSignOut);
        itemAddWorker.setOnAction(handler-> {
            btnAdd.fire();
        });
        itemEditWorker.setOnAction(handler->{
            btnEdit.fire();
        });
        itemWorkerDetails.setOnAction(handler->{
            btnDetails.fire();
        });
        itemRemoveWorker.setOnAction(handler->{
            btnRemove.fire();
        });
        Stage $this = this;
        itemSignOut.setOnAction(handler->{
            $this.hide();
        });


        //menu Miscellaneous
        Menu menuMisc = new Menu("Miscellaneous");
        MenuItem itemGridPaneExample = new MenuItem("GridPane Example");
        MenuItem itemVBoxHBoxExample = new MenuItem("VBox HBox Example");
        MenuItem itemAccordionExmaple = new MenuItem("Accordion Example");
        MenuItem itemTictactoeExample = new MenuItem("Tictactoe Example");
        MenuItem itemCalculatorExample = new MenuItem("Calculator Example");
        menuMisc.getItems().addAll(itemGridPaneExample, itemVBoxHBoxExample,
                itemAccordionExmaple, itemTictactoeExample, itemCalculatorExample);

        itemGridPaneExample.setOnAction(handler->{
            GridPaneExample gridPaneExample = new GridPaneExample();
            gridPaneExample.showAndWait();
        });

        itemVBoxHBoxExample.setOnAction(handler->{
            VBoxHBoxExample ex = new VBoxHBoxExample();
            ex.showAndWait();
        });

        itemAccordionExmaple.setOnAction(handler->{
            AccordionExample accordionExample = new AccordionExample();
            accordionExample.showAndWait();
        });

        itemTictactoeExample.setOnAction(handler->{
            TictactoeExample ex = new TictactoeExample();
            ex.showAndWait();
        });
        itemCalculatorExample.setOnAction(handler->{
            CalculatorExample ex = new CalculatorExample();
            ex.showAndWait();
        });

        //menu Chart
        Menu menuChart = new Menu("Chart");
        MenuItem itemAreaChartExample = new MenuItem("AreaChart Example");
        MenuItem itemBarChartExample = new MenuItem("BarChart Example");
        MenuItem itemBubbleChartExample = new MenuItem("BubbleChart Example");
        MenuItem itemLineChartExample = new MenuItem("LineChart Example");
        MenuItem itemLineChartExample2 = new MenuItem("LineChart Example2");
        MenuItem itemPieChartExample = new MenuItem("PieChart Example");
        MenuItem itemScatterChartExample = new MenuItem("ScatterChart Example");
        menuChart.getItems().addAll(itemAreaChartExample, itemBarChartExample,
                itemBubbleChartExample, itemLineChartExample,
                itemLineChartExample2, itemPieChartExample, itemScatterChartExample);

        itemAreaChartExample.setOnAction(handler->{
            AreaChartExample ex = new AreaChartExample();
            ex.showAndWait();
        });

        itemBarChartExample.setOnAction(handler->{
            BarChartExample ex = new BarChartExample();
            ex.showAndWait();
        });

        itemBubbleChartExample.setOnAction(handler->{
            BubbleChartExample ex = new BubbleChartExample();
            ex.showAndWait();
        });

        itemLineChartExample.setOnAction(handler->{
            LineChartExample ex = new LineChartExample();
            ex.showAndWait();
        });

        itemLineChartExample2.setOnAction(handler->{
            LineChartExample2 ex = new LineChartExample2();
            ex.showAndWait();
        });

        itemPieChartExample.setOnAction(handler->{
            PieChartExample ex = new PieChartExample();
            ex.showAndWait();
        });

        itemScatterChartExample.setOnAction(handler->{
            ScatterChartExample ex = new ScatterChartExample();
            ex.showAndWait();
        });


        menuBar.getMenus().addAll(menuTV, menuMisc, menuChart);
        root0.setTop(menuBar);
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
        root0.setCenter(root);
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

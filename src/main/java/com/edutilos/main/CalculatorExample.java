package com.edutilos.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by edutilos on 14.06.18.
 */
public class CalculatorExample extends Application {
    //properties
    private VBox root;
    private TextArea areaDisplay;
    private GridPane paneControls;
    private Button[] btnControls;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        addComponents();
        registerEvents();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(CalculatorExample.class.getResource("calculator_example.css").toExternalForm());
        primaryStage.show();
    }

    private void addComponents() {
        root = new VBox();
        root.setSpacing(50);
        areaDisplay = new TextArea();
        paneControls = new GridPane();
        paneControls.setVgap(5);
        paneControls.setHgap(5);
        btnControls = new Button[20];
        for(int i=0; i< btnControls.length; ++i) {
            switch(i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    btnControls[i] = new Button(String.valueOf(i));
                    break;
                case 10:
                    btnControls[i] = new Button("+");
                    break;
                case 11:
                    btnControls[i] = new Button("-");
                    break;
                case 12:
                    btnControls[i] = new Button("*");
                    break;
                case 13:
                    btnControls[i] = new Button("/");
                    break;
                case 14:
                    btnControls[i] = new Button("^");
                    break;
                case 15:
                    btnControls[i] = new Button("%");
                    break;
                case 16:
                    btnControls[i] = new Button("(");
                    break;
                case 17:
                    btnControls[i] = new Button(")");
                    break;
                case 18:
                    btnControls[i] = new Button("=");
                    break;
                case 19:
                    btnControls[i] = new Button("C");
                    break;
            }

            btnControls[i].setId("ttt_cell");
        }

        for(int i=0; i< btnControls.length; i+=5) {
            paneControls.addRow(i/5, btnControls[i], btnControls[i+1],
                    btnControls[i+2], btnControls[i+3], btnControls[i+4]);

        }
        root.getChildren().addAll(areaDisplay, paneControls);
    }

    private void registerEvents() {
        for(Button btn: btnControls) {
            btn.setOnAction(handler-> {
                String content = btn.getText();
                switch(content) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "^":
                    case "%":
                        areaDisplay.setText(areaDisplay.getText()+ " "+ content + " ");
                        break;
                    case "=":
                        ScriptEngine se = new ScriptEngineManager().getEngineByName("js");
                        try {
                            Object res = se.eval(areaDisplay.getText());
                            areaDisplay.setText(areaDisplay.getText()+ " = "+ res.toString());
                        } catch (ScriptException e) {
                            areaDisplay.setText(areaDisplay.getText()+ " = "+ e.getMessage());
                        }
                        break;
                    case "C":
                        areaDisplay.clear();
                        break;
                    default:
                        areaDisplay.setText(areaDisplay.getText()+ content);
                }
            });
        }
    }
}

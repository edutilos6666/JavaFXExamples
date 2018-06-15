package com.edutilos.main;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by edutilos on 10.06.18.
 */
public class AccordionExample extends Stage {

    //properties
    private Scene scene;
    private Group root;
    private TitledPane tp1, tp2, tp3;
    private Accordion accordion;

    public AccordionExample() {
        setStage();
    }

    public void setStage() {
        addComponents();
        registerEvents();
        scene = new Scene(root, 500, 500);
        this.setScene(scene);
    }

    private void addComponents() {
        root = new Group();
        tp1 =  new TitledPane();
        tp2 = new TitledPane();
        tp3 = new TitledPane();
        fillTP1();
        fillTP2();
        fillTP3();
        accordion = new Accordion();
        accordion.getPanes().addAll(tp1, tp2, tp3);
        root.getChildren().add(accordion);
    }

    private void fillTP1() {
        Button btn1, btn2, btn3, btn4;
        btn1 = new Button("Button 1");
        btn2 = new Button("Button 2");
        btn3 = new Button("Button 3");
        btn4 = new Button("Button 4");
        tp1.setText("VBox");
        VBox r = new VBox();
        r.getChildren().addAll(btn1, btn2, btn3, btn4);
        tp1.setContent(r);
    }

    private void fillTP2() {
        Button btn1, btn2, btn3, btn4;
        btn1 = new Button("Button 1");
        btn2 = new Button("Button 2");
        btn3 = new Button("Button 3");
        btn4 = new Button("Button 4");
        tp2.setText("HBox");
        HBox r = new HBox();
        r.getChildren().addAll(btn1, btn2, btn3, btn4);
        tp2.setContent(r);
    }

    private void fillTP3() {
        Button btn1, btn2, btn3, btn4;
        btn1 = new Button("Button 1");
        btn2 = new Button("Button 2");
        btn3 = new Button("Button 3");
        btn4 = new Button("Button 4");
        tp3.setText("FlowPane");
        FlowPane r = new FlowPane();
        r.getChildren().addAll(btn1, btn2, btn3, btn4);
        tp3.setContent(r);
    }

    private void registerEvents() {
        accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue, TitledPane newValue) {
                if(newValue != null) {
                    System.out.println(newValue.getText());
                }
            }
        });
    }
}

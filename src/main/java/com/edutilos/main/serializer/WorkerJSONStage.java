package com.edutilos.main.serializer;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by edutilos on 15.06.18.
 */
public class WorkerJSONStage extends Stage {
    //properties
    private Scene scene;
    private VBox root;
    private Label lblTitle;
    private TextArea areaContent;
    private String content;

    public WorkerJSONStage(String content) {
        this.content = content;
        setStage();
    }

    private void setStage() {
        addComponents();
        registerEvents();
        scene = new Scene(root, 500, 500);
        this.setScene(scene);
    }

    private void addComponents() {
        root = new VBox();
        root.setSpacing(50);
        lblTitle = new Label("JSON Content");
        areaContent = new TextArea(content);
        root.getChildren().addAll(lblTitle, areaContent);
    }

    private void registerEvents() {

    }
}

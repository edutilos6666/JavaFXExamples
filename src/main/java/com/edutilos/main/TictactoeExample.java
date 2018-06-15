package com.edutilos.main;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Created by edutilos on 14.06.18.
 */
public class TictactoeExample extends Stage {
    //properties
    private VBox root;
    private Label lblPicker;
    private ComboBox<String> comboPicker;
    private GridPane paneCells;
    private Button btnRestart;

    public TictactoeExample() {
        setStage();
    }


    public void setStage() {
        addComponents();
        registerEvents();
        Scene scene = new Scene(root, 500, 500);
        this.setScene(scene);
        scene.getStylesheets().add(TictactoeExample.class.getResource("tictactoe_example.css").toExternalForm());

    }

    private void addComponents() {
        root = new VBox();
        root.setSpacing(50);
        lblPicker = new Label("Choose Tictactoe Type: ");
        comboPicker = new ComboBox<>();
        comboPicker.getItems().addAll("3x3", "5x5", "7x7");
        comboPicker.getSelectionModel().select(0);
        HBox boxPicker = new HBox();
        boxPicker.getChildren().addAll(lblPicker, comboPicker);
        root.getChildren().add(boxPicker);
        paneCells = new GridPane();
        root.getChildren().add(paneCells);
        generate3To3Grid();

        btnRestart = new Button("Restart the game");
        btnRestart.setDisable(true);
        root.getChildren().add(btnRestart);
    }

    private void registerEvents() {
        comboPicker.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue != null) {
                    switch(newValue) {
                        case "3x3":
                            generate3To3Grid();
                            break;
                        case "5x5":
                            generate5To5Grid();
                            break;
                        case "7x7":
                            generate7To7Grid();
                            break;
                    }
                }
            }
        });

        btnRestart.setOnAction(handler->{
            ObservableList<Node> nodes = paneCells.getChildren();
            for(Node node: nodes) {
                Button btn = (Button)node;
                btn.setDisable(false);
                btn.setText("");
            }
            firstPlayer = true;
            btnRestart.setDisable(true);
        });
    }

    private boolean firstPlayer = true;
    private boolean isDisabled = false;
    private void generate3To3Grid() {
        firstPlayer = true;
        paneCells.getChildren().clear();
        //paneCells.setPrefWidth(500);
        final Button btns[]  = new Button[3*3];
        for(int i=0; i< btns.length; ++i) {
            btns[i] = new Button("");
            btns[i].setId("ttt_cell");
        }

        for(int i=0; i< btns.length; i+=3) {
            paneCells.addRow(i/3, btns[i], btns[i+1], btns[i+2]);
        }


        for(Button btn:btns) {
            btn.setOnAction(handler-> {
                if(firstPlayer && btn.getText().isEmpty()) {
                    btn.setText("X");
                    firstPlayer = false;
                    if(TictactoeLogic.checkIfGameOver3x3(btns, "X")) {
                        declareWinner(true);
                        for(Button _btn: btns) _btn.setDisable(true);
                        btnRestart.setDisable(false);
                    }
                } else if(!firstPlayer && btn.getText().isEmpty()) {
                    btn.setText("O");
                    firstPlayer = true;
                    if(TictactoeLogic.checkIfGameOver3x3(btns, "O")) {
                        declareWinner(false);
                        for(Button _btn: btns) _btn.setDisable(true);
                        btnRestart.setDisable(false);
                    }
                }
            });
        }
    }


    private void generate5To5Grid() {
        firstPlayer = true;
        paneCells.getChildren().clear();
        //paneCells.setPrefWidth(500);
        final Button btns[]  = new Button[5*5];
        for(int i=0; i< btns.length; ++i) {
            btns[i] = new Button("");
            btns[i].setId("ttt_cell");
        }

        for(int i=0; i< btns.length; i+=5) {
            paneCells.addRow(i/5, btns[i], btns[i+1], btns[i+2], btns[i+3], btns[i+4]);
        }


        for(Button btn:btns) {
            btn.setOnAction(handler-> {
                if(firstPlayer && btn.getText().isEmpty()) {
                    btn.setText("X");
                    firstPlayer = false;
                    if(TictactoeLogic.checkIfGameOver5x5(btns, "X")) {
                        declareWinner(true);
                        for(Button _btn: btns) _btn.setDisable(true);
                        btnRestart.setDisable(false);
                    }
                } else if(!firstPlayer && btn.getText().isEmpty()) {
                    btn.setText("O");
                    firstPlayer = true;
                    if(TictactoeLogic.checkIfGameOver5x5(btns, "O")) {
                        declareWinner(false);
                        for(Button _btn: btns) _btn.setDisable(true);
                        btnRestart.setDisable(false);
                    }
                }
            });
        }
    }

    private void generate7To7Grid() {
        firstPlayer = true;
        paneCells.getChildren().clear();
        //paneCells.setPrefWidth(500);
        final Button btns[]  = new Button[7*7];
        for(int i=0; i< btns.length; ++i) {
            btns[i] = new Button("");
            btns[i].setId("ttt_cell");
        }

        for(int i=0; i< btns.length; i+=7) {
            paneCells.addRow(i/7, btns[i], btns[i+1], btns[i+2], btns[i+3], btns[i+4], btns[i+5], btns[i+6]);
        }


        for(Button btn:btns) {
            btn.setOnAction(handler-> {
                if(firstPlayer && btn.getText().isEmpty()) {
                    btn.setText("X");
                    firstPlayer = false;
                    if(TictactoeLogic.checkIfGameOver7x7(btns, "X")) {
                        declareWinner(true);
                        for(Button _btn: btns) _btn.setDisable(true);
                        btnRestart.setDisable(false);
                    }
                } else if(!firstPlayer && btn.getText().isEmpty()) {
                    btn.setText("O");
                    firstPlayer = true;
                    if(TictactoeLogic.checkIfGameOver7x7(btns, "O")) {
                        declareWinner(false);
                        for(Button _btn: btns) _btn.setDisable(true);
                        btnRestart.setDisable(false);
                    }
                }
            });
        }
    }

    private void declareWinner (boolean firstPlayer) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Declaration of Winner");
        if(firstPlayer) {
            alert.setHeaderText("First Player");
            alert.setContentText("First Player won, congratulation!");
        } else {
            alert.setHeaderText("Second Player");
            alert.setContentText("Second Player won, congratulation!");
        }

        alert.showAndWait();
    }


    static class TictactoeLogic {
        public static boolean checkIfGameOver3x3(Button[]  btns, String content) {
            boolean partHorizontal = (btns[0].getText().equals(content) && btns[1].getText().equals(content) && btns[2].getText().equals(content)) ||
                    (btns[3].getText().equals(content) && btns[4].getText().equals(content) && btns[5].getText().equals(content)) ||
                    (btns[6].getText().equals(content) && btns[7].getText().equals(content) && btns[8].getText().equals(content)) ;

            boolean partVertical =  (btns[0].getText().equals(content) && btns[3].getText().equals(content) && btns[6].getText().equals(content)) ||
                    (btns[1].getText().equals(content) && btns[4].getText().equals(content) && btns[7].getText().equals(content)) ||
                    (btns[2].getText().equals(content) && btns[5].getText().equals(content) && btns[8].getText().equals(content)) ;

            boolean partDiagonal = (btns[0].getText().equals(content) && btns[4].getText().equals(content) && btns[8].getText().equals(content)) ||
                    (btns[2].getText().equals(content) && btns[4].getText().equals(content) && btns[6].getText().equals(content)) ;
            return partHorizontal || partVertical || partDiagonal;
        }


        public static boolean checkIfGameOver5x5(Button[]  btns, String content) {
            boolean partHorizontal = (btns[0].getText().equals(content) && btns[1].getText().equals(content) && btns[2].getText().equals(content) && btns[3].getText().equals(content) && btns[4].getText().equals(content)) ||
                    (btns[5].getText().equals(content) && btns[6].getText().equals(content) && btns[7].getText().equals(content) && btns[8].getText().equals(content) && btns[9].getText().equals(content)) ||
                    (btns[10].getText().equals(content) && btns[11].getText().equals(content) && btns[12].getText().equals(content) && btns[13].getText().equals(content) && btns[14].getText().equals(content)) ||
                    (btns[15].getText().equals(content) && btns[16].getText().equals(content) && btns[17].getText().equals(content) && btns[18].getText().equals(content) && btns[19].getText().equals(content)) ||
                    (btns[20].getText().equals(content) && btns[21].getText().equals(content) && btns[22].getText().equals(content) && btns[23].getText().equals(content) && btns[24].getText().equals(content));

            boolean partVertical =  (btns[0].getText().equals(content) && btns[5].getText().equals(content) && btns[10].getText().equals(content) && btns[15].getText().equals(content) && btns[20].getText().equals(content)) ||
                    (btns[1].getText().equals(content) && btns[6].getText().equals(content) && btns[11].getText().equals(content) && btns[16].getText().equals(content) && btns[21].getText().equals(content)) ||
                    (btns[2].getText().equals(content) && btns[7].getText().equals(content) && btns[12].getText().equals(content) && btns[17].getText().equals(content) && btns[22].getText().equals(content)) ||
                    (btns[3].getText().equals(content) && btns[8].getText().equals(content) && btns[13].getText().equals(content) && btns[18].getText().equals(content) && btns[23].getText().equals(content)) ||
                    (btns[4].getText().equals(content) && btns[9].getText().equals(content) && btns[14].getText().equals(content) && btns[19].getText().equals(content) && btns[24].getText().equals(content));

            boolean partDiagonal = (btns[0].getText().equals(content) && btns[6].getText().equals(content) && btns[12].getText().equals(content) && btns[18].getText().equals(content) && btns[24].getText().equals(content)) ||
                    (btns[4].getText().equals(content) && btns[8].getText().equals(content) && btns[12].getText().equals(content) && btns[16].getText().equals(content) && btns[20].getText().equals(content));
            return partHorizontal || partVertical || partDiagonal;
        }



        public static boolean checkIfGameOver7x7(Button[]  btns, String content) {
            boolean partHorizontal = (btns[0].getText().equals(content) && btns[1].getText().equals(content) && btns[2].getText().equals(content) && btns[3].getText().equals(content) && btns[4].getText().equals(content) && btns[5].getText().equals(content) && btns[6].getText().equals(content)) ||
                    (btns[7].getText().equals(content) && btns[8].getText().equals(content) && btns[9].getText().equals(content) && btns[10].getText().equals(content) && btns[11].getText().equals(content) && btns[12].getText().equals(content) && btns[13].getText().equals(content)) ||
                    (btns[14].getText().equals(content) && btns[15].getText().equals(content) && btns[16].getText().equals(content) && btns[17].getText().equals(content) && btns[18].getText().equals(content) && btns[19].getText().equals(content) && btns[20].getText().equals(content)) ||
                    (btns[21].getText().equals(content) && btns[22].getText().equals(content) && btns[23].getText().equals(content) && btns[24].getText().equals(content) && btns[25].getText().equals(content) && btns[26].getText().equals(content) && btns[27].getText().equals(content)) ||
                    (btns[28].getText().equals(content) && btns[29].getText().equals(content) && btns[30].getText().equals(content) && btns[31].getText().equals(content) && btns[32].getText().equals(content) && btns[33].getText().equals(content) && btns[34].getText().equals(content)) ||
                    (btns[35].getText().equals(content) && btns[36].getText().equals(content) && btns[37].getText().equals(content) && btns[38].getText().equals(content) && btns[39].getText().equals(content) && btns[40].getText().equals(content) && btns[41].getText().equals(content)) ||
                    (btns[42].getText().equals(content) && btns[43].getText().equals(content) && btns[44].getText().equals(content) && btns[45].getText().equals(content) && btns[46].getText().equals(content) && btns[47].getText().equals(content) && btns[48].getText().equals(content));

            boolean partVertical =  (btns[0].getText().equals(content) && btns[7].getText().equals(content) && btns[14].getText().equals(content) && btns[21].getText().equals(content) && btns[28].getText().equals(content) && btns[35].getText().equals(content) && btns[42].getText().equals(content)) ||
                    (btns[1].getText().equals(content) && btns[8].getText().equals(content) && btns[15].getText().equals(content) && btns[22].getText().equals(content) && btns[29].getText().equals(content) && btns[36].getText().equals(content) && btns[43].getText().equals(content)) ||
                    (btns[2].getText().equals(content) && btns[9].getText().equals(content) && btns[16].getText().equals(content) && btns[23].getText().equals(content) && btns[30].getText().equals(content) && btns[37].getText().equals(content) && btns[44].getText().equals(content)) ||
                    (btns[3].getText().equals(content) && btns[10].getText().equals(content) && btns[17].getText().equals(content) && btns[24].getText().equals(content) && btns[31].getText().equals(content) && btns[38].getText().equals(content) && btns[45].getText().equals(content)) ||
                    (btns[4].getText().equals(content) && btns[11].getText().equals(content) && btns[18].getText().equals(content) && btns[25].getText().equals(content) && btns[32].getText().equals(content) && btns[39].getText().equals(content) && btns[46].getText().equals(content)) ||
                    (btns[5].getText().equals(content) && btns[12].getText().equals(content) && btns[19].getText().equals(content) && btns[26].getText().equals(content) && btns[33].getText().equals(content) && btns[40].getText().equals(content) && btns[47].getText().equals(content)) ||
                    (btns[6].getText().equals(content) && btns[13].getText().equals(content) && btns[20].getText().equals(content) && btns[27].getText().equals(content) && btns[34].getText().equals(content) && btns[41].getText().equals(content) && btns[48].getText().equals(content));

            boolean partDiagonal =    (btns[0].getText().equals(content) && btns[8].getText().equals(content) && btns[16].getText().equals(content) && btns[24].getText().equals(content) && btns[32].getText().equals(content) && btns[40].getText().equals(content) && btns[48].getText().equals(content)) ||
                    (btns[6].getText().equals(content) && btns[12].getText().equals(content) && btns[18].getText().equals(content) && btns[24].getText().equals(content) && btns[30].getText().equals(content) && btns[36].getText().equals(content) && btns[42].getText().equals(content));

            return partHorizontal || partVertical || partDiagonal;
        }

    }
}


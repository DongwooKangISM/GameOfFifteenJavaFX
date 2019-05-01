package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    public Button[] arrayTiles;
    private Model model = new Model();

    @FXML
    private Text move;

    @FXML
    private Button tile1;

    @FXML
    private Button tile2;

    @FXML
    private Button tile3;

    @FXML
    private Button tile4;

    @FXML
    private Button tile5;

    @FXML
    private Button tile6;

    @FXML
    private Button tile7;

    @FXML
    private Button tile8;

    @FXML
    private Button tile9;

    @FXML
    private Button tile10;

    @FXML
    private Button tile11;

    @FXML
    private Button tile12;

    @FXML
    private Button tile13;

    @FXML
    private Button tile14;

    @FXML
    private Button tile15;

    @FXML
    private Button tile16;



    @FXML
    private void tile(ActionEvent event) {
        if(model.gameEnd(arrayTiles) == false) {
            if (model.checkMove(arrayTiles, model.findPosition(arrayTiles, ((Button) event.getSource()).getText()))) {
                move.setText(String.valueOf(Integer.parseInt(move.getText()) + 1));
                model.swapVariable(arrayTiles, model.findPosition(arrayTiles, ((Button) event.getSource()).getText()), model.findPosition(arrayTiles, " "));

                if(model.gameEnd(arrayTiles)) {
                    java.util.Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            for (int i = 1; i < arrayTiles.length; i++) {
                                arrayTiles[i].setStyle("-fx-background-color: #D3D3D3");
                            }
                        }
                    };
                    timer.schedule(task, 1000);
                }
            }
        }
    }



    @FXML
    public void initialize() {
        tileArray();
        model.shuffle(arrayTiles);
    }

    @FXML
    private void retry() {
        model.shuffle(arrayTiles);
        for (int i = 1; i < arrayTiles.length; i++) {
            arrayTiles[i].setStyle("-fx-foreground-color: #ff0000; ");
        }
        move.setText("0");
    }

    public void tileArray() {
        arrayTiles = new Button[17];
        arrayTiles[1] = tile1;
        arrayTiles[2] = tile2;
        arrayTiles[3] = tile3;
        arrayTiles[4] = tile4;
        arrayTiles[5] = tile5;
        arrayTiles[6] = tile6;
        arrayTiles[7] = tile7;
        arrayTiles[8] = tile8;
        arrayTiles[9] = tile9;
        arrayTiles[10] = tile10;
        arrayTiles[11] = tile11;
        arrayTiles[12] = tile12;
        arrayTiles[13] = tile13;
        arrayTiles[14] = tile14;
        arrayTiles[15] = tile15;
        arrayTiles[16] = tile16;
    }

}

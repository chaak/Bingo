package com.web.client;

import com.web.server.BingoBoard;
import com.web.server.RandomNumber;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class ClientBingo extends Application {

    private static double NUMBER_X = 2.2;
    private static double NUMBER_Y = 6.2;
    private static double X_ALIGMENT = 0.4;
    private static double Y_ALIGMENT = 0.4;
    private static String WINNER = "WINNER";

    private BingoBoard board = new BingoBoard();
    private static List<Combo> combos = new ArrayList<>();
    static boolean playable = true;
    static boolean turn = false;
    private Tile[][] checkBingo = new Tile[5][6];
    private static Timer timer = new Timer();
    public static RandomNumber randomNumber = new RandomNumber();

    private Parent createContent() throws InterruptedException, IOException {

        Pane root = new Pane();
        root.setPrefSize(500, 700);
        board.initBoard();

        //populate window with tiles
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                Tile tile = new Tile();
                FreeTile freeTile = new FreeTile();
                BingoTile bingoTile = new BingoTile();

                randomNumber.setTranslateY(NUMBER_Y * 100);
                randomNumber.setTranslateX(NUMBER_X * 100);

                freeTile.setTranslateX(2 * 100);
                freeTile.setTranslateY(3 * 100);

                bingoTile.setTranslateX(i * 100);
                bingoTile.setTranslateY(0);

                tile.setTranslateX(i * 100);
                tile.setTranslateY(j * 100);

                root.getChildren().addAll(tile, freeTile, bingoTile);
                checkBingo[i][j] = tile;
            }
        }

        root.getChildren().addAll(randomNumber);
        //populate horizontal lines
        for (int y = 1; y < 6; y++) {
            combos.add(new Combo(checkBingo[0][y], checkBingo[1][y], checkBingo[2][y], checkBingo[3][y], checkBingo[4][y]));
        }
        //populate tiles with numbers
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 5; y++) {
                board.getNumber(x, y).setTranslateX((y + X_ALIGMENT) * 100);
                board.getNumber(x, y).setTranslateY((x - Y_ALIGMENT) * 100);
                root.getChildren().addAll(board.getNumber(x, y));
            }
        }
        timer.schedule(new ServerConnection(), 0, 1000);
        return root;
    }

    static void checkState() {
        for (Combo combo : combos) {
            if (combo.isBingo()) {
                playable = false;
                timer.cancel();
                randomNumber.setValue(WINNER);
                break;
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String args[]) throws IOException {
        launch(args);
    }
}


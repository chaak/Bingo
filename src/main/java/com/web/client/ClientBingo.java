package com.web.client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class ClientBingo extends Application {

    private static double NUMBER_X = 2.0;
    private static double NUMBER_Y = 6.0;
    private static double X_ALIGMENT = 0.4;
    private static double Y_ALIGMENT = 0.4;

    private BingoBoard board = new BingoBoard();

    private Parent createContent() throws InterruptedException {
        Pane root = new Pane();
        root.setPrefSize(500, 700);

        board.initBoard();

        //ustawianie kafli w okienku
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                Tile tile = new Tile();
                FreeTile freeTile = new FreeTile();
                BingoTile bingoTile = new BingoTile();
                RandomNumber randomNumber = new RandomNumber("50");

                randomNumber.setTranslateY(NUMBER_Y * 100);
                randomNumber.setTranslateX(NUMBER_X * 100);

                freeTile.setTranslateX(2 * 100);
                freeTile.setTranslateY(3 * 100);

                bingoTile.setTranslateX(i * 100);
                bingoTile.setTranslateY(0 * 100);

                tile.setTranslateX(j * 100);
                tile.setTranslateY(i * 100);

                root.getChildren().addAll(tile, randomNumber, freeTile, bingoTile);
            }
        }

        //wstawianie wartosci do kafli
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 5; y++) {
                board.getNumber(x, y).setTranslateX((y + X_ALIGMENT) * 100);
                board.getNumber(x, y).setTranslateY((x - Y_ALIGMENT) * 100);
                root.getChildren().addAll(board.getNumber(x, y));
            }
        }
//
//        for (int x = 0; x < 7; x++) {
//            for (int y = 0; y < 5; y++) {
//                int finalX = x;
//                int finalY = y;
//                tile.setOnMouseClicked(event -> {
//                    if(board.isClicked(finalX, finalY, tile)) tile.drawB();
//                });
//            }
//        }

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}

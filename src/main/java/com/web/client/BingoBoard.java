package com.web.client;

import javafx.scene.text.Text;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
class BingoBoard {
    private static int SIZE_Y = 7;
    private static int SIZE_X = 5;
    private Tile[][] board = new Tile[SIZE_Y][SIZE_Y];
    private static String bingo = "BINGO";
    private int iterator = 0;

    BingoBoard() {
        initBoard();
    }

    void initBoard() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j <= SIZE_X; j++) {
                board[i][j] = new Tile(i, j, "5");

                //change it
                board[1][0] = new Tile(i, j, String.valueOf(bingo.charAt(0)));
                board[1][1] = new Tile(i, j, String.valueOf(bingo.charAt(1)));
                board[1][2] = new Tile(i, j, String.valueOf(bingo.charAt(2)));
                board[1][3] = new Tile(i, j, String.valueOf(bingo.charAt(3)));
                board[1][4] = new Tile(i, j, String.valueOf(bingo.charAt(4)));
            }
        }
    }


    Text getNumber(int x, int y) {
        return board[x][y].getValue();
    }

    void setNumber(int x, int y, String value) {
        board[x][y].setValue(value);
    }
}

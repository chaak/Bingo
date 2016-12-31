package com.web.client;

import javafx.scene.text.Text;

import java.util.Random;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
class BingoBoard {
    private static int SIZE_Y = 7;
    private static int SIZE_X = 5;
    private Tile[][] board = new Tile[SIZE_Y][SIZE_Y];
    private static String bingo = "BINGO";

    BingoBoard() {
        initBoard();
    }

    void initBoard() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j <= SIZE_X; j++) {
                board[1][0] = new Tile(i, j, String.valueOf(bingo.charAt(0)));
                board[1][1] = new Tile(i, j, String.valueOf(bingo.charAt(1)));
                board[1][2] = new Tile(i, j, String.valueOf(bingo.charAt(2)));
                board[1][3] = new Tile(i, j, String.valueOf(bingo.charAt(3)));
                board[1][4] = new Tile(i, j, String.valueOf(bingo.charAt(4)));
                //generate rows
                board[i][0] = new Tile(i, j, String.valueOf(randomNumber(1, 15)));
                board[i][1] = new Tile(i, j, String.valueOf(randomNumber(16, 30)));
                board[i][2] = new Tile(i, j, String.valueOf(randomNumber(31, 45)));
                board[i][3] = new Tile(i, j, String.valueOf(randomNumber(46, 60)));
                board[i][4] = new Tile(i, j, String.valueOf(randomNumber(61, 75)));
                board[4][2] = new Tile(i, j, " ");
            }
        }
    }


    Text getNumber(int x, int y) {
        return board[x][y].getValue();
    }

    void setNumber(int x, int y, String value) {
        board[x][y].setValue(value);
    }

    private static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
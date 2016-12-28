package com.web.client;

import javafx.scene.text.Text;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class BingoBoard {
    public static int SIZE = 5;

    private Tile [][] board = new Tile[SIZE][SIZE];

    void initBoard(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                Tile tile = new Tile(i, j, "0");
                board[i][j] = tile;
            }
        }
    }

    String getNumber(int x, int y){
        return board[x][y].getValue();
    }

    void setNumber(int x, int y, String value){
        board[x][y].setValue(value);
    }
}

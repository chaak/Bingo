package com.web.server;
import com.web.client.ClientBingo;
import com.web.client.Tile;
import javafx.scene.text.Text;
import java.util.Objects;
import java.util.Random;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class BingoBoard {
    private static int SIZE_Y = 7;
    private static int SIZE_X = 5;
    private static Tile[][] board = new Tile[SIZE_Y][SIZE_Y];
    private static String bingo = "BINGO";

    public void initBoard() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j <= SIZE_X; j++) {
                board[1][0] = new Tile(i, j, String.valueOf(bingo.charAt(0)));
                board[1][1] = new Tile(i, j, String.valueOf(bingo.charAt(1)));
                board[1][2] = new Tile(i, j, String.valueOf(bingo.charAt(2)));
                board[1][3] = new Tile(i, j, String.valueOf(bingo.charAt(3)));
                board[1][4] = new Tile(i, j, String.valueOf(bingo.charAt(4)));

                board[i][0] = new Tile(i, j, String.valueOf(randomNumber(1, 15)));
                board[i][1] = new Tile(i, j, String.valueOf(randomNumber(16, 30)));
                board[i][2] = new Tile(i, j, String.valueOf(randomNumber(31, 45)));
                board[i][3] = new Tile(i, j, String.valueOf(randomNumber(46, 60)));
                board[i][4] = new Tile(i, j, String.valueOf(randomNumber(61, 75)));
                board[4][2] = new Tile(i, j, " ");
            }
        }
    }

    public Text getNumber(int x, int y) {
        return board[x][y].getValue();
    }

    public static boolean isClickAvaiable() {
        for(int i = 0; i < SIZE_Y; i++){
            for(int j = 0; j < SIZE_X; j++){
                 if(Objects.equals(board[i][j].getValue().getText(), ClientBingo.randomNumber.getValue().getText())) {
                     return true;
                 }
            }
        }
        return false;
    }

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}

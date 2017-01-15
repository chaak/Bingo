package com.web.client;

import com.web.server.BingoBoard;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class Tile extends StackPane {

    private int x;
    private int y;
    private Text value = new Text();

    public Tile(int x, int y, String newValue) {
        this.x = x;
        this.y = y;
        value.setText(newValue);
        value.setFont(Font.font(30));
    }

    Tile() {
        Rectangle border = new Rectangle(100, 100);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);

        setOnMouseClicked(event -> {
            if (!ClientBingo.playable) {
                return;
            }

            if (event.getButton() == MouseButton.PRIMARY) {
                if (BingoBoard.isClickAvaiable()) {
                    if(ClientBingo.turn){
                        return;
                    }
                    setValue("B");
                    border.setFill(Color.YELLOW);
                    ClientBingo.turn = true;
                }
            }
        });
        getChildren().addAll(border, value);
    }

    public Text getValue() {
        return this.value;
    }

    private void setValue(String newValue) {
        this.value.setText(newValue);
        this.value.setFill(Color.RED);
        this.value.setFont(Font.font(0));
    }

}

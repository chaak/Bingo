package com.web.client;

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
class Tile extends StackPane {

    private int x;
    private int y;

    private Text value = new Text();
    private RandomNumber number = new RandomNumber();

    Tile(int x, int y, String newValue) {
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

        if(BingoBoard.isClickAvaiable()) {
            setOnMouseClicked(event -> {
                if (!ClientBingo.playable) {
                    return;
                }

                if (event.getButton() == MouseButton.PRIMARY) {
                    setValue("B");
                    border.setFill(Color.YELLOW);
                    ClientBingo.checkState();
                }
            });
        }
        getChildren().addAll(border, value, number);
    }

    Text getValue() {
        return this.value;
    }

    private void setValue(String newValue) {
        this.value.setText(newValue);
        this.value.setFill(Color.RED);
        this.value.setFont(Font.font(0));
    }

}

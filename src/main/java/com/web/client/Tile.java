package com.web.client;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Objects;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
class Tile extends StackPane {

    private int x;
    private int y;

    private Text value = new Text();
    private Text B = new Text();
    Text numberToCheck = new Text();

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

        B.setFont(Font.font(45));
        B.setFill(Color.RED);

        numberToCheck.setText("5"); //server ustala te liczbe
        numberToCheck.setFill(Color.BLACK);
        numberToCheck.setFont(Font.font(50));

        setOnMouseClicked(event -> {
            if(Objects.equals("5", numberToCheck.getText()))
                drawB();
        });

        getChildren().addAll(border, B);
    }

    public void drawB() {
        B.setText("B");
    }

    public Text getValue() {
        return this.value;
    }

    public void setValue(String newValue) {
        this.value.setText(newValue);
    }

}

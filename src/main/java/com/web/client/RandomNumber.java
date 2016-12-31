package com.web.client;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by JakubWitczak on 30.12.2016.
 */
public class RandomNumber extends Tile {

    RandomNumber() {
        Text number = new Text();
        Rectangle border = new Rectangle(100, 100);
        border.setFill(null);
        border.setStroke(null);

        number.setText("5"); //server ustala te liczbe
        number.setFill(Color.ORANGE);
        number.setFont(Font.font(50));

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, number);
    }
}

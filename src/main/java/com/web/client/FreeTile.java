package com.web.client;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by JakubWitczak on 30.12.2016.
 */
class FreeTile extends Tile {
    FreeTile(){
        Rectangle border = new Rectangle(100, 100);
        border.setFill(Color.GREEN);
        border.setStroke(Color.BLACK);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border);
    }
}

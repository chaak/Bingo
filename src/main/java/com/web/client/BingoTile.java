package com.web.client;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by JakubWitczak on 31.12.2016.
 */
class BingoTile extends Tile {
    BingoTile(){
        Rectangle border = new Rectangle(100, 100);
        border.setFill(Color.ORANGE);
        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border);
    }
}

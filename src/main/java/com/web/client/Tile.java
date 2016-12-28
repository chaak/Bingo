package com.web.client;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
class Tile extends StackPane {
    Tile(){
        Rectangle border = new Rectangle(160, 160);
        border.setFill(null);
        border.setStroke(Color.BLACK);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border);
    }
}

package com.web.client;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by JakubWitczak on 30.12.2016.
 */
class RandomNumber extends StackPane{
    private static int X_ALIGEMNET = -60;
    private Text number = new Text();

    RandomNumber() {
        Rectangle border = new Rectangle(100, 100);
        border.setFill(null);
        border.setStroke(null);
        number.setFill(Color.ORANGE);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, number);
    }

    void setValue(String newValue){
        number.setFont(Font.font(50));
        number.setText(newValue);

        if(newValue.equals("WINNER"))
            number.setTranslateX(X_ALIGEMNET);
    }

    Text getValue(){
        return number;
    }

}

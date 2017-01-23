package com.web.server;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Created by JakubWitczak on 30.12.2016.
 */
public class RandomNumber extends StackPane {
    private static int X_ALIGEMNET = -80;
    private Text number = new Text();

    public RandomNumber() {
        Rectangle border = new Rectangle(100, 100);
        border.setFill(null);
        border.setStroke(null);
        number.setFill(Color.ORANGE);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, number);
    }

    public void setValue(String newValue) {
        number.setFont(Font.font(50));
        number.setText(newValue);

        if (newValue.contains("WINNER") || newValue.contains("LOSE")) {
            number.setTranslateX(X_ALIGEMNET);
            number.setFill(Color.RED);
        }
    }

    public Text getValue() {
        return number;
    }

}

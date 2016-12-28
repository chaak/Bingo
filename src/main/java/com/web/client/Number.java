package com.web.client;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


/**
 * Created by JakubWitczak on 28.12.2016.
 */
class Number extends StackPane {
    Number() throws InterruptedException {
        Text number = new Text();
        number.setText("45");

        number.setFill(Color.BLACK);
        number.setFont(new Font(50));
        number.setTextAlignment(TextAlignment.RIGHT);

        getChildren().addAll(number);
    }
}

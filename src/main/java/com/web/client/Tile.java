package com.web.client;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
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
    public Text numberToCheck = new Text();

    Tile(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value.setText(value);
    }

    Tile() {
        Rectangle border = new Rectangle(100, 100);
        border.setFill(null);
        border.setStroke(Color.BLACK);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, B);

        B.setFont(Font.font(45));
        B.setFill(Color.RED);

        numberToCheck.setText("45"); //server ustala te liczbe
        numberToCheck.setFill(Color.BLACK);
        numberToCheck.setFont(new Font(50));

        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY)
                if (Objects.equals(event.getButton().toString(), numberToCheck.getText()))
                    drawB();
        });
    }

    private void drawB() {
        B.setText("B");
    }

    public String getValue() {
        return this.value.getText();
    }

    public void setValue(String newValue) {
        this.value.setText(newValue);
    }
}

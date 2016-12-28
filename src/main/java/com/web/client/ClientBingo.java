package com.web.client;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class ClientBingo extends Application {

    private static double NUMBER_X = 2.2;
    private static double NUMBER_Y = 6.1;

    private Parent createContent() throws InterruptedException {
        Pane root = new Pane();
        root.setPrefSize(500, 700);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                Tile tile = new Tile();
                Number number = new Number();
                tile.setTranslateX(j * 100);
                tile.setTranslateY(i * 100);
                number.setTranslateY(NUMBER_Y * 100);
                number.setTranslateX(NUMBER_X * 100);

                root.getChildren().addAll(tile, number);
            }
        }
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}

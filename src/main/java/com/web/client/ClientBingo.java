package com.web.client;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by JakubWitczak on 28.12.2016.
 */
public class ClientBingo extends Application {

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 960);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 160);
                tile.setTranslateY(i * 160);

                root.getChildren().addAll(tile);
            }
        }
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

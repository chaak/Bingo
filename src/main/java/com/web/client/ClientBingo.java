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

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(800,800);
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

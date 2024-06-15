package org.example.cryptosistema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader menuScene = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(menuScene.load(), 320, 380);
        stage.setTitle("Cypto");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
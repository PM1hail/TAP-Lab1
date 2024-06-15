package org.example.lab6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader moveText = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene mainScene = new Scene(moveText.load(), 600, 360);

        stage.setTitle("Moved Text");

        stage.setScene(mainScene);
        stage.show();
    }
}
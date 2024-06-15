package org.example.cryptosistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable{
    @FXML
    private ChoiceBox<String> choiceBox;

    private final String[] keys = new String[]{"One key", "Two keys"};

    Parent inputTextKey;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(keys);
        choiceBox.setOnAction(t -> {
            try {
                selectScene(t);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void selectScene(ActionEvent t) throws IOException {
        if (keys[0].equals(choiceBox.getValue())) {
            inputTextKey = FXMLLoader.load(getClass().getResource("input-text-key.fxml"));
        } else if (keys[1].equals(choiceBox.getValue())) {
            inputTextKey = FXMLLoader.load(getClass().getResource("input-text-keys.fxml"));
        }
    }

    public void press(ActionEvent event){
        Stage stage;
        Scene scene;
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(inputTextKey);
            stage.setScene(scene);
            stage.show();
    }
}
package org.example.cryptosistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultController implements Initializable {
    @FXML
    private TextArea crypt;
    @FXML
    private TextArea decrypt;

    CryptFile cf = new CryptFile();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
                    crypt.setText(String.valueOf(cf.readCryptFile()));
                    decrypt.setText(String.valueOf(cf.readDecryptFile()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void press(ActionEvent event) throws IOException {
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent inputTextKey = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene cryptScene = new Scene(inputTextKey);
        stage.setScene(cryptScene);
        stage.show();
    }

}

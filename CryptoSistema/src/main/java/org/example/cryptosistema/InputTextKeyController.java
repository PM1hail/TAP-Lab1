package org.example.cryptosistema;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.abs;

public class InputTextKeyController implements Initializable {

    @FXML
    private TextField keyField;
    @FXML
    private TextArea textArea;
    @FXML
    private ChoiceBox choiceBox;
    Boolean crypt;

    private final String[] process = new String[]{"Crypt","Decrypt"};

    private char alfabet[] = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
                                        'P','Q','R','S','T','U','V','W','X','Z'};
    private String str;
    private int key;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(process);
        choiceBox.setOnAction(t -> cryptingBool(t));
    }

    public void cryptingBool(Event t){
        if(process[0].equals(choiceBox.getValue())){
            crypt = true;
        } else if (process[1].equals(choiceBox.getValue())) {
            crypt = false;
        }
    }

    public void press(ActionEvent event) throws IOException {
        if(crypt){
            str = textArea.getText();
            key = Integer.parseInt(keyField.getText());
            crypting(str, key);
        }else {
            str = textArea.getText();
            key = Integer.parseInt(keyField.getText());
            decrypt(str, key);
        }
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent inputTextKey = FXMLLoader.load(getClass().getResource("Result.fxml"));
        Scene cryptScene = new Scene(inputTextKey);
        stage.setScene(cryptScene);
        stage.show();
    }


    void crypting(String str, int key) throws IOException {
        CryptFile cf = new CryptFile();
        cf.writeDecryptFile(str);
        str = uperC(str);
        StringBuffer crypt;
        crypt = new StringBuffer(str);
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            for (int j = 0; j < alfabet.length; j++){
                if(c == alfabet[j]) {
                    if (key + j <= alfabet.length - 1) {
                        crypt.deleteCharAt(i);
                        crypt.insert(i, alfabet[key + j]);
                    }
                    else{
                        crypt.deleteCharAt(i);
                        crypt.insert(i, alfabet[abs(alfabet.length - key - j)]);
                    }
                }
            }
        }
        this.str = new String(crypt);
        cf.writeCryptFile(this.str);
    }

    void decrypt(String str, int key) throws IOException {
        str = str.toUpperCase();
        CryptFile cf = new CryptFile();
        cf.writeCryptFile(str);
        StringBuffer crypt;
        crypt = new StringBuffer(this.str);
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            for (int j = 0; j < alfabet.length; j++){
                if(c == alfabet[j]) {
                    if (j - key >= 0) {
                        crypt.deleteCharAt(i);
                        crypt.insert(i, alfabet[j - key]);
                    }
                    else{
                        crypt.deleteCharAt(i);
                        crypt.insert(i, alfabet[alfabet.length - abs(j -
                                key)]);
                    }
                }
            }
        }
        this.str = new String(crypt);
        cf.writeDecryptFile(this.str);
    }


    public String uperC(String str){
        StringBuffer s = new StringBuffer(str);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){s.deleteCharAt(i);}
        }
        str = new String(s).toUpperCase();
        return str;
    }


}


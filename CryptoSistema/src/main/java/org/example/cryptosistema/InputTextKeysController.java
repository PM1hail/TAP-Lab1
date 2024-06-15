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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.abs;

public class InputTextKeysController implements Initializable {
    @FXML
    private TextField firstKeyField;
    @FXML
    private TextField secondKeyField;
    @FXML
    private TextArea textArea;
    @FXML
    private ChoiceBox choiceBox;
    Boolean crypt;

    private final String[] process = new String[]{"Crypt","Decrypt"};

    private char alfabet[] = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
            'P','Q','R','S','T','U','V','W','X','Z'};
    private String str;
    private int key1;
    private String key2;

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
            key1 = Integer.parseInt(firstKeyField.getText());
            key2 = secondKeyField.getText();
            crypting(str, key1, key2);
        }else {
            str = textArea.getText();
            key1 = Integer.parseInt(firstKeyField.getText());
            key2 = secondKeyField.getText();
            decrypt(str, key1, key2);
        }
        Stage stage;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent inputTextKey = FXMLLoader.load(getClass().getResource("Result.fxml"));
        Scene cryptScene = new Scene(inputTextKey);
        stage.setScene(cryptScene);
        stage.show();
    }

    public void crypting(String str, int key1, String key2) throws IOException {
        CryptFile cf = new CryptFile();
        cf.writeDecryptFile(str);

        key2 = uperC(key2);
        StringBuffer temp = new StringBuffer(String.valueOf(key2));
        for(char a : alfabet){
            Pattern pattern = Pattern.compile(String.valueOf(a));
            Matcher matcher = pattern.matcher(temp);
            if(matcher.find() == false ){
                temp.append(a);
            }
        }

        for(int i = 0; i < temp.length();i++){
            for(int j = 0; j < temp.length(); j++){
                if(i != j ){
                    if(temp.charAt(i) == temp.charAt(j)){
                        temp.deleteCharAt(j);
                        i = 0;
                        j = 0;
                    }
                }
            }
        }
        key2 = new String(temp);

        str = uperC(str);
        StringBuffer crypt;
        crypt = new StringBuffer(str);
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            for (int j = 0; j < key2.length(); j++){
                if(c == key2.charAt(j)) {
                    if (key1 + j <= key2.length() - 1) {
                        crypt.deleteCharAt(i);
                        crypt.insert(i, key2.charAt(key1 + j));
                    }
                    else{
                        crypt.deleteCharAt(i);
                        crypt.insert(i, key2.charAt(abs(key2.length() - key1 - j)));
                    }
                }
            }
        }
        this.str = new String(crypt);
        cf.writeCryptFile(this.str);
    }

    void decrypt(String str, int key1, String key2) throws IOException {
        str = str.toUpperCase();
        CryptFile cf = new CryptFile();
        cf.writeCryptFile(str);
        key2 = uperC(key2);
        StringBuffer temp = new StringBuffer(String.valueOf(key2));
        for(char a : alfabet){
            Pattern pattern = Pattern.compile(String.valueOf(a));
            Matcher matcher = pattern.matcher(temp);
            if(matcher.find() == false ){
                temp.append(a);
            }
        }

        for(int i = 0; i < temp.length();i++){
            for(int j = 0; j < temp.length(); j++){
                if(i != j ){
                    if(temp.charAt(i) == temp.charAt(j)){
                        temp.deleteCharAt(j);
                        i = 0;
                        j = 0;
                    }
                }
            }
        }
        key2 = new String(temp);
        StringBuffer crypt;
        crypt = new StringBuffer(this.str);
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            for (int j = 0; j < key2.length(); j++){
                if(c == key2.charAt(j)) {
                    if (j - key1 >= 0) {
                        crypt.deleteCharAt(i);
                        crypt.insert(i, key2.charAt(j - key1));
                    }
                    else{
                        crypt.deleteCharAt(i);
                        crypt.insert(i, key2.charAt(abs(key1 - j - key2.length())));
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

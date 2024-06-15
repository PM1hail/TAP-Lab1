package org.example.lab7;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Stack;

public class HelloController {
    @FXML
    private Label myLabel;
    @FXML
    private Button myButton;
    @FXML
    private TextField myTextField;
    @FXML
    private Text h1Text;
    private String string;

    @FXML
    public void click() {
        Stack<Character> stack = new Stack<>();

        string = myTextField.getText();
        for (int i = 0; i< string.length(); i++){
            stack.push(string.charAt(i));
        }

        char ch[] = new char[string.length()];

        for(int i = 0; i < string.length(); i++){
            ch[i] = stack.pop();
        }
        string = new String(ch);
            myLabel.setText("Result: " + string);
    }


}
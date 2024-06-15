package org.example.lab6;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
    Random rand = new Random();
    @FXML
    private Text Sirul1;
    @FXML
    private Text Sirul2;
    @FXML
    private Text Sirul3;
    @FXML
    private Text Sirul4;

    Boolean S = true;

    private int xlimit = 540, ylimit = 334, r1, x = 0, y = 0;
    private int r[] = new int[]{0,0,0,0};
    private int count = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(int i = 0; i < 4;) {
            r1 = rand.nextInt(1,5);
            for(int j = 0; j < 4; j++) {
                if (r[j] == r1) {
                    S = false;
                }
            }
                if(S){
                   r[i] = r1;
                    System.out.println(r1);
                   i++;
                }else{S = true;}
        }
            count(count);

            System.out.println("executed");

    }

    public void count(int count){
        switch(r[count]){
            case 1: Si1();
                break;
            case 2: Si2();
                break;
            case 3: Si3();
                break;
            case 4: Si4();
                break;
        }
    }

    public void Si1(){
        TranslateTransition move = new TranslateTransition();
        move.setDuration(Duration.seconds(2));
        move.setByX(rand.nextInt(xlimit));
        move.setByY(rand.nextInt(ylimit));
        move.setNode(Sirul1);
        move.play();
        move.setOnFinished(e->{count++;if(count < 4)count(count);});
    }
    public void Si2(){
        TranslateTransition move = new TranslateTransition();
        move.setDuration(Duration.seconds(2));
        move.setByX(rand.nextInt(xlimit));
        move.setByY(rand.nextInt(ylimit - 25));
        move.setNode(Sirul2);
        move.play();
        move.setOnFinished(e->{count++;if(count < 4)count(count);});
    }
    public void Si3(){
        TranslateTransition move = new TranslateTransition();
        move.setDuration(Duration.seconds(2));
        move.setByX(rand.nextInt(xlimit));
        move.setByY(rand.nextInt(ylimit - 55));
        move.setNode(Sirul3);
        move.play();
        move.setOnFinished(e->{count++;if(count < 4) count(count);});
    }
    public void Si4(){
        TranslateTransition move = new TranslateTransition();
        move.setDuration(Duration.seconds(2));
        move.setByX(rand.nextInt(xlimit));
        move.setByY(rand.nextInt(ylimit - 85));
        move.setNode(Sirul4);
        move.play();
        move.setOnFinished(e->{count++;if(count < 4) count(count);});
    }
}
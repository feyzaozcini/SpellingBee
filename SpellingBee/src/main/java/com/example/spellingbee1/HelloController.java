package com.example.spellingbee1;

import java.io.*;
import java.lang.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.scene.control.ListView;

import java.time.LocalDateTime;
import java.util.*;
import java.util.ArrayList;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.example.spellingbee1.Answers.cevaplar;
import static com.example.spellingbee1.Answers.harfler;
import com.example.spellingbee1.Pangram;

public class HelloController extends Pangram {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView myImage;
    @FXML
    private Button btdDelete;

    @FXML
    private Button btnChange;

    @FXML
    private Button btnEnter;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btnAnswer;
    @FXML
    private Button btnGiris;
    @FXML
    private Button btnGirilen;

    @FXML
    private Polygon shp1;

    @FXML
    private Polygon shp2;

    @FXML
    private Polygon shp3;

    @FXML
    private Polygon shp4;

    @FXML
    private Polygon shp5;

    @FXML
    private Polygon shp6;

    @FXML
    private Polygon shp7;

    @FXML
    private TableView<?> tblWords;

    @FXML
    private TextField tfWordEnter;
    @FXML
    private TextField txtScore;
    @FXML
    private TextField txtGirilen;

    @FXML
    private ListView lst;

    public String Sentence="";


    @FXML
    private void DeleteClicked() {
        tfWordEnter.setText("" + tfWordEnter.getText().substring(0, tfWordEnter.getText().length() - 1));
        Sentence = Sentence.substring(0, Sentence.length() - 1);
    }
    ArrayList<String> list = new ArrayList();
    Alert a = new Alert(AlertType.NONE);


    public int score=0;

    @FXML
    void btnEnterClicked(ActionEvent event ) throws Exception{

        String name = tfWordEnter.getText();
        if(name.length()<4){
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Aradığınız kelime an az 4 harfli olmalıdır");
            a.show();

        }
        else if(!name.contains(btn7.getText())){
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Kelimeniz Merkez Harfi İçermelidir!!");
            a.show();
        }

        else{
            Scanner sc1 = new Scanner(System.in);
            String word = name;
            boolean flag = false;
            Scanner fr = new Scanner(new FileInputStream("src\\main\\java\\com\\example\\spellingbee1\\VPSOZLUK.txt"));


            while (fr.hasNextLine()) {
                String line = fr.nextLine();
                if ((line.indexOf(word)) != -1) {
                    flag = true;

                }
            }
            if (flag) {
                if(name.contains(alphabet))
                {
                    score+=7;
                    String Score=Integer.toString(score);
                    if(list.contains(name)){
                        a.setAlertType(AlertType.ERROR);
                        a.setHeaderText(null);
                        a.setContentText("Bu Kelimeyi Zaten Buldunuz!!");
                        a.show();

                    }
                    else{
                        lst.getItems().add(name);
                        txtScore.setText(Score);
                        list.add(name);
                    }

                }
                else{
                    score++;
                    String Score=Integer.toString(score);
                    if(list.contains(name)){
                        a.setAlertType(AlertType.ERROR);
                        a.setHeaderText(null);
                        a.setContentText("Bu Kelimeyi Zaten Buldunuz!!");
                        a.show();

                    }
                    else{
                        lst.getItems().add(name);
                        txtScore.setText(Score);
                        list.add(name);
                    }

                }

            } else {
                a.setAlertType(AlertType.ERROR);
                a.setHeaderText(null);
                a.setContentText("Hatalı Ya Da Eksik Kelime");
                a.show();

            }

        }
        Sentence="";
        tfWordEnter.clear();

    }
    Pangram png=new Pangram();
    char[] words=new char[7];
    String alphabet="";

    @FXML
    void btnGirisClicked(ActionEvent event) throws Exception{

        score=0;
        tfWordEnter.clear();
        lst.getItems().clear();
        String Score=Integer.toString(score);
        txtScore.setText(Score);

            Random random = new Random();

            int index = random.nextInt(png.farkli.size());

            for(int j=0; j<png.farkli.size(); j++){
                alphabet= png.farkli.get(index);

                for(int i=0;i<7;i++){
                    char result=alphabet.charAt(i);
                    words[i] = result;
                }
                System.out.println(alphabet);



                btn1.setText(String.valueOf(words[0]));
                btn2.setText(String.valueOf(words[1]));
                btn3.setText(String.valueOf(words[2]));
                btn4.setText(String.valueOf(words[3]));
                btn5.setText(String.valueOf(words[4]));
                btn6.setText(String.valueOf(words[5]));
                btn7.setText(String.valueOf(words[6]));


            }

    }
    @FXML
    protected void ClickedText()throws Exception{
        String name = tfWordEnter.getText();
        if(name.length()<4){
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Aradığınız kelime an az 4 harfli olmalıdır");
            a.show();

        }
        else if(!name.contains(btn7.getText())){
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("Kelimeniz Merkez Harfi İçermelidir!!");
            a.show();
        }

        else{
            Scanner sc1 = new Scanner(System.in);
            String word = name;
            boolean flag = false;
            Scanner fr = new Scanner(new FileInputStream("src\\main\\java\\com\\example\\spellingbee1\\VPSOZLUK.txt"));


            while (fr.hasNextLine()) {
                String line = fr.nextLine();
                if ((line.indexOf(word)) != -1) {
                    flag = true;

                }
            }
            if (flag) {
                if(name.contains(alphabet))
                {
                    score+=7;
                    String Score=Integer.toString(score);
                    if(list.contains(name)){
                        a.setAlertType(AlertType.ERROR);
                        a.setHeaderText(null);
                        a.setContentText("Bu Kelimeyi Zaten Buldunuz!!");
                        a.show();

                    }
                    else{
                        lst.getItems().add(name);
                        txtScore.setText(Score);
                        list.add(name);
                    }

                }
                else{
                    score++;
                    String Score=Integer.toString(score);
                    if(list.contains(name)){
                        a.setAlertType(AlertType.ERROR);
                        a.setHeaderText(null);
                        a.setContentText("Bu Kelimeyi Zaten Buldunuz!!");
                        a.show();

                    }
                    else{
                        lst.getItems().add(name);
                        txtScore.setText(Score);
                        list.add(name);
                    }

                }

            } else {
                a.setAlertType(AlertType.ERROR);
                a.setHeaderText(null);
                a.setContentText("Hatalı Ya Da Eksik Kelime");
                a.show();

            }

        }
        Sentence="";
        tfWordEnter.clear();
    }

    @FXML
    protected void SuffleBtn(){
        ArrayList<String > btns=new ArrayList<>();
        btns.add(btn1.getText());
        btns.add(btn2.getText());
        btns.add(btn3.getText());
        btns.add(btn4.getText());
        btns.add(btn5.getText());
        btns.add(btn6.getText());
        Collections.shuffle(btns);
        btn1.setText(btns.get(0));
        btn2.setText(btns.get(1));
        btn3.setText(btns.get(2));
        btn4.setText(btns.get(3));
        btn5.setText(btns.get(4));
        btn6.setText(btns.get(5));


    }
    @FXML
    protected void ClickedBtn1(){
        Sentence+=btn1.getText();
        tfWordEnter.setText(Sentence);

    }
    @FXML
    protected void ClickedBtn2(){
        Sentence+=btn2.getText();
        tfWordEnter.setText(Sentence);

    }
    @FXML
    protected void ClickedBtn3(){
        Sentence+=btn3.getText();
        tfWordEnter.setText(Sentence);

    }
    @FXML
    protected void ClickedBtn4(){
        Sentence+=btn4.getText();
        tfWordEnter.setText(Sentence);

    }
    @FXML
    protected void ClickedBtn5(){
        Sentence+=btn5.getText();
        tfWordEnter.setText(Sentence);

    }
    @FXML
    protected void ClickedBtn6(){
        Sentence+=btn6.getText();
        tfWordEnter.setText(Sentence);

    }
    @FXML
    protected void ClickedBtn7(){
        Sentence+=btn7.getText();
        tfWordEnter.setText(Sentence);

    }
    @FXML
    void switchToScene1(ActionEvent event) {
        try {
            root=FXMLLoader.load(getClass().getResource("start-page.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage=(Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    String Girilen="";
    char[] girilen=new char[7];

    @FXML
    public void girilenHarfAktar(){
        harfler.clear();
        cevaplar.clear();
        Girilen=txtGirilen.getText();
        if(Girilen.length()<7||Girilen.length()>7){
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText(null);
            a.setContentText("7 Farklı Harf Girmelisiniz!!!");
            a.show();
        }
        else{
            alphabet=Girilen;
            System.out.println(alphabet);
            for(int i=0;i<7;i++){
                char result=Girilen.charAt(i);
                girilen[i] = result;
                    }
            for(int i=0; i<7; i++) {
                for (int j = i + 1; j < 7; j++) {

                    if (girilen[i] == girilen[j]) {
                        a.setAlertType(AlertType.ERROR);
                        a.setHeaderText(null);
                        a.setContentText("7 Farklı Harf Girmelisiniz!!!");
                        a.show();
                        Optional<ButtonType> result = a.showAndWait();
                        if (result.get() == ButtonType.OK){

                        }



                    }
                }
            }

                btn1.setText(String.valueOf(girilen[0]));
                btn2.setText(String.valueOf(girilen[1]));
                btn3.setText(String.valueOf(girilen[2]));
                btn4.setText(String.valueOf(girilen[3]));
                btn5.setText(String.valueOf(girilen[4]));
                btn6.setText(String.valueOf(girilen[5]));
                btn7.setText(String.valueOf(girilen[6]));
                txtGirilen.setVisible(false);
                btnGirilen.setVisible(false);
        }

    }

    public void switchToScene2(ActionEvent event) {

        try {
            root=FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage=(Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToScene3(ActionEvent event)  {


        try {
            root=FXMLLoader.load(getClass().getResource("Answers.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage=(Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();



        harfler.clear();
        cevaplar.clear();

        score=0;
        tfWordEnter.clear();
        lst.getItems().clear();
        String Score=Integer.toString(score);
        txtScore.setText(Score);
        harfler.add(btn1.getText().charAt(0));
        harfler.add(btn2.getText().charAt(0));
        harfler.add(btn3.getText().charAt(0));
        harfler.add(btn4.getText().charAt(0));
        harfler.add(btn5.getText().charAt(0));
        harfler.add(btn6.getText().charAt(0));
        harfler.add(btn7.getText().charAt(0));

    }

    @FXML
    public void btncvp(){
        Answers a1=new Answers();
        for(String str:cevaplar)
            answerList.getItems().add(str);
        harfler.clear();
        cevaplar.clear();
    }

    @FXML
    private Button btnKendin;
    @FXML
    private Button btncvp;
    @FXML
    private ImageView myImageView;

    @FXML
    void btnKendin(ActionEvent event) {
        txtGirilen.setVisible(true);
        btnGirilen.setVisible(true);
    }
    @FXML
    private ListView answerList;
    @FXML
    private Button btnBack;
}
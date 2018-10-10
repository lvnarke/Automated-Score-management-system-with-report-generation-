package sample;

import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class OCR   {
    //Stage stage2 = new Stage();
    public static boolean var=false;
    public TextField txt2;
    public JFXToggleButton tg1;
    public CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    static String ocrpath="";

    /*public void initialize(URL location, ResourceBundle resources) {
        lab1.setText(ocrpath);
    }*/
    public void funn(ActionEvent event) throws Exception{
        System.out.println("Button pressed");
        ocrpath=txt2.getText();
        if(tg1.isFocused() && var==false){
            System.out.println(var);
            var=true;
            //cb1.
            cb1.setDisable(false);
            cb2.setDisable(false);
            cb3.setDisable(false);
            cb4.setDisable(false);
            cb5.setDisable(false);
            cb6.setDisable(false);
            cb7.setDisable(false);
        }
        if(tg1.isFocused() && var==true){
            System.out.println(var);
            var=false;
            cb1.setDisable(true);
            cb2.setDisable(true);
            cb3.setDisable(true);
            cb4.setDisable(true);
            cb5.setDisable(true);
            cb6.setDisable(true);
            cb7.setDisable(true);
        }
        //lab1.setText(ocrpath);

    }
    public void button_fun(ActionEvent event) throws Exception{
        System.out.println("Button pressed");
        Do_OCR obj = new Do_OCR();
        obj.do_OCR(ocrpath);
    }
}

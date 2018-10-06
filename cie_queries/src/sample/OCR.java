package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class OCR   {
    Stage stage2 = new Stage();
    public TextField txt2;
    public Label lab1;
    static String ocrpath="";

    /*public void initialize(URL location, ResourceBundle resources) {
        lab1.setText(ocrpath);
    }*/
    public void funn(ActionEvent event) throws Exception{
        System.out.println("Button pressed");
        ocrpath=txt2.getText();
        //lab1.setText(ocrpath);
        Parent root = FXMLLoader.load(getClass().getResource("screen6.fxml"));
        stage2.setScene(new Scene(root, 1108, 693));
        stage2.show();
    }
    public void button_fun(ActionEvent event) throws Exception{
        System.out.println("Button pressed");
        Do_OCR obj = new Do_OCR();
        obj.do_OCR(ocrpath);
    }
}

package sample;

import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;


public class OCR   {
    //Stage stage2 = new Stage();
    public static boolean var=false;
    public TextField txt2;
    public JFXToggleButton tg1;
    public CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    static String ocrpath="";
    public static boolean q1=false,q2=false,q3=false,t1=false,t2=false,t3=false,assgn=false;

    /*public void initialize(URL location, ResourceBundle resources) {
        lab1.setText(ocrpath);
    }*/
    public void funn(ActionEvent event) throws Exception{
        System.out.println("Button pressed");
        ocrpath=txt2.getText();
        if( var==true){
            System.out.println(var);
            var=false;
            //cb1.
            cb1.setDisable(false);
            cb2.setDisable(false);
            cb3.setDisable(false);
            cb4.setDisable(false);
            cb5.setDisable(false);
            cb6.setDisable(false);
            cb7.setDisable(false);
            cb1.setSelected(false);
            cb2.setSelected(false);
            cb3.setSelected(false);
            cb4.setSelected(false);
            cb5.setSelected(false);
            cb6.setSelected(false);
            cb7.setSelected(false);

            q1=cb1.isSelected();
            q2=cb2.isSelected();
            q3=cb3.isSelected();
            t1=cb4.isSelected();
            t2=cb5.isSelected();
            t3=cb6.isSelected();
            assgn=cb7.isSelected();
        }
        else if( var==false){
            System.out.println(var);
            var=true;
            cb1.setSelected(true);
            cb2.setSelected(true);
            cb3.setSelected(true);
            cb4.setSelected(true);
            cb5.setSelected(true);
            cb6.setSelected(true);
            cb7.setSelected(true);
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

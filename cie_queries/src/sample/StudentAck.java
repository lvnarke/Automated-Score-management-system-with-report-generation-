package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.ResourceBundle;

public class StudentAck implements Initializable {
    public ComboBox picker;
    public TextArea msg;

    public void initialize(URL location, ResourceBundle resources)  {
        int i=0;
        picker.getItems().removeAll(picker.getItems());
        // comboBox.getItems().addAll("V Sem A Section ", "III Sem B Section", "I Sem C Section");
        while(i < Controller.class_values.size()){
            //System.out.println(Controller.arrayList.get(i));
            picker.getItems().add(""+Controller.class_values.get(i));
            i++;
        }
        picker.getSelectionModel().select("Select Teacher ID ");

    }
    public void selection(){
        picker.getSelectionModel();
        String sel=(String)picker.getValue();
        System.out.println(sel);
    }
    public void send(ActionEvent event){
        String message=msg.getText();
        System.out.println("This message is to be sent: "+message);
    }

}

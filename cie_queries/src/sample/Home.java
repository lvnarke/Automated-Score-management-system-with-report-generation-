package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Home  implements Initializable{

   static Stage stage2 = new Stage();
   static Stage stage3 = new Stage();
    Connection conn;
    Statement st = null;
    public ComboBox comboBox;
    public Label lb1;

   /* ObservableList<String> options =

            FXCollections.observableArrayList(
                    "Option 1",
                    "Option 2",
                    "Option 3"
            );
    band.setItems(options);*/



    public void initialize(URL location, ResourceBundle resources)  {

        int i=0;
        comboBox.getItems().removeAll(comboBox.getItems());
      // comboBox.getItems().addAll("V Sem A Section ", "III Sem B Section", "I Sem C Section");
        while(i < Controller.arrayList.size()){
            //System.out.println(Controller.arrayList.get(i));
            comboBox.getItems().add(""+Controller.arrayList.get(i));
            i++;
        }
       comboBox.getSelectionModel().select("Select Section");
       lb1.setText(Controller.first_name.toUpperCase());
       // lb1.setText(Controller.username.toUpperCase());
        //Main m = new Main();
    }

    public void select(){
         comboBox.getSelectionModel();
         String sel=(String)comboBox.getValue();
         System.out.println(sel);
    }

    public void fun3(ActionEvent event) throws Exception {
       // Controller.stage7.close();
        System.out.println("OCR page");
        Parent root = FXMLLoader.load(getClass().getResource("screen4.fxml"));
        stage2.setScene(new Scene(root, 1108, 693));
        stage2.show();
       // Dummy dummyv = new Dummy();
      //  dummyv.function();

    }
    public void fun4(ActionEvent event) throws Exception {
       // Controller.stage7.close();
        System.out.println("Report page");
        Parent root = FXMLLoader.load(getClass().getResource("screen5.fxml"));
        stage3.setScene(new Scene(root, 1267, 653));
        stage3.show();
    }




}

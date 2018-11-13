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
import sample.screens.notifdb;

import java.awt.Desktop;
import java.net.URI;
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
    public Label n1;
    public Label n2;
    public Label n3;
    public Label n4;
    public Label n5;
    public Label n6;
    public Label n7;
    public Label msg1;
    public Label msg2;
    public Label msg3;
    public Label msg4;
    public Label msg5;
    public Label msg6;
    public Label msg7;


   /* ObservableList<String> options =

            FXCollections.observableArrayList(
                    "Option 1",
                    "Option 2",
                    "Option 3"
            );
    band.setItems(options);*/



    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("V Sem A Section ", "III Sem B Section", "I Sem C Section");
        comboBox.getSelectionModel().select("V Sem A Section ");
        lb1.setText(Controller.username.toUpperCase());
        String id=Controller.username;// id has to be set with the usn or primary key
        notifdb con =new notifdb();
        con.collection=con.database.getCollection(id);
        con.get_Msgs(con.collection);
        n1.setText(con.Senderlist.get(0));
        n2.setText(con.Senderlist.get(1));
        n3.setText(con.Senderlist.get(2));
        n4.setText(con.Senderlist.get(3));
        n5.setText(con.Senderlist.get(4));
        n6.setText(con.Senderlist.get(5));
        n7.setText(con.Senderlist.get(6));
        msg1.setText(con.Msglist.get(0));
        msg2.setText(con.Msglist.get(1));
        msg3.setText(con.Msglist.get(2));
        msg4.setText(con.Msglist.get(3));
        msg5.setText(con.Msglist.get(4));
        msg6.setText(con.Msglist.get(5));
        msg7.setText(con.Msglist.get(6));

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
    public void chromeapi (ActionEvent event) throws Exception
    {
        Desktop d= Desktop.getDesktop();
        try{
            d.browse(new URI("https://app.powerbi.com/groups/me/reports/18f4e9f0-2183-4011-a6df-120ffcb217d6/ReportSection"));
        }
        catch (java.net.URISyntaxException e)
        {}
        catch(java.io.IOException e2)
        {}
    }



}

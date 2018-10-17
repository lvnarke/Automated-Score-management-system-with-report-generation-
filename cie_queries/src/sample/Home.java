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
import java.util.ResourceBundle;

public class Home  implements Initializable{

    public static Stage stage2 = new Stage();
    public static Stage stage3 = new Stage();
    public ComboBox comboBox;
    public Label lb1;
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
        //Main m = new Main();
    }

    public void select(){
         comboBox.getSelectionModel();
         String sel=(String)comboBox.getValue();
         System.out.println(sel);
    }

    public void fun3(ActionEvent event) throws Exception {
       // stage3.close();
        System.out.println("Button pressed");
        Parent root = FXMLLoader.load(getClass().getResource("screen4.fxml"));
        stage2.setScene(new Scene(root, 1108, 693));
        stage2.show();

    }
    public void fun4(ActionEvent event) throws Exception {
       // stage2.close();
        System.out.println("Button pressed");
        Parent root = FXMLLoader.load(getClass().getResource("screen5.fxml"));
        stage3.setScene(new Scene(root, 1161, 653));
        stage3.show();
    }


}

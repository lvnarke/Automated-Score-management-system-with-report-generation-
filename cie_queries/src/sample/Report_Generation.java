package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Report_Generation {



   Stage stage2 = new Stage();
   Stage stage3 = new Stage();
   public void btn1_fun(ActionEvent event) throws Exception {
       stage3.close();
       System.out.println("Button pressed");
       Parent root = FXMLLoader.load(getClass().getResource("screen7.fxml"));
       stage2.setScene(new Scene(root, 1420, 700));
       stage2.show();
   }
    public void btn2_fun(ActionEvent event) throws Exception {
        stage2.close();
        System.out.println("Button pressed");
        Parent root = FXMLLoader.load(getClass().getResource("screen5.fxml"));
        stage3.setScene(new Scene(root, 1420, 700));
        stage3.show();
    }
}

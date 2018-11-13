package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentHome {
    static Stage stage4 = new Stage();
    static Stage stage5 = new Stage();
    public void fun3(ActionEvent event) throws Exception {
        stage4.close();
        System.out.println("Student ACK");
        Parent root = FXMLLoader.load(getClass().getResource("student_ack.fxml"));
        stage5.setScene(new Scene(root, 1108, 693));
        stage5.show();


    }
    public void fun4(ActionEvent event) throws Exception {
        stage5.close();
        System.out.println("Report page for Student");
        Parent root = FXMLLoader.load(getClass().getResource("screen5.fxml"));
        stage4.setScene(new Scene(root, 1267, 653));
        stage4.show();
    }
}

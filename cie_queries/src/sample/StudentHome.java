package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//import java.awt.*;
import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentHome implements Initializable {

    static Stage stage4 = new Stage();
    static Stage stage5 = new Stage();
    public Label lb1;
    public void initialize(URL location, ResourceBundle resources) {
        lb1.setText(Controller.first_name.toUpperCase());
    }
    public void fun3(ActionEvent event) throws Exception {
        stage4.close();
        System.out.println("Student ACK");
        Parent root = FXMLLoader.load(getClass().getResource("student_ack.fxml"));
        stage5.setScene(new Scene(root, 300, 400));
        stage5.show();


    }
    public void fun4(ActionEvent event) throws Exception {
        stage5.close();
        System.out.println("Report page for Student");
        Parent root = FXMLLoader.load(getClass().getResource("screen5.fxml"));
        stage4.setScene(new Scene(root, 1267, 653));
        stage4.show();
    }
    public void chromeapi_student (ActionEvent event) throws Exception
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

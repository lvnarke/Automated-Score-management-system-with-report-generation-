package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    Connection conn;
    Statement st = null;
     Stage stage2 = new Stage();
    public TextField txt;
    public PasswordField pass;
    public static String username="";
    public static String password="";

    public Controller(){
        conn=sqlConnection.Connector(dbType.MYSQLDB);
        if(conn ==null) System.exit(1);
    }
    public void fun1(ActionEvent event) throws Exception {
        System.out.println("Button pressed");
         username=txt.getText().toLowerCase();
         password = pass.getText().toLowerCase();
        System.out.println(username+" "+password);
        Parent root = FXMLLoader.load(getClass().getResource("screen2.fxml"));
        stage2.setScene(new Scene(root, 1420, 700));
        stage2.show();
       // stage2.close();
    }
    public void find(String uname ,String pass) throws SQLException {
        String sql = "SELECT `first_name`, `last_name` FROM `cie`.`teacher` WHERE `username` is uname, `password` is pass";
        ResultSet rs = conn.createStatement().executeQuery(sql);
    }

}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
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
    public int flag=0,auxillary_flag=0;
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
         find(username,password);
        System.out.println(username+" "+password);
      if(auxillary_flag==0) {
          Parent root = FXMLLoader.load(getClass().getResource("screen2.fxml"));
          stage2.setScene(new Scene(root, 1250, 653));
          stage2.setResizable(false);
          stage2.show();
      }
       // stage2.close();
    }
    public void find(String uname ,String pass) throws SQLException {
        String sql = "SELECT * FROM `cie`.`teacher`";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            String s1=rs.getString("username");
            String s2=rs.getString("password");
            if(s1.equals(uname) && s2.equals(pass))
                    flag=1;
        }

        String sql2= "SELECT * FROM `cie`.`student_table`";
        ResultSet rs2=conn.createStatement().executeQuery(sql2);
        while(rs2.next() && flag!=1){
            String s1=rs.getString("USN");
            if(s1.equals(uname) && s1.equals(pass))
                flag=2;
        }
        /*if(flag==0){
            auxillary_flag=1;
            Dialog d = new Alert(Alert.AlertType.INFORMATION, "Incorrect Username or Password");
            d.show();
        }*/
    }

}

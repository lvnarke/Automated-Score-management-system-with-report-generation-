package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {
    Connection conn;
    Statement st = null;
     Stage stage2 = new Stage();
     Stage stage3 = new Stage();
    public TextField txt;
    public PasswordField pass;
    public Label label;
    private int flag=0,auxillary_flag=0;
    public static String username="";
    public static String password="";
    public static String first_name="";
    public static String last_name="";
    public static String class_val="";
    public static ArrayList<String> class_values = new ArrayList<String>();
    public static ArrayList<String> arrayList = new ArrayList<String>();
    public Controller(){
        conn=sqlConnection.Connector(dbType.MYSQLDB);
        if(conn ==null) System.exit(1);
    }
    public void fun1(ActionEvent event) throws Exception {
        System.out.println("Button pressed");
         username=txt.getText().toUpperCase();
         password = pass.getText().toUpperCase();
         find(username,password);
        System.out.println(username+" "+password);
        if(flag==1){
            //System.out.println("Flag is set to 1");
            search(username,password);
        }
        if(flag==2){
            search1();
        }
      if(flag==1) {
          Parent root = FXMLLoader.load(getClass().getResource("screen2.fxml"));
          stage2.setScene(new Scene(root, 1250, 653));
          stage2.setResizable(false);
          stage2.show();
      }
      else if(flag==2){
          Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
          stage3.setScene(new Scene(root, 1250, 653));
          stage3.setResizable(false);
          stage3.show();
      }

       // stage2.close();
    }
    private void find(String uname ,String pass) throws SQLException {
        String sql = "SELECT * FROM `cie`.`teacher`";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        System.out.println("Teacher");
        while(rs.next()){
            System.out.println("Teacher");
            String s1=rs.getString(1);
            String s2=rs.getString(2);
            if(s1.equals(uname) && s2.equals(pass))
            {   flag=1;
                first_name=rs.getString("first_name");
                last_name=rs.getString("last_name");

            }
        }

        String sql2= "SELECT * FROM `cie`.`student_table`";
        ResultSet rs2=conn.createStatement().executeQuery(sql2);
        System.out.println("Student");
        while(rs2.next() && flag!=1){
            System.out.println("Student");
            String s1=rs2.getString(1);
            if(s1.equals(uname) && s1.equals(pass)) {
                flag = 2;
                first_name=rs2.getString("first_name");
                last_name=rs2.getString("last_name");
                class_val=rs2.getString("class");
            }
        }

        if(flag==0){
            auxillary_flag=1;
           label.setText("Invalid Username or Password");
        }

    }
    private void search(String uname ,String pass) throws SQLException {
        String sql = "SELECT * FROM `cie`.`teacher`";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            String s1=rs.getString(1);
            String s2 = rs.getString(2);
            if(s1.equals(uname)&&s2.equals(pass)){

                arrayList.add(""+rs.getString("class-1"));
                arrayList.add(""+rs.getString("class-2"));
                arrayList.add(""+rs.getString("class-3"));

                }
        }

        //System.out.println(arrayList);
        //System.out.println(first_name+" "+last_name);
    }
    private void search1() throws Exception{

        String sql = "SELECT * FROM `cie`.`teacher`";
        ResultSet rs1 = conn.createStatement().executeQuery(sql);
        while(rs1.next()){
            String s1 = rs1.getString("class-1");
            String s2 = rs1.getString("class-2");
            String s3 = rs1.getString("class-3");
            if(s1.equals(class_val)||s2.equals(class_val)||s3.equals(class_val))
                class_values.add(""+rs1.getString("TID"));
        }
        System.out.println(class_values);
    }

}

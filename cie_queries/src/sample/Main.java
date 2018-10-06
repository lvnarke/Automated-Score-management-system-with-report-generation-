package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Automated Score Management System");
        primaryStage.setScene(new Scene(root, 1420, 700));

        Connection conn=sqlConnection.Connector(dbType.MYSQLDB);

        System.out.println(conn);
        if(conn == null)
            System.out.println("Connection failed");
        else
            System.out.println("Connection sucessfull");
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

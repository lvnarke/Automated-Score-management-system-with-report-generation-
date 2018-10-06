package sample;

import java.sql.DriverManager;
import java.sql.Connection;

public class sqlConnection {
    public static Connection Connector(dbType db)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cie","root","Root@123");
            return conn;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}

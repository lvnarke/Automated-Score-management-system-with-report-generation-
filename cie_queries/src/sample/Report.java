package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Report {

    Connection conn;
    Statement st = null;
    String str=Controller.username;
    ArrayList<String> al = new ArrayList<String>();

    public Report(){
        conn=sqlConnection.Connector(dbType.MYSQLDB);
        if(conn ==null) System.exit(1);
    }

    public void retreiveinfo() throws SQLException {

        String sql = "SELECT * FROM `cie`.`quiz_t`";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            while (rs.next()) {
                String q = rs.getString("USN-1");
                if (str.equals(q)) {
                    al.add(rs.getString("c_code-1"));
                   al.add(rs.getString("Q1"));
                   al.add(rs.getString("Q2"));
                   al.add(rs.getString("Q3"));


                }
            }
        }

        String sql1 = "SELECT * FROM `cie`.`test_t`";
        ResultSet rs1 = conn.createStatement().executeQuery(sql1);
        while(rs1.next()){
            while (rs1.next()) {
                String q = rs1.getString("USN");
                if (str.equals(q)) {
                    al.add(rs.getString("c_code"));
                    al.add(rs.getString("T1"));
                    al.add(rs.getString("T2"));
                    al.add(rs.getString("T3"));


                }
            }
        }

    }

}

package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Report {

    Connection conn;
   // Statement st = null;
    String str=Controller.username;
    ArrayList al = new ArrayList();
    ArrayList al1 = new ArrayList();
    private float usn_total=0,course_total=0;
    private float f1=0,f2=0;

    public Report(){
        conn=sqlConnection.Connector(dbType.MYSQLDB);
        if(conn ==null) System.exit(1);
    }

    public void retreiveInfo_usn() throws SQLException {

        String sql = "SELECT * FROM `cie`.`quiz_t`";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            while (rs.next()) {
                String q = rs.getString("USN-1");
                if (str.equals(q)) {

                    al.add(rs.getString("USN-1"));
                    al.add(rs.getFloat("Q1"));
                    al.add(rs.getFloat("Q2"));
                    al.add(rs.getFloat("Q3"));

                   usn_total += rs.getFloat("Q1") + rs.getFloat("Q2")+ rs.getFloat("Q3");
                   break;


                }
            }
        }

        String sql1 = "SELECT * FROM `cie`.`test_t`";
        ResultSet rs1 = conn.createStatement().executeQuery(sql1);
        while(rs1.next()){
            while (rs1.next()) {
                String q = rs1.getString("USN");
                if (str.equals(q)) {
                    al.add(rs1.getString("USN"));
                    al.add(rs1.getFloat("T1"));
                    al.add(rs1.getFloat("T2"));
                    al.add(rs1.getFloat("T3"));

                    usn_total += rs.getFloat("T1")+rs.getFloat("T2") +rs.getFloat("T3");
                    break;


                }
            }
        }
        String sql2="SELECT * FROM `cie`.`assgn-lab`";

        ResultSet rs2= conn.createStatement().executeQuery(sql2);
        while(rs2.next()){
            String q=rs2.getString("stud_usn");
            if(str.equals(q)){

                al.add(rs2.getString("stud_usn"));
                al.add(rs2.getFloat("assignment"));
                al.add(rs2.getFloat("lab"));
                al.add(rs2.getFloat("selfstudy"));
              //  float assgn=rs2.getFloat("assignment");
               // float self=rs2.getFloat("selfstudy");
                usn_total += rs2.getFloat("assignment")+rs2.getFloat("lab")+rs2.getFloat("selfstudy");

                break;

            }
        }
    }

    public void retrieveInfo_course() throws SQLException{

        String sql = "SELECT * FROM `cie`.`quiz_t`";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while(rs.next()){
            while (rs.next()) {
                String q = rs.getString("c_code-1");
                if (str.equals(q)) {

                    al1.add(rs.getString("c_code-1"));
                    al1.add(rs.getFloat("Q1"));
                    al1.add(rs.getFloat("Q2"));
                    al1.add(rs.getFloat("Q3"));

                    course_total += rs.getFloat("Q1") + rs.getFloat("Q2")+ rs.getFloat("Q3");
                    break;


                }
            }
        }

        String sql1 = "SELECT * FROM `cie`.`test_t`";
        ResultSet rs1 = conn.createStatement().executeQuery(sql1);
        while(rs1.next()){
            while (rs1.next()) {
                String q = rs1.getString("c_code");
                if (str.equals(q)) {
                    al1.add(rs1.getString("c_code"));
                    al1.add(rs1.getFloat("T1"));
                    al1.add(rs1.getFloat("T2"));
                    al1.add(rs1.getFloat("T3"));

                    course_total += rs.getFloat("T1")+rs.getFloat("T2") +rs.getFloat("T3");
                    break;


                }
            }
        }
        String sql2="SELECT * FROM `cie`.`assgn-lab`";

        ResultSet rs2= conn.createStatement().executeQuery(sql2);
        while(rs2.next()){
            String q=rs2.getString("course-code");
            if(str.equals(q)){
                al1.add(rs2.getString("course-code"));
                al1.add(rs2.getFloat("assignment"));
                al1.add(rs2.getFloat("lab"));
                course_total += rs2.getFloat("assignment")+ rs2.getFloat("lab")+rs2.getFloat("selfstudy");

                break;

            }
        }
    }

}

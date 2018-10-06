package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    Connection conn;
    Statement st = null;


    public Insert(){
        conn=sqlConnection.Connector(dbType.MYSQLDB);
        if(conn ==null) System.exit(1);
    }

    public void insertinfo(String usn,String first_name, String last_name, String year, String phno) throws SQLException{

        st = conn.createStatement();
        PreparedStatement ps = null;

        String Query="INSERT INTO `cie`.`student_table` (`USN`, `first_name`, `last_name`, `year`, `phno`) VALUES (?, ?, ?, ?, ?)";
        try {
            ps=conn.prepareStatement(Query);

            ps.setString(1,usn);
            ps.setString(2,first_name);
            ps.setString(3,last_name);
            ps.setString(4,year);
            ps.setString(5,phno);

            }
        catch (Exception e){
            System.out.println("Hello "+e);
            // System.out.println("Insertion of data failed");
        }
        finally {
            ps.execute();
            ps.close();
        }
    }

    public void insertintoquiz(String q1, String q2, String q3,String usn, String ccode) throws SQLException{
        st = conn.createStatement();
        PreparedStatement ps = null;

        String query="INSERT INTO `cie`.`quiz_t` (`Q1`, `Q2`, `Q3`, `USN-1`, `c_code-1`) VALUES (?, ?, ?, ?, ?)";
        try {
            ps=conn.prepareStatement(query);

            ps.setString(1,q1);
            ps.setString(2,q2);
            ps.setString(3,q3);
            ps.setString(4,usn);
            ps.setString(5,ccode);

        }
        catch (Exception e){
            System.out.println("Hello "+e);

        }
        finally {
            ps.execute();
            ps.close();
        }
    }

    public void insertintotest(String t1, String t2, String t3,String usn, String ccode) throws SQLException{
        st = conn.createStatement();
        PreparedStatement ps = null;

        String query="INSERT INTO `cie`.`test_t` (`T1`, `T2`, `T3`, `USN`, `c_code`) VALUES (?, ?, ?, ?, ?)";
        try {
            ps=conn.prepareStatement(query);

            ps.setString(1,t1);
            ps.setString(2,t2);
            ps.setString(3,t3);
            ps.setString(4,usn);
            ps.setString(5,ccode);

        }
        catch (Exception e){
            System.out.println("Hello "+e);

        }
        finally {
            ps.execute();
            ps.close();
        }
    }
    }



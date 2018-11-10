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

    public void insertinfo(String usn,String first_name, String last_name, int semester, String section) throws SQLException{

        st = conn.createStatement();
        PreparedStatement ps = null;

        String Query="INSERT INTO `cie`.`student_table` (`USN`, `first_name`, `last_name`, `semester`, `section`) VALUES (?, ?, ?, ?, ?)";
        try {
            ps=conn.prepareStatement(Query);

            ps.setString(1,usn);
            ps.setString(2,first_name);
            ps.setString(3,last_name);
            ps.setInt(4,semester);
            ps.setString(5,section);

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

    public void insertintoquiz(String usn, String ccode,float q1, float q2, float q3) throws SQLException{
        st = conn.createStatement();
        PreparedStatement ps = null;

        String query="INSERT INTO `cie`.`quiz_t` (`USN-1`, `c_code-1`, `Q1`, `Q2`, `Q3`) VALUES (?, ?, ?, ?, ?)";
        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,usn);
            ps.setString(2,ccode);
            ps.setFloat(3,q1);
            ps.setFloat(4,q2);
            ps.setFloat(5,q3);


        }
        catch (Exception e){
            System.out.println("Hello "+e);

        }
        finally {
            ps.execute();
            ps.close();
        }
    }

    public void insertintotest(String usn, String ccode,float t1, float t2, float t3) throws SQLException{
        st = conn.createStatement();
        PreparedStatement ps = null;

        String query="INSERT INTO `cie`.`test_t` (`USN`, `c_code`, `T1`, `T2`, `T3`) VALUES (?, ?, ?, ?, ?)";
        try {
            ps=conn.prepareStatement(query);
            ps.setString(1,usn);
            ps.setString(2,ccode);
            ps.setFloat(3,t1);
            ps.setFloat(4,t2);
            ps.setFloat(5,t3);


        }
        catch (Exception e){
            System.out.println("Hello "+e);

        }
        finally {
            ps.execute();
            ps.close();
        }
    }
    public void insertintocourse(String ccode,String cname) throws SQLException{
        st = conn.createStatement();
        PreparedStatement ps = null;

        String query="INSERT INTO `cie`.`course` (`c_code`, `c_name`) VALUES (?, ?)";
        try {
            ps=conn.prepareStatement(query);

            ps.setString(1,ccode);
            ps.setString(2,cname);


        }
        catch (Exception e){
            System.out.println("Hello "+e);

        }
        finally {
            ps.execute();
            ps.close();
        }
    }
    public void insertintoassgn(String ccode,String usn,float assignment,float lab,float selfstudy) throws SQLException{
        st = conn.createStatement();
        PreparedStatement ps = null;

        String query="INSERT INTO `cie`.`assgn-lab` (`course-code`, `stud_usn`, `assignment`, `lab`, `selfstudy`) VALUES (?, ?, ?, ?, ?)";
        try {
            ps=conn.prepareStatement(query);

            ps.setString(1,ccode);
            ps.setString(2,usn);
            ps.setFloat(3,assignment);
            ps.setFloat(4,lab);
            ps.setFloat(5,selfstudy);



        }
        catch (Exception e){
            System.out.println("Hello "+e);

        }
        finally {
            ps.execute();
            ps.close();
        }
    }
    public void insertintoco(String usn,String ccode,float co1,float co2,float co3, float co4) throws SQLException{
        st = conn.createStatement();
        PreparedStatement ps = null;

        String query="INSERT INTO `cie`.`co-po` (`usn_co`, `ccode_co`, `CO1`, `CO2`, `CO3`, `CO4`) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps=conn.prepareStatement(query);

            ps.setString(1,ccode);
            ps.setString(2,usn);
            ps.setFloat(3,co1);
            ps.setFloat(4,co2);
            ps.setFloat(5,co3);
            ps.setFloat(6,co4);

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



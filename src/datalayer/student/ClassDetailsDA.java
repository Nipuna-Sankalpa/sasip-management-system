/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.student;

import com.sun.rowset.CachedRowSetImpl;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import model.student.Student;
import utilities.DBConnection;
import utilities.DBHandler;
import utilities.AddRecordException;

/**
 *
 * @author Yellow Flash
 */
public class ClassDetailsDA {
    private static ClassDetailsDA classDetails;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement statement;

    public static ClassDetailsDA getInstance(){
        if(classDetails == null)
            classDetails = new ClassDetailsDA();
        
        return classDetails;
    }
    public  boolean addRecord(Student student) throws SQLException, ClassNotFoundException, FileNotFoundException, AddRecordException {
        con = DBConnection.getConnection();
        int i;

        con.setAutoCommit(false);
        String query = "INSERT INTO classdetail (studentID,classID) values (?,?)";
        statement = con.prepareStatement(query);
        statement.setString(1, student.getStudentID());
        for (i = 0; i < student.getClasses().size(); i++) {
            statement.setString(2, student.getClasses().get(i));
            statement.addBatch();
        }
        if (i == student.getClasses().size()) {
            statement.executeBatch();
            con.commit();
            con.close();
            return true;
        } else {
            con.rollback();
            con.close();
            throw new AddRecordException();
        }

    }

    public  int updateRecord(String studentID, String classID) throws ClassNotFoundException, SQLException, FileNotFoundException {
        con = DBConnection.getConnection();
        String query = "UPDATE classdetail SET classID='" + classID + "' WHERE studentID='" + studentID + "'";
        int temp = DBHandler.setData(con, query);

        con.close();

        return temp;
    }

    public  int deleteRecord(String studentID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM classdetail WHERE studentID='" + studentID + "'";
        int temp = DBHandler.setData(con, query);
        con.close();

        return temp;
    }
    public  int deleteRecord(String studentID,String classID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM classdetail WHERE studentID='" + studentID + "' AND classID='"+classID+"'";
        int temp = DBHandler.setData(con, query);
        con.close();

        return temp;
    }
//pass studentID.stuedntID can be found by searching student method

    public  CachedRowSetImpl searchRecord(String studentID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        CachedRowSetImpl rs=new CachedRowSetImpl();
        String query = "SELECT * FROM employee WHERE " + studentID;
        rs.populate(DBHandler.getData(con, query));
        con.close();
        return rs;

    }
}

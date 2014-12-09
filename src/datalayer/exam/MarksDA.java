/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.exam.StudentMark;
import utilities.DBConnection;
import utilities.DBHandler;
import utilities.AddRecordException;

/**
 *
 * @author Mampitiya
 */
public class MarksDA {

    private static Connection con;
    private static PreparedStatement statement;
//if the commit failed throw an enter mark exception

    public int addMarks(String examID,StudentMark studentMark) throws SQLException, ClassNotFoundException, AddRecordException {
        con = DBConnection.getConnection();
        String query = "INSERT INTO marks (studentID,examID,marks) values (?,?,?)";
        statement = con.prepareStatement(query);
        statement.setString(1, studentMark.getStudentID());
        statement.setString(2, examID);
        statement.setDouble(3, studentMark.getMarks()); 
        int temp = statement.executeUpdate();
        con.close();
        return temp ;
        }
      
    public int updateMarks(StudentMark studentMark, String examID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String query = "UPDATE marks SET marks=? WHERE examID='" + examID + "' and studentID=?";
        statement = con.prepareStatement(query);
        statement.setDouble(1, studentMark.getMarks());

        statement.setString(2, studentMark.getStudentID());

        int temp = statement.executeUpdate();
        con.close();

        return temp;
    }
   
    public ResultSet retrieveSingleStudentMarks(String examID,String studentID) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        con = DBConnection.getConnection();
        String query = "SELECT * FROM marks WHERE StudentID='" + studentID + "' and examID='" + examID +"'" ;
        rs = DBHandler.getData(con, query);
        return rs;
    }

    public ResultSet retrieveSingleExamMarks(String examID) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        con = DBConnection.getConnection();
        String query = "SELECT StudentID,marks FROM marks WHERE examID  ='" + examID + "'";
        rs = DBHandler.getData(con, query);
        return rs;
    }

    public int deleteExamMarks(String examID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM marks WHERE examID='" + examID + "'";
        int temp = DBHandler.setData(con, query);
        con.close();

        return temp;
    }

    public int deleteStudentMarks(String studentID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM marks WHERE studentID='" + studentID + "'";
        int temp = DBHandler.setData(con, query);
        con.close();
        return temp;
    }

    public int deleteOneRecord(String examID, String studentID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM marks WHERE studentID='" + studentID + "' and examID='" + examID + "'";
        int temp = DBHandler.setData(con, query);
        con.close();

        return temp;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.student;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.employee.Employee;
import model.student.EarlyLeaveRecord;
import utilities.DBConnection;
import utilities.DBHandler;
import utilities.DBImageHandler;

/**
 *
 * @author Mampitiya
 */
public class EarlyLeavingDA {

    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement statement;
    private static EarlyLeavingDA earlyLeavingDA = null;
//date has to be entered in leaving record.

    private EarlyLeavingDA() {
    }

    public static EarlyLeavingDA getInstance() {
        if (earlyLeavingDA == null) {
            earlyLeavingDA = new EarlyLeavingDA();
        }
        return earlyLeavingDA;
    }

    public int addRecord(EarlyLeaveRecord record) throws SQLException, ClassNotFoundException, FileNotFoundException {
        con = DBConnection.getConnection();
        int temp;
        String query = "INSERT INTO specialInfo (classID,reason,studentID,date) values(?,?,?,?);";
        statement = con.prepareStatement(query);
        statement.setString(1, record.getClassId());
        statement.setString(2, record.getReason());
        statement.setString(3, record.getStudentId());
        statement.setDate(4, null);
        statement.executeUpdate();
        temp = statement.executeUpdate();

        con.close();
        return temp;
    }

    public int updateRecord(String studentID, String classID, String updatedReason, Date date) throws ClassNotFoundException, SQLException, FileNotFoundException {
        con = DBConnection.getConnection();
        String query = "UPDATE specialInfo SET classID=?,studentID=?,reason=?,date=?";
        int temp;
        statement.setString(1, classID);
        statement.setString(2, studentID);
        statement.setString(3, updatedReason);
        statement.setDate(4, date);
        temp = statement.executeUpdate();

        con.close();

        return temp;
    }

    public int deleteRecord(int entry) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM specialInfo WHERE entryID='" + entry + "'";
        int temp = DBHandler.setData(con, query);
        con.close();

        return temp;
    }

    public ResultSet searchRecord(String studentID, String classID, Date date) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String temp = null;
        if (studentID != null && classID != null && date != null) {
            temp = "studentID='" + studentID + "' and classID='" + classID + "' and date='" + date + "'";
        } else if (studentID != null) {
            temp = "studentID='" + studentID + "'";
        } else if (classID != null) {
            temp = "classID='" + classID + "'";
        } else if (date != null) {
            temp = "date='" + date + "'";
        }
        String query = "SELECT * FROM specialInfo WHERE " + temp;
        rs = DBHandler.getData(con, query);
        return rs;

    }

}

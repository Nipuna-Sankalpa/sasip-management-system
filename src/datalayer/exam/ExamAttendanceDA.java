/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.exam;

import datalayer.student.AttendanceDA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import model.student.Attendance;
import model.student.AttendanceSheet;
import utilities.AddRecordException;
import utilities.DBConnection;

/**
 *
 * @author Yellow Flash
 */
public class ExamAttendanceDA {

    private static ExamAttendanceDA examAttendanceData=null;
    private static Connection con;
    private PreparedStatement statement;
    
    
    private ExamAttendanceDA(){}
    
    public static ExamAttendanceDA getInstance(){
        if (examAttendanceData==null) {
            examAttendanceData=new ExamAttendanceDA();
        }
    return examAttendanceData;
    }

    public boolean addAttendance(AttendanceSheet sheet) throws SQLException, ClassNotFoundException, AddRecordException {
        con = DBConnection.getConnection();
        Iterator<Attendance> it = sheet.iterator();
        Attendance record;
        String query = "INSERT INTO attendanceexam (examID,date,employeeID,studentID,time) values (?,?,?,?,?)";
        con.setAutoCommit(false);
        statement = con.prepareStatement(query);

        while (it.hasNext()) {
            record = it.next();
            statement.setString(1, record.getClassID());
            statement.setDate(2, sheet.getDate());
            statement.setString(3, record.getEmployeeID());
            statement.setString(4, record.getStudentId());
            statement.setTime(5, record.getTime());
            statement.addBatch();
            System.out.println(statement);
        }

        if (!it.hasNext()) {
            statement.executeBatch();
            con.commit();
            return true;
        } else {
            con.rollback();
            throw new AddRecordException();
        }

    }

}

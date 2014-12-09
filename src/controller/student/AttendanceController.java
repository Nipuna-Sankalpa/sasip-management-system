/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.student;

import com.sun.rowset.CachedRowSetImpl;
import datalayer.exam.ExamAttendanceDA;
import datalayer.student.AttendanceDA;
import datalayer.student.EarlyLeavingDA;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.student.Attendance;
import model.student.AttendanceSheet;
import model.student.EarlyLeaveRecord;
import utilities.AddRecordException;
import utilities.ComboBoxUtility;


/**
 *
 * @author Pubudu
 */
public class AttendanceController {//act as the controller that handles messages from the view layer to data access layer
                                   //and vice versa.
    AttendanceDA attendanceData;
    ExamAttendanceDA examAttendanceData;
    EarlyLeavingDA earlyLeavingDA;

    public AttendanceController() {
        this.attendanceData = AttendanceDA.getInstance();
        this.examAttendanceData=ExamAttendanceDA.getInstance();
        this.earlyLeavingDA=EarlyLeavingDA.getInstance();
    }
    
    public boolean addAttendanceSheet(AttendanceSheet sheet) {
        boolean result = false;
        try {
            result = attendanceData.addAttendance(sheet);
        } catch (SQLException | ClassNotFoundException | AddRecordException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    public boolean addExamAttendanceSheet(AttendanceSheet sheet) {
        boolean result = false;
        try {
            result = examAttendanceData.addAttendance(sheet);
        } catch (SQLException | ClassNotFoundException | AddRecordException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    public void earlyLeaveManagement(EarlyLeaveRecord record) throws SQLException, ClassNotFoundException, FileNotFoundException{
    earlyLeavingDA.addRecord(record);
    }
    
    public String checkPreviousAttendance(String id, String classID){
        String status = "";
        try {
            CachedRowSetImpl records = attendanceData.retrieveSingleStudentMarks(id, classID);
            //System.out.println(id+" : "+classID);

            if(records.next())
                status = "Last attended: "+records.getString(3);
            else
                status = "Not available";
            //System.out.println(status);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
}

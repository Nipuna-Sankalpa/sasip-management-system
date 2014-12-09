/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.student;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.rowset.CachedRowSetImpl;
import datalayer.exam.ExamAttendanceDA;
import datalayer.student.AttendanceDA;
import datalayer.student.EarlyLeavingDA;
import datalayer.tution.TutionDA;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.student.Attendance;
import model.student.AttendanceSheet;
import model.student.EarlyLeaveRecord;
import model.tution.Tution;
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
    TutionDA tutionDA;

    public AttendanceController() {
        this.attendanceData = AttendanceDA.getInstance();
        this.examAttendanceData=ExamAttendanceDA.getInstance();
        this.earlyLeavingDA=EarlyLeavingDA.getInstance();
        this.tutionDA = new TutionDA();
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
                status = records.getString(3);
            else
                status = "Not available";
            //System.out.println(status);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public String[] getAvailableMakeUpClasses(String lastAttendance, String classID){
        ArrayList<String> list = new ArrayList<String>();
        String year = classID.substring(0, 4);
        
        if(!hasMissedPrevClass(lastAttendance))
            return new String[] { "" };
        
        System.out.println("year in getAvaiClasses: "+year);
        Tution[] classes = null;
        
        try {
            classes = tutionDA.searchByClassYear(year);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(classes.length);
        
        for (int i = 0; i < classes.length; i++) 
            list.add(classes[i].getId()+" on "+classes[i].getDay());
        
        return list.toArray(new String[0]);
    }
    
    public boolean hasMissedPrevClass(String dateTxt){
//        String[] arr = dateTxt.split("-");
//        Date date = new Date(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
        String format = "yyyy-MM-dd";
        
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(dateTxt);
        } catch (ParseException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(dateTxt);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        cal.setTimeInMillis(System.currentTimeMillis());
        
        System.out.println(cal.getTime());
        int currentWeek = cal.get(Calendar.WEEK_OF_YEAR);
        
        System.out.println("difference in weeks: "+currentWeek+", "+week);
        
        return (currentWeek - week) > 1;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.student;

import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;

/**
 *
 * @author Mampitiya
 */
public class Attendance {

    private String studentId;
    private Date date;
    private Time time;
    private String employeeID;
    private String classID;

    public String getEmployeeID() {
        return employeeID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public Attendance(String studentId, long currentTime, String employeeID) {
        this.studentId = studentId;
        this.employeeID = employeeID;
        date = new Date(currentTime);
        time = new Time(currentTime);
    }

    public String getStudentId() {
        return studentId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }
}

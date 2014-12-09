/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.employee;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Mampitiya
 */
public class WorkingDetail {//this is the model class for the working details of a single employee
    private String employeeID;
    private String classID;
    private Date date;
    private Time time;

    public WorkingDetail(String employeeID, String classID, Date date, Time time) {
        this.employeeID = employeeID;
        this.classID = classID;
        this.date = date;
        this.time = time;
    }

    public String getEmployeeID() {//getEmployeeID
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {//setEmployeeID
        this.employeeID = employeeID;
    }

    public String getClassID() {//getClassID
        return classID;
    }

    public void setClassID(String classID) {//setClassID
        this.classID = classID;
    }

    public Date getDate() {//getDate
        return date;
    }

    public void setDate(Date date) {//setDate
        this.date = date;
    }

    public Time getTime() {//getTime
        return time;
    }

    public void setTime(Time time) {//setTime
        this.time = time;
    }
    
    
}

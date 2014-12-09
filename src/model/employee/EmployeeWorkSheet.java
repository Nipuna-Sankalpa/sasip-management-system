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
 * @author Yellow Flash
 */
public class EmployeeWorkSheet {//this defines the model class for an EmployeeWorkSheet object
    private String employeeID;
    private Time time;
    private Date date;
    private String classID;
    private String entryID;

    public EmployeeWorkSheet(String employeeID, String classID) {//initialize the attibutes
        this.employeeID = employeeID;
        this.classID = classID;
        time=new Time(System.currentTimeMillis());
        date=new Date(System.currentTimeMillis());        
    }

   public EmployeeWorkSheet(String employeeID) {//initialize the attibutes
        this.employeeID = employeeID;
        time=new Time(System.currentTimeMillis());
        date=new Date(System.currentTimeMillis());
        /**************/
        this.classID = "2014M";
        /**************/
    }
    
    public String getEmployeeID() {//getEmployeeID
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {//setEmployeeID
        this.employeeID = employeeID;
    }

    public Time getTime() {//getTime
        return time;
    }

    public void setTime(Time time) {//setTime
        this.time = time;
    }

    public Date getDate() {//getDate
        return date;
    }

    public void setDate(Date date) {//setDate
        this.date = date;
    }

    public String getClassID() {//getClassID
        return classID;
    }

    public void setClassID(String classID) {//setClassID
        this.classID = classID;
    }

    public String getEntryID() {//getEntryID
        return entryID;
    }

    public void setEntryID(String entryID) {//setEntryID
        this.entryID = entryID;
    }
            
    
}

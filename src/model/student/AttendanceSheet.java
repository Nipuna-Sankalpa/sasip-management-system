/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Mampitiya
 */
public class AttendanceSheet implements Iterable{
    ArrayList<Attendance> records;
    Date date;
    String classID;

    public AttendanceSheet() {
        this.records = new ArrayList<>();
        date = new Date(System.currentTimeMillis());
    }
    
    public boolean addRecord(Attendance record){
        return records.add(record);
    }
    
    public Attendance getRecord(int index){
        return records.get(index);
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public Date getDate() {
        return date;
    }

    public String getClassType() {
        return classID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setClassType(String classType) {
        this.classID = classType;
    }
    
    @Override
    public Iterator iterator() {
        Iterator<Attendance> it = new Iterator<Attendance>() {

            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < records.size();
            }

            @Override
            public Attendance next() {
                return records.get(current++);
            }
        };
        return it;
    }
}

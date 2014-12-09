/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.exam;

/**
 *
 * @author Dilip
 */
public class StudentMark {
    private String studentID ;
    private double marks ;

    public StudentMark(String studentID, double marks) {
        this.studentID = studentID;
        this.marks = marks;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    
}

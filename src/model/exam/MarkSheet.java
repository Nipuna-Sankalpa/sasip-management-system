/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exam;

import java.util.ArrayList;

/**
 *
 * @author Mampitiya
 */
public class MarkSheet {

    private ArrayList<StudentMark> marksList;

    public ArrayList<StudentMark> getMarksList() {
        return marksList;
    }
    private String examID;

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public MarkSheet(String examID) {
        marksList = new ArrayList<StudentMark>();
        this.examID = examID;
    }

    public void addStudentMark(StudentMark studentMark) {
        marksList.add(studentMark);
    }

    public void deleteStudentMark(StudentMark studentMark) {
        marksList.remove(studentMark);
    }

    public StudentMark getStudentMark(int index) {
        return marksList.get(index);
    }

}

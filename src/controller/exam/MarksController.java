/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.exam;

import datalayer.exam.ExamDA;
import datalayer.exam.MarksDA ;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.exam.StudentMark;

/**
 *
 * @author Dilip
 */
public class MarksController {//act as the controller that handles messages from the view layer to data access layer
                                   //and vice versa.
    
    private MarksDA marksDA = new MarksDA();
    private ExamDA examDA=ExamDA.getInstance();
    
    public void addMarks(String examID,StudentMark studentMark) // add marks
    {
        try {
            marksDA.addMarks(examID, studentMark);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please update existing Student mark");
        }
 
    }
    
    public ResultSet retrieveSingleExamMarks(String examId) 
    {
        ResultSet rs = null ;
        try {
            rs = marksDA.retrieveSingleExamMarks(examId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       return rs ; 
    }
    public ResultSet searchAll()
    {
        ResultSet rs = null ;
        try {
            rs = examDA.searchAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       return rs ; 
    }
    public void updateMarks(StudentMark studentMark,String examID)
    {
        try {
            marksDA.updateMarks(studentMark,examID); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
    }
    public ResultSet retrieveSingleStudentMarks(String examID,String studentID)
    {
        ResultSet rs = null ;
        try {
            rs = marksDA.retrieveSingleStudentMarks(examID,studentID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       return rs ;
        
    }
    public void deleteOneRecord(String examID,String studentID)
    {
        try {
            marksDA.deleteOneRecord(examID, studentID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}

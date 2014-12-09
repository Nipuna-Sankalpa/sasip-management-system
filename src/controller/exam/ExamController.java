/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.exam;

import datalayer.exam.ExamDA;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.exam.Exam;
import net.proteanit.sql.DbUtils; 

/**
 *
 * @author Dilip
 */

public class ExamController {//act as the controller that handles messages from the view layer to data access layer
                             //and vice versa.
    
    private ExamDA examDA = ExamDA.getInstance();
    
    public void addExam(Exam exam) // adda new exam
    {
        try {
            examDA.addExam(exam);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public TableModel updateTable() // update table which return TableModel object
    {
        TableModel model = null ;
        try {
           model  =  DbUtils.resultSetToTableModel(examDA.searchAll()) ; 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
      return model ;
    }
    
    public void updateExam(Exam exam) // update existing exam
    {
        try {
            examDA.updateExam(exam);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    public ResultSet searchExam(String examID) // search a exam , this method return a result set which equals given examID
    {
        ResultSet rs = null;
        try {
            rs = examDA.searchExamID(examID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       return rs ; 
    }
    public void deleteExam(String examID) // delete a exam
    {
        try {
          examDA.deleteExam(examID);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e); 
        }
        
    }
    public ResultSet searchExamCount(String classYear) // search a exam , this method return a result set which equals given classYear 
    {
        ResultSet rs = null;
        try {
            rs = examDA.searchExamCount(classYear);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs ;
    }
}

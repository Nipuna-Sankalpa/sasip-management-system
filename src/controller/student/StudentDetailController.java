/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.student;

import datalayer.student.StudentDA;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.student.Student;
import view.student.AddStudent;
import view.student.DeleteStudent;
import view.student.EditStudent;
import view.student.SearchStudent;

/**
 *
 * @author Pubudu
 */
public class StudentDetailController {//act as the controller that handles messages from the view layer to data access layer
                                   //and vice versa.
    private Student studentModel;
    private AddStudent addView;
    private DeleteStudent deleteView;
    private EditStudent editView;
    private SearchStudent searchView;
    private StudentDA studentData;
    
    public StudentDetailController(){
        studentData = StudentDA.getInstance();
    }
    
    public int addStudent(Student student) {
        this.studentModel = student;
        int result = -1;
        try {
            result = studentData.addStudent(studentModel);
        } catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
            Logger.getLogger(StudentDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public String updateId(String year) {
        String id = null;

        try {
            id = studentData.updateId(year);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }
    
    public Student searchStudentByID(String id) {
        Student student = null;
        try {
            student = studentData.searchStudentByID(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
    
    public Student searchStudentByName(String name) {
        Student student = null;
        try {
            student = studentData.searchStudentByName(name);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }
    
    public ResultSet getClassDetails(String id) {
        ResultSet results = null;
        try {
            results = studentData.getClassDetails(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return results;
    }
    
    public ResultSet getClassDetailsByName(String name) {
        ResultSet results = null;
        try {
            results = studentData.getClassDetailsByName(name);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return results;
    }
    
    public int updateStudent(Student student) {
        int result = -1;
        try {
            result = studentData.updateStudent(student);
        } catch (ClassNotFoundException | SQLException | FileNotFoundException ex) {
            Logger.getLogger(StudentDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int deleteStudent(String id){
        int result = -1;
        try {
            result = studentData.deleteStudent(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void setStudentModel(Student studentModel) {
        this.studentModel = studentModel;
    }
    
    public void setDeleteView(DeleteStudent deleteView) {
        this.deleteView = deleteView;
    }

    public void setEditView(EditStudent editView) {
        this.editView = editView;
    }

    public void setSearchView(SearchStudent searchView) {
        this.searchView = searchView;
    }

    public void setAddView(AddStudent addView) {
        this.addView = addView;
    }

    public Student getStudentModel() {
        return studentModel;
    }

    public AddStudent getAddView() {
        return addView;
    }

    public DeleteStudent getDeleteView() {
        return deleteView;
    }

    public EditStudent getEditView() {
        return editView;
    }

    public SearchStudent getSearchView() {
        return searchView;
    }
}

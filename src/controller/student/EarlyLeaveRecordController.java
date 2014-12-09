/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.student;

import datalayer.student.ClassDetailsDA;
import datalayer.student.StudentDA;
import model.student.Student;
import view.attendance.AttendanceManagement;

/**
 *
 * @author Pubudu
 */
public class EarlyLeaveRecordController {//act as the controller that handles messages from the view layer to data access layer
                                   //and vice versa.
    private Student studentModel;
    private AttendanceManagement attendanceView;
    private StudentDA studentData;
    private ClassDetailsDA classDetails;

    public EarlyLeaveRecordController() {
        classDetails = ClassDetailsDA.getInstance();
    }

    public Student getStudentModel() {
        return studentModel;
    }

    public AttendanceManagement getAttendanceView() {
        return attendanceView;
    }

    public StudentDA getStudentData() {
        return studentData;
    }

    public void setStudentModel(Student studentModel) {
        this.studentModel = studentModel;
    }

    public void setAttendanceView(AttendanceManagement attendanceView) {
        this.attendanceView = attendanceView;
    }

    public void setStudentData(StudentDA studentData) {
        this.studentData = studentData;
    }
}

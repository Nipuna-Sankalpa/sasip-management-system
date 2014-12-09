/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.payment;

import datalayer.exam.ExamDA;
import datalayer.payment.ExamPaymentDA;
import datalayer.payment.MonthlyPaymentDA;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.payment.ExamFeePayment;
import model.payment.MonthlyFeePayment;
import model.payment.PaymentSheet;
import utilities.AddRecordException;

/**
 *
 * @author Yasanka Jayawardane
 */
public class PaymentController {//act as the controller that handles messages from the view layer to data access layer
    //and vice versa.

    ExamPaymentDA epDA = ExamPaymentDA.getepDA();           //to control methods of ExamPayment data layer
    MonthlyPaymentDA mpDA = MonthlyPaymentDA.getmpDA();     //to control methods of ExamPayment data layer

    /*MonthlyPaymentDA methods
     *
     *
     *
     *
     */
    public boolean addMonthPayments(PaymentSheet<MonthlyFeePayment> paysheet) throws SQLException, ClassNotFoundException, AddRecordException {
        //calls addMonthPayments of the MonthlyPaymentDA
        boolean state = mpDA.addMonthPayments(paysheet);
        return state;

    }

    public int addInitialMonthPayment(String studentID, String classID, Double amount, String employeeID, String month) throws ClassNotFoundException, SQLException {
        //calls addInitialMonthPaymen of the MonthlyPaymentDA
        int state = mpDA.addInitialMonthPayment(studentID, classID, amount, employeeID, month);

        return state;
    }

    public ResultSet getClassDetails(String studentID) throws ClassNotFoundException, SQLException {
        //calls getClassDetails of the MonthlyPaymentDA
        ResultSet rst = mpDA.getClassDetails(studentID);

        return rst;
    }

    public int deleteOneMonthPaymentRecord(String studentID, String paymentID) throws ClassNotFoundException, SQLException {
        //calls deleteOneMonthPaymentRecord of the MonthlyPaymentDA object
        int temp = mpDA.deleteOneMonthPaymentRecord(studentID, paymentID);
        return temp;

    }

    public ResultSet getMonthlyPaymentHistory(String studentID) throws ClassNotFoundException, SQLException {
        //calls getMonthlyPaymentHistory of the MonthlyPaymentDA object
        ResultSet rst = mpDA.getMonthlyPaymentHistory(studentID);

        return rst;
    }

    public String nextPaymentMonth(String stuID, String clsID) throws ClassNotFoundException, SQLException {
        //calls nextPaymentMonth of the MonthlyPaymentDA object
        String month = "";
        month = mpDA.nextPaymentMonth(stuID, clsID);
        return month;
    }

    public String nextPaymentID() throws ClassNotFoundException, SQLException {
        //calls nextPaymentID of the MonthlyPaymentDA object
        String nextPID = "";
        nextPID = mpDA.nextPaymentID();

        return nextPID;
    }

    /*MonthlyPaymentDA methods
     *
     *
     *
     *
     */
    /*ExamPaymentDA methods
     *
     *
     *
     *
     */
    public ResultSet getExamPayments() throws ClassNotFoundException, SQLException {

        ResultSet rst = epDA.getExamPayments();
        return rst;
    }

    public double getAmount(String examID) throws ClassNotFoundException, SQLException {
        double amount = 0;
        ResultSet rs = null;
        ExamDA examDA = ExamDA.getInstance();
        rs = examDA.searchExamID(examID);
        if (rs.next()) {
            amount = rs.getDouble(5);
        }
        return amount;
    }

    public ResultSet getExampaymentDetails(String examID) throws ClassNotFoundException, SQLException {
        ResultSet rst = epDA.getExampaymentDetails(examID);
        return rst;
    }

    public boolean addExamPayments(PaymentSheet<ExamFeePayment> paysheet) throws SQLException, ClassNotFoundException, AddRecordException {
        boolean state;
        state = epDA.addExamPayments(paysheet);
        return state;

    }

    public int deleteOneExamPaymentRecord(String studentID, String paymentID) throws ClassNotFoundException, SQLException {

        int temp = epDA.deleteOneExamPaymentRecord(studentID, paymentID);
        return temp;
    }

    public ResultSet getExamPaymentHistory(String studentID) throws ClassNotFoundException, SQLException {
        ResultSet rst = epDA.getExamPaymentHistory(studentID);
        return rst;
    }

    /*ExamPaymentDA methods
     *
     *
     *
     *
     */
    public String getMonthlyPaymentStatus(String id) {
        String status = "";

        ResultSet rs;
        try {
            rs = mpDA.getMonthlyPaymentHistory(id);
            if (rs.next()) {
                status = "Paid";
                return status;
            } else {
                status = "Not Paid";
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public String getExamPaymentStatus(String id) {
        String status = "";

        try {
            ResultSet rs = epDA.getExamPaymentHistory(id);

            if (rs.next()) {
                status = "Paid";
                //System.out.println(status);
                return status;
            } else {
                status = "Not Paid";
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}

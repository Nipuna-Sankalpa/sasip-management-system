/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

/**
 *
 * @author Mampitiya
 */
public class ExamFeePayment{// extends Payment{/*
    
    private String examID;
    private String studentID;
    private String employeeID;
    private double amount;
    private java.sql.Date date;
    
    public ExamFeePayment(String examID, String studentID, String employeeID, double amount, java.util.Date udate){
        this.examID = examID;
        this.studentID = studentID;
        this.employeeID = employeeID;
        this.amount = amount;
        this.date = new java.sql.Date(udate.getTime());
    }
   

    /**
     * @return the examID
     */
    public String getExamID() {
        return examID;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the date
     */
    public java.sql.Date getDate() {
        return date;
    }
}

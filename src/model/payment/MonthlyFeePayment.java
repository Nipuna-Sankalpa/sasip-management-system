/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;
/**
 *
 * @author Mampitiya
 */
public class MonthlyFeePayment {
    private String classId;
    private String month;
     private String paymentId;
    private String studentId;
    private String employeeID;
    private double amount;
    private java.util.Date date;
    
   public MonthlyFeePayment(String studentId, String classId, String month, String cashierId,String paymentID, double amount, java.util.Date date) {
        
        this.studentId = studentId;
        this.employeeID = cashierId;
        this.month = month;
        this.classId = classId;
        this.amount = amount;
        this.paymentId = paymentID;
        this.date = date;
        
    }
    public String getClassId() {
        return classId;
    }

    public String getMonth() {
        return month;
    }
    
    

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @return the employeeID
     */
    public String getCashierId() {
        return employeeID;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return the timeStamp
     */
    
    public java.sql.Date getDate() {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
}

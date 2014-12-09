/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

import java.sql.Timestamp;
import java.sql.Time;
import java.util.Date;
import model.payment.*;

/**
 *
 * @author Mampitiya
 */
public abstract class Payment { 
    
    private String paymentId;
    private String studentId;
    private String classId;
    private String cashierId;
    private String month;
    private double amount;
    private Timestamp timeStamp;
    private Date date;
    private PaymentSheet MonthPaySheet = new PaymentSheet() ;

    public Payment(String studentId, String classId, String month, String cashierId, double amount, Date date) {
        this.studentId = studentId;
        this.cashierId = cashierId;
        this.month = month;
        this.classId = classId;
        this.amount = amount;
        this.paymentId = generatePaymentID();
        this.date = date;
        timeStamp=new Timestamp(System.currentTimeMillis());
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCashierId() {
        return cashierId;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getDate() {
        return getTimeStamp();
    }

    public Date getTime() {
        return getDate();
    }
    
    private String generatePaymentID(){
        String id = "0000000003";
        return id;
    }

    /**
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @return the timeStamp
     */
    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}

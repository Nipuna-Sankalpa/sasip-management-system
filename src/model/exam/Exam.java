/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exam;
import java.sql.Date ;
/**
 *
 * @author Mampitiya
 */
public class Exam {
    private String examID ;
    private Date date ;
    private String discription ;
    private String classYear ;
    private String amount ;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Exam(String examID,Date date,String discription,String classYear,String amount) {
    this.examID = examID ;
    this.date = date ;
    this.classYear = classYear ;
    this.amount=amount;
    this.discription = discription ;
    }

    public String getClassYear() {
        return classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }
    
    public String getExamID() {
        return examID;
    }

    public Date getDate() {
        return date;
    }
 
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
}

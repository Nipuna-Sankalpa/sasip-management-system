/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.payment.ExamFeePayment;
import model.payment.PaymentSheet;
import utilities.AddRecordException;
import utilities.DBConnection;
import utilities.DBHandler;

/**
 *
 * @author Mampitiya
 */
public class ExamPaymentDA {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement statement;
    int temp = 0;
    private static ExamPaymentDA epDA;
    private ExamPaymentDA(){
        
    }
   
    public static ExamPaymentDA getepDA(){
        if(epDA==null){
            epDA =  new ExamPaymentDA();
        }
        
        return epDA;
    }
    
    public ResultSet getExamPayments() throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();
        String sql = "Select examID, classYear FROM exam order by date desc";        
        ResultSet rst = DBHandler.getData(con, sql);
        return rst;
    }
    
    public ResultSet getExampaymentDetails(String examID) throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();
        String sql = "Select description,date FROM exam where examID= '"+examID+"'";        
        ResultSet rst = DBHandler.getData(con, sql);
        return rst;
    }
    
    public static boolean addExamPayments(PaymentSheet<ExamFeePayment> paysheet) throws SQLException, ClassNotFoundException, AddRecordException {
        con = DBConnection.getConnection();
        int temp = 0, i;

        String query = "INSERT INTO examfee (examID,studentID,employeeID) values (?,?,?)";
        con.setAutoCommit(false);
        statement = con.prepareStatement(query);
        for (i = 0; i < paysheet.getPayList().size(); i++) {
            statement.setString(1, paysheet.retrievepayments(i).getExamID());
            statement.setString(2, paysheet.retrievepayments(i).getStudentID());
            statement.setString(3, paysheet.retrievepayments(i).getEmployeeID());
            statement.addBatch();
        }
        if (i == paysheet.getPayList().size()) {
            statement.executeBatch();
            con.commit();
            return true;
        } else {
            con.rollback();
            throw new AddRecordException();
        }

    }
    public int deleteOneExamPaymentRecord(String studentID, String paymentID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM examfee WHERE studentID='" + studentID + "' and examID='" + paymentID + "'";
        int temp = DBHandler.setData(con, query);
        con.close();

        return temp;
    }
     public ResultSet getExamPaymentHistory(String studentID) throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();
        String sql = "Select examID,date from examfee where studentID = '"+studentID+"'";        
        ResultSet rst = DBHandler.getData(con, sql);
                   
        return rst;
    }
    
}

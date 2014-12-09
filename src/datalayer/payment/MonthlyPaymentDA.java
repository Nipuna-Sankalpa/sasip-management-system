/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilities.DBConnection;
import utilities.DBHandler;
import model.payment.*;
import utilities.AddRecordException;
import java.util.Calendar;
/**
 *
 * @author Yasanka Jayawardane
 */
public class MonthlyPaymentDA {

    private static Connection con;
    private static ResultSet rst;
    private static PreparedStatement statement;
    int temp = 0;
    private static MonthlyPaymentDA mpDA;

    private MonthlyPaymentDA() {

    }

    public static MonthlyPaymentDA getmpDA() {
        if (mpDA == null) {
            mpDA = new MonthlyPaymentDA();
        }

        return mpDA;
    }

    public int addInitialMonthPayment(String studentID, String classID, Double amount, String employeeID, String month) throws ClassNotFoundException, SQLException {
        int state;
        Statement stm;
        String paymentID = nextPaymentID();
        stm = con.createStatement();
        String query = "INSERT INTO classfees (studentID,classID,amount,employeeID,paymentID,month) values ('" + studentID + "','" + classID + "','" + amount + "','" + employeeID + "','" + paymentID + "','" + month + "')";
        state = stm.executeUpdate(query);

        return state;
    }

    public boolean addMonthPayments(PaymentSheet<MonthlyFeePayment> paysheet) throws SQLException, ClassNotFoundException, AddRecordException {
        con = DBConnection.getConnection();
        int temp = 0, i;

        String query = "INSERT INTO classfees (studentID,classID,amount,employeeID,paymentID,month) values (?,?,?,?,?,?)";
        con.setAutoCommit(false);
        statement = con.prepareStatement(query);
        for (i = 0; i < paysheet.getPayList().size(); i++) {
            statement.setString(1, paysheet.retrievepayments(i).getStudentId());
            statement.setString(2, paysheet.retrievepayments(i).getClassId());
            statement.setDouble(3, paysheet.retrievepayments(i).getAmount());
            statement.setString(4, paysheet.retrievepayments(i).getCashierId());
            statement.setString(5, paysheet.retrievepayments(i).getPaymentId());
            statement.setString(6, paysheet.retrievepayments(i).getMonth());
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

    public ResultSet getClassDetails(String studentID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String sql = "Select classID, classYear, classCategory, dayOfWeek from classdetail natural join class where studentID = '" + studentID + "'";
        ResultSet rst = DBHandler.getData(con, sql);

        return rst;
    }

    public int deleteOneMonthPaymentRecord(String studentID, String paymentID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM classfees WHERE studentID='" + studentID + "' and paymentID='" + paymentID + "'";
        int temp = DBHandler.setData(con, query);
        con.close();

        return temp;
    }

    public ResultSet getMonthlyPaymentHistory(String studentID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String sql = "Select paymentID,month,date,classID from classFees where studentID = '" + studentID + "'";
        ResultSet rst = DBHandler.getData(con, sql);

        return rst;
    }

    public String nextPaymentMonth(String stuID, String clsID) throws ClassNotFoundException, SQLException {
        String month = "";
        con = DBConnection.getConnection();
        String sql = "SELECT month FROM `classfees` where studentID = '" + stuID + "' and classID = '" + clsID + "' order by date desc limit 1";// "select month, max(date) from classfees where studentID = '" + stuID + "' and classID = '" + clsID + "'";
        ResultSet rst = DBHandler.getData(con, sql);
        if (rst.next()) {
            month = rst.getString(1);
            month = nextMonth(month);
        }
        
        else{
            //current month eka == DDD
            
            int monthVal = Calendar.getInstance().get(Calendar.MONTH)+1;
            
            switch(monthVal){
                case 1:
                    month = "JANUARY";
                break;
                
                case 2:
                    month = "FEBRUARY";
                break;
                    
                case 3:
                    month = "MARCH";
                break;
                    
                case 4:
                    month = "APRIL";
                break;
                
                case 5:
                    month = "MAY";
                break;
                    
                case 6:
                    month = "JUNE";
                break;
                    
                 case 7:
                    month = "JULY";
                break;
                     
                 case 8:
                    month = "AUGUST";
                break;
                     
                case 9:
                    month = "SEPTEMBER";
                break;
                    
                case 10:
                    month = "OCTOBER";
                break;
                    
                case 11:
                    month = "NOVEMBER";
                break;
                    
                case 12:
                    month = "DECEMBER";
                break;
            }
        }
        
        return month;
    }

    public String nextPaymentID() throws ClassNotFoundException, SQLException {
        String nextPID = "";
        int x;
        con = DBConnection.getConnection();
        String sql = "SELECT max(paymentID) FROM classfees";// "select month, max(date) from classfees where studentID = '" + stuID + "' and classID = '" + clsID + "'";
        ResultSet rst = DBHandler.getData(con, sql);
        if (rst.next()) {
            nextPID = rst.getString(1);
            if (nextPID!= null) {
                
            x = Integer.parseInt(nextPID);
            }else x=0;
        } else {
            x = 0;
        }

        x++;
        nextPID = "" + x;
        
        return nextPID;
    }

    public static String nextMonth(String curMonth) {
        String month = new String("");
        if (curMonth.equalsIgnoreCase("JANUARY")) {
            month = "FEBRUARY";
        } else if (curMonth.equalsIgnoreCase("FEBRUARY")) {
            month = "MARCH";
        } else if (curMonth.equalsIgnoreCase("MARCH")) {
            month = "APRIL";
        } else if (curMonth.equalsIgnoreCase("APRIL")) {
            month = "MAY";
        } else if (curMonth.equalsIgnoreCase("MAY")) {
            month = "JUNE";
        } else if (curMonth.equalsIgnoreCase("JUNE")) {
            month = "JULY";
        } else if (curMonth.equalsIgnoreCase("JULY")) {
            month = "AUGUST";
        } else if (curMonth.equalsIgnoreCase("AUGUST")) {
            month = "SEPTEMBER";
        } else if (curMonth.equalsIgnoreCase("SEPTEMBER")) {
            month = "OCTOBER";
        } else if (curMonth.equalsIgnoreCase("OCTOBER")) {
            month = "NOVEMBER";
        } else if (curMonth.equalsIgnoreCase("NOVEMBER")) {
            month = "DECEMBER";
        } else if (curMonth.equalsIgnoreCase("DECEMBER")) {
            month = "JANUARY";
        }

        return month;
    }

}

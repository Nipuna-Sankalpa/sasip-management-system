/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.employee;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.employee.EmployeeWorkSheet;
import utilities.AddRecordException;
import utilities.DBConnection;
import utilities.DBHandler;

/**
 *
 * @author Yellow Flash
 */
public class EmployeeWorkDetailDA {

    private static Connection con;
    private static PreparedStatement statement;
//if the commit failed,throw an enter mark exception

    public static int addWorkingDetail(EmployeeWorkSheet sheet) throws SQLException, ClassNotFoundException, AddRecordException {//add Payments
        con = DBConnection.getConnection();//retrieve connection
        int temp = 0;
        String query = "INSERT INTO employee_working_detail (employeeID,time,date,classID) values (?,?,?,?)";
        statement = con.prepareStatement(query);

        statement.setString(1, sheet.getEmployeeID());
        statement.setTime(2, sheet.getTime());
        statement.setDate(3, sheet.getDate());
        statement.setString(4, sheet.getClassID());
        temp = statement.executeUpdate();//execute the query
        return temp;

    }
//assumption-payment ID will not change

    public static int updateWorkingDetail(EmployeeWorkSheet sheet) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();//retrieve connection
        String query = "UPDATE employee_working_detail SET employeeID=?,time=?,date=?,classID=? WHERE entryID=?";
        statement = con.prepareStatement(query);
        statement.setString(1, sheet.getEmployeeID());
        statement.setTime(2, sheet.getTime());
        statement.setDate(3, sheet.getDate());
        statement.setString(4, sheet.getClassID());
        statement.setString(5, sheet.getEntryID());
        int temp = statement.executeUpdate();//execute the query
        con.close();//close the connection
        return temp;
    }

    public static CachedRowSetImpl searchWorkingDetByID(String employeeID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();//retrieve connection
        String sql = "Select date, time, classID from employee_working_detail where employeeID = '" + employeeID + "'";
        CachedRowSetImpl rst = new CachedRowSetImpl();
        rst.populate(DBHandler.getData(con, sql));    //execute the query
        con.close();//close the connection
        return rst;
    }
    
    public static CachedRowSetImpl searchWorkingDetByName(String name) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();//retrieve connection
        String sql = "Select concat(firstName, ' ', lastName) as name, employeeID, date, time, classID from employee_working_detail natural join employee having name = '" + name + "'";
        CachedRowSetImpl rst = new CachedRowSetImpl();
        rst.populate(DBHandler.getData(con, sql));     //execute the query
        con.close();//close the connection
        return rst;
    }

    public static CachedRowSetImpl retrieveSingleClassWork(String classID) throws ClassNotFoundException, SQLException {
        CachedRowSetImpl rs = null;
        con = DBConnection.getConnection();//retrieve connection
        String query = "SELECT * FROM examfees WHERE classID='" + classID + "'";
        rs = new CachedRowSetImpl();
        rs.populate(DBHandler.getData(con, query));//execute the query
        con.close();//close the connection
        return rs;
    }

    public static ResultSet retrieveWorkByDay(Date date) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        con = DBConnection.getConnection();//retrieve connection
        String query = "SELECT * FROM employee_working_detail WHERE date='" + date + "'";
        rs = DBHandler.getData(con, query);//execute the query
        return rs;
    }

    public static ResultSet DeleteWorkByDay(Date date) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        con = DBConnection.getConnection();//retrieve connection
        String query = "DELETE FROM employee_working_detail WHERE date='" + date + "'";
        rs = DBHandler.getData(con, query);//execute the query
        return rs;
    }

    public static ResultSet retrieveTable() throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        con = DBConnection.getConnection();//retrieve connection
        String query = "SELECT * FROM employee_working_detail";
        rs = DBHandler.getData(con, query);//execute the query
        return rs;
    }

    public static int deleteSingleEmployeeWork(String employeeID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();//retrieve connection
        String query = "DELETE FROM employee_working_detail WHERE employeeID='" + employeeID + "'";
        int temp = DBHandler.setData(con, query);//execute the query
        con.close();//close the connection
        return temp;
    }

    public static int deleteSingleClassWork(String classID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();//retrieve connection
        String query = "DELETE FROM employee_working_detail WHERE classID='" + classID + "'";
        int temp = DBHandler.setData(con, query);//execute the query
        con.close();//close the connection
        return temp;
    }

    public static int deleteOneRecord(String classID, String employeeID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();//retrieve connection
        String query = "DELETE FROM employee_working_detail WHERE employeeID='" + employeeID + "' and examID='" + classID + "'";
        int temp = DBHandler.setData(con, query);//execute the query
        con.close();//close the connection
        return temp;
    }
}

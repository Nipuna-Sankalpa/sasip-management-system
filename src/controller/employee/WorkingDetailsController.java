/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.employee;

import datalayer.employee.EmployeeWorkDetailDA;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.employee.EmployeeWorkSheet;
import utilities.AddRecordException;

/**
 *
 * @author Mampitiya
 */
public class WorkingDetailsController {
    private final EmployeeWorkDetailDA employeeWorkDetailDA;

    public WorkingDetailsController() {
        employeeWorkDetailDA = new EmployeeWorkDetailDA();
    }
    
    public int addPayments(EmployeeWorkSheet sheet) throws SQLException, ClassNotFoundException, AddRecordException {
        return employeeWorkDetailDA.addWorkingDetail(sheet);
    }
    
    public int updatePayments(EmployeeWorkSheet sheet) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.updateWorkingDetail(sheet);
    }
    
    public ResultSet searchWorkingDetByID(String employeeID) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.searchWorkingDetByID(employeeID);
    }
    
    public ResultSet searchWorkingDetByName(String name) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.searchWorkingDetByName(name);
    }
    
    public ResultSet retrieveSingleClassWork(String classID) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.retrieveSingleClassWork(classID);
    }
    
    public ResultSet retrieveWorkByDay(Date date) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.retrieveWorkByDay(date);
    }
    
    public ResultSet DeleteWorkByDay(Date date) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.DeleteWorkByDay(date);
    }
    
    public ResultSet retrieveTable() throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.retrieveTable();
    }
    
    public int deleteSingleEmployeeWork(String employeeID) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.deleteSingleEmployeeWork(employeeID);
    }
    
    public int deleteSingleClassWork(String classID) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.deleteSingleClassWork(classID);
    }
    
    public int deleteOneRecord(String classID, String employeeID) throws ClassNotFoundException, SQLException {
        return employeeWorkDetailDA.deleteOneRecord(classID, employeeID);
    }
}
    

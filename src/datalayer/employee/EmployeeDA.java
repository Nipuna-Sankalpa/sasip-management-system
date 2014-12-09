/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.employee;

import java.io.FileNotFoundException;
import utilities.DBConnection;
import utilities.DBHandler;
import model.employee.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import utilities.DBImageHandler;

/**
 *
 * @author Mampitiya
 */
public class EmployeeDA {

    private static Connection con; //to get the connection
    private static ResultSet resultSet; //to get the returned data

    public int addEmployee(Employee emp) throws SQLException, ClassNotFoundException, FileNotFoundException {//add Employee
        con = DBConnection.getConnection();//retrieve connection
        String query = "";
        int temp = 0;
        if(emp != null)//if employee is not null
            query = "insert into employee values('" + emp.getEmployeeID() + "','" + emp.getDesignation() + "','" + emp.getAddress() + "','" + emp.getMobile() + "','" + null + "','" + emp.getFirstName() + "','" + emp.getLastName() + "','" + emp.getPassword() + "','" + emp.getAccessLevel() + "');";
        if(!query.isEmpty())    
            temp = DBHandler.setData(con, query);//execute the query
        DBImageHandler.updateImage(con, emp.getImagePath(), "employee", emp.getEmployeeID());//update the image of the employee
        return temp;
    }

    public int updateEmployee(Employee emp) throws ClassNotFoundException, SQLException, FileNotFoundException {//update Employee
        con = DBConnection.getConnection();//retrieve connection
        String query = "";
        int temp = 0;
        if(emp != null)//if employee is not null
            query = "UPDATE employee SET designation='" + emp.getDesignation() + "',address='" + emp.getAddress() + "',mobile='" + emp.getMobile() + "',firstName='" + emp.getFirstName() + "',lastName='" + emp.getLastName() + "', accessLevel=" + emp.getAccessLevel() + " WHERE employeeID='" + emp.getEmployeeID() + "'";
        if(!query.isEmpty())   
            temp = DBHandler.setData(con, query);//execute the query
        DBImageHandler.updateImage(con, emp.getImagePath(), "employee", emp.getEmployeeID());//update the image of the employee
        return temp;
    }

    public int deleteEmployee(String employeeID) throws ClassNotFoundException, SQLException {//delete Employee
        con = DBConnection.getConnection();//retrieve connection
        String query[] = new String[5];
        int temp = 0;
        if(employeeID != null){//if employee is not null, here all other entries which hold this id as foriegn key are deleted
            query[4] = "DELETE FROM employee WHERE employeeID='" + employeeID+ "'";
            query[0] = "DELETE FROM attendance WHERE employeeID='" + employeeID+ "'";
            query[1] = "DELETE FROM classfees WHERE employeeID='" + employeeID+ "'";
            query[2] = "DELETE FROM employee_working_detail WHERE employeeID='" + employeeID+ "'";
            query[3] = "DELETE FROM examfee WHERE employeeID='" + employeeID+ "'";
        }
        for (String query1 : query) {
            DBHandler.setData(con, query1);//execute the query
        }
        con.close();//close the connection
        return temp;
    }

    public Employee searchEmployeeByName(String name) throws ClassNotFoundException, SQLException {//search Employee By Name
        con = DBConnection.getConnection();//retrieve connection
        String query = "";
        if(name != null)
            query = "SELECT concat(firstName, ' ', lastName) as name, firstName, lastName, mobile, address, designation, image, accessLevel, employeeID, password FROM employee having name = '" + name + "';";
        if(!query.isEmpty())
            resultSet = DBHandler.getData(con, query);  //execute the query      
        if (resultSet.next()) {
            String designation = resultSet.getString(6);
            String address = resultSet.getString(5);
            String mobile = resultSet.getString(4);
            String imagePath = resultSet.getString(7);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            int accessLevel = resultSet.getInt(8);
            String employeeID = resultSet.getString(9);
            String password = resultSet.getString(8);
            
            ImageIcon img = DBImageHandler.retrieveImage(resultSet);
            
            Employee employee = new Employee(accessLevel, address, designation, employeeID, firstName, lastName, mobile, imagePath);
            employee.setImage(img);//update the image of the employee
            employee.setPassword(password);
            
            con.close();//close the connection
            return employee;
        }
        con.close();//close the connection
        return null;
    }

    public Employee searchEmployeeByID(String employeeID) throws ClassNotFoundException, SQLException {//search Employee By ID
        con = DBConnection.getConnection();//retrieve connection
        String query = "SELECT * FROM employee WHERE employeeID = '" + employeeID + "'";
        resultSet = DBHandler.getData(con, query);//execute the query
        while (resultSet.next()) {
            String designation = resultSet.getString(2);
            String address = resultSet.getString(3);
            String mobile = resultSet.getString(4);
            String imagePath = resultSet.getString(5);
            String firstName = resultSet.getString(6);
            String lastName = resultSet.getString(7);
            int accessLevel = resultSet.getInt(9);
            String password = resultSet.getString(8);
            ImageIcon img = DBImageHandler.retrieveImage(resultSet);
            
            Employee employee = new Employee(accessLevel, address, designation, employeeID, firstName, lastName, mobile, imagePath);
            employee.setImage(img);//update the image of the employee
            employee.setPassword(password);
            con.close();//close the connection
            return employee;
        }
        con.close();//close the connection
        return null;
    }

    public String updateId() throws SQLException, ClassNotFoundException {//this method will return the latest id
        con = DBConnection.getConnection();//retrieve connection
        String sql = "Select max(employeeID) from employee";
        ResultSet rst = DBHandler.getData(con, sql);//execute the query
        String updatedId = "00001";
        if (rst.next()) {
            String id = rst.getString(1);
            if (id != null) {
                int newId = Integer.parseInt(id) + 1;
                updatedId = String.format("%05d", newId);
            }
        }
        con.close();//close the connection
        return updatedId;
    }
    
    public int updatePassword(String employeeID, String newPw) throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();//retrieve connection
        String query = "update employee set password = '" +newPw+ "' where employeeID = '" +employeeID+ "'";
        int rst = DBHandler.setData(con, query);//execute the query
        con.close();//close the connection
        return rst;
    }    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.student;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.student.Student;
import utilities.DBConnection;
import utilities.DBHandler;
import utilities.DBImageHandler;

/**
 *
 * @author Mampitiya
 */
public class StudentDA {

    private static StudentDA dataAccess;
    private Connection con;
    private ResultSet rs;
    private PreparedStatement statement;

    private StudentDA() {
    }

    public static StudentDA getInstance() {
        if (dataAccess == null) {
            dataAccess = new StudentDA();
        }

        return dataAccess;
    }

    public int addStudent(Student student) throws SQLException, ClassNotFoundException, FileNotFoundException {
        con = DBConnection.getConnection();
        int temp;
        String query = "INSERT INTO student (studentID, firstName, lastName, address, mobileNumber, guardianName, guardianNumber, gender, image, year) VALUES (?,?,?,?,?,?,?,?,?,?)";
        statement = con.prepareStatement(query);

        statement.setString(1, student.getStudentID());
        statement.setString(2, student.getFirstName());
        statement.setString(3, student.getLastName());
        statement.setString(4, student.getAddress());
        statement.setString(5, student.getMobileNumber());
        statement.setString(6, student.getGuardianName());
        statement.setString(7, student.getGuardianNumber());
        statement.setBoolean(8, student.isMale());
        statement.setString(9, student.getFilePath());
        statement.setString(10, student.getYear());

        temp = statement.executeUpdate();
        con.close();
        return temp;

    }

    public int updateStudent(Student student) throws ClassNotFoundException, SQLException, FileNotFoundException {
        con = DBConnection.getConnection();
        int temp;
        String query = "UPDATE student SET address=?,mobileNumber=?,guardianName=?,guardianNumber=?,gender=? where studentID = '" + student.getStudentID() + "'";
        statement = con.prepareStatement(query);
        statement.setString(1, student.getAddress());
        statement.setString(2, student.getMobileNumber());
        statement.setString(3, student.getGuardianName());
        statement.setString(4, student.getGuardianNumber());
        statement.setBoolean(5, student.isMale());
        temp = statement.executeUpdate();

//        DBImageHandler.updateImage(con, student.getFilePath(), "student", student.getStudentID());
        con.close();

        return temp;
    }

    public int deleteStudent(String studentID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM student WHERE studentID='" + studentID + "'";
        String query1 = "DELETE FROM classdetail WHERE studentID='" + studentID + "'";
        String query2 = "DELETE FROM attendance WHERE studentID='" + studentID + "'";
        String query3 = "DELETE FROM classfees WHERE studentID='" + studentID + "'";
        String query4 = "DELETE FROM examfee WHERE studentID='" + studentID + "'";
        String query5 = "DELETE FROM marks WHERE studentID='" + studentID + "'";

        DBHandler.setData(con, query1);
        DBHandler.setData(con, query2);
        DBHandler.setData(con, query3);
        DBHandler.setData(con, query4);
        DBHandler.setData(con, query5);
        int temp = DBHandler.setData(con, query);
        con.close();

        return temp;
    }

    public Student searchStudentByID(String studentID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String query = "SELECT * FROM student WHERE studentID = '" + studentID + "'";
        rs = DBHandler.getData(con, query);
        while (rs.next()) {
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String address = rs.getString(4);
            String mobile = rs.getString(5);
            String guardian = rs.getString(6);
            String guardianNo = rs.getString(7);
            boolean gender = rs.getBoolean(8);
            Student student = new Student(studentID, firstName, lastName, address, mobile, guardian, guardianNo, gender);
            ImageIcon img = DBImageHandler.retrieveImage(rs);
            student.setImage(img);
            return student;
        }
        return null;
    }

    public Student searchStudentByName(String name) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String query = "SELECT studentID, firstName, lastName, address, mobileNumber, guardianName, guardianNumber, gender, concat(firstName, ' ', lastName) as name,image  FROM student having name = '" + name + "'";
        rs = DBHandler.getData(con, query);
        while (rs.next()) {
            String studentID = rs.getString(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String address = rs.getString(4);
            String mobile = rs.getString(5);
            String guardian = rs.getString(6);
            String guardianNo = rs.getString(7);
            boolean gender = rs.getBoolean(8);
            
            Student student = new Student(studentID, firstName, lastName, address, mobile, guardian, guardianNo, gender);
            ImageIcon img = DBImageHandler.retrieveImage(rs);
            student.setImage(img);
            return student;
        }
        return null;
    }

    public static String updateId(String year) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getConnection();        
        ResultSet rst;
        String studentID=null;
        //String studentID = year.substring(2).concat("0000"); 
        String query = "SELECT MAX(date),year FROM student GROUP BY year";
        rst = DBHandler.getData(con, query);
        String st;
        String[] s;
        Timestamp date = null;
        while (rst.next()) {
            st = rst.getString(2);
            s = st.split("-");
            if (s[0].equals(year)) {
                date = rst.getTimestamp(1);
                System.out.println(date);
                break;
            }
        }
        String query1 = "SELECT studentID FROM student WHERE date='" + date + "'";
        rst = DBHandler.getData(con, query1);
        if(rst.next()){
            studentID = rst.getString(1); 
        }       
               
        if (studentID != null) {
            int newId = Integer.parseInt(studentID) + 1;
            studentID = String.valueOf(newId);
        }
        rst.close();
        return studentID;
    }

    public ResultSet getClassDetails(String studentID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String sql = "Select classID, classYear, classCategory, dayOfWeek from classdetail natural join class where studentID = '" + studentID + "'";
        ResultSet rst = DBHandler.getData(con, sql);
        return rst;
    }

    public ResultSet getClassDetailsByName(String name) throws ClassNotFoundException, SQLException {
        String names[] = name.split("\\w");
        System.out.println(names[0]);
        con = DBConnection.getConnection();
        String sql = "select classID, classYear, classCategory, dayOfWeek, firstName from classdetail natural join class natural join student where firstName = '" + names[0] + "' and lastName = '" + names[1] + "'";
        ResultSet rst = DBHandler.getData(con, sql);
        return rst;
    }
}

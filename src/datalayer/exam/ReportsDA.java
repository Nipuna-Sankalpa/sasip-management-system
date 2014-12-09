/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.exam;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import org.jfree.data.category.DefaultCategoryDataset;
import utilities.DBConnection;
import utilities.DBHandler;
import utilities.RoundUp;

/**
 *
 * @author Yellow Flash
 */
public class ReportsDA {

    Connection con;
    ResultSet rs;

    public int gradeA(String examID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        int count = 0;
        rs = null;

        String queryA = "SELECT COUNT(studentID) FROM marks where marks between 75 AND 100 AND examID='" + examID + "'";

        rs = DBHandler.getData(con, queryA);
        if (rs.next()) {
            count = rs.getInt(1);

        }
        con.close();
        return count;
    }

    public int gradeB(String examID) throws ClassNotFoundException, SQLException {
        int count = 0;
        con = DBConnection.getConnection();
        rs = null;

        String queryB = "SELECT COUNT(studentID) FROM marks where marks between 65 AND 74 AND examID='" + examID + "'";

        rs = DBHandler.getData(con, queryB);
        if (rs.next()) {
            count = rs.getInt(1);

        }
        con.close();
        return count;
    }

    public int gradeC(String examID) throws ClassNotFoundException, SQLException {
        int count = 0;
        con = DBConnection.getConnection();
        rs = null;

        String queryC = "SELECT COUNT(studentID) FROM marks where marks between 55 AND 64 AND examID='" + examID + "'";

        rs = DBHandler.getData(con, queryC);
        if (rs.next()) {
            count = rs.getInt(1);

        }
        con.close();
        return count;
    }

    public int gradeS(String examID) throws ClassNotFoundException, SQLException {
        int count = 0;
        con = DBConnection.getConnection();
        rs = null;

        String queryS = "SELECT COUNT(studentID) FROM marks where marks between 35 AND 54 AND examID='" + examID + "'";

        rs = DBHandler.getData(con, queryS);
        if (rs.next()) {
            count = rs.getInt(1);

        }
        con.close();
        return count;
    }

    public int gradeW(String examID) throws ClassNotFoundException, SQLException {
        int count = 0;
        con = DBConnection.getConnection();
        rs = null;

        String queryW = "SELECT COUNT(studentID) FROM marks where marks between 0 AND 34 AND examID='" + examID + "'";
        rs = DBHandler.getData(con, queryW);
        if (rs.next()) {
            count = rs.getInt(1);

        }
        con.close();
        return count;
    }

    public int total(String examID) throws SQLException, ClassNotFoundException {
        int count = 0;
        con = DBConnection.getConnection();
        rs = null;

        String queryTotal = "SELECT COUNT(studentID) FROM marks where examID='" + examID + "'";
        rs = DBHandler.getData(con, queryTotal);
        if (rs.next()) {
            count = rs.getInt(1);

        }
        con.close();
        return count;
    }

    public float highestMark(String examID) throws SQLException, ClassNotFoundException {
        float mark = 0;
        con = DBConnection.getConnection();
        String query = "SELECT MAX(marks) FROM marks WHERE examID='" + examID + "'";
        rs = DBHandler.getData(con, query);
        if (rs.next()) {
            mark = (float) rs.getDouble(1);
            mark = RoundUp.precision(2, mark);
        }
        con.close();
        return mark;
    }

    public float lowestMark(String examID) throws SQLException, ClassNotFoundException {
        float mark = 0;
        con = DBConnection.getConnection();
        String query = "SELECT MIN(marks) FROM marks WHERE examID='" + examID + "'";
        rs = DBHandler.getData(con, query);
        if (rs.next()) {
            mark = (float) rs.getDouble(1);
            mark = RoundUp.precision(2, mark);
        }
        con.close();
        return mark;
    }

    public float avgtMark(String examID) throws SQLException, ClassNotFoundException {
        float mark = 0;
        con = DBConnection.getConnection();
        String query = "SELECT AVG(marks) FROM marks WHERE examID='" + examID + "'";
        rs = DBHandler.getData(con, query);
        if (rs.next()) {
            mark = (float) rs.getDouble(1);
            mark = RoundUp.precision(2, mark);
        }
        con.close();
        return mark;
    }

    public CachedRowSet OverallClassPerformanceAnalysis(String year) throws SQLException, ClassNotFoundException {
        con = DBConnection.getConnection();
        String query = "SELECT * FROM (SELECT AVG(marks),MAX(marks),MIN(marks),examID FROM marks GROUP BY examID) AS result WHERE examID LIKE '" + year + "%'";
        rs = DBHandler.getData(con, query);
        CachedRowSet set = new CachedRowSetImpl();
        set.populate(rs);
        con.close();
        return set;
    }

    public CachedRowSet individualPerformance(String studentID) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String partialID = "20" + studentID.substring(0, 2);
        String query = "SELECT result1.examID, result1.avgm,result1.topmark,marks.studentID,marks.marks FROM ( select examID,avg(marks) as avgm,max(marks) as topmark from marks group by examID )as result1 INNER JOIN marks ON marks.examID=result1.examID where studentID='" + studentID + "'";
        rs = DBHandler.getData(con, query);
        CachedRowSet set = new CachedRowSetImpl();

        set.populate(rs);
        con.close();
        return set;

    }

    public DefaultCategoryDataset attendanceReport(String year) throws ClassNotFoundException, SQLException {
        String query1 = "Select examID from exam where examID LIKE '" + year + "%'";
        String examID;
        float data;
        int index = 0;
        int examTotalStudent, examAttended;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        con = DBConnection.getConnection();
        ResultSet rs1 = null;
        rs1 = DBHandler.getData(con, query1);
        while (rs1.next()) {

            examID = rs1.getString(1);

//            System.out.println(classID);
            examTotalStudent = totalPresentStudents(con, year);
            System.out.println("classTotalStudent " + examTotalStudent);
            examAttended = examAttended(con, examID);
            System.out.println("classMonthlyStudent " + examAttended);
            data = RoundUp.precision(2, ((float) (examAttended) / examTotalStudent) * 20);
            dataSet.addValue(data, "Attendance Precentage", examID);

        }
        con.close();
        return dataSet;

    }
    public int examAttended(Connection con,String year) throws SQLException{
    int numberOfStudent = 0;
        ResultSet rs;
        String query = "select count(studentID) from attendanceexam where examID LIKE '" + year + "%'";
        rs = DBHandler.getData(con, query);
        if (rs.next()) {
            numberOfStudent = rs.getInt(1);
        }
        return numberOfStudent;
    }

    public int totalPresentStudents(Connection con, String year) throws SQLException {
        int numberOfStudent = 0;
        ResultSet rs;
        String query = "select count(studentID) from classdetail where classID LIKE '" + year + "%'";
        rs = DBHandler.getData(con, query);
        if (rs.next()) {
            numberOfStudent = rs.getInt(1);
        }
        return numberOfStudent;
    }

}

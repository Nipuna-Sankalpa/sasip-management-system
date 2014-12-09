/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.student;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import model.exam.MarkSheet;
import model.exam.StudentMark;
import model.student.Attendance;
import model.student.AttendanceSheet;
import org.jfree.data.category.DefaultCategoryDataset;
import utilities.AddRecordException;
import utilities.DBConnection;
import utilities.DBHandler;
import utilities.RoundUp;

/**
 *
 * @author Mampitiya
 */
public class AttendanceDA {

    private static AttendanceDA attendanceData;
    private static Connection con;
    private PreparedStatement statement;

    private AttendanceDA() {
    }

    public static AttendanceDA getInstance() {
        if (attendanceData == null) {
            attendanceData = new AttendanceDA();
        }

        return attendanceData;
    }
//if the commit failed throw an enter mark exception

    public boolean addAttendance(AttendanceSheet sheet) throws SQLException, ClassNotFoundException, AddRecordException {
        con = DBConnection.getConnection();
        Iterator<Attendance> it = sheet.iterator();
        Attendance record;
        String query = "INSERT INTO attendance (studentID,classID,date,time,employeeID) values (?,?,?,?,?)";
        con.setAutoCommit(false);
        statement = con.prepareStatement(query);

        while (it.hasNext()) {
            record = it.next();
            statement.setString(1, record.getStudentId());
            statement.setString(2, sheet.getClassID());
            statement.setDate(3, record.getDate());
            statement.setTime(4, record.getTime());
            statement.setString(5, record.getEmployeeID());
            statement.addBatch();
            System.out.println(statement);
        }

        if (!it.hasNext()) {
            statement.executeBatch();
            con.commit();
            return true;
        } else {
            con.rollback();
            throw new AddRecordException();
        }

    }


    public int updateAttendance(Attendance newEntry, Attendance oldEntry) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String query = "UPDATE attendance SET studentID=?,examID=?,date=?,time=?,employeeID=? WHERE studentID='" + oldEntry.getStudentId() + "' AND classID='" + oldEntry.getClassID() + "' AND date='" + oldEntry.getDate() + "' AND time='" + oldEntry.getTime() + "'";
        statement = con.prepareStatement(query);

        statement.setString(1, newEntry.getStudentId());
        statement.setString(2, newEntry.getClassID());
        statement.setDate(3, newEntry.getDate());
        statement.setTime(4, newEntry.getTime());
        statement.setString(5, newEntry.getEmployeeID());

        int temp = statement.executeUpdate();
        con.close();

        return temp;
    }

    public CachedRowSetImpl retrieveSingleStudentMarks(String studentID, String classID) throws ClassNotFoundException, SQLException {
        CachedRowSetImpl rs = new CachedRowSetImpl();
        con = DBConnection.getConnection();

        String query = "SELECT * FROM attendance WHERE StudentID='" + studentID + "' AND classID='" + classID + "' ORDER BY date";
        rs.populate(DBHandler.getData(con, query));
        con.close();
        return rs;
    }

    public DefaultCategoryDataset attendanceReportData(String date) throws ClassNotFoundException, SQLException {
        String query1 = "Select classID from class";
        String classID;
        float data;
        int index = 0;
        int classTotalStudent, classMonthlyStudent;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        con = DBConnection.getConnection();
        ResultSet rs1 = null;
        rs1 = DBHandler.getData(con, query1);
        while (rs1.next()) {

            classID = rs1.getString(1);
            
            System.out.println(classID);
            classTotalStudent = totalPresentStudents(con, classID);
            System.out.println("classTotalStudent "+classTotalStudent);
            classMonthlyStudent = classMonthlyStudents(con, classID, date);
            System.out.println("classMonthlyStudent "+classMonthlyStudent);
            data = RoundUp.precision(2, ((float) (classMonthlyStudent) / classTotalStudent)*20);
            dataSet.addValue(data, "Attendance Precentage", classID);

        }
        con.close();
        return dataSet;

    }

    public int totalPresentStudents(Connection con, String classID) throws SQLException {
        int numberOfStudent = 0;
        ResultSet rs;
        String query = "select count(studentID) from classdetail where classID='" + classID + "'";
        rs = DBHandler.getData(con, query);
        if (rs.next()) {
            numberOfStudent = rs.getInt(1);
        }
        return numberOfStudent;
    }

    public int classMonthlyStudents(Connection con, String classID, String date) throws SQLException {
        int numberOfStudent = 0;
        ResultSet rs;
        String query = "select new1.count from("
                + "    select count(new.year) as count,new.year from("
                + "    select extract(year_month from date) as year from attendance where classID='" + classID + "'"
                + "    "
                + "    )as new group by year "
                + "    )as new1 where new1.year='" + date + "'";

        rs = DBHandler.getData(con, query);
        if (rs.next()) {
            numberOfStudent = rs.getInt(1);
        }
        return numberOfStudent;
    }
}

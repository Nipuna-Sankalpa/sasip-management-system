/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.exam.Exam;
import utilities.DBConnection;
import utilities.DBHandler;

/**
 *
 * @author Mampitiya
 */
public class ExamDA {


    private static Connection con;
    private static PreparedStatement statement;
    private static ExamDA exDA=null;
private ExamDA(){}

public static ExamDA getInstance(){
    if (exDA==null) {
        exDA=new ExamDA();
    }
return exDA;
}
    public int addExam(Exam exam) throws SQLException, ClassNotFoundException {
        //con = DBConnection.getConnection();
        String query = "INSERT INTO exam (examID,date,description,classYear,amount) values (?,?,?,?,?)";
        statement = con.prepareStatement(query);
        statement.setString(1, exam.getExamID());
        statement.setDate(2, exam.getDate());
        statement.setString(3, exam.getDiscription());
        statement.setString(4, exam.getClassYear());
        statement.setString(5, exam.getAmount());
        int temp = statement.executeUpdate();
        con.close();
        return temp;
    }

    public int updateExam(Exam exam) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String query = "UPDATE exam SET examID=? , date=? , description=? amount=? WHERE examID=?";
        statement = con.prepareStatement(query);
        statement.setString(1, exam.getExamID());
        statement.setDate(2, exam.getDate());
        statement.setString(3, exam.getDiscription());
        statement.setString(4, exam.getAmount() );
        statement.setString(5, exam.getExamID() );
        int temp = statement.executeUpdate();
        con.close();

        return temp;
    }

    public int deleteExam(String ID) throws ClassNotFoundException, SQLException {

        con = DBConnection.getConnection();
        String query = "DELETE FROM exam WHERE examID='" + ID + "'";
        String query1 = "DELETE FROM marks WHERE examID='" + ID + "'";
        int temp = DBHandler.setData(con, query1);
        int temp1 = DBHandler.setData(con, query);
        con.close();

        return temp;
    }
    public ResultSet searchExamCount(String classYear) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        con = DBConnection.getConnection();
        String query="SELECT examID,date FROM exam WHERE classYear='"+classYear+"'";
        rs=DBHandler.getData(con, query);
        //con.close();
        return rs;
    }
    public ResultSet searchExamID(String examID) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        con = DBConnection.getConnection();
        String query="SELECT * FROM exam WHERE examID='"+examID+"'";
        rs=DBHandler.getData(con, query);
        //con.close();
        return rs;
    }
    public ResultSet searchAll() throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        con = DBConnection.getConnection();
        String query="SELECT examID,date,description FROM exam" ;
        rs=DBHandler.getData(con, query);
        //con.close();
        return rs;
    }

}

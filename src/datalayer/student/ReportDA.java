/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.student;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import javax.sql.rowset.CachedRowSet;
import utilities.DBConnection;
import utilities.DBHandler;

/**
 *
 * @author Yellow Flash
 */
public class ReportDA {

    public int[] attendancePerMonth(int year, int month, String classID) throws SQLException, ClassNotFoundException {

        Connection con = DBConnection.getConnection();
        ResultSet rs;
        month = month - 1;
        String[] query = new String[6];
        int data[] = new int[6];

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Calendar cal3 = Calendar.getInstance();
        Calendar cal4 = Calendar.getInstance();
        Calendar cal5 = Calendar.getInstance();
        Calendar cal6 = Calendar.getInstance();

        cal1.set(year, month, 1);
        cal2.set(year, month, 8);
        cal3.set(year, month, 15);
        cal4.set(year, month, 22);
        cal5.set(year, month, 29);
        cal6.set(year, month, 31);
        java.util.Date date1 = cal1.getTime();
        java.util.Date date2 = cal2.getTime();
        java.util.Date date3 = cal3.getTime();
        java.util.Date date4 = cal4.getTime();
        java.util.Date date5 = cal5.getTime();
        java.util.Date date6 = cal6.getTime();

        Date d1 = new Date(date1.getTime());
        Date d2 = new Date(date2.getTime());
        Date d3 = new Date(date3.getTime());
        Date d4 = new Date(date4.getTime());
        Date d5 = new Date(date5.getTime());
        Date d6 = new Date(date6.getTime());
        
        System.out.println(d1);

        query[0] = "SELECT r.student FROM ( SELECT COUNT(studentID) as student,classID FROM (SELECT studentID,classID FROM attendance WHERE date BETWEEN '" + d1 + "' AND '" + d2 + "' ) AS res1 GROUP BY classID )as r where classID='" + classID + "'";
        query[1] = "SELECT r.student FROM ( SELECT COUNT(studentID) as student,classID FROM (SELECT studentID,classID FROM attendance WHERE date BETWEEN '" + d2 + "' AND '" + d3 + "' ) AS res1 GROUP BY classID )as r where classID='" + classID + "'";
        query[2] = "SELECT r.student FROM ( SELECT COUNT(studentID) as student,classID FROM (SELECT studentID,classID FROM attendance WHERE date BETWEEN '" + d3 + "' AND '" + d4 + "' ) AS res1 GROUP BY classID )as r where classID='" + classID + "'";
        query[3] = "SELECT r.student FROM ( SELECT COUNT(studentID) as student,classID FROM (SELECT studentID,classID FROM attendance WHERE date BETWEEN '" + d4 + "' AND '" + d5 + "' ) AS res1 GROUP BY classID )as r where classID='" + classID + "'";
        query[4] = "SELECT r.student FROM ( SELECT COUNT(studentID) as student,classID FROM (SELECT studentID,classID FROM attendance WHERE date BETWEEN '" + d5 + "' AND '" + d6 + "' ) AS res1 GROUP BY classID )as r where classID='" + classID + "'";
        query[5] = "SELECT result.student FROM (SELECT COUNT(studentID) AS student,classID FROM classdetail GROUP BY classID) AS result WHERE classID='" + classID + "'";
        for (int i = 0; i < 6; i++) {
            rs = DBHandler.getData(con, query[i]);
            if (rs.next()) {
                data[i] = rs.getInt(1);
            }else
                data[i] = 0;
        }
        con.close();
        return data;
    }

}

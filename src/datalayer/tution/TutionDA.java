/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer.tution;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.tution.Tution;
import utilities.DBConnection;
import utilities.DBHandler;

/**
 *
 * @author Mampitiya
 */
public class TutionDA {
    private static Connection con;
    private static PreparedStatement statement;
    private static ResultSet rs;
    
    public int addTution(Tution tution) throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();
        int temp;
        String query = "INSERT INTO class VALUES (?,?,?,?,?);";
        statement = con.prepareStatement(query);
        statement.setString(1, tution.getId());
        statement.setString(2, tution.getYear());
        statement.setString(3, tution.getCategory());
        statement.setString(4, tution.getDay());
        statement.setInt(5, tution.getMonthlyFee());
        
        temp = statement.executeUpdate();
        con.close();
        return temp;
    }
    
    public int deleteTutuion(String classID) throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();
        String query = "DELETE FROM class WHERE classID='"+classID+"'";
        int temp = DBHandler.setData(con, query);
        con.close();
        return temp;
    }
    
    public Tution searchByID(String id) throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();
        String query = "SELECT * FROM class WHERE classID = '" + id + "'";
        rs = DBHandler.getData(con, query);
        if(rs.next()){
            String year = rs.getString(2);
            String cat = rs.getString(3);
            String day = rs.getString(4);
            int monthlyFee = rs.getInt(5);
            
            Tution tution = new Tution(id, cat, year, day, monthlyFee);
            con.close();
            return tution;
        }
        System.out.println("NULL");
        return null;
    }
    
    public CachedRowSetImpl getClassByID() throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();
        CachedRowSetImpl rst=new CachedRowSetImpl();
        String query = "Select classID from class";
        rst.populate(DBHandler.getData(con, query)); 
        con.close();
        return rst;
    }
    
    public int addClassDet(String studentID, String classID) throws ClassNotFoundException, SQLException{
        con = DBConnection.getConnection();
        String query = "Insert into classdetail values('"+studentID+"' , '"+classID+"');";
        int temp = DBHandler.setData(con, query);
        return temp;
    }
    
    public Tution[] searchByClassYear(String input) throws ClassNotFoundException, SQLException {
        con = DBConnection.getConnection();
        String query = "SELECT * FROM class WHERE classYear = '" + input + "'";
        rs = DBHandler.getData(con, query);
        ArrayList<Tution> list = new ArrayList<Tution>();
        
        while(rs.next()){
            String id = rs.getString(1);
            String year = rs.getString(2);
            String cat = rs.getString(3);
            String day = rs.getString(4);
            int monthlyFee = rs.getInt(5);
            
            Tution tution = new Tution(id, cat, year, day, monthlyFee);
            list.add(tution);   
        }
        
        con.close();
        System.out.println("query: "+list.size());
        return list.toArray(new Tution[0]);
    }
}

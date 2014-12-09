/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.tution;

import com.sun.rowset.CachedRowSetImpl;
import datalayer.tution.TutionDA;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.tution.Tution;

/**
 *
 * @author Mampitiya
 */
public class TutionController {//act as the controller that handles messages from the view layer to data access layer
                                   //and vice versa.
    private final TutionDA tutionDA;
    public TutionController(){
        this.tutionDA = new TutionDA();
    }
    public CachedRowSetImpl getClassByID() throws ClassNotFoundException, SQLException{
        return tutionDA.getClassByID();
    }
    
    public Tution searchByID(String id) throws ClassNotFoundException, SQLException{
        return tutionDA.searchByID(id);
    }
    
    public int deleteTutuion(String classID) throws ClassNotFoundException, SQLException{
        return tutionDA.deleteTutuion(classID);
    }
    
    public int addTution(Tution tution) throws ClassNotFoundException, SQLException{
        return tutionDA.addTution(tution);
    }
    
    public int addClassDet(String studentID, String classID) throws ClassNotFoundException, SQLException{
        return tutionDA.addClassDet(studentID, classID);
    }
}

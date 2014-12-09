/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

/**
 *
 * @author Dilip
 */
import java.sql.ResultSet ;
import javax.swing.JOptionPane;
public class ExamIDGenerater {
    
  

    public String createExamID(String classYear,ResultSet rs) 
    {
        String examID ;
        String count = analyzeRS(rs) ;
        if(count.length()==1)
            examID = classYear +"00" + count  ;
        else
            examID = classYear +"0" + count  ;
            
        
        return examID ;
    }
    public String analyzeRS(ResultSet rs)
    {
        int count  = 0;
       try {
           
           while(rs.next())
           {
               count ++ ;
           }
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
       return Integer.toString(count+1);
    }
    
}

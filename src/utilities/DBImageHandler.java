/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;

/**
 *
 * @author Yellow Flash
 */
public class DBImageHandler {private static PreparedStatement statement;
    private static ImageIcon image;
    private static ResultSet rs;

    public static int updateImage(Connection Con, String filePath, String tableName, String ID) throws FileNotFoundException, SQLException {

        FileInputStream fis = new FileInputStream(filePath);
        statement = Con.prepareStatement("UPDATE " + tableName + " SET image=? WHERE " + tableName + "ID='" + ID + "'");
        statement.setBinaryStream(1, (InputStream) fis);
        int ret = statement.executeUpdate();
        Con.close();
        return ret;
    }
//general method definition for retrieve images from dataBase
//use search methods in student and employee to get result set.
//passing result set has to be made next atleast once.

    public static ImageIcon retrieveImage(ResultSet rs) throws SQLException {
        byte array[];

        //DBImageHandler.rs = rs;
        array = rs.getBytes("image");
        image = new ImageIcon(array);
        return image;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pubudu
 */
public class BarcodeReader {
    private String barcode;
    private Scanner in;
    private ArrayList<String> ids;
    private int index;

    public BarcodeReader(File file) {
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BarcodeReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BarcodeReader() {
        ids = new ArrayList<String>();
        ids.add("140001");
        ids.add("140002");
        ids.add("140003");
        ids.add("140004");
    }
    
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public String getNextBarcode(){
//        if(in.hasNext())
//            return in.next();
//        
//        return null;
        return ids.size()<=index ? null : ids.get(index++);
    }
}

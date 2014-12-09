/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pubudu
 */
public class BarcodeReader1 {
    private String barcode;
    private Scanner in;

    public BarcodeReader1(File file) {
        try {
            in = new Scanner(file);
            System.out.println("Test");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BarcodeReader1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public String getNextBarcode(){
        if(in.hasNext())
            return in.next();
        
        return null;
    }
}

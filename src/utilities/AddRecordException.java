/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

/**
 *
 * @author Yellow Flash
 */
public class AddRecordException extends Exception {

    public AddRecordException() {
        super("Error has occured.Data has been rollbacked.Try Again !!");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import accessLevels.AccessLevelManager;
import datalayer.employee.EmployeeDA;
import datalayer.employee.EmployeeWorkDetailDA;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.MainGUI;
import model.employee.Employee;
import model.employee.EmployeeWorkSheet;
import utilities.AddRecordException;

/**
 *
 * @author Yellow Flash
 */
public class LoginController {

    public static void login(LoginWindowInterface window) {
        Employee employee = null;
        String userID;
        int accessLevel;
        char[] password, password1 = null;
        userID = window.getUserTxtFld().getText();
        password = window.getPswrdField().getPassword();
        try {

            employee = new EmployeeDA().searchEmployeeByID(userID);
            password1 = employee.getPassword().toCharArray();
            accessLevel = employee.getAccessLevel();
            if (Arrays.equals(password, password1)) {

                window.setVisible(false);
                updateWorkingDetail(userID);
                MainGUI mainGUI = new MainGUI(userID,employee);
                mainGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                

                AccessLevelManager alm = new AccessLevelManager(mainGUI);

                switch (accessLevel) {
                    case 2:
                        alm.cashierAccess();
                        break;

                    case 3:
                        alm.cardMarkerAccess();
                        break;

                    case 4:

                        alm.teamLeaderAccess();
                        break;
                }
                mainGUI.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(window, "Access Denide");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(window, "User Does Not Exist");
        } catch (AddRecordException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void updateWorkingDetail(String userID) throws SQLException, ClassNotFoundException, AddRecordException{
       EmployeeWorkSheet empSheet = new EmployeeWorkSheet(userID);
        EmployeeWorkDetailDA.addWorkingDetail(empSheet);

    }

    public static void enterLogin(final LoginWindowInterface window) {
        window.getPswrdField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    Employee employee = null;
                    String userID;
                    int accessLevel;
                    char[] password, password1 = null;
                    userID = window.getUserTxtFld().getText();
                    password = window.getPswrdField().getPassword();

                    try {
                        employee = new EmployeeDA().searchEmployeeByID(userID);

                        if (employee != null) {
                            password1 = employee.getPassword().toCharArray();
                            accessLevel = employee.getAccessLevel();
                            if (Arrays.equals(password, password1)) {
                                window.setVisible(false);
                                MainGUI mainGUI = new MainGUI(userID,employee);
                                mainGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                

                                AccessLevelManager alm = new AccessLevelManager(mainGUI);

                                switch (accessLevel) {
                                    case 2:
                                        alm.cashierAccess();
                                        break;

                                    case 3:
                                        alm.cardMarkerAccess();
                                        break;

                                    case 4:

                                        alm.teamLeaderAccess();
                                        break;
                                }

                                mainGUI.setVisible(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(window, "Access Denide");
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                    }
                }
            }
        });
    }
}

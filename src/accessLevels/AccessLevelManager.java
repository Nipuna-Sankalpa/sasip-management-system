/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accessLevels;

import javax.swing.JButton;
import main.MainGUI;

/**
 *
 * @author Mampitiya
 */
public class AccessLevelManager {
    JButton addEmp;
    JButton deleteEmp;
    JButton updateEmp;

    JButton manageExam;
    JButton deleteEx;
    JButton updateEx;

    JButton addPay;
    JButton deletePay;

    JButton addStu;
    JButton updateStu;
    JButton deleteStu;
    JButton perf;
    JButton attendance;
    
    JButton btns[];
    
    public AccessLevelManager(MainGUI mainGUI){ //assign all buttons that should be disabled
        addEmp = mainGUI.getAddEmployeeBtn();
        deleteEmp = mainGUI.getDeleteEmployeeBtn();
        updateEmp = mainGUI.getUpdateEmployeeBtn();
        
        manageExam = mainGUI.getManageExamBtn();
        updateEx = mainGUI.getMarksBtn();
        
        addPay = mainGUI.getAddPaymentBtn();
        deletePay = mainGUI.getDeletePaymentBtn();
        
        addStu = mainGUI.getAddStudentBtn();
        updateStu = mainGUI.getUpdateStudentBtn();
        deleteStu = mainGUI.getDeleteStudentBtn();
        perf = mainGUI.getPerformanceBtn();
        attendance = mainGUI.getWeeklyAttendanceBtn();
    }
    
    public void cashierAccess(){//disable buttons that should not be accessed by cashier
        btns = new JButton[]{addEmp, deleteEmp, updateEmp};
        for (JButton btn : btns) {
            if(btn != null)
            btn.setEnabled(false);
        }
    }
    
    public void teamLeaderAccess(){//disable buttons that should not be accessed by teamLeader
        btns = new JButton[]{addEmp, deleteEmp, updateEmp, addPay, deletePay};
        for (JButton btn : btns) {
            if(btn != null)
            btn.setEnabled(false);
        }
    }
    
    public void cardMarkerAccess(){//disable buttons that should not be accessed by cardMarker
        btns = new JButton[]{manageExam, deleteEx, updateEx, addPay, deletePay, perf};
        for (JButton btn : btns) {
            if(btn != null)
            btn.setEnabled(false); 
        }
    }
}

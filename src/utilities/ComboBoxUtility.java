/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Mampitiya
 */
public class ComboBoxUtility {

    private ArrayList<String> list = new ArrayList<>();

    public static void setComboItem(JComboBox comboBox, String sql) throws SQLException, ClassNotFoundException {
        ResultSet rst = DBHandler.getData(DBConnection.getConnection(), sql);
        String blank = "";
        comboBox.addItem(blank);
        if (rst.next()) {
            do {
                String item = rst.getString(1);
                comboBox.addItem(item);
            } while (rst.next());
        }
    }

    public void setSearchableCombo(final JComboBox comboBox, final JTextField textField, final String noItemText) {
        int size = comboBox.getItemCount();
        for (int i = 0; i < size; i++) {

            boolean exists = false;

            for (String s : list) {
                if (s.equalsIgnoreCase(comboBox.getItemAt(i).toString())) {
                    exists = true;
                    break;
                }
            }
            Collections.sort(list);

            if (!exists) {
                list.add(comboBox.getItemAt(i).toString());
            }
        }
        textField.setText("");

        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode != KeyEvent.VK_ENTER && keyCode != KeyEvent.VK_UP && keyCode != KeyEvent.VK_DOWN && keyCode != KeyEvent.VK_ESCAPE) {
                    String toFind = textField.getText().substring(0, textField.getCaretPosition());

                    comboBox.hidePopup();
                    comboBox.removeAllItems();
                    comboBox.addItem("");

                    for (String item : list) {
                        if (item.toUpperCase().startsWith(toFind.toUpperCase())) {
                            comboBox.addItem(item);
                        }
                    }

                    if (comboBox.getItemCount() == 0) {
                        comboBox.addItem(noItemText);
                    }
                    comboBox.showPopup();
                    textField.setText(toFind);

                } else if (keyCode == KeyEvent.VK_ENTER && comboBox.getSelectedIndex() == -1) {
                    comboBox.setSelectedIndex(comboBox.getSelectedIndex());

                    if (comboBox.getItemCount() == 1 && !(comboBox.getItemAt(0).toString()).equals(noItemText)) {
                        comboBox.setSelectedIndex(0);
                    } else if (comboBox.getItemCount() > 0) {
                        comboBox.setSelectedIndex(0);
                    } else {
                        //   comboBox.setSelectedItem("");
                        textField.setText("");
                    }
                } else if (keyCode == KeyEvent.VK_ESCAPE) {
                    comboBox.setSelectedItem(textField.getText());
                }
            }
        });
    }
}

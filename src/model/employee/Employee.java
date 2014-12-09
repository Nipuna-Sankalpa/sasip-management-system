/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employee;

import javax.swing.ImageIcon;

/**
 *
 * @author Mampitiya
 */
public class Employee {//this defines the model class for an employee object

    private int accessLevel;//define the attributes
    private String address;
    private String designation;
    private String employeeID;
    private String firstName;
    private String lastName;
    private String mobile;
    private String password;
    private String imagePath;
    private ImageIcon image;

    public Employee(int accessLevel, String address, String designation, String employeeID, String firstName, String lastName, String mobile, String imagePath) {
        this.accessLevel = accessLevel;//initialize the attributes
        this.address = address;
        this.designation = designation;
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.imagePath = imagePath;
    }

    public Employee(int accessLevel, String address, String designation, String employeeID, String firstName, String lastName, String mobile, String password, String imagePath) {
        this.accessLevel = accessLevel;//initialize the attributes
        this.address = address;
        this.designation = designation;
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.password = password;
        this.imagePath = imagePath;
    }

    public String getImagePath() {//getImagePath
        return imagePath;
    }

    public void setImagePath(String imagePath) {//setImagePath
        this.imagePath = imagePath;
    }

    public ImageIcon getImage() {//getImage
        return image;
    }

    public void setImage(ImageIcon image) {//setImage
        this.image = image;
    }

    public int getAccessLevel() {//getAccessLevel
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {//setAccessLevel
        this.accessLevel = accessLevel;
    }

    public String getAddress() {//getAddress
        return address;
    }

    public void setAddress(String address) {//setAddress
        this.address = address;
    }

    public String getDesignation() {//getDesignation
        return designation;
    }

    public void setDesignation(String designation) {//setDesignation
        this.designation = designation;
    }

    public String getEmployeeID() {//getEmployeeID
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {//setEmployeeID
        this.employeeID = employeeID;
    }

    public String getFirstName() {//getFirstName
        return firstName;
    }

    public void setFirstName(String firstName) {//setFirstName
        this.firstName = firstName;
    }

    public String getLastName() {//getLastName
        return lastName;
    }

    public void setLastName(String lastName) {//setLastName
        this.lastName = lastName;
    }

    public String getMobile() {//getMobile
        return mobile;
    }

    public void setMobile(String mobile) {//setMobile
        this.mobile = mobile;
    }

    public String getPassword() {//getPassword
        return password;
    }

    public void setPassword(String password) {//setPassword
        this.password = password;
    }

}

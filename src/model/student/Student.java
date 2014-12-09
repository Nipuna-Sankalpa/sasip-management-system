/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.student;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Mampitiya
 */
public class Student {

    private String studentID;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String guardianName;
    private String guardianNumber;
    private boolean gender;
    private ImageIcon image;
    private String filePath;
    private ArrayList <String> attendClasses;
    private String year;

    public Student(String studentID, String firstName, String lastName, String address, String mobileNumber, String guardianName, String guardianNumber, boolean gender, ImageIcon image, String filePath) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.guardianName = guardianName;
        this.guardianNumber = guardianNumber;
        this.gender = gender;
        this.image = image;
        this.filePath = filePath;
    }

    public Student(String studentID, String firstName, String lastName, String address, String mobileNumber, String guardianName, String guardianNumber, boolean gender) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.guardianName = guardianName;
        this.guardianNumber = guardianNumber;
        this.gender = gender;
        attendClasses=new ArrayList<>();
    }

    public ArrayList<String> getAttendClasses() {
        return attendClasses;
    }

    public void setAttendClasses(ArrayList<String> attendClasses) {
        this.attendClasses = attendClasses;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianNumber() {
        return guardianNumber;
    }

    public void setGuardianNumber(String guardianNumber) {
        this.guardianNumber = guardianNumber;
    }

    public boolean isMale() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public void setClass(String classes){
    attendClasses.add(classes);
    }
    public ArrayList<String> getClasses(){
    return attendClasses;       
    }

}

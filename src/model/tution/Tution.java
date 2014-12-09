/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tution;

/**
 *
 * @author Mampitiya
 */
public class Tution {
    private String id;
    private String category;
    private String year;
    private String day;
    private int monthlyFee;

    public Tution(String id, String category, String year, String day, int monthlyFee) {
        this.id = id;
        this.category = category;
        this.year = year;
        this.day = day;
        this.monthlyFee = monthlyFee;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}

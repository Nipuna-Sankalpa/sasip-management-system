/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import datalayer.student.AttendanceDA;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import static report.Exam.reportDA;

/**
 *
 * @author Yellow Flash
 */
public class Attendance {

//    year which need to check attendance and particular month
    private Attendance() {
    }
    private static Attendance attendance = null;

    public static Attendance getInstance() {
        if (attendance == null) {
            attendance = new Attendance();
        }
        return attendance;
    }
    

    public void overallClassPerformanceAnalysis(String year, String month) throws SQLException, ClassNotFoundException {
        AttendanceDA attDA = AttendanceDA.getInstance();
        DefaultCategoryDataset dataSet = attDA.attendanceReportData(year + month);
        JFreeChart chart = ChartFactory.createBarChart3D("", "Classes", "Attendance Precentage", dataSet);
        CategoryPlot plot = chart.getCategoryPlot();
        ChartFrame frame = new ChartFrame("Attendance Analysis",chart);
        frame.setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }
}

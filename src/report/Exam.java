/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import datalayer.exam.ReportsDA;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.TableOrder;
import utilities.RoundUp;

/**
 *
 * @author Yellow Flash
 */
public class Exam {

    static ReportsDA reportDA = new ReportsDA();

    public void overallClassPerformanceGradeAnalysis(String examID) throws SQLException, ClassNotFoundException {
        float gradeA = 0;
        float gradeB = 0;
        float gradeC = 0;
        float gradeS = 0;
        float gradeW = 0;
        float total = 0;
        float total1 = 0;

        total = reportDA.total(examID);

        gradeA = RoundUp.precision(2, reportDA.gradeA(examID) / total);
        gradeB = RoundUp.precision(2, reportDA.gradeB(examID) / total);
        gradeC = RoundUp.precision(2, reportDA.gradeC(examID) / total);
        gradeS = RoundUp.precision(2, reportDA.gradeS(examID) / total);
        gradeW = RoundUp.precision(2, reportDA.gradeW(examID) / total);

        total1 = gradeA + gradeB + gradeC + gradeS + gradeW;

        if (total1 > 100) {
            total1 = total1 - 100;
            gradeW = gradeW - total1;
        }
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        DefaultPieDataset pieDataSet = new DefaultKeyedValuesDataset();
        pieDataSet.setValue("A :-" + gradeA * 100 + "%", gradeA);
        pieDataSet.setValue("B :-" + gradeB * 100 + "%", gradeB);
        pieDataSet.setValue("C :-" + gradeC * 100 + "%", gradeC);
        pieDataSet.setValue("S :-" + gradeS * 100 + "%", gradeS);
        pieDataSet.setValue("W :-" + gradeW * 100 + "%", gradeW);

        JFreeChart chart = ChartFactory.createPieChart("2104 GRADE ANALYSIS", pieDataSet);

        ChartFrame frame = new ChartFrame("GRADE ANALYSIS", chart, true);
        frame.setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    public void overallClassPerformanceAnalysis(String year) throws SQLException, ClassNotFoundException {
        CachedRowSet set = reportDA.OverallClassPerformanceAnalysis(year);

        DefaultCategoryDataset datasetAvg = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetMax = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetMin = new DefaultCategoryDataset();

        while (set.next()) {
            datasetAvg.setValue(set.getDouble(1), "Average Marks", set.getString(4));
            datasetMax.setValue(set.getDouble(2), "Maximum Marks", set.getString(4));
            datasetMin.setValue(set.getDouble(3), "Minimum Marks", set.getString(4));

        }
        JFreeChart chart = ChartFactory.createLineChart("Mark Analysis", "ExamID", "Marks", null);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setDataset(1, datasetAvg);
        plot.setDataset(2, datasetMax);
        plot.setDataset(3, datasetMin);

        CategoryItemRenderer r1 = new DefaultCategoryItemRenderer();
        CategoryItemRenderer r2 = new DefaultCategoryItemRenderer();
        CategoryItemRenderer r3 = new DefaultCategoryItemRenderer();
        r1.setSeriesPaint(1, Color.BLUE);
        r2.setSeriesPaint(2, Color.GREEN);
        r3.setSeriesPaint(3, Color.YELLOW);

        plot.setRenderer(1, r1);
        plot.setRenderer(2, r2);
        plot.setRenderer(3, r3);

        ChartFrame frame = new ChartFrame("Mark Analysis", chart);
        frame.setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    public void individualPerformance(String studentID) throws ClassNotFoundException, SQLException {
        CachedRowSet set = reportDA.individualPerformance(studentID);

        DefaultCategoryDataset datasetAvg = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetMax = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetMarks = new DefaultCategoryDataset();

        while (set.next()) {

            datasetAvg.setValue(RoundUp.precision(1, (float) set.getDouble(2)), "Average Marks", set.getString(1));
            datasetMax.setValue(RoundUp.precision(1, (float) set.getDouble(3)), "Maximum Marks", set.getString(1));
            datasetMarks.setValue(RoundUp.precision(1, (float) set.getDouble(5)), "Individual Marks", set.getString(1));

        }
        JFreeChart chart = ChartFactory.createLineChart("Mark Analysis", "ExamID", "Marks", null);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setDataset(1, datasetAvg);
        plot.setDataset(2, datasetMax);
        plot.setDataset(3, datasetMarks);

        CategoryItemRenderer r1 = new DefaultCategoryItemRenderer();
        CategoryItemRenderer r2 = new DefaultCategoryItemRenderer();
        CategoryItemRenderer r3 = new DefaultCategoryItemRenderer();
        r1.setSeriesPaint(1, Color.BLUE);
        r2.setSeriesPaint(2, Color.GREEN);
        r3.setSeriesPaint(3, Color.YELLOW);

        plot.setRenderer(1, r1);
        plot.setRenderer(2, r2);
        plot.setRenderer(3, r3);

        ChartFrame frame = new ChartFrame("Mark Analysis", chart);
        frame.setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    public void examAttendanceReport(String year) throws ClassNotFoundException, SQLException {
        DefaultCategoryDataset dataSet = reportDA.attendanceReport(year);
        JFreeChart chart = ChartFactory.createBarChart3D("", "Classes", "Attendance Precentage", dataSet);
        CategoryPlot plot = chart.getCategoryPlot();
        ChartFrame frame = new ChartFrame("Attendance Analysis", chart);
        frame.setSize(800, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);

    }
}

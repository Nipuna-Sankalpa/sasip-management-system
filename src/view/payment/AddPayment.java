/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.payment;

/**
 *
 * @author Yasanka Jayawardane
 */
public class AddPayment extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddPayment
     */
    public AddPayment(String userID) {
        initComponents();
        
        MonthPayment monthPayment = new MonthPayment(userID);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) monthPayment.getUI()).setNorthPane(null);
        addMonthPayment.add(monthPayment);
        monthPayment.setVisible(true);

        ExamPayment examPayment = new ExamPayment(userID);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) examPayment.getUI()).setNorthPane(null);
        addExamPayment.add(examPayment);
        examPayment.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        addMonthPayment = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        addExamPayment = new javax.swing.JDesktopPane();

        setBorder(null);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        addMonthPayment.setOpaque(false);

        javax.swing.GroupLayout addMonthPaymentLayout = new javax.swing.GroupLayout(addMonthPayment);
        addMonthPayment.setLayout(addMonthPaymentLayout);
        addMonthPaymentLayout.setHorizontalGroup(
            addMonthPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        addMonthPaymentLayout.setVerticalGroup(
            addMonthPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMonthPayment)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMonthPayment)
        );

        jTabbedPane1.addTab("Month Payment", jPanel2);

        addExamPayment.setOpaque(false);

        javax.swing.GroupLayout addExamPaymentLayout = new javax.swing.GroupLayout(addExamPayment);
        addExamPayment.setLayout(addExamPaymentLayout);
        addExamPaymentLayout.setHorizontalGroup(
            addExamPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        addExamPaymentLayout.setVerticalGroup(
            addExamPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addExamPayment)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addExamPayment)
        );

        jTabbedPane1.addTab("Exam Payment", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane addExamPayment;
    private javax.swing.JDesktopPane addMonthPayment;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}

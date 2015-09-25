/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author namBH
 */
public class AdminPanel extends javax.swing.JPanel {


    public AdminPanel() {
        initComponents();
        
        QuestionManagementPanel pnlQuestion = new QuestionManagementPanel();
        tabPnlMain.addTab("Question Management", pnlQuestion);
        
        AccountManagementPanel pnlAccount = new AccountManagementPanel();
        tabPnlMain.addTab("Account Management", pnlAccount);
        
        QuizPanel pnlQuiz = new QuizPanel();
        tabPnlMain.addTab("Statistic Quiz", pnlQuiz);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPnlMain = new javax.swing.JTabbedPane();

        setLayout(new java.awt.BorderLayout());
        add(tabPnlMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabPnlMain;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.QuestionBll;
import bll.QuizBll;
import bll.QuizDetailBll;
import bll.UserBll;
import dto.QuizDetailObj;
import dto.QuizObj;
import dto.UserObj;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author namBH
 */
public class ViewResultPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewResultPanel
     */
    UserBll userBll = new UserBll();
    QuestionBll questionBll = new QuestionBll();
    QuizBll quizBll = new QuizBll();
    QuizDetailBll quizDetailBll = new QuizDetailBll();
    ArrayList<QuizObj> lstQuiz = new ArrayList<>();
    
    private String username;
    
    public ViewResultPanel(JLabel lblStatus) {
        initComponents();
        
        String strStatus = lblStatus.getText();
        username = strStatus.substring(0, strStatus.indexOf(" "));
        
        bindingQuizTable();
    }
    
    private void setQuizTableWidth(String colName, int width){
        tblQuiz.getColumn(colName).setPreferredWidth(width);
        tblQuiz.getColumn(colName).setMaxWidth(width);
        tblQuiz.getColumn(colName).setMinWidth(width);
    }
    
    private void setQuizDetailTableWidth(String colName, int width){
        tblQuizDetail.getColumn(colName).setPreferredWidth(width);
        tblQuizDetail.getColumn(colName).setMaxWidth(width);
        tblQuizDetail.getColumn(colName).setMinWidth(width);
    }
    
    private void bindingQuizTable(){
        UserObj obj = userBll.getUserByUsername(username);
        
        lstQuiz = quizBll.getByUser(obj.getUserId());
        Vector cols = new Vector();
        Vector data = new Vector();
        cols.add("ID");
        cols.add("Date Play");
        cols.add("Money");
        
        for (QuizObj quizObj : lstQuiz) {
            Vector row = new Vector();
            row.add(quizObj.getQuizId());
            row.add(quizObj.getDateChange());
            row.add("$ " + quizObj.getMoney());
            
            data.add(row);
        }
        DefaultTableModel tblModel = new DefaultTableModel(data, cols);
        tblQuiz.setModel(tblModel);
        setQuizTableWidth("ID", 30);
        setQuizTableWidth("Money", 50);
        
        if(lstQuiz.size() > 0){
            tblQuiz.setRowSelectionInterval(0, 0);
            bindingQuizDetailTable(0);
        }
    }

    private void bindingQuizDetailTable(int rowSelected){
        if(rowSelected >= 0 && rowSelected < lstQuiz.size()){
            QuizObj quiz = lstQuiz.get(rowSelected);
            ArrayList<QuizDetailObj> lstQuizDetail = quizDetailBll.getById(quiz.getQuizId());
            
            Vector cols = new Vector();
            Vector data = new Vector();
            cols.add("Index");
            cols.add("Question");
            cols.add("Answered");

            int i=1;
            for (QuizDetailObj quizDetailObj : lstQuizDetail) {
                Vector row = new Vector();
                row.add(i++);
                row.add(questionBll.getById(quizDetailObj.getQuestionId()).getContent());
                row.add(quizDetailObj.isStatus() ? "True" : "False");

                data.add(row);
            }
            DefaultTableModel tblModel = new DefaultTableModel(data, cols);
            tblQuizDetail.setModel(tblModel);
            setQuizDetailTableWidth("Index", 50);
            setQuizDetailTableWidth("Answered", 60);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuiz = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuizDetail = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(255);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quiz Result"));

        tblQuiz.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblQuiz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblQuiz.setRowHeight(20);
        tblQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuizMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQuiz);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quiz Question", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblQuizDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblQuizDetail.setEnabled(false);
        tblQuizDetail.setRowHeight(30);
        jScrollPane2.setViewportView(tblQuizDetail);

        jSplitPane1.setRightComponent(jScrollPane2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblQuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuizMouseClicked
        int rowSelected = tblQuiz.getSelectedRow();
        bindingQuizDetailTable(rowSelected);
    }//GEN-LAST:event_tblQuizMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tblQuiz;
    private javax.swing.JTable tblQuizDetail;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.QuizBll;
import bll.UserBll;
import dto.AdminObj;
import dto.QuizObj;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NamPC
 */
public class QuizPanel extends javax.swing.JPanel {

    QuizBll quizBll = new QuizBll();
    UserBll userBll = new UserBll();
    
    ArrayList<QuizObj> lstQuiz = new ArrayList<>();
    
    public QuizPanel() {
        initComponents();
        
        bindingData();
    }
    
    private void bindingData(){
        lstQuiz = quizBll.getAll();
        
        Vector cols = new Vector();
        cols.add("Id");
        cols.add("Date Play");
        cols.add("Money");
        cols.add("User");
        
        Vector data = new Vector();
        for (QuizObj quiz : lstQuiz) {
            Vector row = new Vector();
            row.add(quiz.getQuizId());
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            row.add(dateFormat.format(quiz.getDateChange()));
            row.add("$ "+quiz.getMoney());
            row.add(userBll.getUserById(quiz.getUserId()).getUsername());
            
            data.add(row);
        }
        
        DefaultTableModel tblModel = new DefaultTableModel(data, cols);
        tblQuiz.setModel(tblModel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblQuiz = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

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
        tblQuiz.setRowHeight(25);
        jScrollPane1.setViewportView(tblQuiz);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQuiz;
    // End of variables declaration//GEN-END:variables
}

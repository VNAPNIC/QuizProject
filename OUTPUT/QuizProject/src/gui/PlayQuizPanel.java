/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.AnswerBll;
import bll.QuestionBll;
import bll.QuizBll;
import bll.QuizDetailBll;
import bll.UserBll;
import dto.AnswerObj;
import dto.QuestionObj;
import dto.QuizDetailObj;
import dto.QuizObj;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author namBH
 */
public class PlayQuizPanel extends javax.swing.JPanel {
    
    QuestionBll questionBll = new QuestionBll();
    AnswerBll answerBll = new AnswerBll();
    UserBll userBll = new UserBll();
    QuizBll quizBll = new QuizBll();
    QuizDetailBll quizDetailBll = new QuizDetailBll();
    
    ArrayList<QuestionObj> lstQuestion = new ArrayList<>();
    ArrayList<AnswerObj> lstAnwser = new ArrayList<>();
    ArrayList<QuizDetailObj> lstSelected = new ArrayList<>();
    int questionLength = 10;
    int indexQuestion = 0;
    private String username;
    
    public PlayQuizPanel(JLabel lblStatus) {
        initComponents();
        
        String strStatus = lblStatus.getText();
        username = strStatus.substring(0, strStatus.indexOf(" "));
        loadData();
        bindingControl();
    }
    
    private void loadData() {
        ArrayList<QuestionObj> lstAllQuestion = questionBll.getAll();
        while (lstQuestion.size() < questionLength && lstAllQuestion.size() > 0) {
            int index = (int) (Math.random() * lstAllQuestion.size());
            lstQuestion.add(lstAllQuestion.get(index));
            lstAllQuestion.remove(index);
        }
    }
    
    private void bindingControl() {
        rdbA.setSelected(true);
        if (indexQuestion < lstQuestion.size()) {
            QuestionObj question = lstQuestion.get(indexQuestion);
            txtQuestion.setText(question.getContent());
            lstAnwser = answerBll.getAnswerByQuestion(question.getQuestionId());
            if (lstAnwser.size() == 4) {
                rdbA.setText(lstAnwser.get(0).getContent());
                rdbB.setText(lstAnwser.get(1).getContent());
                rdbC.setText(lstAnwser.get(2).getContent());
                rdbD.setText(lstAnwser.get(3).getContent());
            }
        } 
        lstMoney.setSelectedIndex(questionLength - indexQuestion);
    }
    
    private void saveQuiz(){
        QuizObj quizObj = new QuizObj();
        quizObj.setDateChange(new Timestamp(new Date().getTime()));
        String strMoney = lstMoney.getSelectedValue().toString();
        quizObj.setMoney(Integer.parseInt(strMoney.substring(strMoney.indexOf(" ")+1)));
        quizObj.setUserId(userBll.getUserByUsername(username).getUserId());
        
        quizBll.insert(quizObj);
        ArrayList<QuizObj> lstQuiz = quizBll.getAll();
        quizObj.setQuizId(lstQuiz.get(lstQuiz.size()-1).getQuizId());
        
        for (QuizDetailObj quizDetail : lstSelected) {
            quizDetail.setQuizId(quizObj.getQuizId());
            quizDetailBll.insert(quizDetail);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMoney = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        rdbD = new javax.swing.JRadioButton();
        rdbC = new javax.swing.JRadioButton();
        rdbB = new javax.swing.JRadioButton();
        rdbA = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setPreferredSize(new java.awt.Dimension(598, 223));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(170, 117));

        txtQuestion.setEditable(false);
        txtQuestion.setBackground(new java.awt.Color(204, 204, 204));
        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        txtQuestion.setBorder(javax.swing.BorderFactory.createTitledBorder("Question"));
        jScrollPane1.setViewportView(txtQuestion);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(70, 464));

        lstMoney.setBackground(new java.awt.Color(204, 204, 204));
        lstMoney.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Money", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        lstMoney.setFont(new java.awt.Font(".VnGothic", 1, 12)); // NOI18N
        lstMoney.setForeground(new java.awt.Color(0, 0, 255));
        lstMoney.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "$ 1000", "$ 900", "$ 800", "$ 700", "$ 600", "$ 500", "$ 400", "$ 300", "$ 200", "$ 100", "$ 0" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstMoney.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstMoney.setEnabled(false);
        jScrollPane2.setViewportView(lstMoney);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Answer"));

        rdbD.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdbD);

        rdbC.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdbC);

        rdbB.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdbB);
        rdbB.setText(" ");

        rdbA.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdbA);
        rdbA.setSelected(true);
        rdbA.setText(" ");

        jLabel1.setText("A. ");

        jLabel2.setText("B. ");

        jLabel3.setText("C. ");

        jLabel4.setText("D. ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(rdbB, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbA)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdbB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rdbC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdbD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.png"))); // NOI18N
        btnSubmit.setText(" Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel5.setText(" ");

        jLabel6.setText(" ");

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 0, 0));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("  ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        lblMessage.setText("");
        lblMessage.setForeground(Color.RED);
        int select = -1;
        if(rdbA.isSelected()){
            select = 0;
        } else if(rdbB.isSelected()){
            select = 1;
        } else if(rdbC.isSelected()){
            select = 2;
        } else if(rdbD.isSelected()){
            select = 3;
        }
        if(select > -1){
            QuizDetailObj quizDetail = new QuizDetailObj();
            quizDetail.setQuestionId(lstQuestion.get(indexQuestion).getQuestionId());
            if(lstAnwser.get(select).isStatus()){
                quizDetail.setStatus(true);
                lstSelected.add(quizDetail);
                
                indexQuestion++;
                bindingControl();
                if(indexQuestion == questionLength){
                    lblMessage.setText("You are victory !!!");
                    lblMessage.setForeground(Color.GREEN);
                    btnSubmit.setEnabled(false);
                    saveQuiz();
                }
            } else {
                quizDetail.setStatus(false);
                lstSelected.add(quizDetail);
                
                lblMessage.setText("You are loser !");
                btnSubmit.setEnabled(false);
                saveQuiz();
            }
        } else {
            lblMessage.setText("Select a true answer");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JList lstMoney;
    private javax.swing.JRadioButton rdbA;
    private javax.swing.JRadioButton rdbB;
    private javax.swing.JRadioButton rdbC;
    private javax.swing.JRadioButton rdbD;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.QuizDetailObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuizDetailDao extends DaoTool {

    public boolean insert(QuizDetailObj obj) {
        boolean rs = false;
        String sql = "insert into QuizDetail(quiz_id, question_id, [status]) values(?, ?, ?)";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, obj.getQuizId());
            pre.setInt(2, obj.getQuestionId());
            pre.setBoolean(3, obj.isStatus());
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ArrayList<QuizDetailObj> getById(int quizId) {
        ArrayList<QuizDetailObj> lstQuizDetail = new ArrayList<>();
        String sql = "select * from QuizDetail where quiz_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, quizId);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                while(rsSelect.next()){
                    QuizDetailObj obj = new QuizDetailObj();
                    obj.setQuizId(rsSelect.getInt("quiz_id"));
                    obj.setQuestionId(rsSelect.getInt("question_id"));
                    obj.setStatus(rsSelect.getBoolean("status"));
                    
                    lstQuizDetail.add(obj);
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(QuizDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstQuizDetail;
    }

    public ArrayList<QuizDetailObj> getByQuestion(int questionId) {
        ArrayList<QuizDetailObj> lstQuizDetail = new ArrayList<>();
        String sql = "select * from QuizDetail where question_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, questionId);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                while(rsSelect.next()){
                    QuizDetailObj obj = new QuizDetailObj();
                    obj.setQuizId(rsSelect.getInt("quiz_id"));
                    obj.setQuestionId(rsSelect.getInt("question_id"));
                    obj.setStatus(rsSelect.getBoolean("status"));
                    
                    lstQuizDetail.add(obj);
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(QuizDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstQuizDetail;
    }
}

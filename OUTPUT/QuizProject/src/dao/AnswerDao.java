/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AnswerObj;
import dto.QuestionObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AnswerDao extends DaoTool{
    public ArrayList<AnswerObj> getAnswerByQuestion(int questionId) {
        ArrayList<AnswerObj> rs = new ArrayList<>();
        String sql = "select * from Answer where question_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, questionId);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                while(rsSelect.next()){
                    AnswerObj obj = new AnswerObj();
                    obj.setAnswerId(rsSelect.getInt("answer_id"));
                    obj.setContent(rsSelect.getString("content"));
                    obj.setQuestionId(rsSelect.getInt("question_id"));
                    obj.setStatus(rsSelect.getBoolean("status"));
                    rs.add(obj);
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public AnswerObj getById(int answerId) {
        AnswerObj rs = null;
        String sql = "select * from Answer where answer_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, answerId);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                if(rsSelect.next()){
                    rs = new AnswerObj();
                    rs.setAnswerId(answerId);
                    rs.setContent(rsSelect.getString("content"));
                    rs.setQuestionId(rsSelect.getInt("question_id"));
                    rs.setStatus(rsSelect.getBoolean("status"));
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean insert(AnswerObj obj) {
        boolean rs = false;
        String sql = "insert into Answer(content, question_id, [status]) values(?, ?, ?)";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, obj.getContent());
            pre.setInt(2, obj.getQuestionId());
            pre.setBoolean(3, obj.isStatus());
            
            int count = pre.executeUpdate();
            if(count > 0){
                rs = true;
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean update(AnswerObj obj) {
        boolean rs = false;
        String sql = "update Answer set content=?, question_id=?, [status]=? where answer_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, obj.getContent());
            pre.setInt(2, obj.getQuestionId());
            pre.setBoolean(3, obj.isStatus());
            pre.setInt(4, obj.getAnswerId());
            
            int count = pre.executeUpdate();
            if(count > 0){
                rs = true;
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean delete(int answerId) {
        boolean rs = false;
        String sql = "delete Answer where answer_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, answerId);
            
            int count = pre.executeUpdate();
            if(count > 0){
                rs = true;
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean deleteByQuestion(int questionId) {
        boolean rs = false;
        String sql = "delete Answer where question_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, questionId);
            
            int count = pre.executeUpdate();
            if(count > 0){
                rs = true;
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}

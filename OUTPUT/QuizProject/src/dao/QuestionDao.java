/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.QuestionObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuestionDao extends DaoTool{
    public ArrayList<QuestionObj> getAll() {
        ArrayList<QuestionObj> rs = new ArrayList<>();
        String sql = "select * from Question";
        try {
            connect();
            ResultSet rsSelect = getResultSet(sql);
            if (rsSelect != null) {
                while(rsSelect.next()){
                    QuestionObj obj = new QuestionObj(rsSelect.getInt("question_id"), rsSelect.getString("content"));
                    rs.add(obj);
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public QuestionObj getById(int questionId) {
        QuestionObj rs = new QuestionObj();
        String sql = "select * from Question where question_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, questionId);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                if(rsSelect.next()){
                    rs = new QuestionObj(rsSelect.getInt("question_id"), rsSelect.getString("content"));
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean insert(QuestionObj obj) {
        boolean rs = false;
        String sql = "insert into Question(content) values(?)";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, obj.getContent());
            
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
    
    public boolean update(QuestionObj obj) {
        boolean rs = false;
        String sql = "update Question set content=? where question_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, obj.getContent());
            pre.setInt(2, obj.getQuestionId());
            
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
    
    public boolean delete(int questionId) {
        boolean rs = false;
        String sql = "delete Question where question_id=?";
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

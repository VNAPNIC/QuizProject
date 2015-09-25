/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.QuizObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QuizDao extends DaoTool {

    public boolean insert(QuizObj obj) {
        boolean rs = false;
        String sql = "insert into Quiz(date_change, [money], [user_id]) values(?, ?, ?)";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setTimestamp(1, obj.getDateChange());
            pre.setInt(2, obj.getMoney());
            pre.setInt(3, obj.getUserId());
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ArrayList<QuizObj> getAll() {
        ArrayList<QuizObj> lstQuiz = new ArrayList<>();
        String sql = "select * from Quiz";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                while(rsSelect.next()){
                    QuizObj obj = new QuizObj();
                    obj.setQuizId(rsSelect.getInt("quiz_id"));
                    obj.setDateChange(rsSelect.getTimestamp("date_change"));
                    obj.setMoney(rsSelect.getInt("money"));
                    obj.setUserId(rsSelect.getInt("user_id"));
                    
                    lstQuiz.add(obj);
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(QuizDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstQuiz;
    }
    
    public ArrayList<QuizObj> getByUser(int userId) {
        ArrayList<QuizObj> lstQuiz = new ArrayList<>();
        String sql = "select * from Quiz where user_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, userId);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                while(rsSelect.next()){
                    QuizObj obj = new QuizObj();
                    obj.setQuizId(rsSelect.getInt("quiz_id"));
                    obj.setDateChange(rsSelect.getTimestamp("date_change"));
                    obj.setMoney(rsSelect.getInt("money"));
                    obj.setUserId(rsSelect.getInt("user_id"));
                    
                    lstQuiz.add(obj);
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(QuizDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstQuiz;
    }


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDao extends DaoTool {

    public boolean insert(UserObj obj) {
        boolean rs = false;
        String sql = "insert into [User](username, [password], email, birthday, [address]) values(?, ?, ?, ? , ?)";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getPassword());
            pre.setString(3, obj.getEmail());
            pre.setString(4, obj.getBirthday());
            pre.setString(5, obj.getAddress());
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean update(UserObj obj) {
        boolean rs = false;
        String sql = "update [User] set username=?, [password]=?, email=?, birthday=?, [address]=? where user_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getPassword());
            pre.setString(3, obj.getEmail());
            pre.setString(4, obj.getBirthday());
            pre.setString(5, obj.getAddress());
            pre.setInt(6, obj.getUserId());
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean delete(int userId) {
        boolean rs = false;
        String sql = "delete [User] where user_id=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, userId);
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public UserObj getUserByUsername(String username) {
        UserObj obj = null;
        String sql = "select * from [User] where username=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                if(rsSelect.next()){
                    obj = new UserObj();
                    obj.setUserId(rsSelect.getInt("user_id"));
                    obj.setUsername(rsSelect.getString("username"));
                    obj.setPassword(rsSelect.getString("password"));
                    obj.setEmail(rsSelect.getString("email"));
                    obj.setBirthday(rsSelect.getString("birthday"));
                    obj.setAddress(rsSelect.getString("address"));
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    public UserObj getUserById(int userId) {
        UserObj obj = null;
        String sql = "select * from [User] where [user_id]=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, userId);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                if(rsSelect.next()){
                    obj = new UserObj();
                    obj.setUserId(rsSelect.getInt("user_id"));
                    obj.setUsername(rsSelect.getString("username"));
                    obj.setPassword(rsSelect.getString("password"));
                    obj.setEmail(rsSelect.getString("email"));
                    obj.setBirthday(rsSelect.getString("birthday"));
                    obj.setAddress(rsSelect.getString("address"));
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    public boolean check(String username, String password) {
        boolean rs = false;
        String sql = "select count(*) from [User] where upper(username)=? and password=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username.toUpperCase());
            pre.setString(2, password);
            ResultSet rsCount = pre.executeQuery();
            if (rsCount != null && rsCount.next()) {
                int count = rsCount.getInt(1);
                if (count > 0) {
                    rs = true;
                }
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    
}

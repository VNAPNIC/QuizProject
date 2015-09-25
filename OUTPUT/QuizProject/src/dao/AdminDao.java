/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AdminObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminDao extends DaoTool {

    public boolean insert(AdminObj obj) {
        boolean rs = false;
        String sql = "insert into [Admin](username, [password], full_name, birthday, email) values(?, ?, ?, ?, ?)";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getPassword());
            pre.setString(3, obj.getFullName());
            pre.setString(4, obj.getBirthday());
            pre.setString(5, obj.getEmail());
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean update(AdminObj obj) {
        boolean rs = false;
        String sql = "update [Admin] set [password]=?, full_name=?, birthday=?, email=? where username=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, obj.getPassword());
            pre.setString(2, obj.getFullName());
            pre.setString(3, obj.getBirthday());
            pre.setString(4, obj.getEmail());
            pre.setString(5, obj.getUsername());
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean delete(String username) {
        boolean rs = false;
        String sql = "delete [Admin] where username=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            int count = pre.executeUpdate();
            if (count > 0) {
                rs = true;
            }
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public AdminObj getByUsername(String username) {
        AdminObj obj = null;
        String sql = "select * from [Admin] where username=?";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                if(rsSelect.next()){
                    obj = new AdminObj();
                    obj.setUsername(rsSelect.getString("username"));
                    obj.setPassword(rsSelect.getString("password"));
                    obj.setFullName(rsSelect.getString("full_name"));
                    obj.setBirthday(rsSelect.getString("birthday"));
                    obj.setEmail(rsSelect.getString("email"));
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    public ArrayList<AdminObj> getAll() {
        ArrayList<AdminObj> lstAdmin = new ArrayList<>();
        String sql = "select * from [Admin]";
        try {
            connect();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rsSelect = pre.executeQuery();
            if (rsSelect != null) {
                while(rsSelect.next()){
                    AdminObj obj = new AdminObj();
                    obj.setUsername(rsSelect.getString("username"));
                    obj.setPassword(rsSelect.getString("password"));
                    obj.setFullName(rsSelect.getString("full_name"));
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    obj.setBirthday(dateFormat.format(rsSelect.getDate("birthday")));
                    obj.setEmail(rsSelect.getString("email"));
                    
                    lstAdmin.add(obj);
                }
            }
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstAdmin;
    }

    public boolean check(String username, String password) {
        boolean rs = false;
        String sql = "select count(*) from [Admin] where upper(username)=? and [password]=?";
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
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    
}

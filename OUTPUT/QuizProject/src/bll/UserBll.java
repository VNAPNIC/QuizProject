/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.UserDao;
import dto.UserObj;


public class UserBll {
    UserDao dao = new UserDao();

    public UserBll() {
    }
    
    public boolean insert(UserObj obj) {
        return dao.insert(obj);
    }
    
    public boolean update(UserObj obj){
        return dao.update(obj);
    }
    
    public boolean delete(int userId) {
        return dao.delete(userId);
    }
    
    public UserObj getUserByUsername(String username) {
        return dao.getUserByUsername(username);
    }
    
    public UserObj getUserById(int userId) {
        return dao.getUserById(userId);
    }
    
    public boolean check(String username, String password) {
        return dao.check(username, password);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.AdminDao;
import dto.AdminObj;
import java.util.ArrayList;


public class AdminBll {
    AdminDao dao = new AdminDao();

    public AdminBll() {
    }
    
    public boolean insert(AdminObj obj) {
        return dao.insert(obj);
    }
    
    public boolean update(AdminObj obj){
        return dao.update(obj);
    }
    
    public boolean delete(String username) {
        return dao.delete(username);
    }
    
    public AdminObj getByUsername(String username) {
        return dao.getByUsername(username);
    }
    
    public ArrayList<AdminObj> getAll(){
        return dao.getAll();
    }
    
    public boolean check(String username, String password) {
        return dao.check(username, password);
    }
}

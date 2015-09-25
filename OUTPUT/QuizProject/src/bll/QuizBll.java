/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.QuizDao;
import dto.QuizObj;
import java.util.ArrayList;


public class QuizBll {
    QuizDao dao = new QuizDao();
    
    public boolean insert(QuizObj obj) {
        return dao.insert(obj);
    }
    
    public ArrayList<QuizObj> getAll() {
        return dao.getAll();
    }
    
    public ArrayList<QuizObj> getByUser(int userId) {
        return dao.getByUser(userId);
    }
}

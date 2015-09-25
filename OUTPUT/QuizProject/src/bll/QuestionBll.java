/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.QuestionDao;
import dto.QuestionObj;
import java.util.ArrayList;


public class QuestionBll {
    QuestionDao dao = new QuestionDao();
    public ArrayList<QuestionObj> getAll() {
        return dao.getAll();
    }
    
    public QuestionObj getById(int questionId) {
        return dao.getById(questionId);
    }
    
    public boolean insert(QuestionObj obj){
        return dao.insert(obj);
    }
        
    public boolean update(QuestionObj obj){
        return dao.update(obj);
    }
        
    public boolean delete(int questionId){
        return dao.delete(questionId);
    }
}

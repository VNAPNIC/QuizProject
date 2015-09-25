/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.AnswerDao;
import dto.AnswerObj;
import dto.QuestionObj;
import java.util.ArrayList;


public class AnswerBll {
    AnswerDao dao = new AnswerDao();
    public ArrayList<AnswerObj> getAnswerByQuestion(int questionId) {
        return dao.getAnswerByQuestion(questionId);
    }
    
    public AnswerObj getById(int answerId) {
        return dao.getById(answerId);
    }
    
    public boolean insert(AnswerObj obj){
        return dao.insert(obj);
    }
        
    public boolean update(AnswerObj obj){
        return dao.update(obj);
    }
        
    public boolean delete(int answerId){
        return dao.delete(answerId);
    }
    
    public boolean deleteByQuestion(int questionId){
        return dao.deleteByQuestion(questionId);
    }
}

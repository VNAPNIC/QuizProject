/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.QuizDetailDao;
import dto.QuizDetailObj;
import java.util.ArrayList;


public class QuizDetailBll {
    QuizDetailDao dao = new QuizDetailDao();
    
    public boolean insert(QuizDetailObj obj) {
        return dao.insert(obj);
    }
    
    public ArrayList<QuizDetailObj> getById(int quizId) {
        return dao.getById(quizId);
    }
    
    public ArrayList<QuizDetailObj> getByQuestion(int questionId) {
        return dao.getByQuestion(questionId);
    }
    
    
}

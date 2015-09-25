/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


public class QuizDetailObj {
    private int quizId;
    private int questionId;
    private boolean status;

    public QuizDetailObj() {
    }

    public QuizDetailObj(int quizId, int questionId, boolean status) {
        this.quizId = quizId;
        this.questionId = questionId;
        this.status = status;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}

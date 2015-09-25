/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


public class AnswerObj {
    private int answerId;
    private String content;
    private int questionId;
    private boolean status;

    public AnswerObj() {
    }

    public AnswerObj(int answerId, String content, int questionId, boolean status) {
        this.answerId = answerId;
        this.content = content;
        this.questionId = questionId;
        this.status = status;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}

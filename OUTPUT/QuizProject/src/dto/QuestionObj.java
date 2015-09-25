/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


public class QuestionObj {
    private int questionId;
    private String content;

    public QuestionObj() {
    }

    public QuestionObj(int questionId, String content) {
        this.questionId = questionId;
        this.content = content;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}

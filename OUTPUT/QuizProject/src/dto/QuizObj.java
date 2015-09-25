/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Timestamp;


public class QuizObj {
    private int quizId;
    private Timestamp dateChange;
    private int money;
    private int userId;

    public QuizObj() {
    }

    public QuizObj(int quizId, Timestamp dateChange, int money, int userId) {
        this.quizId = quizId;
        this.dateChange = dateChange;
        this.money = money;
        this.userId = userId;
    }

    public Timestamp getDateChange() {
        return dateChange;
    }

    public void setDateChange(Timestamp dateChange) {
        this.dateChange = dateChange;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}

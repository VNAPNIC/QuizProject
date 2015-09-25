/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


public class AdminObj {
    private String username;
    private String password;
    private String fullName;
    private String birthday;
    private String email;

    public AdminObj() {
    }

    public AdminObj(String username, String password, String fullName, String birthday, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}

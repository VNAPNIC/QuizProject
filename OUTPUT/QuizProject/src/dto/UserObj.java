/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


public class UserObj {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String birthday;
    private String address;

    public UserObj() {
    }

    public UserObj(String username, String password, String email, String birthday, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }

    public UserObj(int userId, String username, String password, String email, String birthday, String address) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.regex.Pattern;


public class Common {
    public final static String INSERT_SUCCESS = "Insert success !";
    public final static String INSERT_FAIL = "Insert fail !";
    
     public final static String ADD_SUCCESS = "Add success !";
    public final static String ADD_FAIL = "Add fail !";
    
    public final static String REGISTER_SUCCESS = "Register success !";
    public final static String REGISTER_FAIL = "Register fail !";
    
    public final static String LOGIN_FAIL = "Login fail !";
    
    public final static String UPDATE_SUCCESS = "Update success !";
    public final static String UPDATE_FAIL = "Update fail !";
    
    public final static String CHANGE_SUCCESS = "Change success !";
    public final static String CHANGE_FAIL = "Change fail !";
    
    public final static String DELETE_SUCCESS = "Delete success !";
    public final static String DELETE_FAIL = "Delete fail !";
            
    public static boolean checkEmail(String email) {
        if (!Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email)) {
            return false;
        } else {
            return true;
        }
    }
}

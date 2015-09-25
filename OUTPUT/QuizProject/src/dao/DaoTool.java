/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoTool {

    protected Connection con;

    public DaoTool() {
    }

    public void connect() {
        String hostname = "localhost";
        String port = "1433";
        String database = "QuizDB";
        String user = "sa";
        String pass = "123456";

        String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://"+hostname+":"+port+"; database="+database;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getResultSet(String strSql){
        try {
            PreparedStatement pre = con.prepareStatement(strSql);
            ResultSet rs = pre.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author INT303
 */
public class BuildConnection {

    private static DataSource ds = null;
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String URL = "jdbc:derby://localhost:1527/quisiss";
    private static final String USERNAME = "quisiss";
    private static final String PASSWORD = "quisiss";
    private static boolean isLoad = false;

    public static Connection getConnection() {
        Connection conn = null;
//        if (! isLoad) {
//            try {
//                Class.forName(DRIVER);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(BuildConnection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            isLoad = true ;
//        }
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(BuildConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    /*public static Connection getConnectionFromPool() {

        Connection conn = null;
        if (ds == null) {
            try {
                Context ctx = new InitialContext();
                ds = (DataSource) ctx.lookup("jdbc/quisiss") ;
            } catch (NamingException ex) {
                Logger.getLogger(BuildConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            conn = ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(BuildConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }*/

    public static Connection createConnection(){
        Connection conn = null;
    
        try {
            try{
                Class.forName("com.mysql.jdbc.Driver"); 
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Printing connection object "+conn);
        } catch (Exception e){
            e.printStackTrace();
        }
            return conn; 
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}

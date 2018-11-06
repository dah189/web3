/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class Jdbc {
    private static Connection conn;
    
    //connect derby db
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:derby://localhost:1527/dah189"; 
        String user = "IS2560";
        String password = "IS2560";
 
        Connection conn = null;
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }
 
    //close derby db
    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
        if (stmt != null && !stmt.isClosed()) {
            stmt.close();
        }
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

}

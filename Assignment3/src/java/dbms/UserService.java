/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;
import javaBean.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class UserService {
    
    private Connection conn;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    public static Boolean sameUser = false;
    
    //the method that allow users login
    public Users checkUsers(String username, String password){
        //if didn't find user, return null
        Users guest = null;
		try {   //connect db
			conn = Jdbc.getConnection();
			String sql = "select * from Users where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
                        //construct right user
			if(rs.next()) {
				guest = new Users();
				guest.setUsername(rs.getString("username"));
				guest.setPassword(rs.getString("password"));
				guest.setEmail(rs.getString("email"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Jdbc.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return guest;

    }
    
    //the method for user to register
    public Users addUser (Users guest) {
        
        Boolean nullUser = "".equals(guest.getUsername()) || "".equals(guest.getPassword()) || "".equals(guest.getEmail());
        //if users didn't complete the register form
        if(nullUser){
            return null;
        }
        
		try {   //the sql1 judge that whether the username have existed in db
			conn = Jdbc.getConnection();
                        String sql1 = "select * from Users where username=?";
                        ps = conn.prepareStatement(sql1);
                        ps.setString(1, guest.getUsername());
                        rs = ps.executeQuery();
                        if(rs.next()){
                            sameUser = true; //this boolean was used in RegisterServlet for poping different alter
                            return null;
                        }
                        
                        //the sql2 used to insert a new user in db
			String sql2 = "insert into Users (username,password,email) values(?,?,?)";
			ps = conn.prepareStatement(sql2);
			ps.setString(1, guest.getUsername());
			ps.setString(2, guest.getPassword());
			ps.setString(3, guest.getEmail());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				Jdbc.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return guest;
		
		
	}

    
}


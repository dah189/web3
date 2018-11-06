/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBean;

import java.io.Serializable;

public class Users implements Serializable {
    private String username;
    private String password;
    private String email;
    
    public Users(){
        super();
    }
    
    public Users(String username, String password, String email){
        super();
        this.username = username;
        this.password = password;
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
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
        
        @Override
        public String toString() {
		return "User [ password=" + password + ", username=" + username + ", email=" + email+ "]";
	}

}

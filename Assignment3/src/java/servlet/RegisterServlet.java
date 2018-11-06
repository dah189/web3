/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dbms.*;
import java.io.IOException;
import java.io.PrintWriter;
import javaBean.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //get the data from user inputing
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");       
        
        Users guest = new Users(username, password, email);
        
        UserService service = new UserService();
        
        if(service.addUser(guest) != null){ //guest isn't null means this user can be created

            service.addUser(guest); //create a new user in db

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resister Success!</title>");   
                out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"); 
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container\">");
                out.println("<h2>Dear " + guest.getUsername() + "</h2>");
                out.println("<p>Your email is " + guest.getEmail() + "</p>");
                out.println("<p>And you have registered our website! Now you can return and login.</p>");
                out.println("<a href=\"index.jsp\" class=\"btn btn-secondary\">Return</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }else if(service.sameUser){ //the sameUser is true means the username have existed in db
            try (PrintWriter out = response.getWriter()) {
            out.print("<script>alert('The username have been registered!');  window.location='register.jsp'</script>");
            }
            service.sameUser = false; //reset the boolean
        }
        else{ //other condition. maybe the form wasn't completed.
            try (PrintWriter out = response.getWriter()) {
            out.print("<script>alert('Register fail! Maybe you did not complete the form');  window.location='register.jsp'</script>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package com.java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String id = session.getId();
        System.out.println("servlet session:"+id);
        if("admin".equals(username.trim()) && "admin".equals(password.trim())){
            session.setAttribute("isLogined","Y");
            String path = (String)session.getAttribute("path");
            session.removeAttribute("path");
            if(path == null)
                response.sendRedirect("http://112.5.162.246:580/ue/index.html");
            else
                response.sendRedirect(path);
        }
        else{
            response.sendRedirect("login.jsp?error=yes");
        }
    }
}

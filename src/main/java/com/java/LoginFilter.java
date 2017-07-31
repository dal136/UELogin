package com.java;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        String path = request.getServletPath();

        System.out.println("filter path:"+path);

        String id = session.getId();
        System.out.println("filter session:"+id);

        if(session.getAttribute("isLogined") == null &&
           !path.endsWith("login.jsp") &&
           !path.endsWith("LoginServlet") &&
           !path.endsWith("favicon.ico")){
            session.setAttribute("path", path);
            response.sendRedirect("login.jsp");
            return;
        }
        else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

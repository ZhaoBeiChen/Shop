package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/21.
 */
@WebServlet(name = "Logout")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("status","no");
//        if(!session.getAttribute("NowPage").equals("PersonalInfo")) {
//            response.sendRedirect("../index.jsp");
//        }else {
//            response.sendRedirect("../" + session.getAttribute("NowPage") + ".jsp");
//        }
        response.sendRedirect("../index.jsp");
    }
}

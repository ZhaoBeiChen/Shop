package controller;

import model.struct.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/26.
 */
@WebServlet(name = "ResetPassword")
public class ResetPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String user = (String) request.getSession().getAttribute("FG_user");
        String newPW = request.getParameter("resetNewPasswd");
        String conPW = request.getParameter("resetConfirmPasswd");
        if(newPW.equals(conPW)){
            User u = new User();
            u = u.getUserInfo(user);
            u.setPaswsword(newPW);
            u.changeUserInfo(u);
            response.sendRedirect("../Login.jsp");
        }
        else {
            response.sendRedirect("../ResetPassword.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

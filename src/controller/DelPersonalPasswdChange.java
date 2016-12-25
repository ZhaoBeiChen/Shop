package controller;

import model.struct.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/23.
 */
@WebServlet(name = "DelPersonalPasswdChange")
public class DelPersonalPasswdChange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        String oldPW = request.getParameter("infoChangePW_oldPW");
        String newPW = request.getParameter("infoChangePW_newPW");
        String conPW = request.getParameter("infoChangePW_conPW");
        String userID = (String)request.getSession().getAttribute("userName");
        User user = new User();
        user = user.getUserInfo(userID);
        if(user.getPaswsword().equals(oldPW)){
            if(newPW.equals(conPW)){
                user.setPaswsword(newPW);
                user.changeUserInfo(user);
                request.getSession().setAttribute("status","no");
                response.sendRedirect("../Login.jsp");
            }
            else {
                response.sendRedirect("../PersonalPasswdChange.jsp");
            }
        }
        else {
            response.sendRedirect("../PersonalPasswdChange.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

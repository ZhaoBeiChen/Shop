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
@WebServlet(name = "DelRegister")
public class DelRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String userID = request.getParameter("InfoRegister_userID");
        String passwd = request.getParameter("InfoRegister_passwd");
        String sex = request.getParameter("InfoRegister_sex");
        String phone = request.getParameter("InfoRegister_phone");
        String email = request.getParameter("InfoRegister_email");
        String address = request.getParameter("InfoRegister_address");
        User user = new User();
        user.setUserID(userID);
        user.setPaswsword(passwd);
        if(sex.equals("male")) {
            user.setSex("1");
        }else {
            user.setSex("0");
        }
        user.setPhoneNumber(Long.parseLong(phone));
        user.setEmail(email);
        user.setAddress(address);
        user.addUser(user);
        response.sendRedirect("../Login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

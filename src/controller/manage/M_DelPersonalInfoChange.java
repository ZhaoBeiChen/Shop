package controller.manage;

import model.struct.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/25.
 */
@WebServlet(name = "M_DelPersonalInfoChange")
public class M_DelPersonalInfoChange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String newSex = request.getParameter("M_infoChange_sex");
        String newPhone = request.getParameter("M_infoChange_phone");
        String newEmail = request.getParameter("M_infoChange_email");
        String newAddress = request.getParameter("M_infoChange_address");
        String userID = request.getParameter("M_infoChange_userID");
        String password = request.getParameter("M_infoChange_passwd");
        User user = new User();
        user.setUserID(userID);
        user.setPaswsword(password);
        if(newSex.equals("male")) {
            user.setSex("1");
        }else {
            user.setSex("0");
        }
        user.setPhoneNumber(Long.parseLong(newPhone));
        user.setEmail(newEmail);
        user.setAddress(newAddress);
        user.changeUserInfo(user);
        request.getSession().setAttribute("sex",newSex);
        request.getSession().setAttribute("phone",newPhone);
        request.getSession().setAttribute("email",newEmail);
        request.getSession().setAttribute("address",newAddress);
        response.sendRedirect("../../"+ request.getSession().getAttribute("NowPage") +".jsp");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

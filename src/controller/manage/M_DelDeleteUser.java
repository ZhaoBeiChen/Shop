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
@WebServlet(name = "M_DelDeleteUser")
public class M_DelDeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String user_id = request.getParameter("M_infoDelete_userid");
        User user = new User();
        user.deleteUser(user_id);
        response.sendRedirect("../../ManagePage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

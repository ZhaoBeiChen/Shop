package controller.manage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/25.
 */
@WebServlet(name = "M_DelShopClass")
public class M_DelShopClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String classes = request.getParameter("class_0");
        if(classes.equals("user")){
            session.setAttribute("shopClass","user");
        }
        else if(classes.equals("goods")){
            session.setAttribute("shopClass","goods");
        }
        response.sendRedirect("../../ManagePage.jsp");
    }
}

package controller.manage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/25.
 */
@WebServlet(name = "DelManageInfo")
public class DelManageInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String classes = (String) request.getSession().getAttribute("shopClass");
        String thingID = request.getParameter("thing_id");
        request.getSession().setAttribute("thingID",thingID);

        if(classes.equals("user")){
            response.sendRedirect("../../Manage_person.jsp");
        }
        else if (classes.equals("goods")){
            response.sendRedirect("../../Manage_goods.jsp");
        }
        else {
            response.sendRedirect("../../ManagePage.jsp");
        }
    }
}

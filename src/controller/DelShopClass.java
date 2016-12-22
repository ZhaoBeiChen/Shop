package controller;

import javafx.application.Application;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "DelShopClass")
public class DelShopClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String classes = request.getParameter("class_0");
        if(classes.equals("all")){
            session.setAttribute("shopClass","all");
        }
        else if(classes.equals("fps")){
            session.setAttribute("shopClass","fps");
        }
        else if(classes.equals("roleplay")){
            session.setAttribute("shopClass","roleplay");
        }
        response.sendRedirect("../GoodsPage.jsp");
        //request.getRequestDispatcher("/GoodsPage.jsp").forward(request,response);
    }
}

package controller;

import model.struct.ShopCar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/22.
 */
@WebServlet(name = "DelDeleteShopCar")
public class DelDeleteShopCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String carid = request.getParameter("shopcar_carid");
        ShopCar car = new ShopCar();
        car.deleteShopCar(carid);
        response.sendRedirect("../ShopCar.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

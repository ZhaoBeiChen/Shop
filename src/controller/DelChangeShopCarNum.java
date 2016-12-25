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
@WebServlet(name = "DelChangeShopCarNum")
public class DelChangeShopCarNum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String carid = request.getParameter("shopcar_carid");
        int newNum = Integer.parseInt(request.getParameter("shopcar_num").toString());
        ShopCar car = new ShopCar();
        car = car.ifCarExist(carid);
        car.setNum(newNum);
        car.changeCarInfo(car);
        response.sendRedirect("../ShopCar.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

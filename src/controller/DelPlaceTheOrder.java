package controller;

import model.struct.Order;
import model.struct.ShopCar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by asus-pc on 2016/12/22.
 */
@WebServlet(name = "DelPlaceTheOrder")
public class DelPlaceTheOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String userID = request.getParameter("shopcar_order");
        ShopCar car = new ShopCar();
        ArrayList<ShopCar> carList = new ArrayList<ShopCar>();
        carList = car.getCarList(userID);
        Order order;
        for(int i=0; i<carList.size(); i++){
            order = new Order();
            order.setOrderID(Long.toString(new Date().getTime()));
            order.setGoodsID(carList.get(i).getGoodsID());
            order.setOrderDate(new Date());
            order.setGoodsFee(carList.get(i).getPrice());
            order.setTotalprice(carList.get(i).totalprice(userID));
            order.setMemberID(userID);
            order.setIsConfirm("Y");
            order.addOrder(order);
        }
        for(int i=0; i<carList.size(); i++){
            carList.get(i).deleteShopCar(carList.get(i).getCarID());
        }
        response.sendRedirect("../ShopCar.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

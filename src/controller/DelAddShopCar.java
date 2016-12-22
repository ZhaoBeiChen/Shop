package controller;

import model.struct.Goods;
import model.struct.ShopCar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/22.
 */
@WebServlet(name = "DelAddShopCar")
public class DelAddShopCar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("status").toString().equals("yes")) {
            String goodsid = request.getParameter("goodsInfo_goodsid");
            String memberID = (String) session.getAttribute("userName");
            int num = Integer.parseInt(request.getParameter("goodsInfo_num"));
            Goods good = new Goods();
            good = good.getGoodsInfo(goodsid);
            ShopCar car = new ShopCar();
            car.setCarID(memberID + "_" + goodsid);
            car.setGoodsID(goodsid);
            car.setNum(num);
            car.setPrice(good.getPrice());
            car.setMemberID(memberID);
            if (car.ifCarExist(car.getCarID()) != null) {
                car = car.ifCarExist(car.getCarID());
                num = num + car.getNum();
                car.setNum(num);
                car.changeCarInfo(car);
            } else {
                car.addShopCar(car);
            }
            response.sendRedirect("../ShopCar.jsp");
        }
        else {
            response.sendRedirect("../Login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

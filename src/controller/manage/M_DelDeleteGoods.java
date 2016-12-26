package controller.manage;

import model.struct.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asus-pc on 2016/12/26.
 */
@WebServlet(name = "M_DelDeleteGoods")
public class M_DelDeleteGoods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String goodID = request.getParameter("M_infoDelete_goodsid");
        Goods good = new Goods();
        good.deleteGoods(goodID);
        response.sendRedirect("../../ManagePage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

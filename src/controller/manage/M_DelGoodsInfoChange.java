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
@WebServlet(name = "M_DelGoodsInfoChange")
public class M_DelGoodsInfoChange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String goodsID = request.getParameter("M_infoChange_goodsID");
        String classes = request.getParameter("M_infoChange_classes");
        double price = Double.parseDouble(request.getParameter("M_infoChange_price"));
        String url = request.getParameter("M_infoChange_url");
        String introduce = request.getParameter("M_infoChange_introduce");
        Goods good = new Goods();
        good = good.getGoodsInfo(goodsID);
        good.setClassID(classes);
        good.setPrice(price);
        good.setGoodsURL(url);
        good.setGoodsIntroduce(introduce);
        good.changeGoosInfo(good);
        response.sendRedirect("../../"+ request.getSession().getAttribute("NowPage") +".jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

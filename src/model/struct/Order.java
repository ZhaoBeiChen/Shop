package model.struct;

import model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by asus-pc on 2016/12/21.
 */
public class Order implements databaseCon,dataBaseDestory{

    protected String orderID;
    protected String goodsID;
    protected Date orderDate;
    protected double goodsFee;
    protected double totalprice;
    protected String memberID;
    protected String isConfirm;
    ResultSet result = null;		//结果集对象
    PreparedStatement pre = null;


    public String getOrderID() {
        return orderID;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getGoodsFee() {
        return goodsFee;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getIsConfirm() {
        return isConfirm;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setGoodsFee(double goodsFee) {
        this.goodsFee = goodsFee;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setIsConfirm(String isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Order(){

    }

    public Order(String orderID, String goodsID, Date orderDate, double goodsFee, double totalprice, String memberID, String isConfirm){
        this.orderID = orderID;
        this.goodsID = goodsID;
        this.orderDate = orderDate;
        this.goodsFee = goodsFee;
        this.totalprice = totalprice;
        this.memberID = memberID;
        this.isConfirm = isConfirm;
    }

    public int checkinfo(Order order){
        if(order.getOrderID().equals("")){
            return -1;
        }
        if(order.getGoodsID().equals("")){
            return -1;
        }
        if(order.getOrderDate() == null){
            return -1;
        }
        if(order.getGoodsFee() == 0.0){
            return -1;
        }
        if(order.getTotalprice() == 0.0){
            return -1;
        }
        if(order.getMemberID().equals("")){
            return -1;
        }
        if(order.getIsConfirm().equals("")){
            order.setIsConfirm("Y");
        }
        return 1;
    }

    public void addOrder(Order order){
        if(checkinfo(order)!=-1){
            String sql = "insert into tb_order (orderid, goodsid, orderdate, goodsfee, totalprice, memberid, isconfirm) values(?,?,?,?,?,?,?)";
            try {
                pre = connecting.getConnection(con).prepareStatement(sql);
                pre.setString(1, order.getOrderID());
                pre.setString(2, order.getGoodsID());
                pre.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
                pre.setDouble(4, order.getGoodsFee());
                pre.setDouble(5, order.getTotalprice());
                pre.setString(6, order.getMemberID());
                pre.setString(7, order.getIsConfirm());
                result = pre.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("添加订单操作出错！！");
            }finally {
                destoryCon(con,pre,result);
            }
        }else {
            System.out.println("输入Order数据有误！");
        }
    }

    public void deleteOrder(String OrderID){
        String sql = "delete from tb_order where orderid=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1,OrderID);
            result = pre.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除订单操作出错！");
        }finally {
            destoryCon(con,pre,result);
        }
    }

    public ArrayList getOrder(String memberID){
        ArrayList<Order> orderList = new ArrayList<Order>();
        Order order;
        String sql = "select * from tb_order where memberID=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1,memberID);
            result = pre.executeQuery();
            while (result.next()){
                order = new Order();
                order.setOrderID(result.getString("orderid"));
                order.setGoodsID(result.getString("goodsid"));
                order.setOrderDate(result.getDate("orderdate"));
                order.setGoodsFee(result.getDouble("goodsfee"));
                order.setTotalprice(result.getDouble("totalprice"));
                order.setMemberID(memberID);
                order.setIsConfirm(result.getString("isconfirm"));
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            destoryCon(con,pre,result);
        }
    }


    @Override
    public void destoryCon(Connection con, PreparedStatement pre, ResultSet res) {
        if(result!=null){
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pre!=null){
            try {
                pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package model.struct;

import model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;

/**
 * Created by asus-pc on 2016/12/19.
 */
public class Goods implements databaseCon,dataBaseDestory {

    protected String goodsID;
    protected String classID;
    protected String goodsIntroduce;
    protected String goodsURL;
    protected double price;
    protected Date addDate;
    ResultSet result = null;		//结果集对象
    PreparedStatement pre = null;

    public String getGoodsID() {
        return goodsID;
    }

    public String getClassID() {
        return classID;
    }

    public String getGoodsIntrduce() {
        return goodsIntroduce;
    }

    public String getGoodsURL() {
        return goodsURL;
    }

    public double getPrice() {
        return price;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setGoodsIntroduce(String goodsIntrduce) {
        this.goodsIntroduce = goodsIntrduce;
    }

    public void setGoodsURL(String goodsURL) {
        this.goodsURL = goodsURL;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Goods(){

    }

    public  Goods(String goodID, String classID, String intrduce, String url, double price, Date addDate){

        this.goodsID = goodID;
        this.classID = classID;
        this.goodsIntroduce = intrduce;
        this.goodsURL = url;
        this.price = price;
        this.addDate = addDate;
    }

    public int checkInfo(Goods goods){
        if(goods.getGoodsID().equals("")){
            return -1;
        }
        if(goods.getClassID().equals("")){
            goods.setClassID("-");
        }
        if(goods.getGoodsIntrduce().equals("")){
            goods.setGoodsIntroduce("-");
        }
        if(goods.getGoodsURL().equals("")){
            goods.setGoodsURL("-");
        }
        if(goods.getPrice()==0.0){
            return -1;
        }
        if (goods.getAddDate()==null){
            goods.setAddDate(new Date());
        }
        return 1;
    }

    public void addGoods(Goods goods){
        if(checkInfo(goods)!=-1){
            String sql = "insert into tb_goods (goodsid, classid, goodsintroduce, goodsbrand, goodsunit, goodsurl, marketprice, adddate) values(?,?,?,?,?,?,?,?)";
            try {
                pre = connecting.getConnection(con).prepareStatement(sql);
                pre.setString(1, goods.getGoodsID());
                pre.setString(2, goods.getClassID());
                pre.setString(3, goods.getGoodsIntrduce());
                pre.setString(4, "-");
                pre.setString(5, "-");
                pre.setString(6, goods.getGoodsURL());
                pre.setDouble(7, goods.getPrice());
                pre.setDate(8, new java.sql.Date(goods.getAddDate().getTime()));
                result = pre.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("添加用户操作出错！！");
            }finally {
                destoryCon(con,pre,result);
            }
        }else{
            System.out.println("输入Goods数据有误！");
        }
    }

    public void deleteGoods(String ID){
        String sql = "delete from tb_goods where goodsID=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1,ID);
            result = pre.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除商品操作出错！");
        }finally {
            destoryCon(con,pre,result);
        }
    }

    public void changeGoosInfo(Goods NewGoods){
        if(checkInfo(NewGoods)!=-1){
            String sql = "update tb_goods set classid=?, goodsintroduce=?, goodsurl=?, marketprice=?, adddate=? where goodsid=?";
            try {
                pre = connecting.getConnection(con).prepareStatement(sql);
                pre.setString(1, NewGoods.getClassID());
                pre.setString(2, NewGoods.getGoodsIntrduce());
                pre.setString(3, NewGoods.getGoodsURL());
                pre.setDouble(4, NewGoods.getPrice());
                pre.setDate(5, new java.sql.Date(NewGoods.getAddDate().getTime()));
                pre.setString(6, NewGoods.getGoodsID());
                result = pre.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("商品信息修改出错！");
            }finally {
                destoryCon(con,pre,result);
            }
        }
    }

    public Goods getGoodsInfo(String ID){
        String sql = "select * from tb_goods where goodsid=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1, ID);
            result = pre.executeQuery();
            if(result.next()){
                Goods good = new Goods();
                good.setGoodsID(result.getString("goodsid"));
                good.setClassID(result.getString("classid"));
                good.setGoodsIntroduce(result.getString("goodsintroduce"));
                good.setGoodsURL(result.getString("goodsurl"));
                good.setPrice(result.getDouble("marketprice"));
                good.setAddDate(result.getDate("adddate"));
                return good;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            destoryCon(con,pre,result);
        }

    }

    public ArrayList getTheSimilarGoods(String classID){
        ArrayList<Goods> similarGoods = new ArrayList<Goods>();
        Goods goods;
        String sql = "select * from tb_goods where classID = ?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1, classID);
            result = pre.executeQuery();
            while (result.next()){
                goods = new Goods();
                goods.setGoodsID(result.getString("goodsid"));
                goods.setClassID(classID);
                goods.setGoodsIntroduce(result.getString("goodsintroduce"));
                goods.setGoodsURL(result.getString("goodsurl"));
                goods.setPrice(result.getDouble("marketprice"));
                goods.setAddDate(result.getDate("adddate"));
                similarGoods.add(goods);
            }
            return similarGoods;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            destoryCon(con,pre,result);
        }
    }

    public ArrayList getAllGoods(){
        ArrayList<Goods> allGoods = new ArrayList<Goods>();
        Goods good;
        String sql = "select * from tb_goods";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            result = pre.executeQuery();

            while (result.next()){
                good = new Goods();
                good.setGoodsID(result.getString("goodsid"));
                good.setClassID(result.getString("classid"));
                good.setGoodsURL(result.getString("goodsurl"));
                allGoods.add(good);
            }
            return allGoods;
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

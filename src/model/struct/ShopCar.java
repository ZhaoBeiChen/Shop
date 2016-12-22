package model.struct;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;
import java.util.ArrayList;

/**
 * Created by asus-pc on 2016/12/21.
 */
public class ShopCar implements databaseCon,dataBaseDestory {

    protected String carID;
    protected String goodsID;
    protected int num;
    protected double price;
    protected String memberID;
    ResultSet result = null;		//结果集对象
    PreparedStatement pre = null;

    public String getCarID() {
        return carID;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public int getNum() {
        return num;
    }

    public double getPrice() {
        return price;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public ShopCar(){

    }

    public ShopCar(String carID, String GoodsID, int num, Double price, String memberID){
        this.carID = carID;
        this.goodsID = GoodsID;
        this.num = num;
        this.price = price;
        this.memberID = memberID;
    }

    public int checkInfo(ShopCar car){
        if(car.getCarID().equals("")){
            return -1;
        }
        if(car.getGoodsID().equals("")){
            return -1;
        }
        if(car.getMemberID().equals("")){
            return -1;
        }
        if(car.getNum() == 0){
            return -1;
        }
        if(car.getPrice() == 0.0){
            return -1;
        }
        return 1;
    }

    public void addShopCar(ShopCar car){
        if(checkInfo(car)!=-1){
            String sql = "insert into tb_shopcar (cartid, goodsid, num, marketprice, memberid) values(?,?,?,?,?)";
            try {
                pre = connecting.getConnection(con).prepareStatement(sql);
                pre.setString(1, car.getCarID());
                pre.setString(2, car.getGoodsID());
                pre.setInt(3, car.getNum());
                pre.setDouble(4, car.getPrice());
                pre.setString(5, car.getMemberID());
                result = pre.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("购物车添加出错！");
            }finally {
                destoryCon(con,pre,result);
            }
        }else {
            System.out.println("输入carShop数据有误！");
        }
    }

    public void deleteShopCar(String carID){
        String sql = "delete from tb_shopcar where cartID=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1, carID);
            result = pre.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除购物车出错！");
        }finally {
            destoryCon(con,pre,result);
        }
    }

    public void changeCarInfo(ShopCar car){
        if(checkInfo(car)!=-1){
            String sql = "update tb_shopcar set goodsid=?, num=?, marketprice=?, memberid=?, where cartid=?";
            try {
                pre = connecting.getConnection(con).prepareStatement(sql);
                pre.setString(1, car.getGoodsID());
                pre.setInt(2, car.getNum());
                pre.setDouble(3, car.getPrice());
                pre.setString(4, car.getMemberID());
                pre.setString(5, car.getCarID());
                result = pre.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("购物车信息修改出错！");
            }finally {
                destoryCon(con,pre,result);
            }
        }
    }

    public Goods getCarGoodsInfo(String Goodsid){
        Goods good = new Goods();
        good = good.getGoodsInfo(Goodsid);
        return good;
    }

    public ArrayList getCarList(String memberID){
        ArrayList<ShopCar> carList = new ArrayList<ShopCar>();
        ShopCar car;
        String sql = "select * from tb_shopcar where memberid=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1, memberID);
            result = pre.executeQuery();
            while (result.next()){
                car = new ShopCar();
                car.setCarID(result.getString("cartid"));
                car.setGoodsID(result.getString("goodsid"));
                car.setNum(result.getInt("num"));
                car.setPrice(result.getDouble("marketprice"));
                car.setMemberID(memberID);
                carList.add(car);
            }
            return carList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            destoryCon(con,pre,result);
        }
    }

    public ShopCar ifCarExist(String carID){
        ShopCar car = new ShopCar();
        String sql = "select * from tb_shopcar where cartID=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1,carID);
            result = pre.executeQuery();
            if(result.next()){
                car.setGoodsID(carID);
                car.setGoodsID(result.getString("goodsid"));
                car.setNum(result.getInt("num"));
                car.setPrice(result.getDouble("marketPrice"));
                car.setMemberID(result.getString("memberid"));
                return car;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double totalprice(String memberID){
        String sql = "select * from tb_shopcar where memberid=?";
        double fee = 0.0;
        int number = 0;
        double sum = 0.0;
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1,memberID);
            result = pre.executeQuery();
            while (result.next()){
                fee = result.getDouble("marketprice");
                number = result.getInt("num");
                sum = number * fee;
            }
            return sum;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
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

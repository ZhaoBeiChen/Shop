package model.struct;

import model.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by asus-pc on 2016/12/16.
 */
public class User implements dataBaseDestory,databaseCon {

    protected String userID;
    protected String sex;
    protected String paswsword;
    protected long phoneNumber;
    protected String email;
    protected String address;
    ResultSet result = null;		//结果集对象
    PreparedStatement pre = null;

    public String getUserID() {
        return userID;
    }

    public String getSex() {
        return sex;
    }

    public String getPaswsword() {
        return paswsword;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPaswsword(String paswsword) {
        this.paswsword = paswsword;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(){

    }



    public User(String ID, String sex, String password, int phone, String email, String address){
        this.userID = ID;
        this.sex = sex;
        this.paswsword = password;
        this.phoneNumber = phone;
        this.email = email;
        this.address = address;
    }

    public int checkInfo(User user){
        if(user.getUserID().equals("")){
            return -1;
        }
        if(user.getSex().equals("")){
            user.setSex("-");
        }
        if(user.getPaswsword().equals("")){
            return -1;
        }
        if(Long.toString(user.getPhoneNumber()).equals(null) ){
            user.setPhoneNumber(0);
        }
        if(user.getEmail().equals("")){
            user.setEmail("-");
        }
        if(user.getAddress().equals("")){
            user.setAddress("-");
        }
        return 1;
    }

    public void addUser(User user) {
        if(checkInfo(user)!=-1) {
            String sql = "insert into tb_user (memberid, sex, password, phone, emails, address) values(?,?,?,?,?,?)";
            try {
                pre = connecting.getConnection(con).prepareStatement(sql);

            pre.setString(1, user.getUserID());
            pre.setString(2, user.getSex());
            pre.setString(3, user.getPaswsword());
            pre.setString(4, Long.toString(user.getPhoneNumber()));
            pre.setString(5, user.getEmail());
            pre.setString(6, user.getAddress());
            result = pre.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("添加用户操作出错！！");
            }finally {
                destoryCon(con,pre,result);
            }
        }
        else {
            System.out.println("输入User数据有误！");
        }
    }

    public void deleteUser(String ID){
        String sql = "delete from tb_user where memberID=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1,ID);
            result = pre.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除用户操作出错！");
        }finally {
            destoryCon(con,pre,result);
        }
    }

    public void changeUserInfo(User user){
        if(checkInfo(user)!=-1){
            String sql = "update tb_user set password=?, sex=?, phone=?, emails=?, address=? where memberID=?";
            try {
                pre = connecting.getConnection(con).prepareStatement(sql);
                pre.setString(1, user.getPaswsword());
                pre.setString(2, user.getSex());
                pre.setString(3, Long.toString(user.getPhoneNumber()));
                pre.setString(4, user.getEmail());
                pre.setString(5, user.getAddress());
                pre.setString(6, user.getUserID());
                result = pre.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("用户信息修改出错！");
            }finally {
                destoryCon(con,pre,result);
            }
        }
    }

    public int LoginCheck(String ID, String password){
        String sql = "select * from tb_user where memberID=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1,ID);
            result = pre.executeQuery();
            if(result.next()){
                if(result.getString("password").equals(password)){
                    return 1;
                }
                else {
                return 0;
            }
        }
            else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -2;
        }finally {
            destoryCon(con,pre,result);
        }
    }

    public User getUserInfo(String userName){
        String sql = "select * from tb_user where memberID=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1, userName);
            result = pre.executeQuery();
            if(result.next()){
                User user = new User();
                user.setUserID(result.getString("memberID"));
                user.setPaswsword(result.getString("password"));
                user.setSex(result.getString("sex"));
                user.setPhoneNumber(Long.parseLong(result.getString("phone")));
                user.setEmail(result.getString("emails"));
                user.setAddress(result.getString("address"));
                return user;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            destoryCon(con,pre,result);
        }
    }

    public ArrayList getUserList(){
        User user;
        ArrayList<User> userList = new ArrayList<User>();
        String sql = "select * from tb_user";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            result = pre.executeQuery();
            while (result.next()){
                user = new User();
                user.setUserID(result.getString("memberID"));
                user.setPaswsword(result.getString("password"));
                user.setSex(result.getString("sex"));
                user.setPhoneNumber(Long.parseLong(result.getString("phone")));
                user.setEmail(result.getString("emails"));
                user.setAddress(result.getString("address"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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

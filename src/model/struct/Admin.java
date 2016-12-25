package model.struct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DAO.*;

/**
 * Created by asus-pc on 2016/12/23.
 */
public class Admin implements databaseCon,dataBaseDestory{

    protected String adminID;
    protected String passWord;

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getPassWord() {
        return passWord;
    }

    ResultSet result = null;		//结果集对象
    PreparedStatement pre = null;


    public boolean checkAdmin(String ID, String passwd){
        String sql = "select * from tb_admin where memberID=?";
        try {
            pre = connecting.getConnection(con).prepareStatement(sql);
            pre.setString(1,ID);
            result = pre.executeQuery();
            if(result.next()){
                if(result.getString("password").equals(passwd)){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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

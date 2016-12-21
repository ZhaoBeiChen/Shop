package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by asus-pc on 2016/12/16.
 */
public class dataConnecting implements DataBaseInfo {


    public Connection getConnection(Connection con) {
        try {
            Class.forName(OracleDiver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Oracle驱动类没有找到！");
        }
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接出错！");
        }
        return con;
    }
}

package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by asus-pc on 2016/12/16.
 */
public interface databaseCon {
    public dataConnecting connecting = new dataConnecting();
    Connection con = null;			//创建一个数据库连接
}

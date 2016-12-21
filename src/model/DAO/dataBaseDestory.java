package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by asus-pc on 2016/12/16.
 */
public interface dataBaseDestory {
    public void destoryCon(Connection con, PreparedStatement pre, ResultSet res);
}

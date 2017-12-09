package xcxxx.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    private static DataSource dataSource = null;
    static {
        dataSource = new ComboPooledDataSource("mysql");
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
}

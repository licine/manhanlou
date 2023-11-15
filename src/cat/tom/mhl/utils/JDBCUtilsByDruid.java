package cat.tom.mhl.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Package: com.linghu.utils
 * @ClassName: JDBCUtilsByDruid
 * @Author: linghu
 * @CreateTime: 2023/3/30 16:27
 * @Description: 基于Druid(德鲁伊)的 JDBCUtils 工具类
 */
public class JDBCUtilsByDruid {


    private static  DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //方法1：获取德鲁伊连接池的“连接”的 getConnection 方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //方法2：断开与德鲁伊连接池的"连接"
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



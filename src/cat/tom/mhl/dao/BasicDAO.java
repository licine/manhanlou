package cat.tom.mhl.dao;
import cat.tom.mhl.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 令狐荣豪
 * @version 1.0
 */
public class BasicDAO<T> {
    private QueryRunner qr=new QueryRunner();

    /**
     * 修改-表-记录的操作。
     * @param sql
     * @param parameters
     * @return
     */
    public int update(String sql,Object... parameters){
        Connection connection=null;

        try {
            connection= JDBCUtilsByDruid.getConnection();

            int update = qr.update(connection, sql, parameters);

            return update;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    /**
     *查询多行多列的操作，返回多行
     * @param sql
     * @param clazz 传入一个类的Class对象,比如Actor.class[反射机制]
     * @param parameters
     * @return 根据Actor.class返回对应的ArrayList集合
     */
    public List<T> queryMulti(String sql,Class<T> clazz,Object... parameters){

        Connection connection=null;

        try {
            connection=JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanListHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }

    }

    /**
     * 查询单行多列的操作，返回单行多列
     * @param sql
     * @param clazz
     * @param parameters
     * @return
     */
    public T querySingle(String sql,Class<T> clazz,Object...parameters){
        Connection connection=null;
        try {
            connection= JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    /**
     * 查询单行单列，返回单行单列,返回单值的方法
     * @param sql
     * @param parameters
     * @return 返回单值
     */
    public Object queryScalar(String sql,Object... parameters){

        Connection connection=null;

        try {
            connection= JDBCUtilsByDruid.getConnection();
            Object query = qr.query(connection, sql, new ScalarHandler(), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
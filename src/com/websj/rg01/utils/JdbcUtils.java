package com.websj.rg01.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类 使用Druid连接池
 **/
public class JdbcUtils {

    /** 数据源 **/
    private static DataSource ds;

    public static DataSource getDataSource(){
        return ds;
    }

    public static void main(String[] args) {

    }
    static {


        try{
            //加载配置文件
            Properties properties = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流in
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(in);
            //创建数据库连接池，初始化连接池对象
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


        /**
         * 获取连接Connection对象
         */
        public static Connection getConnection() throws SQLException {
            return ds.getConnection();
    }


//     * 关闭连接，释放内存
    public static void close(Statement stmt,Connection conn){
			       /* if(stmt != null){
			            try {
			                stmt.close();
			            } catch (SQLException e) {
			                e.printStackTrace();
			            }
			        }

			        if(conn != null){
			            try {
			                conn.close();//归还连接
			            } catch (SQLException e) {
			                e.printStackTrace();
			            }
			        }*/

        close(null,stmt,conn);
    }

    public static void close(ResultSet rs,Statement stat,Connection conn){
        if(rs!=null){
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stat!=null){
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if(conn!=null){
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

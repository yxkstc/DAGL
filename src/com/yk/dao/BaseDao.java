package com.yk.dao;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    // 初始化参数
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    //query-11.传入属性名 拼接set方法
    public static String getSetter(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase( ) + fieldName.substring(1);
    }

    /**
     * 查询的通用方法
     * query
     *
     * @param sql
     * @param paramsValue
     * @param 'lass<T>'
     */
    public <T> List<T> query(String sql, Object[] paramsValue, Class<T> clazz) {
        // query-1.返回的集合
        List<T> list = new ArrayList<T>( );
        // query-2.对象
        T temp = null;
        try {
            // query-3. 获取连接
            con = JDBCUtils.getConnection( );
            // query-4. 创建stmt对象
            pstmt = con.prepareStatement(sql);

            if (paramsValue != null && paramsValue.length > 0) {
                for (int i = 0; i < paramsValue.length; i++) {
                    pstmt.setObject(i + 1, paramsValue[i]);
                }
            }
            // query-5. 执行查询
            rs = pstmt.executeQuery( );
            // query-6. 获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData( );
            // query-7. 获取列的个数
            int columnCount = rsmd.getColumnCount( );

            // query-8. 遍历rs
            while (rs.next( )) {
                // 要封装的对象
                temp = clazz.newInstance( );

                // query-9. 遍历每一行的每一列, 封装数据
                for (int i = 0; i < columnCount; i++) {
                    // query-10.获取每一列的列名称
                    String columnName = rsmd.getColumnName(i + 1);
                    //检查数据类型是否一致。
                    //System.out.println("columnName:"+columnName+"----------getSetter:"+getSetter(columnName));
                    Field field = clazz.getDeclaredField(columnName);
                    Method method = clazz.getMethod(getSetter(columnName), field.getType( ));
                    method.invoke(temp, rs.getObject(i + 1));
                    /*// 获取每一列的列名称, 对应的值
                    //Object value = rs.getObject(columnName);
                    // 封装： 设置到t对象的属性中  【BeanUtils组件】
                    //  BeanUtils.copyProperty(temp,columnName,value);*/
                }

                // query-12.把封装完毕的对象，添加到list集合中
                list.add(temp);
            }


        } catch (Exception e) {
            e.printStackTrace( );
        } finally {
            JDBCUtils.colseResource(con, pstmt, rs);
        }

        return list;
    }

    /**
     * 更新的通用方法
     *
     * @param sql         更新的sql语句(update/insert/delete)
     * @param paramsValue sql语句中占位符对应的值(如果没有占位符，传入null)
     */
    public void update(String sql, Object[] paramsValue) {
        try {
            // update-1获取连接
            con = JDBCUtils.getConnection( );
            // update-2创建执行命令的stmt对象
            pstmt = con.prepareStatement(sql);
            //System.out.println( sql);打印sql检查错误
            // update-3参数元数据： 得到占位符参数的个数
            //int count = pstmt.getParameterMetaData().getParameterCount( );
            // update-4设置占位符参数的值
            if (paramsValue != null && paramsValue.length > 0) {
                // update-循环给参数赋值
                for (int i = 0; i < paramsValue.length; i++) {
                    pstmt.setObject(i+1, paramsValue[i].toString());
                }
            }
            // update-5执行更新
            pstmt.executeUpdate( );

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.colseResource(con, pstmt, null);
        }
    }

/**
 * END
 * */
}

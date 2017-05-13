package com.ahuo.dao;

import com.ahuo.bean.UserBean;
import com.ahuo.utlis.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ahuo on 17-5-13.
 */
public class UserDao {


    //因为这个操作类就是对数据库进行操作，所有要连接数据库
    private JDBCUtil util;

    public JDBCUtil getUtil() {
        return util;
    }

    public void setUtil(JDBCUtil util) {
        this.util = util;
    }

    //
    public void saveUser(UserBean user){

        Connection conn = null;
        PreparedStatement stat = null;

        try {
            String sql = "insert into member values (null,?,?,?,?,?,?,?,?)";
            conn = util.getConnection();        //创建连接
            stat = conn.prepareStatement(sql);  //创建预处理对象

            //存储数据（有几个问好，就存几个）
            stat.setString(1, user.uuid);
            stat.setString(2, user.name);
            stat.setString(3, user.photo);
            stat.setInt(4, user.age);
            stat.setDouble(5, user.height);
            stat.setDouble(6, user.weight);
            stat.setString(7, user.blog);
            stat.setString(8, user.headImage);

            stat.executeUpdate();//保存

        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            try {
                if(conn!=null&!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    //登录时，通过用户名找到这个对象，因为查询到的是一个对象，所有返回一个user
    public UserBean getUserByName(String uname){
        UserBean user = null;

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet res = null;

        try {
            String sql = "select * from member where username = ?";
            conn = util.getConnection();
            stat = conn.prepareStatement(sql);

            stat.setString(1, uname);

            //把查询到的数据放到结果集中
            res = stat.executeQuery();//查询

            //如果查询到，就将结果集中的数据保存到用户中
            if(res.next()){
                user = new UserBean();
                user.uuid=(res.getString("uuid"));
                user.name=(res.getString("name"));
                user.photo=(res.getString("photo"));
                user.age=(res.getInt("age"));
                user.height=(res.getDouble("height"));
                user.weight=(res.getDouble("weight"));
                user.blog=(res.getString("blog"));
                user.headImage=(res.getString("headImage"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{

            try {
                if(conn!=null&!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}

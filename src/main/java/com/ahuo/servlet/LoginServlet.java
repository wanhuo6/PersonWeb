package com.ahuo.servlet;

import com.ahuo.bean.UserBean;
import com.ahuo.core.config.WebConfig;
import com.ahuo.dao.UserDao;
import com.ahuo.utlis.JDBCUtil;
import com.alibaba.fastjson.JSONObject;
import com.huo.tools.HuoUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ahuo on 17-5-10.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/GetLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        String username = req.getParameter("username");
        String pass = req.getParameter("pass");

        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();

        //如果用户名和密码不为空，并且长度大于0就执行if语句--->判断查询到的user--->判断密码是否一致
        if(username!=null&&username.length()>0&&pass!=null&&pass.length()>0){

            ServletContext ctx = this.getServletContext();
           /* String url = ctx.getInitParameter("url");*/
            String dbuser = ctx.getInitParameter("dbuser");
            String dbpass = ctx.getInitParameter("dbpass");
            String url="jdbc:mysql://rm-uf62q4flhiq09jm89o.mysql.rds.aliyuncs.com:3306/person";


            JDBCUtil util = new JDBCUtil(url, "wanhuo", "huijie21@");


            //然后将util作为参数传给操作类
            UserDao dao = new UserDao();
            dao.setUtil(util);

            //调用操作类的通过用户名查询用户
            UserBean user = dao.getUserByName(username);

            if(user!=null){
                if(user.password.equals(pass)){
                    out.println("<h1>恭喜你！登录成功！</h1>");
                    out.println("<br><a href='http://www.liuhuijie.cn'>进入首页</a>");
                }else{
                    out.println("<h1>登录失败！密码错误！</h1>");
                    out.println("<br><a href='index.jsp'>点此登录</a>");
                }
            }else{
                out.println("<h1>登录失败！用户名错误！</h1>");
                out.println("<br><a href='index.jsp'>点此登录</a>");
            }

        }else{
            out.println("<h1>登录失败！用户名/密码错误！</h1>");
            out.println("<br><a href='index.jsp'>点此登录</a>");
        }


        out.flush();
        out.close();

    }
}

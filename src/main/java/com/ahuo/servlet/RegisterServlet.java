package com.ahuo.servlet;

import com.ahuo.bean.UserBean;
import com.ahuo.dao.UserDao;
import com.ahuo.utlis.JDBCUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wanhuo on 2017-5-13.
 */

@WebServlet(name = "RegisterServlet",urlPatterns = "/GetRegister")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //提交方式为post
        req.setCharacterEncoding("utf8");
        //接收请求中的参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String photo = req.getParameter("photo");

        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();

        //输入校验
        if(account!=null&&password!=null&&password2!=null&&password.equals(password2)){

            //要连接数据库，先从配置表中获取初始化参数传给JDBSUtil的构造函数
            ServletContext ctx = this.getServletContext();
           /* String url = ctx.getInitParameter("url");*/
            String dbuser = ctx.getInitParameter("dbuser");
            String dbpass = ctx.getInitParameter("dbpass");
           String url="jdbc:mysql://rm-uf62q4flhiq09jm89o.mysql.rds.aliyuncs.com:3306/person";


            JDBCUtil util = new JDBCUtil(url, "wanhuo", "huijie21@");

            //userdao--->util--->数据库
            //然后将util作为参数传给操作类
            UserDao dao = new UserDao();
            dao.setUtil(util);

            //将获取的的参数存到uer中，调用操作类中的方法保存
            UserBean user = new UserBean();
            user.account=account;
            user.name=account;
            user.password=password;
            user.photo = photo;
            user.uuid=String.valueOf(System.currentTimeMillis());

            // TODO: 2017-5-13 try handle 
            if (dao.saveUser(user)){
                out.println("<h1>恭喜你！注册成功</h1>");
                out.println("<br><a href='/'>点此登录</a>");
            }else{
                out.println("<h1>参数有误，注册失败！</h1>");
                out.println("<br><a href='jsp/register.jsp'>重新注册</a>");
            }
        }else{
            out.println("<h1>参数有误，注册失败！</h1>");
            out.println("<br><a href='jsp/register.jsp'>重新注册</a>");
        }

        out.flush();
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}

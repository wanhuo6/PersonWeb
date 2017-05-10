package com.ahuo.servlet;

import com.ahuo.bean.UserBean;
import com.alibaba.fastjson.JSONObject;
import com.huo.tools.HuoUtils;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean userBean=new UserBean();
        userBean.name= HuoUtils.getString("liu");
        userBean.age=12;
        userBean.height=175.0;
        String jsonObjectStr= JSONObject.toJSONString(userBean);

        PrintWriter printWriter= resp.getWriter();
        printWriter.write(jsonObjectStr);
        resp.setContentType("text/json");
        resp.setCharacterEncoding("gb2312");
    }
}

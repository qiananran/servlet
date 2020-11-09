package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 请求转发
*   req.getRequestDispatcher("s04").forward(req,resp);
*   可以让请求从服务器端跳转到客户端(或跳转到指定的servlet)
*  特点：
*       1.服务器行为
*       2.地址栏不改变
*       3.请求转发使用的一个请求
*       4.数据可以共享
*
* */

@WebServlet("/s03")
public class Servlet03  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收客户端请求的参数
        String uname = req.getParameter("uname");
        System.out.println("Servlet03 uname:" + uname);

        //请求转发，跳转到servlet04
        //req.getRequestDispatcher("s04").forward(req,resp);
        //请求转发，到jsp页面
        req.getRequestDispatcher("https://dyilin.com").forward(req,resp);
    }
}

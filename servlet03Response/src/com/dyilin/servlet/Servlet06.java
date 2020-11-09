package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 重定向与请求转发的区别
*   1. 请求转发的地址栏不会发生改变，重定向的地址栏会发生改变
*   2. 请求转发只有一次请求，重定向有两次请求
*   3. 请求转发时request对象可共享，重定向不可共享
*   4. 绝对地址定位到站点后  重定向的绝对地址到http
*   5. 请求转发是服务器行为， 重定向是客户端行为
*
* */

@WebServlet("/s06")
public class Servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet06.....");

        //接收参数
        String uname = request.getParameter("uname");
        System.out.println("servlet06:" + uname);

        //设置域对象
        request.setAttribute("upwd","123456");

        //请求转发
        //request.getRequestDispatcher("index.jsp").forward(request,response);
        //重定向
        //response.sendRedirect("index.jsp");
        //重定向跳转到博客
        response.sendRedirect("https://dyilin.com");
    }
}

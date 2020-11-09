package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* session 域对象
*
*   setAttribute()设置域对象，
*   getAttribute()获取域对象
*   removeAttribute() 删除域对象
*
*   请求转发：一次请求
*       request请求是有效的
*       session请求也是有效的
*   重定向：两转发
*       request请求无效
*       session作用域有效
*
* */

@WebServlet("/se02")
public class Session02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();

       //设置域对象
       session.setAttribute("uname","admin");
       session.setAttribute("upwd","123456");

       //移除域对象
        session.removeAttribute("upwd");

        /*request域对象*/
        request.setAttribute("name","zhangshan");

        //请求转发
        //request.getRequestDispatcher("index.jsp").forward(request,response);
        //重定向
        response.sendRedirect("index.jsp");
    }
}

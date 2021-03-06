package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 解决响应乱码问题
*   1. 设置服务器端的编码格式
*       response.setCharacterEncoding("UTF-8");
*   2. 设置客户端的编码格式
*       response.setHeader("content-type","text/html;charset=utf-8");
*   总结：
*       设置客户端和服务器端都支持中文，其保持一致
*   同时设置客户端和服务端的编码格式
* */
@WebServlet("/s03")
public class Servlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        //设置服务器编码方式
//        response.setCharacterEncoding("UTF-8");
//        //设置客户端的响应类型
//        response.setHeader("content-type","text/html;charset=utf-8");
        //同时
        response.setContentType("text/html;charset=utf-8");
        ServletOutputStream out = response.getOutputStream();
        out.write("<h2>你好</h2>".getBytes("utf-8"));

    }
}

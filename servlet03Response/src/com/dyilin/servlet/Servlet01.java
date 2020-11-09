package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 响应数据
*   getWriter()         字符串输出流(输出字符串)
*   getObjectStream()   字节输出流(输出一切数据)
*
*   两种流不可以同时使用，如果同时使用会报错
*
* */
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*getWriter()         字符串输出流(输出字符串)*/
        //获取字符输出流
        PrintWriter writer = response.getWriter();
        //输出数据
        writer.write("hello");
        writer.write("<h3>你好</h3>");
        /*getObjectStream()   字节输出流（输出一切数据）*/
        /*ServletOutputStream out = response.getOutputStream();
        out.write("hi".getBytes());*/
    }
}

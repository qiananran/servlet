package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 请求乱码问题
*   乱码原因：
*       由于在解析过程中默认的编码方式为ISO－８８５９－1（此编码不支持中文）所以解析式一定会出现乱码
*
*   请求乱码问题
*
*    GET请求
*       不会有乱码
*    POST请求
*       会乱码，通过设置服务器解析编码形式
*       req.setCharacterEncoding("UTF-8");
*  目前是一个GET请求 8.0之后的Tomcat不会乱码
*
* 注：
*   1. req.setCharacterEncoding("UTF-8"); 只针对POST请求乱码有效
*   2. new String(request.getParamenter("uname").getBytes("ISO-8859-1"),"UTF-8") 针对任何请求方式
*       但是如果数据本身不乱码，还依然使用new String()方法转换，则会乱码
* */

@WebServlet("/s02")
public class Servlet02 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获取客户端传递的参数
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        System.out.println("姓名:" + uname);
        System.out.println("密码：" + upwd);
    }
}

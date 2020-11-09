package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* request作用域
*   通过该对象可以在一个请求中传递数据，作用范围：在一次请求中有效，即服务器跳转有效，（请求转发跳转时有效）
*   // 设置域对象内容
*   request.setAttribute(String name,String value);
*   // 设置域对象内容
*   request.getAttribute(String name);
*   // 删除域对象内容
*   request.removeAttribute(String name);
*
* */

@WebServlet("/s06")
public class Servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet05 .....");

        //获取域对象内容
        String name = (String)req.getAttribute("name");
        System.out.println("姓名:" + name);
        int age = (int)req.getAttribute("age");
        System.out.println("年龄：" + age);
        List<String> list = (List<String>)req.getAttribute("list");
        System.out.println("list[0]:" + list.get(0));
    }
}

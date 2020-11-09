package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* session
*   session对象的获取
*       requset.getSession():
*       当获取session对象时，会先判断session对象是否存在，如果不存在先创建session对象
* */

@WebServlet("/se01")
public class Session01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();

        //获取session的会话标识符
        String id = session.getId();
        System.out.println(id);

        //获取session的创建时间
        System.out.println(session.getCreationTime());
        //获取最后访问的时间
        System.out.println(session.getLastAccessedTime());

        //判断是否是一个session对西安g
        System.out.println(session.isNew());
    }
}

package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* cookie到期时间
*
*   负整数：
*       表示只在浏览器内存中存活，关闭浏览器失效（默认值为-1）
*   正整数
*       表示存活指定秒数，单位秒
*   零
*       表示删除cookie
* */

@WebServlet("/cook03")
public class Cookie03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*到期时间：负整数(默认值为-1 ：表示只在浏览器的内存中存活，关闭浏览器后失效)*/
        Cookie cookie = new Cookie("uname1", "dyilin");
        cookie.setMaxAge(-1); //关闭浏览器失效
        response.addCookie(cookie);

        /*到期时间：正整数（表示存活的指定秒数，会将数据存在磁盘中）*/
        Cookie cookie2 = new Cookie("uname2", "dyilin");
        cookie.setMaxAge(30); //关闭浏览器失效
        response.addCookie(cookie);
        /*到期时间：零（表示删除cookie）*/
        Cookie cookie3 = new Cookie("uname3", "dyilin");
        cookie.setMaxAge(0); //关闭浏览器失效
        response.addCookie(cookie);
    }
}

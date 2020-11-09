package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/s01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*常用方法*/

        //获取请求时的完整路径，（从http开始，到？前面结束）
        String url = req.getRequestURL() + "";
        System.out.println("获取请求时的完整路径:"+url);
        //获取请求时的部分路径（从项目的站点名开始，到？前面结束）
        String uri = req.getRequestURI();
        System.out.println("获取请求时的部分路径:"+uri);
        //获取请求时的参数字符串（从？后面开始，到最后的字符串）
        String queryString = req.getQueryString();
        System.out.println("获取请求时的参数字符串:"+queryString);
        //获取请求方式（GET和POST）
        String method = req.getMethod();
        System.out.println("获取请求方式:"+method);
        //获取当前协议版本（HTTP/1.1）
        String protocol = req.getProtocol();
        System.out.println("获取当前协议版本:"+protocol);
        //获取项目的站点名（项目对外访问路径）
        String webapp = req.getContextPath();
        System.out.println("获取项目的站点名:"+webapp);

        //获取请求的参数
        //获取指定名称的参数值（重点的）返回字符串
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        System.out.println("uname:" + uname + ",upwd:" + upwd);
        //获取指定名称的参数的所有参数值（用于复选框）返回的是字符数组
        String[] hobbys = req.getParameterValues("hobby");
        if (hobbys != null && hobbys.length > 0){
            for (String hobby : hobbys) {
                System.out.println("爱好:" + hobby);
            }
        }
    }
}

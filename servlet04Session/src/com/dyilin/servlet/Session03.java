package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
* Session对象的销毁
*   1. 默认到期时间：30分钟
*   2. 手动设置销毁时间
*
*   3. 立即销毁
*   4. 关闭浏览器失效
*       session底层依赖cookie，cookie对象默认只在浏览器内存中存活，关闭浏览器即失效
*   5. 关闭服务器
* */

@WebServlet("/se03")
public class Session03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();

        //Session对象的最大不活动时间
        //System.out.println("Session对象的最大不活动时间：" +  session.getMaxInactiveInterval());

        //修改最大不活动时间
        //session.setMaxInactiveInterval(15); // 15秒

        //立即销毁
        session.invalidate();
    }
}

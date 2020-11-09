<%--
  Created by IntelliJ IDEA.
  User: qianmo
  Date: 2020/10/29
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%
    //获取参数
    String uname = request.getParameter("uname");
    //获取request作用域
    String upwd = (String) request.getAttribute("upwd");

    //输出内同
    out.print(uname);
    out.print("--------");
    out.print(upwd);
  %>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: qianmo
  Date: 2020/10/31
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <%
    //获取session域对象
    String uname = (String)request.getSession().getAttribute("uname");
    String upwd =(String) request.getSession().getAttribute("upwd");

    String name = (String)request.getAttribute("name");

    out.print(name);
    out.print("<br/>");
    out.print("--------");
    out.print("<br/>");
    out.print("uname:" + uname);
    out.print("<br/>");
    out.print("upwd:" + upwd);
  %>

  <body>

  </body>
</html>

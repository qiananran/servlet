<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: qianmo
  Date: 2020/10/28
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%--如果要在jsp中写Java代码需要卸载脚本段中--%>
  <%
    String name = (String)request.getAttribute("name");
    System.out.println("姓名:" + name);
    int age = (int)request.getAttribute("age");
    System.out.println("年龄：" + age);
    List<String> list = (List<String>)request.getAttribute("list");
    System.out.println("list[0]:" + list.get(0));

  %>
  </body>
</html>

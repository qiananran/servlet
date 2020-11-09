<%--
  Created by IntelliJ IDEA.
  User: dyilin
  Date: 2020/11/5
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP四大与对象</title>
</head>

<%--
    JSP的四大域对象
--%>

<%
    //获取域对象中的值
    out.print("page范围：" + pageContext.getAttribute("name"));
    out.print("request范围：" + request.getAttribute("name1"));
    out.print("session范围：" + session.getAttribute("name2"));
    out.print("application范围：" + application.getAttribute("name3"));

%>

<body>

</body>
</html>

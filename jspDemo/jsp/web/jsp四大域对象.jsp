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
        page作用域
            在当前页面有效，跳转后无效
        request作用域
            在一次请求中有效，服务器跳转有效，客户端跳转失效
        session作用域
            在一次会话中有效，服务器和客户端跳转有效
        application作用域
            在整个应用中有效
--%>



<body>

<%
    //设置page范围的域对象
    pageContext.setAttribute("name","zhangsan");
    //设置request范围的域对象
    request.setAttribute("name1","wagnweu");
    //设置session范围的域对象
    session.setAttribute("name2","dyilin");
    //设置application范围的域对象
    application.setAttribute("name3","zhaoliu");
%>


<%--jsp中服务端的跳转--%>
<jsp:forward page="jsp四大域对象2.jsp"></jsp:forward>

</body>
</html>

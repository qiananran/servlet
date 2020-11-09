<%--
  Created by IntelliJ IDEA.
  User: dyilin
  Date: 2020/10/31
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>脚本小程序</title>
</head>
<body>
<%--
    Sctiptlet脚本小程序
        jsp 一共有三种脚本小程序，可以写Java代码，定义局部变量，编写语句等
            第一种：Java脚本段,可以写Java代码，定义局部变量，编写语句等
                <%
                    //可以写Java代码
                %>
            第二种：声明,声明全局变量，方法，类等
                <!%
                    //声明全局变量
                %>
            第二种：输出表达式:可以输出变量和字符值
                <%=数值%>
--%>

<%--Java脚本段,可以写Java代码，定义局部变量，编写语句等--%>
<%
    String str = "hello jsp";
    //输出到控制台
    System.out.println(str);
    //输出到浏览器
    out.print(str);

    //输出全局变量
    out.write("全局变量：" + num);
%>

<%--声明,声明全局变量，方法，类等--%>
<%!
    int num = 10;
%>

<%--输出表达式:可以输出变量和字符值--%>
<%=str%>
</body>
</html>

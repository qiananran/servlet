# JSP&EL&JSTL

1. jsp:
   1. 指令
   2. 注释
   3. 内置对象
2. MVC开发模式
3. EL表达式
4. JSTL标签



## JSP：

1. 指令

   * 作用：用于配置JSP页面，导入资源文件

   * 格式：

     <%@ 指令名称 属性1="属性值1" 属性2="属性值2" %>

   * 分类：

     1. page：用于配置JSP页面的

        | 属性            | 描述                                           | 解释                                                         |
        | --------------- | ---------------------------------------------- | ------------------------------------------------------------ |
        | contentType     | 等同于response.setContextType                  | 设置响应体的mine类型以及字符集 <br/>设置当前jsp页面的编码：pageEncoding="utf-8" |
        | language="java" | 设置语言                                       |                                                              |
        | buffer="8kb"    | 默认值，设置缓冲大小                           |                                                              |
        | import          | 用来导包的                                     |                                                              |
        | errorPage       | 当前页面发生异常后，会自动跳转到指定到指定页面 |                                                              |
        | isErrorPage     | 用来表示当前页面是否为错误页面                 | true：是，可以使用内置对象exception false：<br/>否，不能使用内置对象exception |

        

     2. include：页面包含的。导入页面的资源文件

        * <%@include file="top.jsp"%>

     3. taglib：导入资源

        * <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          * prefix : 前缀，自定义

2. 注释

   1. html

      /<!---->:只能注释html

   2. jsp注释

      <%----%>：能注释所有

3. 内置对象

   > 在jsp页面中不需要创建，直接使用的对象

   | 内置对象    | 描述                                      | 真实类型            | 解释                            |
   | ----------- | ----------------------------------------- | ------------------- | ------------------------------- |
   | pageContext | 当前页面共享数据（获取其他8个内置对对象） | pageContext         |                                 |
   | request     | 一次请求内共享数据                        | HttpServletRequest  |                                 |
   | session     | 一次会话中共享数据                        | HttpSession         |                                 |
   | application | 所用用户间共享数据                        | ServletContext      |                                 |
   | response    | 响应对象                                  | HttpServletResponse |                                 |
   | page        | 当前(servlet)页面对象                     | Object              |                                 |
   | out         | 输出对象，数据输出到页面上                | JspWriter           |                                 |
   | config      | servlet的配置对象                         | ServletConfig       |                                 |
   | exception   | 异常对象                                  | Throwable           | 只有声明了isErrorPage后才能使用 |





## MVC：开发模式

1. jsp演变历史

   1. 早期只有servlet，只能使用response输出标签数据，非常麻烦
   2. 后来有jsp，简化了servlet的开发，如果过度使用jsp，在jsp中即写大量的Java代码，有写html表，造成难于维护，难于分工协作
   3. 在后来，java的web开发，借鉴mvc开发模式，使得程序的设计更加合理

2. MVC：

   1. M：Model，模型 javaBean

      * 完成具体的业务操作。如：查询数据库，封装对象

   2. V：View，视图 jsp

      + 展示数据

   3. C：Controller，控制器 servlet

      + 获取用户的输入
      + 调用模型
      + 将数据交给视图进行展示

   4. 优缺点

      1. 优点：
         1. 耦合性低，方便维护
         2. 重用性高
      2. 缺点
         1. 使得项目架构变得复杂，对开发人员要求过高

   5. 图解

      ![](https://cdn.jsdelivr.net/gh/qiananran/Image/chrome_x48xNXgtem.png)



## EL表达式

1. 概念：Expression Language 表达式语言

2. 作用：替换和简化jsp页面中Java代码的编写

3. 语法：${表达式}

4. 注意：

   1. jsp默认支持解析EL表达式
      1. 设置jsp中配置中的指令：isELInored=“true”
      2. \${表达式}：忽略当前这个el表达式

5. 使用：

   1. 运算：

      1. 算数运算符：+ - * /(div) %(mod)
      2. 比较运算符：> < >= <= == !=
      3. 逻辑运算符：&&(and) ||(or)  !(not)
      4. 空运算符：empty
         1. 功能：<font color="red">用于判断字符串、集合、数组对象是否为null或其长度是否为0</font>
         2. ${empty list}

   2. 获取值

      1. el表达式只能从域对象中获取值

      2. 语法：

         1. ${域名称.键名}：从指定域中获取指定键的值
            1. 域的名称：
               1. pagescope  --> pageContext
               2. requestScope --> request
               3. sessionScope --> session
               4. applicationScope --> application
            2. ${键名}：表示一次从最小的域中查找是否有该键对应的键名。直到找到
            3. 获取对象、集合、map值
               1. 对象：${域名称.键名.属性名}
                  1. 本质上调用的是对象的get和set方法
               2. list集合：${域名称.键名[索引]}
               3. Map集合：
                  1. ${域名称.键名.key的名称}
                  2. ${域名称.键名["key的名称"]}

      3. 隐式对象：

         el表达式有11个隐式对象

         1. pageContext：
            1. 获取jsp其中8个内置对象
               1. ${pageContext.request.contextPath}：动态获取虚拟目录



## JSTL

1. 概念：JavaServer Pages Tag Library jsp标准标签库

   1. 有apache组织提供的开源的免费的jsp标签

2. 作用： 用于简化和替换jsp页面上的Java代码

3. 使用步骤：

   1. 导入jstl相关包
   2. 引入标签库：taglib指令：<%@ taglib %>
   3. 使用标签

4. 常用的JSTL标签

   1. if

      1. c:if标签
         1. 属性
            1. test：必须属性，接受Boolean表达式
               + 如果表达式为true，则显示if标签体内容，如果false，则不显示标签体内容
               + 一般情况下，test属性值会结合el表达式一起使用
            2. 注意：c:if标签没有else的情况，想要else情况，则可以在定义一个c:if标签

   2. choose：相当于switch语句

      案例：

      ```html
      <%--
        Created by IntelliJ IDEA.
        User: dyilin
        Date: 2020/11/5
        Time: 20:57
        To change this template use File | Settings | File Templates.
      --%>
      <%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
      
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <html>
      <head>
          <title>Title</title>
      </head>
      <body>
      
      <%--
          完成数字编号对应星期几案例
              1.域中存储一数字
              2.使用choose标签取出数字   相当于switch声明
              3.使用when标签做数字判断    相当于case
              4.otherwise标签做其他情况的生明   相当于defaule
      
      --%>
      
      <%
          request.setAttribute("number",3);
      
      %>
      
      <c:choose>
          <c:when test="${number == 1}">星期一</c:when>
          <c:when test="${number == 1}">星期二</c:when>
          <c:when test="${number == 1}">星期三</c:when>
          <c:when test="${number == 1}">星期四</c:when>
          <c:when test="${number == 1}">星期五</c:when>
          <c:when test="${number == 1}">星期六</c:when>
          <c:when test="${number == 1}">星期天</c:when>
      
          <c:otherwise>输入有误</c:otherwise>
      </c:choose>
      
      
      </body>
      </html>
      
      ```

      

   3. foreach：相当于for循环

      1. 完成重复的操作

         ```java
         for(int i = 0; i < 0; i++){
             
         }
         
         /*属性：
         	begin：开始
         	end：结束
         	var：临时变量
         	step：步长
         */
         ```
         
      
         ```html
         <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
             ${i} <h3>${s.index}</h3>>
   </c:forEach>
         ```

      2. 完成容器的遍历
      
         ```java
         List<User> list;
         for(User user : list){
             
         }
         /*
         
         属性;
      	items:容器对象
         	var：容器中元素的临时变量
      	varStatus：循环状态对象
         		index：容器中元素的索引，从0开始
      		count：循环次数，从1开始
         
         */
         
         ```
         
         ```html
         <%
             List list = new ArrayList();
             list.add("aaa");
             list.add("aaa");
             list.add("aaa");
             list.add("aaa");
         
             request.setAttribute("list",list);
         %>
         <c:forEach items="${list}" varStatus="s" var="str">
             ${s.index} ${s.count} ${str}
         </c:forEach>
         ```
         
         
   
    
   
   ​      
   
      


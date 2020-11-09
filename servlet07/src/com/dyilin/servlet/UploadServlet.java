package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/*
* 文件上传：
*       使用注解@MultipartConfig将一个Servlet表示为支持文件上传
*       Servlet将Multipart/form-data的post请求封装在Part，通过part将上传的文件进行操作
* */

@WebServlet("/uploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text;charset=utf-8");
        //获取普通表单项
        String uname = req.getParameter("uname");
        System.out.println("uname:" + uname);

        //获取一个Part
        Part part = req.getPart("myfile"); //表单中file文件的name属性值
        //通过Part对得到上传文件的文件名
        String submittedFileName = part.getSubmittedFileName();
        System.out.println("上传文件名：" + submittedFileName);

        //得到文件的路经
        String realPath = req.getServletContext().getRealPath("/");
        System.out.println("文件存放的路径：" + realPath);
        //上传文件到指定目录
        part.write(realPath + "/" + submittedFileName);

    }
}

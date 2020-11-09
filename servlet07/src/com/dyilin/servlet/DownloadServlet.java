package com.dyilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件下载");

        //请求编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取参数，得到要下载的文件名
        String fileName = req.getParameter("fileName");
        //参数的非空判断 trim()去除字符串前后空格
        if (fileName == null && "".equals(fileName.trim())){
            resp.getWriter().write("请输入要下载的文件名");
            resp.getWriter().close();
            return;
        }
        //得到图片存放的路径
        String path = req.getServletContext().getRealPath("/download/");
        //通过路径得到file对象
        File file = new File(path + fileName);
        //判断文件对象是否存在，并且是一个标准文件
        if (file.exists() && file.isFile()){
            //设置响应类型
            resp.setContentType("application/x-msdownload");
            //设置头信息
            resp.setHeader("Context-Disposition","attachment;filename" + fileName);
            //响应文件
            //得到输入流
            InputStream in = new FileInputStream(file);
            //得到字节输出流
            ServletOutputStream out = resp.getOutputStream();
            //定义byte数组
            byte[] bytes = new byte[1024];
            //定义长度
            int len = 0;
            //循环输出
            while ((len = in.read(bytes)) != -1){
                //输出内同
                out.write(bytes,0,len);
            }

            //关闭资源
            out.close();
            in.close();
        }else {
            resp.getWriter().write("文件不存在，请重试");
            resp.getWriter().close();
        }
    }
}

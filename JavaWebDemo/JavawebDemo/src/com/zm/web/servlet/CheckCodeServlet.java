package com.zm.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/*验证码*/
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     System.out.println("checkCodeServlet……");
       /*1.创建一个图片对象*/
        //1.1设置图片的宽和高
        int width = 100;
        int height = 50;
        //1.2在内存中创建一个图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        /*2.美化图片*/
        /*2.1填充背景色*/
        //得到画笔对象
        Graphics graphics = image.getGraphics();
        //设置画笔颜色
        graphics.setColor(Color.darkGray);
        //填充
        graphics.fillRect(0,0,width,height);
        /*2.2画边框*/
        //设置画笔颜色
        graphics.setColor(Color.yellow);
        //画边框
        graphics.drawRect(0,0,width-1,height-1);


        /*2.3写验证码*/
        /*生成随机字母*/
        //生成验证码中所有可能用到的字母以及数字
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";

        //生成随机下标
        Random ran = new Random();
        int step = 20;
        //保存验证码信息
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=4;i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            Font font = new Font("微软雅黑",Font.LAYOUT_NO_LIMIT_CONTEXT,30);
            graphics.setFont(new Font("微软雅黑",Font.LAYOUT_NO_LIMIT_CONTEXT,30));

            graphics.drawString(ch + "", step*i, 28);
        }

        //将验证码信息转换成字符串
        String checkCode_session = sb.toString();
        //使用session保存验证码信息
        HttpSession session = req.getSession();
        session.setAttribute("checkCode_session",checkCode_session);

        /*2.4画干扰线*/
        for(int i=0;i<8;i++) {
            int x1 = ran.nextInt(width);
            int y1 = ran.nextInt(height);

            int x2 = ran.nextInt(width);
            int y2 = ran.nextInt(height);
            graphics.setColor(Color.darkGray);
            graphics.drawLine(x1, y1, x2, y2);
        }

        /*3.将图片输出到页面*/
        boolean bool = ImageIO.write(image, "jpg", resp.getOutputStream());
        System.out.println(bool);
    }
}

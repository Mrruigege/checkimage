package com.rui.checkimage.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "check",urlPatterns = "/check")
public class Myservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        BufferedImage bi = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        Color c = new Color(200,150,255);
        g.setColor(c);
        g.fillRect(0,0,68,22);
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVEXYZ123456789".toCharArray();
        Random r = new Random();
        int len = ch.length;
        int index;
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < 4 ; i++){
            index = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
            g.drawString(ch[index]+"",(i*15)+3,18);
            sb.append(ch[index]);
        }
        request.getSession().setAttribute("pic",sb.toString());
        ImageIO.write(bi,"JPG",response.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

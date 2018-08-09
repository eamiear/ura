/**
 * @author eamiear
 * @date 2018/8/9 17:29
 */

package com.ura.admin.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class SysLoginController {

    @Autowired
    private Producer producer;


    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException{
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        String text = producer.createText();
        BufferedImage bi = producer.createImage(text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
    }
}

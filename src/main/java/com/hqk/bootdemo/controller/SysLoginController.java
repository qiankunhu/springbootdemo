package com.hqk.bootdemo.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.hqk.bootdemo.config.KaptchaConfig;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p></p >
 *
 * @author hqk
 * @version 1.0: SysLoginController.java v0.1 2019/6/25 上午10:44 hqk Exp$
 */
@RequestMapping("/app/system")
@Controller
public class SysLoginController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private Producer producer;

   /* @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();

        //生成图片验证码
        BufferedImage image = producer.createImage(text);

        //保存到 redis 自己操做


        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }*/


    @RequestMapping("number.jpg")
    public void number(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();

        //个位数字相加
        String s1 = text.substring(0, 1);
        String s2 = text.substring(1, 2);
        int count = Integer.valueOf(s1).intValue() + Integer.valueOf(s2).intValue();

        //生成图片验证码
        BufferedImage image = producer.createImage(s1 + "+" + s2 + "=?");

        //保存 redis key 自己设置
        //stringRedisTemplate.opsForValue().set("",String.valueOf(count));

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }
}

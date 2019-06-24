package com.hqk.bootdemo.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>全局异常，适用前后端未分离</p >
 *
 * @author hqk
 * @version 1.0: GlobalExceptionResolver.java v0.1 2019/6/19 上午10:42 hqk Exp$
 */
@Component
public class GlobalExceptionResolver  implements HandlerExceptionResolver {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
    private static StringBuilder sb = new StringBuilder();


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //错误信息
        wirte("异常时间："+ dateFormat.format(new Date()));
        wirte("请求地址："+ httpServletRequest.getRequestURL());
        wirte("错误原因："+ e.toString());
        //详细异常
        sb.setLength(0);
        StackTraceElement[] error = e.getStackTrace();
        for (StackTraceElement stackTraceElement : error) {

            sb.append(stackTraceElement.toString()+"\n");
        }

        wirte("详细原因："+ sb.toString());

        //返回统一错误页面
        return new ModelAndView("error");

    }


    //打印到控制台
    void wirte(String msg){
        System.out.println(msg);
    }

}

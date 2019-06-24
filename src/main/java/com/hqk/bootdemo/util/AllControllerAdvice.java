package com.hqk.bootdemo.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>异常处理</p >
 *
 * @author hqk
 * @version 1.0: AllControllerAdvice.java v0.1 2019/6/19 上午10:48 hqk Exp$
 */
@RestControllerAdvice
public class AllControllerAdvice {


    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public Map<String,Object> customexceptionHandler(MyException e){

        Map<String,Object> map  = new HashMap<String,Object>();

        map.put("code",e.getCode());
        map.put("msg",e.getMessage());
        map.put("data",null);

        //可以对异常进行日志记录，写入数据库 或者 发送邮件预警
        // log.info("错误信息"+e.getMessage());

        return map;
    }

    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> exceptionHandler(Exception e){

        Map<String,Object> map  = new HashMap<String,Object>();

        map.put("code","01");
        map.put("msg",e.getMessage());
        map.put("data",null);

        return map;
    }

}


  /* @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> exceptionHandler(Exception e){

        Map<String,Object> map  = new HashMap<String,Object>();

        map.put("code","01");
        map.put("msg",e.getMessage());
        map.put("data",null);

        //异常进行日志记录，写入数据库 或者 发送邮件预警

        return map;
    }*/
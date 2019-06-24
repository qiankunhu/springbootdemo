package com.hqk.bootdemo.controller;

import com.hqk.bootdemo.util.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p >
 *
 * @author hqk
 * @version 1.0: HelloController.java v0.1 2019/6/18 下午3:54 hqk Exp$
 */
@RestController
@RequestMapping("/app/system")
public class HelloController {


    @RequestMapping("version")
    public Map<String, Object> getHello() {

        Map<String, Object> map = new HashMap<>();

        map.put("code", "00");
        map.put("msg", "请求成功");

        try {

            System.out.println(1 / 0);

        } catch (Exception e) {

            throw new MyException("110", "这是个重大的bug,请马上处理");
        }


        return map;

    }


    @RequestMapping("hello")
    public Map<String, Object> getHai() {

        Map<String, Object> map = new HashMap<>();

        map.put("code", "00");
        map.put("msg", "请求成功");

        System.out.println(1 / 0);

        return map;

    }


}

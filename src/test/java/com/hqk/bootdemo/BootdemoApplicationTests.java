package com.hqk.bootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootdemoApplicationTests {

    @Test
    public void contextLoads() {


        String a=null;

        if(null!=a){
            System.out.println(1);
        }else{
            System.out.println(2);
        }


    }

}

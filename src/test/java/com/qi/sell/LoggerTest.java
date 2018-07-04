package com.qi.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Qi
 * 2018/7/4
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);//当前类日志输出时记录是哪个类的

    @Test
    public void test1() {
        String name = "sdf";
        String password = "sfgsdg";
        log.info("name:{},password{}",name,password);

        log.debug("debug...");
        log.info("info...");
        log.error("error...");
    }

}

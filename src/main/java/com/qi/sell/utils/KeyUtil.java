package com.qi.sell.utils;

import java.util.Random;

/**
 * Created by Qi
 * 2018/7/5 17:48
 **/
public class KeyUtil {
    /*生成唯一的主键
     * 格式：时间+随机数
     * */
    //synchronized是为了防止多线程时仍然有重复的可能
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}

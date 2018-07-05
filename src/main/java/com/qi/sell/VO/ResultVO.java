package com.qi.sell.VO;

import lombok.Data;

/**
 * Created by Qi
 * 2018/7/5 10:52
 **/
@Data
public class ResultVO<T> {
    /*error code*/
    private Integer code;

    /*message*/
    private String msg;

    /*data details*/
    private T data;
}

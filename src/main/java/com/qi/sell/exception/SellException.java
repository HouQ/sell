package com.qi.sell.exception;

import com.qi.sell.enums.ResultEnum;

/**
 * Created by Qi
 * 2018/7/5 17:34
 **/
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}

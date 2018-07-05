package com.qi.sell.utils;

import com.qi.sell.VO.ResultVO;

/**
 * 返回结果封装
 * Created by Qi
 * 2018/7/5 13:42
 **/
public class ResultVOUtil {
    public static ResultVO success(Object o) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(o);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}

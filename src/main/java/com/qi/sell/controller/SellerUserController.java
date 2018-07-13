package com.qi.sell.controller;

import com.qi.sell.constant.CookieConstant;
import com.qi.sell.constant.RedisConstant;
import com.qi.sell.entity.SellerInfo;
import com.qi.sell.enums.ResultEnum;
import com.qi.sell.exception.SellException;
import com.qi.sell.service.SellerService;
import com.qi.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Qi
 * 2018/7/13 9:45
 **/
@Controller
@RequestMapping("/sellerinfo")
@Slf4j
public class SellerUserController {
    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/")
    public ModelAndView sellerinfo(){

        return new ModelAndView("manage/login");
    }

    @GetMapping("/login")
    public ModelAndView login(@Valid SellerInfo sellerInfo, BindingResult bindingResult,
                              HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            log.error("【卖家登录】参数不正确,sellerInfo={}", sellerInfo);
            throw new SellException(ResultEnum.SELLER_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        /*1.用户名密码和数据库匹配*/
        SellerInfo seller = sellerService.findSellerByUsername(sellerInfo.getUsername());
        if (seller == null) {
            log.error("【卖家登录】未找到卖家,sellerInfo={}", sellerInfo);
            throw new SellException(ResultEnum.SELLER_NOT_EXIST);
        }

        if (!seller.getPassword().equals(sellerInfo.getPassword())) {
            log.error("【卖家登录】密码错误,sellerInfo={}", sellerInfo);
            throw new SellException(ResultEnum.WRONG_PASSWORD);
        }

        /*2.设置token至redis*/
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().
                set(String.format(RedisConstant.TOKEN_PREFIX, token), seller.getUsername(), expire, TimeUnit.SECONDS);
        //key,value,expire,time unit

        /*3.设置token至cookie*/
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

        return new ModelAndView("redirect:/sellerinfo/success");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        /*1.从cookie查询*/
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        /*2.清除redis*/
        if (cookie != null) {
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            /*3.清除cookie*/
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        return new ModelAndView("redirect:/sellerinfo/logoutsuccess");
    }
}

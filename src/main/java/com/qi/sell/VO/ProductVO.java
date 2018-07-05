package com.qi.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目
 * Created by Qi
 * 2018/7/5 11:07
 **/
@Data
public class ProductVO {

    @JsonProperty("name") //作为josnbei返回时用name的形式
    private String categoryName;


    @JsonProperty("type")
    private String categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}

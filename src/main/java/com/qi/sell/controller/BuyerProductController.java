package com.qi.sell.controller;

import com.qi.sell.VO.ProductInfoVO;
import com.qi.sell.VO.ProductVO;
import com.qi.sell.VO.ResultVO;
import com.qi.sell.entity.ProductCategory;
import com.qi.sell.entity.ProductInfo;
import com.qi.sell.service.CategoryService;
import com.qi.sell.service.ProductService;
import com.qi.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Qi
 * 2018/7/5 10:42
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        /*1.查询所有上架商品*/
        List<ProductInfo> productInfoList = productService.findUpAll();

        /*2.查询类目*/
        List<Integer> categoryTypeList = new ArrayList<>();

//        /*传统做法*/
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        /*lambda方法*/
        categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        /*3.数据拼装*/
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType().toString());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType() == productCategory.getCategoryType()) {
//                    productInfoVOList.add(new ProductInfoVO(productInfo.getProductId(), productInfo.getProductName(), productInfo.getProductPrice().toString(), productInfo.getProductDescription(), productInfo.getProductIcon()));
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}

package com.qi.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Qi
 * 2018/7/4 17:15
 **/
@Entity //Jpa
@DynamicUpdate //可以动态更新修改时间啦
@Data //可以不用手动写get set方法啦
public class ProductCategory {
    /*类目ID*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /*类目名字*/
    private String categoryName;

    /*类目编号*/
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    //    /*创建时间*/
//    private Date createTime;
//
//    /*修改时间*/
//    private Date updateTime;

}

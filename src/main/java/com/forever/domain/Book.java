package com.forever.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("book_info")
@Data
public class Book {

    @TableId(type = IdType.AUTO)
    private Integer book_id;
    private String name;
    private String author;
    private String publish;
    @TableField(value = "ISBN")
    private String ISBN;
    private String introduction;
    private String language;
    private Double price;
    private String pubdate;
    private int cid;
    private int stock;
}

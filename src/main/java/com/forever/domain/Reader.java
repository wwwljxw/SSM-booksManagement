package com.forever.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("reader_info")
@Data
public class Reader {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "reader_id")
    private Integer readerId;
    private String name;
    private String password;
    private String sex;
    private String birthday;
    private String address;
    private String telephone;
    @TableField(value = "card_state")
    private int cardState;

}

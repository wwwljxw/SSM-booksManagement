package com.forever.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("reader_info")
@Data
public class Reader {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private int reader_id;
    private String name;
    private int password;
    private String sex;
    private String birthday;
    private String address;
    private String telephone;
    private int card_state;

}

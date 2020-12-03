package com.forever.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("class_info")
public class Type {
    @TableId(type = IdType.AUTO)
    private int cid;
    private String cname;
}

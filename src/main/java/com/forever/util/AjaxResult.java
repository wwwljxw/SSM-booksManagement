package com.forever.util;

import lombok.Data;

/**
 * @author 林继贤
 * 该工具类用于接收数据库CUD（增加、删除、更新）的执行结果
 */
@Data
public class AjaxResult {
    private boolean success;
    private String message;
    private Integer status;
}

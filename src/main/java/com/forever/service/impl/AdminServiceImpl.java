package com.forever.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.forever.domain.Admin;
import com.forever.dao.AdminMapper;
import com.forever.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-12-09
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     *  管理员登录验证
     */
    public Admin doLogin(String name,String password){
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        Map<String, String> map = new HashMap<>();
        map.put("name",name);
        map.put("password",password);
        wrapper.allEq(map);
        return adminMapper.selectOne(wrapper);
    }

}

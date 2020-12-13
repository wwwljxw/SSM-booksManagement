package com.forever.service;

import com.forever.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2020-12-09
 */
public interface AdminService extends IService<Admin> {
    Admin doLogin(String name,String password);
}

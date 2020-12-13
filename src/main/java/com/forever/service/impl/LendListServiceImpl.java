package com.forever.service.impl;

import com.forever.domain.LendList;
import com.forever.dao.LendListMapper;
import com.forever.service.LendListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-12-09
 */
@Service
public class LendListServiceImpl extends ServiceImpl<LendListMapper, LendList> implements LendListService {

    @Autowired
    private LendListMapper lendMapper;

    public void lendBook(){

    }
}

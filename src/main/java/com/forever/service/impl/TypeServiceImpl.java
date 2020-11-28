package com.forever.service.impl;

import com.forever.dao.TypeMapper;
import com.forever.domain.Type;
import com.forever.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> allTypes() {
        return typeMapper.allTypes();
    }

    @Override
    public int addType(String cname) {
        return typeMapper.addType(cname);
    }

    @Override
    public int deleteType(int cid) {
        return typeMapper.deleteType(cid);
    }
}

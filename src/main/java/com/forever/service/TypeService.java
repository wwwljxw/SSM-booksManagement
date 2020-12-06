package com.forever.service;

import com.forever.domain.Type;
import com.forever.exception.TypeException;
import com.forever.util.AjaxResult;

import java.util.List;
import java.util.Map;

public interface TypeService {


    Map pageAllTypes(int page, int limit);

    AjaxResult addType(String cname) throws TypeException;

    AjaxResult deleteType(int cid) throws TypeException;

    AjaxResult updateType(int cid, String cname) throws TypeException;

    List<Type> allType();
}

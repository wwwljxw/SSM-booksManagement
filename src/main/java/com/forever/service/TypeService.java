package com.forever.service;

import com.forever.exception.TypeException;
import com.forever.util.AjaxResult;

import java.util.Map;

public interface TypeService {


    Map allTypes(int page, int limit);

    AjaxResult addType(String cname) throws TypeException;

    AjaxResult deleteType(int cid) throws TypeException;

    AjaxResult updateType(int cid, String cname) throws TypeException;
}

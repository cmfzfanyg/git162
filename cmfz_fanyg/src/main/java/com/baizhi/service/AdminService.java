package com.baizhi.service;

import com.baizhi.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface AdminService {
    //登录
    public HashMap<String, Object> login(String enCode, String userName, String password, HttpServletRequest request);



    }

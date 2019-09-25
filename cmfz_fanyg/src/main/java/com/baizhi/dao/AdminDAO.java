package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDAO {

    //根据用户名密码查询
    public Admin selectUserNameAndPassword(String userName,String password);


}

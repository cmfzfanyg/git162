package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    //分页
    public Map<String,Object> showAll(Integer page, Integer rows);

    //修改
    public void update(User user);

    //查询总条数
    public Integer totalcounts();

    //查询所有
    public List<User> All();

}

package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDAO {

    //查询所有分页
    public List<User> selectAll(Integer page,Integer rows);
    //修改
    public void update(User user);
    //查询总条数
    public Integer totalcounts();
    //查询所有
    public List<User> All();

}

package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.HashMap;
import java.util.List;

public interface BannerService {

    //查询所有
    public List<Banner> showAll(Integer page,Integer rows);
    //添加
    public String add(Banner banner);
    //修改
    public void edit(Banner banner);
    //删除
    public void del(String id);
    //修改
    public void updatePhoto(Banner banner);
    //总条数
    public Integer totalcounts();
    //修改状态
    HashMap<String,Object> updateStatus(Banner banner);


}

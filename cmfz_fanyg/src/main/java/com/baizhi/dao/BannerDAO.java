package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDAO {

    //查询所有
    public List<Banner> queryAll(@Param("page")Integer page,@Param("rows")Integer rows);
    //增加用户
    public void add(Banner banner);
    //修改
    //    public void edit(String id);
    //删除
    public void del(String id);
    //根据id修改照片名称
    public void updatePhoto(Banner banner);
    //总条数
    public Integer totalcounts();
    //修改状态
    public void update(Banner banner);




}

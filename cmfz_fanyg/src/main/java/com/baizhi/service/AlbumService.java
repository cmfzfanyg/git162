package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {

    //查询所有
    public List<Album> selectAll(Integer page,Integer rows);
    //总条数
    public Integer totalcounts();

}

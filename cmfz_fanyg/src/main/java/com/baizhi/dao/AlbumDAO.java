package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDAO {

    //查询所有
    public List<Album> selectAll(@Param("page") Integer page, @Param("rows") Integer rows);

    //总条数
    public Integer totalcounts();
}

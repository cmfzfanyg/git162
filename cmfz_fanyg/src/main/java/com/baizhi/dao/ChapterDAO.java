package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDAO {

    //查询所有
    public List<Chapter> queryByPage(@Param("rows")Integer page,@Param("rows") Integer rows, @Param("album_id")Integer album_id);
    //查询总条数
    public Integer totalcounts(Integer album_id);
    //添加
    public void add(Chapter chapter);
    //修改
    public void update(Chapter chapter);
    //删除
    public void dalete(String id);

}

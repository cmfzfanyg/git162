package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDAO {

    //查询所有
    public List<Article>  selectAll(@Param("page")Integer page,@Param("rows")Integer rows);
    //删除
    public void delete(Integer id);
    //添加
    public void add(Article article);
    //修改
    public void update(Article article);
    //查询总条数
    public Integer totalcounts();


}

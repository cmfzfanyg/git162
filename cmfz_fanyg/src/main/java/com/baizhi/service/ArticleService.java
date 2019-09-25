package com.baizhi.service;


import com.baizhi.entity.Article;

import java.util.List;

public interface ArticleService {

    //查询所有
    public List<Article> selectAll(Integer page,Integer rows);

    //删除
    public void delete(Integer id);

    //添加
    public void add(Article article);

    //修改
    public void update(Article article);

    //查询总条数
    public Integer totalcounts();

}

package com.baizhi.service;

import com.baizhi.dao.ArticleDAO;
import com.baizhi.entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDAO articleDAO;

    @Override
    public List<Article> selectAll(Integer page,Integer rows) {

        List<Article> articles = articleDAO.selectAll(page,rows);
        return articles;
    }

    @Override
    public void delete(Integer id) {

        articleDAO.delete(id);

    }

    @Override
    public void add(Article article) {

        articleDAO.add(article);
    }

    @Override
    public void update(Article article) {

        articleDAO.update(article);
    }

    @Override
    public Integer totalcounts() {

       Integer totalcounts = articleDAO.totalcounts();
        return totalcounts;
    }
}

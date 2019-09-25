package com.baizhi.action;


import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("showAll")
    @ResponseBody
    public Map<String,Object> showAll(Integer page,Integer rows)throws Exception{

        List<Article> article = articleService.selectAll(page,rows);
        Map<String,Object> maps = new HashMap<String,Object>();
        //设置当前页号
        System.out.println("当前页号"+page);
        maps.put("page",page);
        //当前页展示的数据
        maps.put("rows",article);
        //准备总条数
        Integer totalcounts = articleService.totalcounts();
        maps.put("records",totalcounts);
        //总页数
        Integer count;
        if(totalcounts%rows==0){
            count = totalcounts/rows;
        }else {
            count = totalcounts/rows+1;
        }
        maps.put("total",count);
        return maps;
    }



    @RequestMapping("/edit")
    public void edit(Integer id,String oper){

        if(oper.equals("del")){
            articleService.delete(id);

        }
    }

    @RequestMapping("addArticle")
    public HashMap<String, Object> addArticle(Article article){

        HashMap<String, Object> map = new HashMap<>();
        map.put("message","成功");
        System.out.println("========"+article);
        articleService.add(article);
        return map;
    }

    @RequestMapping("updateArticle")
    public HashMap<String,Object> updateArticle(Article article){

        HashMap<String,Object> map = new HashMap<>();
        map.put("message","成功");
        System.out.println("调用修该数据"+article);
        articleService.update(article);

        return map;

    }




}

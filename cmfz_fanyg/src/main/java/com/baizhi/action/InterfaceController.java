package com.baizhi.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class InterfaceController {

    @RequestMapping("first_page")
    public  HashMap<String,Object> first_page(String uid,String type,String sub_type){

        System.out.println(uid);

        HashMap<String,Object> map = new HashMap<>();

        if(uid!=null){
            if(type.equals("all")){
                //首页展示

                //处理轮播图数据


                //封装轮播图数据


                //处理专辑数据

                //封装专辑数据

                //处理文章数据

                //封装文章数据


            }

            if(type.equals("wen")){
                //专辑数据展示
            }

            if(type.equals("si")){
                //文章的数据
                if(sub_type!=null){
                    if(sub_type.equals("ssyj")){
                        //展示上师言教的文章  自己上师的文章
                    }else {
                        //展示显密法要的文章 其他上师的文章
                    }
                }
            }
        }
        return map;
    }
}

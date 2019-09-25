package com.baizhi.action;

import com.baizhi.entity.City;
import com.baizhi.entity.Pro;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping("echarts")
public class EchartsController {

    @RequestMapping("queryUserCount")
    public HashMap<String,Object> queryUserCount(){

        HashMap<String, Object> map = new HashMap<>();

        map.put("month", Arrays.asList("1月","2月","3月","4月","5月","6月"));
        map.put("boys",Arrays.asList(500,200,800,100,400,900));
        map.put("girls",Arrays.asList(350,200,100,100,400,800));

        return map;
    }

    @RequestMapping("queryUserMap")
    public ArrayList<Pro>  queryUserMap(){
        System.out.println("进来了");
        ArrayList<Pro> pros = new ArrayList<>();

        ArrayList<City> boys = new ArrayList<>();
        boys.add(new City("北京","200"));
        boys.add(new City("深圳","800"));
        boys.add(new City("河南","500"));
        boys.add(new City("西藏","300"));

        ArrayList<City> girls = new ArrayList<>();
        girls.add(new City("北京","200"));
        girls.add(new City("深圳","800"));
        girls.add(new City("安徽","850"));
        girls.add(new City("西藏","300"));

        Pro pro1 = new Pro("男生", boys);
        Pro pro2 = new Pro("女生", girls);

        pros.add(pro1);
        pros.add(pro2);

        return pros;
    }


}

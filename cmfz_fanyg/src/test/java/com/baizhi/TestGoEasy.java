package com.baizhi;

import com.alibaba.fastjson.JSONObject;
import io.goeasy.GoEasy;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGoEasy {

    @Test
    public void TestGoEasy(){

        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-1c0a1d868beb442fae47932acc129e88");
                goEasy.publish("Java-162", "Hello, GoEasy!");

    }

    @Test
    public void TestGoEasyEcharts() {

        for(int i = 0;i<10;i++){

            //创建随机数
            Random random = new Random();

            Integer[] boysrandoms = {random.nextInt(200),random.nextInt(500),random.nextInt(600),
                    random.nextInt(500),random.nextInt(800),random.nextInt(400)
            };
            Integer[] girlsrandoms = {random.nextInt(400),random.nextInt(200),random.nextInt(500),
                    random.nextInt(200),random.nextInt(800),random.nextInt(600)
            };


            //创建一个json对象
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("month", Arrays.asList("1月","2月","3月","4月","5月","6月"));
            jsonObject.put("boys", boysrandoms);
            jsonObject.put("girls", girlsrandoms);

            String content = jsonObject.toJSONString();


            GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-1c0a1d868beb442fae47932acc129e88");
            goEasy.publish("Java-162", content);

            try{
                //线程休息
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

}

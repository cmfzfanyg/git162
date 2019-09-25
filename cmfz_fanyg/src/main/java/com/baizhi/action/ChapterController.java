package com.baizhi.action;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @ResponseBody
    @RequestMapping("queryByPage")
    public Map<String,Object> queryByPage(Integer page,Integer rows,Integer album_id){

        List<Chapter> chapters = chapterService.queryByPage(page,rows,album_id);
        Map<String,Object> maps = new HashMap<String,Object>();
        //设置当前页号
        maps.put("page",page);
        //当前页展示的数据
        maps.put("rows",chapters);
        //准备总条数
        Integer totalcounts = chapterService.totalcounts(album_id);
        maps.put("records",totalcounts);
        //总页数
        Integer count;
        if(totalcounts%rows==0){
            count=totalcounts/rows;
        }else {
            count = totalcounts/rows+1;
        }
        maps.put("total",count);
        return maps;
    }

    @RequestMapping("edit")
    public String edit(Chapter chapter,Integer album_id,String oper,String id){

        if(oper.equals("add")){
            chapter.setAlbum_id(album_id);
            System.out.println(chapter);
            id = chapterService.add(chapter);

        }

        if(oper.equals("edit")){


        }

        if(oper.equals("del")){
            chapterService.delete(id);
        }
        return id;
    }

    @RequestMapping("/uploadChapter")
    public HashMap<String,Object> uploadChapter(MultipartFile url, String id, HttpServletRequest request){

        HashMap<String,Object> map = chapterService.uploadChapter(url, id, request);
        return map;
    }

    @RequestMapping("/downloadChapter")
    public void downloadChapter(String fileName, HttpServletRequest request, HttpServletResponse response){

        System.out.println("进到下载了");
        chapterService.downloadChapter(fileName,request,response);

    }

}

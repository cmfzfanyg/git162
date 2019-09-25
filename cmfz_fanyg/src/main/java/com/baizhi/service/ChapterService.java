package com.baizhi.service;

import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public interface ChapterService {


    //查询所有
    public List<Chapter> queryByPage(Integer page,Integer rows, Integer album_id);

    //总条数
    public Integer totalcounts(Integer album_id);
    //添加
    public String add(Chapter chapter);
    //文件上传 修改数据
    public HashMap<String, Object> uploadChapter(MultipartFile url, String id, HttpServletRequest request);
    //文件下载
    public void downloadChapter(String fileName, HttpServletRequest request, HttpServletResponse response);
    //删除
    public void delete(String id);

}


package com.baizhi.service;


import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import com.baizhi.util.UUIDUtil;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterDAO chapterDAO;

    @Override
    public List<Chapter> queryByPage(Integer page,Integer rows, Integer album_id) {

        List<Chapter> chapters = chapterDAO.queryByPage(page,rows,album_id);

        return chapters;
    }

    @Override
    public Integer totalcounts(Integer album_id) {

        Integer totalcounts = chapterDAO.totalcounts(album_id);

        return totalcounts;
    }

    @Override
    public String add(Chapter chapter) {

        String uuid = UUIDUtil.getUUID();
        chapter.setId(uuid);
        chapter.setUp_date(new Date());
        chapterDAO.add(chapter);
        return uuid;
    }

    @Override
    public HashMap<String, Object> uploadChapter(MultipartFile url, String id, HttpServletRequest request) {

        HashMap<String, Object> map = new HashMap<>();

        try {
            //根据相对路径获取据对路径
            String realPath = request.getSession().getServletContext().getRealPath("/upload/audio");

            File file = new File(realPath);
            if(!file.exists()){
                file.mkdirs();
            }
            //获取文件名
            String filename = url.getOriginalFilename();

            String name = new Date().getTime()+""+filename;
            //文件上传
            url.transferTo(new File(realPath,name));

            //文件的大小 字节 Byte
            double size = (double) url.getSize();
            double dd = size/1024/1024;
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String sizes = decimalFormat.format(dd)+"MB";

            //获取文件的时长
            AudioFile audioFile = AudioFileIO.read(new File(realPath,name));
            //获取时长 秒
            int length = audioFile.getAudioHeader().getTrackLength();

            String duration = length/60+"分"+length%60+"秒";

            //  修改数据
            Chapter chapter = new Chapter();
            chapter.setId(id);
            chapter.setUrl(name);

            System.out.println("获取文件时长"+sizes);
            System.out.println("获取文件大小"+duration);
            chapter.setSize(sizes);
            chapter.setDuration(duration);
            System.out.println("修改操作"+chapter);

            chapterDAO.update(chapter);
            map.put("success","200");
            map.put("message","上传成功");
        } catch (Exception  e) {
            e.printStackTrace();
            map.put("success","400");
            map.put("message","上传失败");
        }

        return map;
    }

    @Override
    public void downloadChapter(String fileName, HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到下载文件Service层了");
        try {
            //1.获取文件的路径
            String realPath = request.getSession().getServletContext().getRealPath("/upload/audio");

            //2.根据路径获取文件
            FileInputStream inputStream = new FileInputStream(new File(realPath,fileName));

            //3.设置响应格式             attachment:以附件的形式下载      inline:在线打开
            response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));

            //获取输出流
            ServletOutputStream outputStream = response.getOutputStream();

            //4.文件下载
            IOUtils.copy(inputStream,outputStream);

            //关闭资源
//            inputStream.close();
//            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

        chapterDAO.dalete(id);
    }

}

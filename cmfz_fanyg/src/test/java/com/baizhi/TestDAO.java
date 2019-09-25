package com.baizhi;


import com.baizhi.dao.AlbumDAO;
import com.baizhi.dao.BannerDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestDAO {

    @Resource
    private BannerDAO bannerDAO;
    @Resource
    private AlbumDAO albumDAO;
    @Autowired
    private BannerService bannerService;
    @Resource
    private ChapterDAO chapterDAO;


    @Test
    public void TestDAO(){
        Integer banners = chapterDAO.totalcounts(1);
        System.out.println(banners);
    }
    @Test
    public void TestDA(){

        String id = null;

        Banner banner = new Banner();
        banner.setName("好的");
        banner.setImg_path("照片名字");
        banner.setStatus("正常");
        id = bannerService.add(banner);
        System.out.println(id);
    }

    @Test
    public void TestDO(){

        Chapter chapter = new Chapter();
        chapter.setId("12333");
        chapter.setName("3.jpg");
        chapterDAO.add(chapter);

    }
    @Test
    public void TestD1O(){

    }

}

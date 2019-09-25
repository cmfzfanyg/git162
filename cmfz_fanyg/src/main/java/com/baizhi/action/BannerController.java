package com.baizhi.action;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @ResponseBody
    @RequestMapping("/showAll")    //当前页号  每页显示的条数
    public Map<String,Object> showAll(Integer page, Integer rows) throws Exception{
        List<Banner> banners = bannerService.showAll(page,rows);
        Map<String,Object>maps = new HashMap<String,Object>();
        //设置当前页号
        maps.put("page",page);
        //当前页展示的数据
        maps.put("rows",banners);
        //准备总条数
        Integer totalcounts = bannerService.totalcounts();
        maps.put("records",totalcounts);
        //总页数
        Integer count;
        if(totalcounts%rows==0){
            count = totalcounts/rows;
        }else {
            count = totalcounts/rows+1;
        }
        maps.put("total",count);
        return   maps;
    }

    @RequestMapping("/edit")
    public String edit(Banner banner,String oper,String id){

        //执行添加操作
        if(oper.equals("add")){
            id = bannerService.add(banner);

        }
        //执行修改操作
        if(oper.equals("edit")){
            bannerService.edit(banner);
        }
        //执行删除操作
        if(oper.equals("del")){
            bannerService.del(id);
        }
        return id;
    }

    @RequestMapping("/bannerUpload")
    public void bannerUpload(MultipartFile img_path, String id, HttpServletRequest request){

        //1.根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/photo");

        //获取文件夹
        File file = new File(realPath);
        //判断文件夹是否存在
        if(!file.exists()){
            file.mkdirs();  //创建文件夹
        }
        //获取文件名
        String filename = img_path.getOriginalFilename();
        //给文件加一个时间戳
        String name = new Date().getTime()+"-"+filename;
        //文件上传
        try {
            img_path.transferTo(new File(realPath,name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //执行修改 修改文件的路径
        Banner banner = new Banner();
        banner.setId(id);
        banner.setImg_path(name);
        //调用Service层修改功能
        bannerService.updatePhoto(banner);
    }

    @RequestMapping("/updateStatus")
    public HashMap<String,Object> updateStatus(Banner banner){
        HashMap<String,Object> map = bannerService.updateStatus(banner);
        return map;
    }
}

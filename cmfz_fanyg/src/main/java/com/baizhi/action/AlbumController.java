package com.baizhi.action;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @ResponseBody
    @RequestMapping("/showAll")
    public Map<String,Object> showAll(Integer page,Integer rows) throws Exception{
        List<Album> albums = albumService.selectAll(page,rows);
        Map<String,Object> maps = new HashMap<>();
        //设置当前页号
        maps.put("page",page);
        //当前页展示的数据
        maps.put("rows",albums);
        //准备总条数
        Integer totalcounts = albumService.totalcounts();
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
}

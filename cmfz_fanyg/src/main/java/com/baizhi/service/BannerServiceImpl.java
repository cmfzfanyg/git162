package com.baizhi.service;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import com.baizhi.util.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerDAO bannerDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Banner> showAll(Integer page,Integer rows) {
        List<Banner> users = bannerDAO.queryAll(page,rows);

        return users;
    }

    @Override
    public String add(Banner banner) {

        String uuid = UUIDUtil.getUUID();
        banner.setId(uuid);
        banner.setStatus("正常");
        banner.setUp_date(new Date());
        bannerDAO.add(banner);
        return uuid;
    }

    @Override
    public void edit(Banner banner) {
        bannerDAO.updatePhoto(banner);
    }

    @Override
    public void del(String id) {
        bannerDAO.del(id);
    }

    @Override
    public void updatePhoto(Banner banner) {
        bannerDAO.updatePhoto(banner);
    }

    @Override
    public Integer totalcounts() {
        Integer totalcounts = bannerDAO.totalcounts();

        return totalcounts;
    }

    @Override
    public HashMap<String, Object> updateStatus(Banner banner) {

        HashMap<String,Object> map = new HashMap<>();

        try{
            bannerDAO.update(banner);
            map.put("success","200");
            map.put("message","修改成功");
        }catch(Exception e){
            e.printStackTrace();
            map.put("success","400");
            map.put("message","修改失败");
        }

        return map;
    }
}

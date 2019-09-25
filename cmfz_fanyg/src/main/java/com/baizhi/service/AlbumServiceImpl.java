package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Resource
    private AlbumDAO albumDAO;


    @Override
    public List<Album> selectAll(Integer page,Integer rows) {

        List<Album> albums = albumDAO.selectAll(page,rows);

        return albums;
    }

    @Override
    public Integer totalcounts() {

        Integer totalcounts= albumDAO.totalcounts();
        return totalcounts;
    }
}

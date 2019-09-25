package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String,Object> showAll(Integer page, Integer rows) {
        List<User> users = userDAO.selectAll(page, rows);

        HashMap<String, Object> map = new HashMap<String, Object>();
        //设置当前页号
        map.put("page",page);


        //当前页展示数据
        map.put("rows",users);

        //准备总条数
        Integer totalcounts = userDAO.totalcounts();
        map.put("records",totalcounts);


        //总页数
        Integer count;
        if(totalcounts%rows==0){
            count=totalcounts/rows;
        }else {
            count = totalcounts/rows+1;
        }
        map.put("total",count);

        return map;
    }

    @Override
    public void update(User user) {

        userDAO.update(user);
    }

    @Override
    public Integer totalcounts() {

        Integer totalcounts = userDAO.totalcounts();

        return totalcounts;
    }

    @Override
    public List<User> All() {

        List<User> users = userDAO.All();
        return users;
    }

}

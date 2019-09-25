package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDAO adminDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public HashMap<String, Object> login(String enCode, String userName, String password, HttpServletRequest request) {
        //获取验证码
        String imageCode =(String)request.getSession().getAttribute("imageCode");

        HashMap<String,Object> map = new HashMap<>();
        //判断验证码
        if(imageCode.equals(enCode)){

            Admin admin = adminDAO.selectUserNameAndPassword(userName,password);
            if(userName.equals(admin.getUserName())){
                if(password.equals(admin.getPassword())){

                    request.getSession().setAttribute("admin",admin);

                    map.put("success","200");
                    map.put("message","登陆成功");
                }else{
                    map.put("success","400");
                    map.put("message","密码错误");
                }
            }else {
                map.put("success","400");
                map.put("message","用户不存在");
            }
        }else {
            map.put("success","400");
            map.put("message","验证码错误");
        }
        return map;


    }
}

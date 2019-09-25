package com.baizhi.action;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.ImageCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String,Object> login(String enCode,String userName,String password, HttpServletRequest request){
            HashMap<String,Object> map = adminService.login(enCode,userName,password,request);

            return map;
    }

    @RequestMapping("getImageCode")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response){
        //1.获取验证码随机字符
        String code = ImageCodeUtil.getSecurityCode();

        //2.存储验证码字符
        request.getSession().setAttribute("imageCode",code);

        //3.将验证码字符生成图片
        BufferedImage image = ImageCodeUtil.createImage(code);

        //4. 设置响应类型
        response.setContentType("image/png");

        //5.将图片响应到页面
        try {
            ImageIO.write(image,"png",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        @RequestMapping("logout")
        public String logout(HttpServletRequest request){
             request.getSession().removeAttribute("admin");

            return "redirect:/login/login.jsp";
    }
}

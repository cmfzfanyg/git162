package com.baizhi.action;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.PhoneMsgUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/showAll")
    @ResponseBody
   public Map<String,Object> showAll(Integer page,Integer rows)throws Exception{

        Map<String, Object> maps = userService.showAll(page, rows);
        return maps;

}

    @RequestMapping("/All")
    @ResponseBody
    public List<User> All() {

        List<User> users = userService.All();

        try {
            //配置相关参数
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("持明法洲", "用户表"), User.class, users);

            //导出Excel
            workbook.write(new FileOutputStream(new File("G://User.xls")));

            //释放资源
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> update(User user){

        userService.update(user);
        Map<String, Object> map = new HashMap<>();
        map.put("message","修改成功");
        return map;
    }

    @RequestMapping("getPhone")
    public void getphone(String phone){

        String random = PhoneMsgUtil.getRandom(6);

        System.out.println("存入session添加判断条件验证码是否正确"+random);

        String message = PhoneMsgUtil.getPhones(phone,random);
        System.out.println(message);
    }



}

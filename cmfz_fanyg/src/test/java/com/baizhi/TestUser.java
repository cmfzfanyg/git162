package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.Teacher;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {

    @Autowired
    private UserService userService;
    @Resource
    private UserDAO userDAO;


    @Test
    public void testUser( ){


        List<User> users = userDAO.All();


        try {
            //配置相关参数
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("持明法洲","用户表"), User.class,users);

            //导出Excel
            workbook.write(new FileOutputStream(new File("G://User.xls")));

            //释放资源
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

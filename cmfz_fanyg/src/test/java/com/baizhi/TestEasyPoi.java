package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEasyPoi {

    @Test
    public void exportEasyPoi(){

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("1", "小黑", 35, new Date()));
        students.add(new Student("2", "小菊", 40, new Date()));
        students.add(new Student("3", "小王八", 25, new Date()));
        students.add(new Student("4", "小贱人", 39, new Date()));
        students.add(new Student("5", "小王", 28, new Date()));

        Teacher teacher = new Teacher("11", "孙帅", students);

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);

        try {

            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生信息表"),Teacher.class,teachers);

            //导出Excel
            workbook.write(new FileOutputStream(new File("G://EasyPoi.xls")));

            //释放资源
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exportEasyPoiw(){

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("1", "小黑", 35, new Date()));
        students.add(new Student("2", "小菊", 40, new Date()));
        students.add(new Student("3", "小王八", 25, new Date()));
        students.add(new Student("4", "小贱人", 39, new Date()));
        students.add(new Student("5", "小王", 28, new Date()));

        Teacher teacher = new Teacher("11", "孙帅", students);

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);

        try {

            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生信息表"),Teacher.class,teachers);

            //导出Excel
            workbook.write(new FileOutputStream(new File("G://EasyPoiwwwwww.xls")));

            //释放资源
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


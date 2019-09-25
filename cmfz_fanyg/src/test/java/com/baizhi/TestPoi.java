package com.baizhi;

import com.baizhi.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPoi {

    @Test
    public void testExportPoi() {

        //创建一个Excel文档
        Workbook workbook = new HSSFWorkbook();
        //创建一个工作薄 sheet 参数 工作薄的名字（sheet1，sheet2,....）
        //如果不指定工作薄的名字默认按照sheet0,sheet1来命名
        Sheet sheet = workbook.createSheet("工作薄1");

        //设置列宽  参数 列下标 列宽度
        sheet.setColumnWidth(3, 256 * 12);

        //创建一行   参数  行下表（下标从0开始）
        Row row = sheet.createRow(0);
        //创建一个单元格  参数：单元格下标（下标从0开始）；
        Cell cell = row.createCell(0);
        //给单元格设置内容
        cell.setCellValue("这是第一行第一个单元格");
        try {
            //导出Excel
            workbook.write(new FileOutputStream(new File("G://TestPoi.xls")));
            //释放资源
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExportPois() {

        Student stu1 = new Student("1", "小黑", 35, new Date());
        Student stu2 = new Student("2", "小菊", 40, new Date());
        Student stu3 = new Student("3", "小王八", 25, new Date());
        Student stu4 = new Student("4", "小贱人", 39, new Date());
        Student stu5 = new Student("5", "小王", 28, new Date());

        List<Student> students = Arrays.asList(stu1, stu2, stu3, stu4, stu5);

        //创建一个Excel文档
        Workbook workbook = new HSSFWorkbook();

        //创建一个工作薄 sheet 参数 工作薄的名字（sheet1，sheet2,....）
        //如果不指定工作薄的名字默认按照sheet0,sheet1来命名
        Sheet sheet = workbook.createSheet("工作薄1");

        //合并单元格   行开始firstRow, 行结束lastRow, 起始单元格firstCol, 结束单元格lastCol

        CellRangeAddress addresses = new CellRangeAddress(0, 0, 0, 3);

        //设置合并
        sheet.addMergedRegion(addresses);

        //设置列宽  参数 列下标 列宽度
        sheet.setColumnWidth(3, 256 * 12);

        //创建日期格式对象
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");
        //获取样式对象
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);


        //创建字体样式对象
        Font font = workbook.createFont();
        font.setBold(true);  //字体加粗
        font.setColor(Font.COLOR_RED);  //设置字体颜色
        font.setFontName("微软雅黑");   //设置字体

        //创建样式对象
        CellStyle cellStyle1 = workbook.createCellStyle();
        //将字体样式放入样式对象
        cellStyle1.setFont(font);
        //设置居中
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);  //文字居中


        //创建标题行
        Row rows = sheet.createRow(0);

        //设置标题行并设置内容
        Cell cell2 = rows.createCell(0);
        cell2.setCellStyle(cellStyle1);
        cell2.setCellValue("学生信息表");

        //创建一行   参数  行下表（下标从0开始）
        Row row = sheet.createRow(1);

        //创建一个目录行
        String[] titles = {"ID", "姓名", "年龄", "生日"};

        for (int i = 0; i < titles.length; i++) {

            //创建一个单元格  参数 单元格下表（下表从0开始）
            Cell cell = row.createCell(i);

            cell.setCellStyle(cellStyle1);
            //   给单元格赋值
            cell.setCellValue(titles[i]);
        }
        //处理数据行
        for (int i = 0; i < students.size(); i++) {
            //创建数据行
            Row row1 = sheet.createRow(i + 2);

            //处理第一个单元格的数据
            Cell cell = row1.createCell(0);
            Student student = students.get(i);
            String id = student.getId();
            cell.setCellValue(id);

            //处理第一个单元格的数据
            row1.createCell(1).setCellValue(students.get(i).getName());
            row1.createCell(2).setCellValue(students.get(i).getAge());
            Cell cell1 = row1.createCell(3);

            cell1.setCellStyle(cellStyle);
            cell1.setCellValue(students.get(i).getBir());

        }


        try {
            //导出Excel
            workbook.write(new FileOutputStream(new File("G://TestPoi.xls")));
            //释放资源
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testinportPoi() {
        try {
            //读取本地Excel文档
            Workbook workbook = new HSSFWorkbook(new FileInputStream(new File("G://TestPoi.xls")));

            //获取工作薄
            Sheet sheet = workbook.getSheet("工作薄1");

            for (int i = 2; i <= sheet.getLastRowNum(); i++) {

                Student student = new Student();
                //获取行
                Row row = sheet.getRow(i);

                //获取单元格
                Cell cell = row.getCell(0);
                //获取String类型的参数
                String id = cell.getStringCellValue();
                //将数据放入对象中
                student.setId(id);
                //获取第一行第二的单元格中的内容并且放入对象中
                student.setName(row.getCell(1).getStringCellValue());

                //获取数字类型的数据
                double age = row.getCell(2).getNumericCellValue();
                student.setAge((int) age);
                //获取日期
                student.setBir(row.getCell(3).getDateCellValue());

                //将数据插入到数据库
                System.out.println("打印" + student);

            }

        } catch (Exception e) {
            System.out.println("============");
            e.printStackTrace();
        }
    }



}

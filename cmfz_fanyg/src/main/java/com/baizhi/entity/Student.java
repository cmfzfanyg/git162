package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Excel(name="ID")
    private String id;

    @Excel(name="姓名")
    private String name;

    @Excel(name="年龄")
    private Integer age;

    @Excel(name="生日" ,format="yyyy-MM-dd")
    private Date bir;

}

package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Excel(name="ID")
    private Integer id;

    @Excel(name="头像")
    private String avatar;

    @Excel(name="手机号")
    private String phone;

    @Excel(name="密码")
    private String password;

    @Excel(name="盐")
    private String salt;

    @Excel(name="状态")
    private String status;

    @Excel(name="姓名")
    private String name;

    @Excel(name="法名")
    private String law_name;

    @Excel(name="性别")
    private String sex;

    @Excel(name="所在地")
    private String city;

    @Excel(name="签名")
    private String sign;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name="注册日期" ,format="yyyy-MM-dd")
    private Date crea_date;

    @Excel(name="上师ID")
    private String guru_id;

}

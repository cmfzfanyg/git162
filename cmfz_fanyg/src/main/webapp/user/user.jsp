<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script>
    $(function() {

        //初始化表单
        $("#untable").jqGrid({
                url : "${path}/user/showAll",
                datatype : "json",
                autowidth:true,
                styleUI:"Bootstrap", //表单格式
                height : "auto",
                rowNum : 3, //每页展示条数
                rowList : [ 1, 6, 9, 12],  //可选展示条数
                pager : '#abpage',   //分页工具
                viewrecords : true,  //是否显示总条数
                colNames : [ 'Id', '头像', '名字', '昵称', '密码','性别','状态','手机号','注册时间' ],
                colModel : [
                    {name : 'id',   width : 55},
                    {name : 'avatar', width : 100,
                        formatter:function(cellValue){
                            return "<img src='${path}/upload/editor/" +cellValue+"' style='width:100px;height:80px'>"
                        }
                    },
                    {name : 'name', width : 90},
                    {name : 'law_name', width : 90},
                    {name : 'password', width : 90},
                    {name : 'sex',  width : 90},
                    {name : 'status',width : 80,align : "left",
                        formatter:function(cellValue,option,rows){
                            if(cellValue=="冻结"){
                                return "<button class='btn btn-danger' onclick='updateStatus(\""+rows.id+"\",\""+cellValue+"\")'>冻结</button>"
                            }else {
                                return "<button class='btn btn-success' onclick='updateStatus(\""+rows.id+"\",\""+cellValue+"\")'>解除冻结</button>"
                            }
                        }
                    },
                    {name : 'phone', editable:true, width : 80,align : "left"},
                    {name : 'crea_date',width : 80,align : "left"},
                ]
            });
         //处理增删改查操作
         $("#untable").jqGrid('navGrid', '#abpage', {
            edit : false,
            add : false,
            del : false,addtext: "增加",edittext: "修改",deltext: "删除" },
             {},  //执行修改操作的额外配置
             {},  //执行添加操作的额外配置
             {}   //执行删除操作的额外配置
         );
    });
    //修改状态
    function updateStatus(id,status){
         if(status=="解除冻结"){
             $.ajax({
                url: "${path}/user/update",
                type:"post",
                dataType: "json",
                data:{"id":id,"status":"冻结"},
                success:function(data){
                    console.log(data);
                    //刷新页面
                    $("#untable").trigger("reloadGrid");
                }
             });
         }else {
             $.ajax({
                 url: "${path}/user/update",
                 type:"post",
                 dataType: "json",
                 data:{"id":id,"status":"解除冻结"},
                 success:function(){
                     //刷新页面
                     $("#untable").trigger("reloadGrid");
                 }
             });
         }
    }
    //点击导出按钮
    $("#btn1").click(function(){
        $.post("${path}/user/All",function(data){ },"json");
        alert("导出成功")
    });

    //点击发送验证码
    $("#btnphone").click(function(){

        //获取手机号
        var phone = $("#phoneInput").val();
        alert(phone);
        $.post("${path}/user/getPhone?phone="+phone,function(data){ },"json");

    });

</script>

<%--初始化面板--%>
<div class="panel panel-info">

    <%--面板头--%>
    <div class="panel panel-heading">
        <h2>用户信息</h2>
    </div>

    <ul class="nav nav-tabs">
        <li class="active"><a href="#">用户管理</a></li>
    </ul>
    <div class="panel panel-body">
            <button id="btn1" class="btn btn-warning" > 一键导出 </button>&emsp;
            <div align="right">
                <input id="phoneInput" name="phone" type="text"/> &emsp;
                <button id="btnphone" class="btn btn-warning" > 发送验证码 </button>&emsp;
            </div>
    </div>

    <%--初始表单--%>
    <table id="untable"/>

    <%--分页工具栏--%>
    <div id="abpage" />

</div>
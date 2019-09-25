<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script>
    $(function() {

        //初始化表单
        $("#bntable").jqGrid({

                url : "${path}/banner/showAll",
                editurl:"${path}/banner/edit",
                datatype : "json",
                rowNum : 3, //每页展示条数
                rowList : [ 3, 6, 9, 12],  //可选展示条数
                styleUI:"Bootstrap", //表单格式
                pager : '#bnpage',   //分页工具
                viewrecords : true,  //是否显示总条数
                autowidth:true,
                height : 210,
                colNames : [ 'Id', '名字', '图片', '状态', '描述','上传时间' ],
                colModel : [
                    {name : 'id',   width : 55},
                    {name : 'name',editable:true, width : 90},
                    {name : 'img_path',editable:true, width : 100,edittype:"file",
                        formatter:function(cellValue){
                            return "<img src='${path}/upload/photo/" +cellValue+"' style='width:100px;height:80px'>"
                        }
                    },
                    {name : 'status',width : 80,align : "left",
                        formatter:function(cellValue,option,rows){
                            if(cellValue=="正常"){
                                return "<button class='btn btn-danger' onclick='updateStatus(\""+rows.id+"\",\""+cellValue+"\")'>不展示</button>"
                            }else {
                                return "<button class='btn btn-success' onclick='updateStatus(\""+rows.id+"\",\""+cellValue+"\")'>正常</button>"
                            }

                        }
                    },
                    {name : 'description', editable:true, width : 80,align : "left"},
                    {name : 'up_date',width : 80,align : "left"},
                ]
            });
         //处理增删改查操作
         $("#bntable").jqGrid('navGrid', '#bnpage', {
            edit : true,
            add : true,
            del : true,addtext: "增加",edittext: "修改",deltext: "删除" },
             {},  //执行修改操作的额外配置
             {
                 //关闭对话框
                 closeAfterAdd:true,
                 afterSubmit:function(data) {
                     console.log(data);
                     $.ajaxFileUpload({
                        url:"${path}/banner/bannerUpload",
                        dataType:"json",
                        type:"post",
                        fileElementId:"img_path",
                        data:{id:data.responseText},
                        success:function(){
                            //刷新页面
                            $("#bntable").trigger("reloadGrid");
                        }
                     });
                     return "guanbi";
                 }
             },  //执行添加操作的额外配置
             {}   //执行删除操作的额外配置
         );
    });
    //修改状态
    function updateStatus(id,status){
         if(status=="正常"){
             $.ajax({
                url: "${path}/banner/updateStatus",
                type:"post",
                dataType: "json",
                data:{"id":id,"status":"不展示"},
                success:function(){
                    //刷新页面
                    $("#bntable").trigger("reloadGrid");
                }
             });
             return "keyi";
         }else {
             $.ajax({
                 url: "${path}/banner/updateStatus",
                 type:"post",
                 dataType: "json",
                 data:{"id":id,"status":"正常"},
                 success:function(){
                     //刷新页面
                     $("#bntable").trigger("reloadGrid");
                 }
             });
         }
    }


</script>

<%--初始化面板--%>
<div class="panel panel-info">

    <%--面板头--%>
    <div class="panel panel-heading">
        <h2>轮播图信息</h2>
    </div>

    <ul class="nav nav-tabs">
        <li class="active"><a href="#">轮播图信息</a></li>
    </ul>

    <%--初始表单--%>
    <table id="bntable"/>

    <%--分页工具栏--%>
    <div id="bnpage" />

</div>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%--页面添加以下脚本--%>
<script charset="utf-8" src="${path}/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="${path}/kindeditor/lang/zh-CN.js"></script>
<script>
    KindEditor.create('#editor_id',{
        uploadJson:"${path}/editor/uploadEditor",
        filePostName:"photo",   //设置上传图片的名称
        allowFileManager:true,   //是否展示浏览远程图片按钮
        fileManagerJson:"${path}/editor/queryPhotos",      //指定浏览远程图片的路径
        afterBlur:function(){     //在kindeditor失去焦点之后执行的内容
            this.sync();          //将kindeditor中
        }


    });
</script>
<script>
    $(function() {
        //初始化表单
        $("#bntable").jqGrid({

                url : "${path}/article/showAll",
                editurl:"${path}/article/edit",
                datatype : "json",
                rowNum : 6, //每页展示条数
                rowList : [6, 9, 12],  //可选展示条数
                styleUI:"Bootstrap", //表单格式
                pager: '#bnpage',   //分页工具
                viewrecords : true,  //是否显示总条数
                autowidth:true,
                height : 210,
                colNames : [ 'ID', '名字', '作者', '内容','上传时间', '所属上师','操作' ],
                colModel : [
                    {name : 'id', width : 100,edittype:"file"},
                    {name : 'title',   width : 55},
                    {name : 'author',width : 80,align : "left"},
                    {name : 'content',width : 80,align : "left"},
                    {name : 'crea_date', width : 90},
                    {name : 'guru_id',  width : 80,align : "left"},
                    {name : 'caozuo',width : 80,align : "left",
                        formatter:function(cellValue){
                            return "<span class='glyphicon glyphicon-th-list'></span>"
                        }
                    },
                ]
            });
         //处理增删改查操作
         $("#bntable").jqGrid('navGrid', '#bnpage', {
            edit : false,
            add : false,
            del : true,addtext: "增加",edittext: "修改",deltext: "删除" },
             {},  //执行修改操作的额外配置
             {},  //执行添加操作的额外配置
             {}   //执行删除操作的额外配置
         );

         // 展示文章信息
         $("#btn1").click(function(){

             var rowId = $("#bntable").jqGrid("getGridParam","selrow");  //只读属性 ，最后选择行的id
             if(rowId != null){
                 //根据id获取行数据
                 var row = $("#bntable").jqGrid("getRowData",rowId);

                 //给input框设置数据
                 $("#title").val(row.title);
                 //给input框设置数据
                 $("#author").val(row.author);
                 //给富文本编辑器设置内容
                 KindEditor.html("#editor_id",row.content);

                 //展示模态框
                 $("#MyModals").modal("show");
                 // 设置按钮
                 $("#MyFooter").html("<button class='btn btn-primary' onclick='updateArticle(\""+rowId+"\")'>提交</button>"+
                     "<button class='btn btn-primary' data-dismiss='modal'>关闭</button>");

             }else {
                 alert("请选择一行");
             }
         })

        // 添加文章
        $("#btn2").click(function(){

            //清空表单
            $("#MyForm")[0].reset();
            //清空kindeditor
            KindEditor.html("#editor_id","");

            //展示模态框
            $("#MyModals").modal("show");

            $("#MyFooter").html("<button class='btn btn-primary' onclick='addArticle()'>提交</button>"+
                        "<button class='btn btn-primary' data-dismiss='modal'>关闭</button>");

        })
    });
    //点击添加按钮 添加文章
    function addArticle(){
        $.ajax({
            url:"${path}/article/addArticle",
            type:"post",
            dataType:"json",
            data:$("#MyForm").serialize(),
            success:function(){

                //关闭模态框
                $("#MyModals").modal("hide");

                //刷新页面
                $("#bntable").trigger("reloadGrid");
            }
        });
    }
    //点击修改按钮 添加文章
    function updateArticle(rowId){
        $.ajax({
            url:"${path}/article/updateArticle?id="+rowId,
            type:"post",
            dataType:"json",
            data:$("#MyForm").serialize(),
            success:function(){

                //关闭模态框
                $("#MyModals").modal("hide");

                //刷新页面
                $("#bntable").trigger("reloadGrid");
            }
        });
    }
</script>

<%--初始化面板--%>
<div class="panel panel-info">
    <%--面板头--%>
    <div class="panel panel-heading">
        <h2>文章管理</h2>
    </div>
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">文章信息</a></li>
    </ul>
    <div class="panel-body">
        <ul class="nav nav-pills nav-stacked">
           <button class="btn btn-warning" id="btn1">  文章信息  </button> &emsp;

           <button class="btn btn-success" id="btn2">  添加文章  </button>  &emsp;

           <button class="btn btn-danger" id="btn3">  删除文章  </button>
        </ul>
    </div>

    <%--初始表单--%>
    <table id="bntable"/>

    <%--分页工具栏--%>
    <div id="bnpage" />

        <div class="modal fade" id="MyModals" role="dialog" aria-labelledby="gridSystemModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content" style="width:730px;" >

                    <%--模态框的标题--%>
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="gridSystemModalLabel">文章信息</h4>
                    </div>
                        <%--模态框的内容--%>
                    <div class="modal-body" align="center">
                        <%--放一个表单--%>
                        <form id="MyForm" >
                            <div class="input-group" style="width: 200px" >
                                <span class="input-group-addon" id="basic-addon1" >名字</span>
                                <input id="title" name="title" type="text" class="form-control"  aria-describedby="basic-addon1" >
                            </div>
                        </br>
                        </br>
                            <div class="input-group" style="width: 200px" >
                                <span class="input-group-addon" id="basic-addon2">作者</span>
                                <input id="author" name="author" type="text" class="form-control"  aria-describedby="basic-addon2" >
                            </div>
                        </br>
                        </br>
                            <%--kindeditor输入框--%>
                            <div align="center">
                                <textarea id="editor_id" name="content" style="width:700px;height:300px;">

                                </textarea>
                            </div>
                        </form>


                    </div>
                        <%--模态框按钮--%>
                    <div class="modal-footer" id="MyFooter">
                        <%--<button type="button" class="btn btn-default" >提交</button>--%>
                        <%--<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>--%>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
</div>
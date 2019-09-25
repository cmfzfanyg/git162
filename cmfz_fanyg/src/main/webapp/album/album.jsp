<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script>
    $(function (){

        $("#abtable").jqGrid({
                url : '${path}/album/showAll',
                datatype : "json",
                autowidth:true,
                styleUI:"Bootstrap",
                height : "auto",
                rowNum : 6,
                rowList : [ 3, 6, 9, 12 ],
                pager : '#abpage',
                viewrecords : true,
                colNames : [ 'id', '标题', '封面', '作者', '评分','播音', '集数', '内容', '发布时间' ],
                colModel : [
                    {name : 'id',index : 'id',  width : 55},
                    {name : 'title',index : 'invdate',width : 90},
                    {name : 'cover',index : 'name',width : 100},
                    {name : 'author',index : 'amount',width : 80,align : "left"},
                    {name : 'score',index : 'tax',width : 80,align : "left"},
                    {name : 'broadcast',index : 'total',width : 80,align : "left"},
                    {name : 'count',index : 'note',width : 150,sortable : false},
                    {name : 'content',index : 'total',width : 80,align : "left"},
                    {name : 'crea_date',index : 'total',width : 80,align : "left"}
                ],
                subGrid : true,   //是否开启子表格
                subGridRowExpanded : function(subgrid_id, row_id) {
                        //开启子表格
                        addSubGrid(subgrid_id,row_id);

                }
            });
        //处理增删改方法
        $("#abtable").jqGrid('navGrid', '#abpage', {
            add : false,
            edit : false,
            del : false
        });
    });

    //子表格
    function addSubGrid(subgridId,rowId){
        //tableId
        var subgridTableId = subgridId+"table";

        //工具栏Id
        var pagerId = subgridId+"page";

        //在子表格中创建一个表单table，创建一个工具栏div
        $("#" + subgridId).html("" +
            "<table id='" + subgridTableId + "'/>"+
            "<div id='"+pagerId+"'/>"
        );
        //初始子表格
        $("#" + subgridTableId).jqGrid({
                url : "${path}/chapter/queryByPage?album_id="+rowId,
                editurl:"${path}/chapter/edit?album_id="+rowId,
                datatype : "json",
                rowNum : 6,
                pager : "#"+pagerId,
                autowidth:true,
                viewrecords : true,  //是否显示总条数
                styleUI:"Bootstrap",
                height : "auto",
                colNames : [ 'id','路径', '大小','时长','上传时间','专辑id','操作' ],
                colModel : [
                    {name : "id",  index : "num",width : 80,key : true},
                    {name : "url",index : "qty",editable:true, width : 100,edittype:"file"},
                    {name : "size",index : "unit",width : 70,align : "left"},
                    {name : "duration",index : "total",width : 70,align : "left",sortable : false},
                    {name : "up_date",index : "unit",width : 70,align : "left"},
                    {name : "album_id",index : "unit",width : 70,align : "left"},
                    {name : "url",index : "unit",width : 70,align : "left",
                        formatter:function(value){
                            return "<a href='#' onclick='play(\""+value+"\")'><span class='glyphicon glyphicon-play-circle'/></a> &emsp; &nbsp; "+
                                   "<a href='#' onclick='downloads(\""+value+"\")'><span class='glyphicon glyphicon-download'/></a>";
                        }
                    },
                ],
            });

        //增删改方法
        $("#" + subgridTableId).jqGrid('navGrid',
            "#" + pagerId, {
                edit : true,
                add : true,
                del : true},
            {},
            {
                closeAfterAdd: true,
                afterSubmit:function(data){
                    $.ajaxFileUpload({
                        url:"${path}/chapter/uploadChapter",
                        type:"post",
                        datatype:"json",
                        fileElementId:"url",
                        data:{id:data.responseText},
                        success:function(){
                            //刷新页面
                            $("#"+subgridTableId).trigger("reloadGrid");

                        }
                    })
                }
            }
        );
    }

    //在线播放
    function play(name) {
        alert("播放"+name);
        $("#myModal").modal("show");
        $("#myAudio").attr("src","${path}/upload/audio/"+name);
    }

    //下载
    function downloads(name) {
         alert("下载"+name);
        //向后台发送请求
        location.href="${path}/chapter/downloadChapter?fileName="+name;
    }

</script>

<%--初始化面板--%>
<div class="panel panel-info">

    <%--面板头--%>
    <div class="panel panel-heading">
        <h2>专辑信息</h2>
    </div>

    <ul class="nav nav-tabs">
        <li class="active"><a href="#">专辑信息</a></li>
    </ul>

    <%--初始表单--%>
    <table id="abtable"/>

    <%--分页工具栏--%>
    <div id="abpage" />


    <%--点击播放模态框--%>
    <div id="myModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <audio id="myAudio" controls/>
        </div>
    </div>
</div>
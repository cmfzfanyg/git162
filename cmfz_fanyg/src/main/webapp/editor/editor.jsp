<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%--页面添加以下脚本--%>
<script charset="utf-8" src="${path}/kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="${path}/kindeditor/lang/zh-CN.js"></script>
<script>
    KindEditor.ready(function(K) {
        window.editor = K.create('#editor_id',{
            uploadJson:"${path}/editor/uploadEditor",
            filePostName:"photo",   //设置上传图片的名称
            allowFileManager:true,   //是否展示浏览远程图片按钮
            fileManagerJson:"${path}/upload/editor",

            }
        );
    });
</script>

<div align="center">
<textarea id="editor_id" name="content" style="width:700px;height:300px;">


</textarea>
</div>
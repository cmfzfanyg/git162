<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<script type="application/javascript"  src="${path}/bootstrap/js/jquery-1.8.3.min.js"></script>
<script type="application/javascript">
     function a(){
        alert("进来了");
    }
</script>

 <%--<input name="注册" type="button" id="btn1" value="注册" onclick="localtion.href='' "/>--%>

<head>

</head>
<body>
<input type="button" class="btn btn-default" id="btn1" value="注册" onclick="a()"/>
</body>




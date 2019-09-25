<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>



<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <%--为ECharts准备一个具备大小（宽度）的DOM--%>
    <div id="main" style="width: 600px;height:400px;"></div>
    <script src="${path}/js/echarts.js"></script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));


        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '用户注册量趋势图',   //标题内容
                show:true,
                link:"${path}/main/main.jsp",
                subtext:"纯属虚构",
            },
            tooltip: {},   //鼠标提示
            legend: {
                data:['男','女']       //选项卡
            },
            xAxis: {
                data: ["1月","2月","3月","4月","5月","6月"]   //横轴展示
            },
            yAxis: {},    //纵轴展示 自适应
            series: [{
                name: '男',
                type: 'bar',
                data: [5, 46, 36, 10, 10, 20]   //数据
            },{
                name: '女',
                type: 'bar',
                data: [5, 20, 200, 10, 10, 20]   //数据
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>

</body>
</html>
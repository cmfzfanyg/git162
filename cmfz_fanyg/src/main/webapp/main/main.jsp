<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>持明法州后台管理系统</title>
    <link rel="icon" href="${path}/bootstrap/img/arrow-up.png" type="image/x-icon">
    <link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.css">

    <%--引入jqgrid中主题css--%>
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/css/css/hot-sneaks/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="${path}/bootstrap/jqgrid/boot/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入js文件--%>
    <script src="${path}/bootstrap/js/jquery.min.js"></script>
    <script src="${path}/bootstrap/js/bootstrap.js"></script>
    <script src="${path}/bootstrap/jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="${path}/bootstrap/jqgrid/boot/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="${path}/bootstrap/js/ajaxfileupload.js"></script>

</head>
<body>
    <!--顶部导航-->
    <!--使用默认导航条的样式-->
    <div class="container">
        <div class="row">
    <nav class="navbar navbar-default">
        <!--导航条充满整个屏幕-->
        <div class="container-fluid">
            <!--导航条标题-->
            <div class="navbar-header">
                <!--导航条触发器的样式-->     <!--给该按钮添加导航条的触发器--> <!--点击按钮后触发对应的菜单项-->
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" datatarget="#bs-example-navbar-collapse-1">
                    <!--按钮中添加3个横杠-->
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!--标题-->
                <a class="navbar-brand" href="#">持名法洲管理系统</a>
            </div>
            <!--导航条展示的具体内容-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">欢迎登录 ${admin.userName}</a></li>
                    <li class="text-right"><a href="${path}/admin/logout">退出登录<span class="glyphicon glyphicon-log-out"></span></a></li>
                </ul>
            </div>
        </div>
    </nav>
        </div>
    </div>

    <!--栅格系统-->
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <!--面板组样式--> <!--两个面板公用的父容器  保证可以交互-->
                <div class="panel-group" id="accordion">
                    <!--默认的面板样式-->
                    <div class="panel panel-danger">
                        <!--面板的头部-->
                        <div class="panel-heading">
                            <!--面板的标题-->
                            <h4 class="panel-title">
                                <!--添加折叠面板的触发器-->
                                <!--触发器触发的目标内 容-->
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                    用户管理
                                </a>
                            </h4>
                        </div>
                        <!--作为折叠的具体内容-->
                        <div id="collapseOne" class="panel-collapse collapse ">
                            <!--面板内容-->
                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked">
                                    <li><button class="btn btn-success">
                                        <a href="javascript:$('#mainId').load('${path}/user/user.jsp')">用户管理</a>
                                    </button></li>
                                    <li><button class="btn btn-warning">
                                        <a href="javascript:$('#mainId').load('${path}/Easy/GoeasyEcharts.jsp')">用户统计</a>
                                    </button></li>
                                    <li><button class="btn btn-warning">
                                        <a href="javascript:$('#mainId').load('${path}/Easy/ChinaJson.jsp')">用户分布</a>
                                    </button></li>
                                </ul>
                             </div>
                        </div>
                    </div>

                    <hr>

                    <!--默认的面板样式-->
                    <div class="panel panel-warning">
                        <!--面板的头部-->
                        <div class="panel-heading">
                            <!--面板的标题-->
                            <h4 class="panel-title">
                                <!--添加折叠面板的触发器-->                        <!--触发器触发的目标内 容-->
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapseOne2">
                                    轮播图管理
                                </a>
                            </h4>
                        </div>
                        <!--作为折叠的具体内容-->
                        <div id="collapseOne2" class="panel-collapse collapse ">
                            <!--面板内容-->
                            <div class="panel-body">
                                 <button class="btn btn-warning">
                                    <a href="javascript:$('#mainId').load('${path}/banner/banner.jsp')">展示轮播图</a>
                                </button>
                            </div>
                        </div>
                    </div>

                    <hr>

                    <!--默认的面板样式-->
                    <div class="panel panel-info">
                        <!--面板的头部-->
                        <div class="panel-heading">
                            <!--面板的标题-->
                            <h4 class="panel-title">
                                <!--添加折叠面板的触发器-->                        <!--触发器触发的目标内 容-->
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapseOne3">
                                    文章管理
                                </a>
                            </h4>
                        </div>
                        <!--作为折叠的具体内容-->
                        <div id="collapseOne3" class="panel-collapse collapse ">
                            <!--面板内容-->
                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked">
                                    <li><button class="btn btn-success">
                                        <a href="javascript:$('#mainId').load('${path}/article/article.jsp')">管理信息</a>
                                    </button></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <hr>

                    <!--默认的面板样式-->
                    <div class="panel panel-heading">
                        <!--面板的头部-->
                        <div class="panel-primary">
                            <!--面板的标题-->
                            <h4 class="panel-title">
                                <!--添加折叠面板的触发器-->                        <!--触发器触发的目标内 容-->
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapseOne4">
                                    上师管理
                                </a>
                            </h4>
                        </div>
                        <!--作为折叠的具体内容-->
                        <div id="collapseOne4" class="panel-collapse collapse ">
                            <!--面板内容-->
                            <div class="panel-body">
                                <a href="#">专辑管理</a>
                            </div>
                        </div>
                    </div>

                    <hr>

                    <!--默认的面板样式-->
                    <div class="panel panel-primary">
                        <!--面板的头部-->
                        <div class="panel-heading">
                            <!--面板的标题-->
                            <h4 class="panel-title">
                                <!--添加折叠面板的触发器-->                        <!--触发器触发的目标内 容-->
                                <a  data-toggle="collapse" data-parent="#accordion" href="#collapseOne5">
                                    专辑管理
                                </a>
                            </h4>
                        </div>
                        <!--作为折叠的具体内容-->
                        <div id="collapseOne5" class="panel-collapse collapse">
                            <!--面板内容-->
                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked">
                                <li><button class="btn btn-success">
                                    <a href="javascript:$('#mainId').load('${path}/album/album.jsp')">专辑信息</a>
                                </button></li>
                                </ul>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
            <div class="col-md-10" id="mainId">
                <div class="jumbotron">
                    <h3>欢迎来到持名法州后台管理系统</h3>
                </div>
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" align="center">
                    <!--轮播图下标-->
                    <ol class="carousel-indicators">
                        <!--data-target与id保持一致-->
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    </ol>

                    <!--轮播图的实际内容  -->
                     
                    <div class="carousel-inner">
                        <div class="item active">
                            <!--需要轮播的图片路径-->
                            <img src="${path}/bootstrap/img/shouye.jpg" alt="...">
                            <!--图片介绍-->
                            <div class="carousel-caption">
                                背景图片
                            </div>
                        </div>
                        <div class="item">
                            <img src="${path}/bootstrap/img/1.png" alt="...">
                            <div class="carousel-caption">
                                jjj
                            </div>
                        </div>
                        <div class="item">
                            <img src="${path}/bootstrap/img/2.png" alt="...">
                            <div class="carousel-caption">
                                jjj
                            </div>
                        </div>
                        <div class="item">
                            <img src="${path}/bootstrap/img/3.png" alt="...">
                            <div class="carousel-caption">
                                jjj
                            </div>
                        </div>
                        <div class="item">
                            <img src="${path}/bootstrap/img/4.png" alt="...">
                            <div class="carousel-caption">
                                jjj
                            </div>
                        </div>
                    </div>
                    <!-- 手工切换轮播图片 -->
                    <!--切换上一张轮播图片-->
                    <a class="left carousel-control" href="#carousel-example-generic"  data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <!--切换下一张轮播图片-->
                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
            <!--页脚-->
            <div class="panel panel-footer" align="center">
                <div>百知教育fanyg@zparkhr.com</div>
            </div>

            </div>
        </div>
    </div>

    <!--左边手风琴部分-->
        <!--巨幕开始-->
        <!--右边轮播图部分-->
        <!--页脚-->
    <!--栅格系统-->

</body>
</html>

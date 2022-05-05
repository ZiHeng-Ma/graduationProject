<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>登录</title>

    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">

    <script src="static/js/demo-rtl.js"></script>


    <link rel="stylesheet" type="text/css" href="static/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="static/css/nanoscroller.css">

    <link rel="stylesheet" type="text/css" href="static/css/theme_styles.css">


    <link href='static/css/css.css' rel='stylesheet' type='text/css'>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body id="login-page-full">
<div id="login-full-wrapper">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div id="login-box">
                    <div id="login-box-holder">
                        <div class="row">
                            <div class="col-xs-12">
                                <header id="login-header">
                                    <div id="login-logo">
                                        <span style="font-size: x-large">学生成绩挖掘系统</span>
                                    </div>
                                </header>
                                <div id="login-box-inner">
                                    <form role="form" action="${pageContext.request.contextPath}/logindispatch">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                            <input class="form-control" type="text" placeholder="学号" name="user">
                                        </div>
<%--                                        <div class="input-group">--%>
<%--                                            <span class="input-group-addon"><i class="fa fa-key"></i></span>--%>
<%--                                            <input type="password" class="form-control" placeholder="密码" name="password">--%>
<%--                                        </div>--%>
                                        <div align="center">
                                            <font size="4" color="red">${message}</font>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <button type="submit" class="btn btn-success col-xs-12">登录</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="static/js/demo-skin-changer.js"></script>
<script src="static/js/jquery.js"></script>
<script src="static/js/bootstrap.js"></script>
<script src="static/js/jquery.nanoscroller.min.js"></script>
<script src="static/js/demo.js"></script>


<script src="static/js/scripts.js"></script>

</body>
</html>
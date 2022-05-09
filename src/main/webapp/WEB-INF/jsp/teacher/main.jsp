<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>教师端-成绩系统</title>

    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">

    <script src="static/js/demo-rtl.js"></script>


    <link rel="stylesheet" type="text/css" href="static/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="static/css/nanoscroller.css">

    <link rel="stylesheet" type="text/css" href="static/css/theme_styles.css">

    <link rel="stylesheet" href="static/css/daterangepicker.css" type="text/css">
    <link rel="stylesheet" href="static/css/jquery-jvectormap-1.2.2.css" type="text/css">
    <link rel="stylesheet" href="static/css/weather-icons.css" type="text/css">
    <link rel="stylesheet" href="static/css/morris.css" type="text/css">

    <link href='static/css/css1.css' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="theme-wrapper">
    <header class="navbar" id="header-navbar">
        <div class="container">
            <a href="" id="logo" class="navbar-brand">
                <span style="font-size: x-large">成绩挖掘系统</span>
            </a>
            <div class="clearfix">
                <button class="navbar-toggle" data-target=".navbar-ex1-collapse" data-toggle="collapse" type="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="fa fa-bars"></span>
                </button>
                <div class="label label-success pull-right" style="display: inline-block;margin-top: 15px;font-size:medium;">欢迎 ${name} 使用成绩管理系统</div>
            </div>
        </div>
    </header>

    <div id="page-wrapper" class="container">
        <div class="row">
            <div id="nav-col">
                <section id="col-left" class="col-left-nano">
                    <div id="col-left-inner" class="col-left-nano-content">
                        <div class="collapse navbar-collapse navbar-ex1-collapse" id="sidebar-nav">
                            <ul class="nav nav-pills nav-stacked">
                                <li class="nav-header nav-header-first hidden-sm hidden-xs">
                                    系统功能
                                </li>
                                <li class="active" style="height: 60px;">
                                    <a href="${pageContext.request.contextPath}/function/dataInAndOut">
                                        <i class="glyphicon glyphicon-stats" style="top: 10px;"></i>
                                        <span>数据导入</span>
                                    </a>
                                </li>
                                <li class="active" style="height: 60px;">
                                    <a href="${pageContext.request.contextPath}/function/scoreManager">
                                        <i class="glyphicon glyphicon-hdd" style="top: 10px;"></i>
                                        <span>成绩管理</span>
                                    </a>
                                </li>
                                <li class="active" style="height: 60px;">
                                    <a href="${pageContext.request.contextPath}/function/scoreSearch">
                                        <i class="glyphicon glyphicon-search" style="top: 10px;"></i>
                                        <span>成绩查询</span>
                                    </a>
                                </li>
                                <li class="active" style="height: 60px;">
                                    <a href="${pageContext.request.contextPath}/function/scoreMiner">
                                        <i class="glyphicon glyphicon-record" style="top: 10px;"></i>
                                        <span>成绩挖掘</span>
                                    </a>
                                </li>
                                <li class="active" style="height: 60px;">
                                    <a href="${pageContext.request.contextPath}/function/scoreStatistic">
                                        <i class="glyphicon glyphicon-align-left" style="top: 10px;"></i>
                                        <span>成绩统计</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </section>
                <div id="nav-col-submenu"></div>
            </div>
            <div id="content-wrapper">
                <div class="jumbotron">
                    <h1 class="display-4">欢迎使用成绩管理系统</h1>
                    <p class="lead">本系统对于教师是全功能开放的，对于学生仅开放部分功能。请根据您的需求，点击左侧按钮进入功能模块。</p>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>教师端-成绩管理</title>

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
                <div class="label label-success pull-right" style="display: inline-block;margin-top: 15px;font-size:medium;">欢迎使用成绩管理系统</div>
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
                                <li class="active">
                                    <a href="${pageContext.request.contextPath}/function/dataInAndOut">
                                        <i class="fa fa-dashboard"></i>
                                        <span>数据导入/导出</span>
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="${pageContext.request.contextPath}/function/scoreManager">
                                        <i class="fa fa-dashboard"></i>
                                        <span>成绩管理</span>
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="${pageContext.request.contextPath}/function/scoreSearch">
                                        <i class="fa fa-dashboard"></i>
                                        <span>成绩查询</span>
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="${pageContext.request.contextPath}/function/scoreMiner">
                                        <i class="fa fa-dashboard"></i>
                                        <span>成绩挖掘</span>
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="${pageContext.request.contextPath}/function/scoreStatistic">
                                        <i class="fa fa-dashboard"></i>
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
                <div class="main-box clearfix">
                    <header class="main-box-header clearfix">
                        <button type="button" class="btn btn-primary">添加</button>
                    </header>
                    <div class="main-box-body clearfix">
                        <div class="table-responsive">

                            <div id="table-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">

                                <table id="table-example" class="table table-hover dataTable no-footer" role="grid">
                                    <thead>
                                    <tr role="row">
                                        <th class="text-center" tabindex="0" aria-controls="table-example" rowspan="1" colspan="1" style="width: 96px;">职工编号</th>
                                        <th class="text-center" tabindex="0" aria-controls="table-example" rowspan="1" colspan="1" style="width: 96px;">课程代号</th>
                                        <th class="text-center" tabindex="0" aria-controls="table-example" rowspan="1" colspan="1" style="width: 96px;">平时成绩</th>
                                        <th class="text-center" tabindex="0" aria-controls="table-example" rowspan="1" colspan="1" style="width: 96px;">期中成绩</th>
                                        <th class="text-center" tabindex="0" aria-controls="table-example" rowspan="1" colspan="1" style="width: 96px;">期末成绩</th>
                                        <th class="text-center" tabindex="0" aria-controls="table-example" rowspan="1" colspan="1" style="width: 96px;">总成绩</th>
                                        <th class="text-center" tabindex="0" aria-controls="table-example" rowspan="1" colspan="1" style="width: 47px;">修改</th>
                                        <th class="text-center" tabindex="0" aria-controls="table-example" rowspan="1" colspan="1" style="width: 47px;">删除</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${scoreList}" var="score">
                                    <tr role="row" class="odd text-center">
                                        <td>${score.t_No}</td>
                                        <td>${score.c_No}</td>
                                        <td>${score.s_Ncor}</td>
                                        <td>${score.s_Mid}</td>
                                        <td>${score.s_Fs}</td>
                                        <td>${score.s_To}</td>
                                        <td><a><button type="button" class="btn btn-warning"></button></a></td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>

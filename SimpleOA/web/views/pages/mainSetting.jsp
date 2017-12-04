<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<h1 class="page-title">
    <i class="icon-lock"></i>
    首页设置
</h1>
<div class="stat-container">
    <div class="stat-holder">
        <div class="stat">
            <span id="time0">0</span>
            本月工时
        </div> <!-- /stat -->
    </div> <!-- /stat-holder -->
    <div class="stat-holder">
        <div class="stat">
            <span id="time1">0</span>
            本周工时
        </div> <!-- /stat -->
    </div> <!-- /stat-holder -->
    <div class="stat-holder">
        <div class="stat">
            <span id="time2">0</span>
            昨日工时
        </div> <!-- /stat -->
    </div> <!-- /stat-holder -->
    <div class="stat-holder">
        <div class="stat">
            <span id="time3">0</span>
            昨日排名
        </div> <!-- /stat -->
    </div> <!-- /stat-holder -->
</div> <!-- /stat-container -->
<div class="widget">
    <div class="widget-header">
        <i class="icon-signal"></i>
        <h3>工时对比</h3>
    </div> <!-- /widget-header -->
    <div class="widget-content">
        <div id="bar-chart" class="chart-holder"></div> <!-- /bar-chart -->
    </div> <!-- /widget-content -->
</div> <!-- /widget -->
<div class="row">
    <div class="span5">
        <div class="widget">
            <div class="widget-header">
                <h3>通知</h3>
            </div> <!-- /widget-header -->
            <div class="widget-content">
                <p>今天的任务是洗脚2017-12-30</p>
            </div> <!-- /widget-content -->
        </div> <!-- /widget -->
    </div> <!-- /span5 -->
    <div class="span4">
        <div class="widget">
            <div class="widget-header">
                <h3>公告</h3>
            </div> <!-- /widget-header -->
            <div class="widget-content">
                <p>今天的任务是洗脚2017-12-30</p>
            </div> <!-- /widget-content -->
        </div> <!-- /widget -->
    </div> <!-- /span4 -->
</div> <!-- /row -->
